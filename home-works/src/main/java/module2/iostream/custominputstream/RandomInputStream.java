package module2.iostream.custominputstream;

import module1.utils.RandomUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * InputStream генерирующий случайные байты
 *
 * @author Egor Stepanov
 * @since  13-11-2017.
 */
public class RandomInputStream extends InputStream {

    @Override
    public int read() throws IOException {
        return RandomUtils.generateInt(0, 255);
    }

    public static void main(String[] args) throws IOException {
        RandomInputStream randomInputStream = new RandomInputStream();
        int b = randomInputStream.read();
        System.out.println(b);
    }
}
