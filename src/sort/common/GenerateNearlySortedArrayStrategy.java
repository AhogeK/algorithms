package sort.common;

/**
 * 生成接近有序的数组
 * 生成的策略是：按照一定的百分比
 * 将有序数组内的随机的两个元素交换，产生逆序对
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-09 19:40:56
 */
public class GenerateNearlySortedArrayStrategy implements IGenerateArrayStrategy {

    private int len = 1_000;
    private int min = 0;
    private int max = 1_000;

    /**
     * 有序的百分比，有序因子
     */
    private double orderlyFactor = 0.9;

    public GenerateNearlySortedArrayStrategy() {
    }

    /**
     * 如果只指定了数组的长度，数组内的随机数值取 [0, len - 1]
     *
     * @param len 数组长度
     */
    public GenerateNearlySortedArrayStrategy(int len) {
        if (len <= 0) {
            throw new IllegalArgumentException("数组的长度不可低于0");
        }
        this.len = len;
    }

    /**
     * 构造函数赋值数组长度及有序百分比
     *
     * @param len           数组长度
     * @param orderlyFactor 有序百分比
     */
    public GenerateNearlySortedArrayStrategy(int len, double orderlyFactor) {
        if (len <= 0) {
            throw new IllegalArgumentException("数组的长度不可低于0");
        }
        if (orderlyFactor > 1 || orderlyFactor < 0) {
            throw new IllegalArgumentException("表征有序程度的浮点数需要传入浮点数，并且数值介于 0 和 1 之间，可 0 可 1。");
        }
        this.len = len;
        this.orderlyFactor = orderlyFactor;
    }

    public GenerateNearlySortedArrayStrategy(int len, int min, int max, double orderlyFactor) {
        if (len <= 0) throw new IllegalArgumentException("数组长度必须大于 0");
        if (min > max) throw new IllegalArgumentException("min 必须小于等于 max");
        if (orderlyFactor < 0 || orderlyFactor > 1)
            throw new IllegalArgumentException("orderlyFactor 需在 [0, 1] 之间");

        this.len = len;
        this.min = min;
        this.max = max;
        this.orderlyFactor = orderlyFactor;
    }

    @Override
    public String getFeature() {
        return String.format("接近有序（有序程度百分比 %.2f%%)", this.orderlyFactor * 100);
    }

    @Override
    public int[] generateArray() {
        int[] array = new int[len];
        // 生成初始化有序数组，范围在 [min, max]
        int step = (max - min) / (len - 1);
        for (int i = 0; i < len; i++) {
            array[i] = min + i * step;
        }
        // 随机交换 swapTimes 次，使用 Fisher-Yates 部分洗牌
        int swapTimes = Math.min((int) (len * (1 - orderlyFactor)), len - 1);
        for (int i = 0; i < swapTimes; i++) {
            int j = i + SortingUtil.RANDOM.nextInt(len - i);
            SortingUtil.swap(array, i, j);
        }
        return array;
    }

    @Override
    public int getLen() {
        return len;
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return len - 1;
    }
}
