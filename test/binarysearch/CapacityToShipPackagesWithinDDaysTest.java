package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-24 18:07:27
 */
class CapacityToShipPackagesWithinDDaysTest {

    private final CapacityToShipPackagesWithinDDays capacityToShipPackagesWithinDDays =
            new CapacityToShipPackagesWithinDDays();

    @Test
    void test() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        int result = capacityToShipPackagesWithinDDays.shipWithinDays(weights, days);
        Assertions.assertEquals(15, result);
    }
}
