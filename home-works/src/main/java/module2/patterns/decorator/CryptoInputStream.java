package module2.patterns.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Egor Stepanov
 * @since  20-11-2017.
 */
public class CryptoInputStream extends FilterInputStream {

    private final byte[] password;

    protected CryptoInputStream(String password,
                                InputStream in) {
        super(in);
        this.password = password.getBytes();
    }

    @Override
    public int read() throws IOException {
        int nextByte = super.read();
        if (nextByte < 1) {
            return -1;
        }
        byte[] b = new byte[] {(byte)(nextByte ^ password[0])};
        return read(b);
    }

    @Override
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        byte[] res = new byte[b.length];

        for (int i = 0; i < b.length; i++) {
            res[i] = (byte)(b[i] ^ password[i % password.length]);
        }

        return super.read(res, off, len);
    }
}
