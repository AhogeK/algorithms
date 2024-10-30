package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-28 23:27:35
 */
class MySqrtTest {

    private final MySqrt mySqrt = new MySqrt();

    @Test
    void case1() {
        int x = 4;
        int expected = 2;
        int actual = mySqrt.mySqrt(x);
        Assertions.assertEquals(expected, actual);
        actual = mySqrt.mySqrt2(x);
        Assertions.assertEquals(expected, actual);
    }
}
