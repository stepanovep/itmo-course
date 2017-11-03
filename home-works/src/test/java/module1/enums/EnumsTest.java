package module1.enums;

import org.junit.Test;

/**
 * @author Egor Stepanov
 * @since 03-11-2017.
 */
public class EnumsTest {

    @Test
    public void toString_test() {
        for (Planet planet: Planet.values()) {
            System.out.println(planet);
        }
    }

}
