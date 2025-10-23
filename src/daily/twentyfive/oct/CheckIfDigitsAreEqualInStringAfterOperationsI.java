package daily.twentyfive.oct;

/**
 * 3461. 判断操作后字符串中的数字是否相等 I
 *
 * @author AhogeK
 * @since 2025-10-23 19:21:26
 */
public class CheckIfDigitsAreEqualInStringAfterOperationsI {
    public boolean hasSameDigits(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        while (len > 2) {
            for (int i = 0; i < len - 1; i++)
                arr[i] = (char) ((arr[i] - '0' + arr[i + 1] - '0') % 10 + '0');
            len--;
        }
        return arr[0] == arr[1];
    }
}
