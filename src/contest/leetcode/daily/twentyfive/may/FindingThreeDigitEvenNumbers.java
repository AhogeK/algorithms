package contest.leetcode.daily.twentyfive.may;

import java.util.*;

/**
 * 2094. 找出 3 位偶数
 *
 * @author AhogeK
 * @since 2025-05-12 10:49:08
 */
public class FindingThreeDigitEvenNumbers {

    public int[] findEvenNumbers(int[] digis) {
        int[] count = new int[10];
        for (int d : digis) count[d]++;

        Set<Integer> set = new HashSet<>();
        for (int d1 = 1; d1 <= 9; d1++) {
            if (count[d1] == 0) continue;
            for (int d2 = 0; d2 <= 9; d2++) {
                if (count[d2] == 0) continue;
                for (int d3 : new int[]{0, 2, 4, 6, 8}) {
                    if (count[d3] == 0) continue;
                    int[] temp = new int[10];
                    temp[d1]++;
                    temp[d2]++;
                    temp[d3]++;
                    boolean valid = true;
                    for (int d = 0; d < 10; d++) {
                        if (temp[d] > count[d]) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        int num = d1 * 100 + d2 * 10 + d3;
                        set.add(num);
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
