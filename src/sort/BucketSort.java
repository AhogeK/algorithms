package sort;

import sort.common.ISortingAlgorithm;

/**
 * @author AhogeK
 * @since 2025-03-14 20:54:22
 */
public class BucketSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // 1. 找到最大值和最小值
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // 2. 计算桶大小和数量
        int n = nums.length;
        int bucketSize = Math.max(1, (max - min) / (int) Math.sqrt(n)); // 避免bucketSize为0
        int bucketCount = (max - min) / bucketSize + 1;

        // 3. 统计每个桶需要的大小
        int[] bucketSizes = new int[bucketCount];
        for (int num : nums) {
            int bucketIndex = (num - min) / bucketSize; // 使用bucketSize计算
            bucketSizes[bucketIndex]++;
        }

        // 4. 创建桶
        int[][] buckets = new int[bucketCount][];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new int[bucketSizes[i]];
            bucketSizes[i] = 0; // 重置计数器
        }

        // 5. 将元素放入桶中
        for (int num : nums) {
            int bucketIndex = (num - min) / bucketSize; // 使用bucketSize计算
            buckets[bucketIndex][bucketSizes[bucketIndex]++] = num;
        }

        // 6. 对每个桶进行排序 (使用插入排序保持稳定性)
        for (int[] bucket : buckets) {
            insertionSort(bucket);
        }

        // 7. 将排序后的元素收集回原数组
        int index = 0;
        for (int[] bucket : buckets) {
            for (int num : bucket) {
                nums[index++] = num;
            }
        }
    }

    private void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i;

            while (j > 0 && arr[j - 1] > current) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = current;
        }
    }
}
