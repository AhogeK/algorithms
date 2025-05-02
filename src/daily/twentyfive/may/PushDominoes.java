package daily.twentyfive.may;

/**
 * 838. 推多米诺
 *
 * @author AhogeK
 * @since 2025-05-02 20:07:04
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = new char[n + 2];
        arr[0] = 'L';
        arr[n + 1] = 'R';
        for (int i = 0; i < n; i++)
            arr[i + 1] = dominoes.charAt(i);

        int l = 0;
        int r = 1;
        while (r < arr.length) {
            while (arr[r] == '.')
                r++;
            if (r - l > 1) {
                char left = arr[l];
                char right = arr[r];
                if (left == right)
                    for (int i = l + 1; i < r; i++)
                        arr[i] = left;
                else if (left == 'R' && right == 'L') {
                    int points = r - l - 1;
                    for (int i = 1; i <= points / 2; i++) {
                        arr[l + i] = 'R';
                        arr[r - i] = 'L';
                    }
                }
            }
            l = r;
            r++;
        }
        return new String(arr, 1, n);
    }
}
