package module2.patterns.decorator;

import module1.utils.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @author Egor Stepanov
 * @since 20-11-2017.
 */
public class CryptoMain {
    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = FileUtils.class.getClassLoader();
        File file = new File(classLoader.getResource("decoratorTestInput.txt").getFile());

        InputStream inputStream = new ObjectInputStream(
                new CryptoInputStream("123", new FileInputStream(file)));

        try(OutputStream outputStream = new ObjectOutputStream(new CryptoOutputStream("123",
                new FileOutputStream("DecoratorTestOutput.txt")))) {
            byte[] buffer = new byte[10];
            while (inputStream.read(buffer) > 0) {
                outputStream.write(buffer);
            }
        }

    }
}
