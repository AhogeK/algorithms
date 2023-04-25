package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-25 10:34:34
 */
class FirstBadVersionTest {

    private final FirstBadVersion firstBadVersion = new FirstBadVersion();

    @Test
    void case1() {
        int n = 100;
        int result = this.firstBadVersion.firstBadVersion(n);
        Assertions.assertEquals(firstBadVersion.getFirstBadVersion(), result);
    }
}
