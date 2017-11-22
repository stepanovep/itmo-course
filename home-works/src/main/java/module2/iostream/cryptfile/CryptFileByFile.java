package module2.iostream.cryptfile;

import module1.utils.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Egor Stepanov
 * @since  22-11-2017.
 */
public class CryptFileByFile {

    private final byte[] password;

    public CryptFileByFile(String passwordFileName) throws IOException {
        this.password = Files.readAllBytes(Paths.get(passwordFileName));
    }

    public void cryptFile(String inputFileName, String outputFileName) throws IOException {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        File file = new File(classLoader.getResource(inputFileName).getFile());

        try(InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream(outputFileName)) {

            byte[] buffer = new byte[128];
            while(inputStream.read(buffer) > 0) {
                outputStream.write(FileUtils.xorBytes(buffer, password));
            }
        }
    }
}
