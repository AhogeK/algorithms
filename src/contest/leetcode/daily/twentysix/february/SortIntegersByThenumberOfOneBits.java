package contest.leetcode.daily.twentysix.february;

import java.util.Arrays;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-25 11:51:36
 */
public class SortIntegersByThenumberOfOneBits {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int bitCount = Integer.bitCount(arr[i]);
            arr[i] = (bitCount << 16) | arr[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) arr[i] = arr[i] & 0xFFFF;
        return arr;
    }
}
