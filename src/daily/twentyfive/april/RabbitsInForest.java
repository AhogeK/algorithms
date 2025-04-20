package daily.twentyfive.april;

/**
 * 781. 森林中的兔子
 *
 * @author AhogeK
 * @since 2025-04-20 15:10:54
 */
public class RabbitsInForest {

    public int numRabbits(int[] answers) {
        // 最多1000种回答
        int[] cnt = new int[1000];
        for (int ans : answers)
            cnt[ans]++;
        int res = 0;
        for (int k = 0; k < 1000; k++) {
            if (cnt[k] == 0) continue;
            int groupSize = k + 1;
            // 需要多少组，每组 groupSize 只，向上取整
            int numGroups = (cnt[k] + groupSize - 1) / groupSize;
            res += numGroups * groupSize;
        }
        return res;
    }
}
