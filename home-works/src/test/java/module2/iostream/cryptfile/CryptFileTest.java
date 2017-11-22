package module2.iostream.cryptfile;

import org.junit.Test;

import java.io.IOException;

/**
 * @author Egor Stepanov
 * @since  22-11-2017.
 */
public class CryptFileTest {

    @Test
    public void testCryptByWord() throws IOException {
        CryptFileByWord crypt = new CryptFileByWord("123");
        crypt.cryptFile("fileToCrypt.txt", "cryptFileOut2.txt");
    }

    @Test
    public void testCryptByFile() throws IOException {
        CryptFileByFile crypt = new CryptFileByFile("passwordFile.txt");
        crypt.cryptFile("fileToCrypt.txt", "fileCryptedC.txt");
    }
}
