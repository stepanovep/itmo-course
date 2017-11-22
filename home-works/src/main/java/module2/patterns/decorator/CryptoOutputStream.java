package module2.patterns.decorator;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Egor Stepanov
 * @since  20-11-2017.
 */
public class CryptoOutputStream extends FilterOutputStream {

    private final byte[] password;

    public CryptoOutputStream(String password,
                              OutputStream out) {
        super(out);
        this.password = password.getBytes();
    }

    @Override
    public void write(int b) throws IOException {
        super.write(new byte[] {(byte)(b ^ password[0])});
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        byte[] res = new byte[b.length];

        for (int i = 0; i < b.length; i++) {
            res[i] = (byte)(b[i] ^ password[i % password.length]);
        }

        super.write(res, off, len);
    }
}
