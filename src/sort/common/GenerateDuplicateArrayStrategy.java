package sort.common;

/**
 * 用于生成包含大量重复元素的随机数组
 *
 * @author AhogeK
 * @since 2025-03-11 16:58:51
 */
public class GenerateDuplicateArrayStrategy implements IGenerateArrayStrategy {

    private final int len;
    // 主要重复的元素值
    private final int dominantValue;
    private int min = 0;
    private int max;
    // 主要重复元素的占比，默认为90%
    private double duplicateRatio = 0.9;

    /**
     * 默认构造函数
     * 随机长度，90%元素相同
     */
    public GenerateDuplicateArrayStrategy() {
        this.len = SortingUtil.RANDOM.nextInt(1000) + 100; // 避免太大的随机值
        this.max = len;
        this.dominantValue = min + SortingUtil.RANDOM.nextInt(max - min + 1);
    }

    /**
     * 指定数组长度，90%元素相同
     *
     * @param len 自定义的数组长度
     */
    public GenerateDuplicateArrayStrategy(int len) {
        this.len = len;
        this.max = len;
        this.dominantValue = min + SortingUtil.RANDOM.nextInt(max - min + 1);
    }

    /**
     * 指定数组长度和范围，90%元素相同
     *
     * @param len 自定义数组长度
     * @param min 自定义最小值
     * @param max 自定义最大值
     */
    public GenerateDuplicateArrayStrategy(int len, int min, int max) {
        this.len = len;
        this.min = min;
        this.max = max;
        this.dominantValue = min + SortingUtil.RANDOM.nextInt(max - min + 1);
    }

    /**
     * 指定数组长度、范围和重复元素占比
     *
     * @param len            自定义数组长度
     * @param min            自定义最小值
     * @param max            自定义最大值
     * @param duplicateRatio 重复元素的占比(0.0-1.0)
     */
    public GenerateDuplicateArrayStrategy(int len, int min, int max, double duplicateRatio) {
        this.len = len;
        this.min = min;
        this.max = max;
        this.duplicateRatio = Math.clamp(duplicateRatio, 0.0, 1.0); // 确保在0到1之间
        this.dominantValue = min + SortingUtil.RANDOM.nextInt(max - min + 1);
    }

    /**
     * 指定数组长度、范围、重复元素占比和主要重复值
     *
     * @param len            自定义数组长度
     * @param min            自定义最小值
     * @param max            自定义最大值
     * @param duplicateRatio 重复元素的占比(0.0-1.0)
     * @param dominantValue  主要重复的元素值
     */
    public GenerateDuplicateArrayStrategy(int len, int min, int max, double duplicateRatio, int dominantValue) {
        this.len = len;
        this.min = min;
        this.max = max;
        this.duplicateRatio = Math.clamp(duplicateRatio, 0.0, 1.0); // 确保在0到1之间
        this.dominantValue = dominantValue;
    }

    @Override
    public String getFeature() {
        return String.format("大量连续重复元素(%.0f%%为%d)", duplicateRatio * 100, dominantValue);
    }

    @Override
    public int[] generateArray() {
        // 参数校验
        assert len > 0;
        if (min > max) {
            int temp = max;
            max = min;
            min = temp;
        }

        int[] array = new int[len];

        // 计算重复元素的数量
        int duplicateCount = (int) (len * duplicateRatio);

        // 1. 先填充主要重复元素
        for (int i = 0; i < duplicateCount; i++) {
            array[i] = dominantValue;
        }

        // 2. 其余位置填充随机值
        for (int i = duplicateCount; i < len; i++) {
            // 生成一个不等于dominantValue的随机值
            int randomValue;
            do {
                randomValue = min + SortingUtil.RANDOM.nextInt(max - min + 1);
            } while (randomValue == dominantValue && max > min); // 如果可能，避免生成与主要值相同的数

            array[i] = randomValue;
        }

        // 3. 打乱数组，创建一些连续区段（可选）
        shuffleWithBias(array, duplicateCount);

        return array;
    }

    /**
     * 特殊打乱算法，倾向于保持一些连续的重复元素片段
     *
     * @param array          要打乱的数组
     * @param duplicateCount 重复元素的数量
     */
    private void shuffleWithBias(int[] array, int duplicateCount) {
        // 决定是否创建长连续段
        boolean createLongSequences = SortingUtil.RANDOM.nextBoolean();

        if (createLongSequences) {
            // 创建较少但较长的连续段
            int segmentCount = Math.max(1, len / 20); // 大约5%的位置作为段的起点

            for (int i = 0; i < segmentCount; i++) {
                int start = SortingUtil.RANDOM.nextInt(len);
                int segmentLength = Math.min(duplicateCount / segmentCount, len - start);

                // 确保这个位置开始有足够空间放置一个段
                if (segmentLength > 3) { // 只有当段长度至少为3时才创建
                    for (int j = 0; j < segmentLength; j++) {
                        if (start + j < len) {
                            array[start + j] = dominantValue;
                        }
                    }
                }
            }
        } else {
            // 标准的Fisher-Yates洗牌算法
            for (int i = len - 1; i > 0; i--) {
                int j = SortingUtil.RANDOM.nextInt(i + 1);
                SortingUtil.swap(array, i, j);
            }
        }
    }

    @Override
    public int getLen() {
        return len;
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public int getMax() {
        return max;
    }

    /**
     * 获取重复元素的占比
     *
     * @return 重复元素的占比
     */
    public double getDuplicateRatio() {
        return duplicateRatio;
    }

    /**
     * 获取主要重复的元素值
     *
     * @return 主要重复的元素值
     */
    public int getDominantValue() {
        return dominantValue;
    }
}
