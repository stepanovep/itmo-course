package module2.iostream.custominputstream;

import java.io.IOException;
import java.io.InputStream;

/**
 * InputStream, генерирующий байты,
 * значения которых образуют "пилу"
 *
 * @author Egor Stepanov
 * @since  17-11-2017.
 */
public class SawInputStream extends InputStream {

    private final int minBound;
    private final int maxBound;

    private final SawType sawType;
    private int prevValue;
    private int value;

    public SawInputStream(SawType sawType, int minBound, int maxBound) {
        this.minBound = minBound;
        this.maxBound = maxBound;
        this.sawType = sawType;
        this.prevValue = minBound -1;
        this.value = minBound;
    }

    @Override
    public int read() throws IOException {
        return nextValue();
    }

    private int nextValue() {
        if (sawType == SawType.SHARP) {
            if (value > maxBound) {
                value = minBound;
            }
            return value++;
        } else {
            if (value > prevValue) {
                prevValue++;
                value++;
                if (value > maxBound) {
                    value = maxBound - 1;
                }
                return prevValue;
            } else {
                prevValue--;
                value--;
                if (value < minBound) {
                    value = minBound + 1;
                }
                return prevValue;
            }
        }
    }

    /**
     * Тип пилы
     */
    enum SawType {
        SHARP,      // ... 9 10 0 1 2 ...
        OBTUSE;     // ... 9 10 9 8 7 ...
    }
}
