package module2.iostream.custominputstream;

import org.junit.Test;
import org.testng.Assert;

import java.io.IOException;

/**
 * @author Egor Stepanov
 * @since  17-11-2017.
 */
public class SawInputStreamTest {

    @Test
    public void sharpSawTest() throws IOException {
        SawInputStream inputStream = new SawInputStream(SawInputStream.SawType.SHARP, 0 , 10);

        for (int i = 0; i <= 10; i++) {
            Assert.assertEquals(inputStream.read(), i);
        }

        for (int i = 0; i <= 10; i++) {
            Assert.assertEquals(inputStream.read(), i);
        }
    }

    @Test
    public void obtuseSawTest() throws IOException {
        SawInputStream inputStream = new SawInputStream(SawInputStream.SawType.OBTUSE, 0, 10);

        for (int i = 0; i <= 10; i++) {
            Assert.assertEquals(inputStream.read(), i);
        }

        for (int i = 9; i >= 0; i--) {
            Assert.assertEquals(inputStream.read(), i);
        }
    }
}
