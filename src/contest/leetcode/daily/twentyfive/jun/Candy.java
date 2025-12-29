package contest.leetcode.daily.twentyfive.jun;

/**
 * 135. 分发糖果
 *
 * @author AhogeK
 * @since 2025-06-02 15:35:32
 */
public class Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) dec++;
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }
}
