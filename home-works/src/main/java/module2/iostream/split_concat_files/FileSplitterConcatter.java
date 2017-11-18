package module2.iostream.split_concat_files;

import module1.utils.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Egor Stepanov
 * @since  13-11-2017.
 */
public class FileSplitterConcatter {

    public static void splitFile(String fileName, int size) throws IOException {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (InputStream fileToSplit = new FileInputStream(file)) {
            int fileNumber = 0;
            byte[] buffer = new byte[size];
            while (fileToSplit.read(buffer) > 0) {
                String splitFileName = "splitFile" + fileNumber;
                try (OutputStream splitFile = new FileOutputStream(splitFileName)) {
                    splitFile.write(buffer);
                }
                fileNumber++;
            }
        }
    }

    public static void concatFiles(String toFile, String ... fromFiles) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(toFile)) {
            for (String fromFile : fromFiles) {
                try (InputStream inputStream = new FileInputStream(fromFile)) {
                    byte[] buffer = new byte[128];
                    while(inputStream.read(buffer) > 0) {
                        outputStream.write(buffer);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        splitFile("fileToSplit.txt", 20);

        String[] concatFiles = new String[8];
        for (int i = 0; i < 8; i++) {
            concatFiles[i] = "splitFile" + i;
        }

        concatFiles("ConcattedFile.txt", concatFiles);
    }
}
