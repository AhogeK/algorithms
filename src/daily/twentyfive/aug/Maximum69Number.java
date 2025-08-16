package daily.twentyfive.aug;

/**
 * 1323. 6 和 9 组成的最大数字
 *
 * @author AhogeK
 * @since 2025-08-16 12:21:48
 */
public class Maximum69Number {
    public int maximum69Number(int num) {
        int temp = num;
        int maxPos = -1;
        int pos = 0;
        while (temp > 0) {
            if (temp % 10 == 6) maxPos = pos;
            pos++;
            temp /= 10;
        }
        if (maxPos != -1) return num + 3 * (int) Math.pow(10, maxPos);
        return num;
    }
}
