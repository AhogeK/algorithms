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

    @Override
    public String getFeature() {
        return String.format("接近有序（有序程度百分比 %d%%)", (int) (this.orderlyFactor * 100));
    }

    @Override
    public int[] generateArray() {
        int[] nearlySortedArray = new int[len];
        // 步骤1：先生成顺序数组
        for (int i = 0; i < len; i++) {
            nearlySortedArray[i] = i;
        }
        // 步骤2：1 - percent 表示无序的百分比，乘以 len，就表示要制造多少逆序对
        int swapTimes = (int) (len * (1 - orderlyFactor));
        for (int i = 0; i < swapTimes; i++) {
            // nextInt(n) 生成 [0, n) 的随机整数
            int index1 = SortingUtil.RANDOM.nextInt(len);
            int index2 = SortingUtil.RANDOM.nextInt(len);
            SortingUtil.swap(nearlySortedArray, index1, index2);
        }
        return nearlySortedArray;
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
