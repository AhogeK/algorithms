package daily.twentyfive.jun;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 *
 * @author AhogeK
 * @since 2025-06-08 19:53:40
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>(n);
        int num = 1;
        for (int i = 0; i < n; ++i) {
            ans.add(num);
            if (num * 10 <= n)
                num *= 10;
            else {
                while (num % 10 == 9 || num + 1 > n)
                    num /= 10;
                num++;
            }
        }
        return ans;
    }
}
