package sort;

import sort.common.ISortingAlgorithm;

import java.util.*;

/**
 * @author AhogeK
 * @since 2025-02-25 15:11:59
 */
public class SedgewickShellSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        if (nums.length <= 1) return;

        Set<Integer> gapSet = new LinkedHashSet<>();
        int k = 0;

        while (true) {
            int t = (k % 2 == 0) ? k / 2 : (k + 1) / 2;
            int gap = (k % 2 == 0)
                    ? 9 * (int) (Math.pow(4, t) - Math.pow(2, t)) + 1
                    : (int) (Math.pow(4, t + 1.0) - 3 * Math.pow(2, t + 1.0)) + 1;

            // gap无效时立即退出
            if (gap > nums.length || gap <= 0) break;

            gapSet.add(gap);
            k++;
        }

        // 保障基础间隔（至少包含gap=1）
        gapSet.add(1);

        // 降序排列并执行排序
        List<Integer> gaps = new ArrayList<>(gapSet);
        gaps.sort(Collections.reverseOrder());
        for (int gap : gaps) {
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                int j = i;
                while (j >= gap && nums[j - gap] > temp) {
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = temp;
            }
        }
    }
}
