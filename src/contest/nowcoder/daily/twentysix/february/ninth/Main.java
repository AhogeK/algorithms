package contest.nowcoder.daily.twentysix.february.ninth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.nowcoder.com/practice/c0784de498ca4779b3dc2a75fddcf12b?channelPut=tracker2">小红的数组清空</a>
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-09 20:56:55
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            cnt.merge(x, 1, Integer::sum);
        }
        long ans = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int v = entry.getKey();
            int cur = entry.getValue();
            int pre = cnt.getOrDefault(v - 1, 0);
            if (cur > pre) ans += cur - pre;
        }
        System.out.println(ans);
    }
}
