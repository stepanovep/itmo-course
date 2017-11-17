package module2.iostream.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Egor Stepanov
 * @since 13-11-2017.
 */
public class CopyFile {

    private static String inputFileName = "home-works\\src\\main\\java\\module2\\iostream\\copy\\in.txt";
    private static String outputFileName = "home-works\\src\\main\\java\\module2\\iostream\\copy\\out.txt";

    private static void copyFile(String in, String out) throws IOException {
        try (InputStream inputStream = new FileInputStream(new File(in));
             OutputStream outputStream = new FileOutputStream(out)) {
             byte[] buffer = new byte[1024];


             while (inputStream.read(buffer) > 0) {
                 outputStream.write(buffer);
             }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new File(".").getAbsoluteFile());
        copyFile(inputFileName, outputFileName);
    }
}
