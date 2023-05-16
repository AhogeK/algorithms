package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-05-16 15:39:27
 */
class KokoEatingBananasTest {

    private final KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();

    @Test
    void case1() {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int result = kokoEatingBananas.minEatingSpeed(piles, h);
        Assertions.assertEquals(4, result);
    }
}
