package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-24 18:58:43
 */
class MinimumNumberOfDaysToMakeMBouquetsTest {

    private final MinimumNumberOfDaysToMakeMBouquets minimumNumberOfDaysToMakeMBouquets =
            new MinimumNumberOfDaysToMakeMBouquets();

    @Test
    void test() {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        int result = minimumNumberOfDaysToMakeMBouquets.minDays(bloomDay, m, k);
        Assertions.assertEquals(3, result);
        result = minimumNumberOfDaysToMakeMBouquets.minDays2(bloomDay, m, k);
        Assertions.assertEquals(3, result);
    }
}
