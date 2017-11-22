package module2.iostream.cryptfile;

import module1.utils.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Egor Stepanov
 * @since  22-11-2017.
 */
public class CryptFileByWord {

    private final byte[] password;

    public CryptFileByWord(String password) {
        this.password = password.getBytes();
    }

    public void cryptFile(String inputFileName, String cryptedFileName) throws IOException {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        File file = new File(classLoader.getResource(inputFileName).getFile());

        try(InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream(cryptedFileName)) {

            byte[] buffer = new byte[1024];

            while (inputStream.read(buffer) > 0) {
                outputStream.write(FileUtils.xorBytes(buffer, password));
            }
        }
    }

}
