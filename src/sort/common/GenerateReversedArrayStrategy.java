package sort.common;

/**
 * 生成一个逆序数组，这是一个极端测试用例
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-09 19:30:08
 */
public class GenerateReversedArrayStrategy implements IGenerateArrayStrategy {

    private int len = 1_000;
    private int min = 0;
    private int max = 1_000;

    public GenerateReversedArrayStrategy() {
    }

    public GenerateReversedArrayStrategy(int len) {
        if (len <= 0) {
            throw new IllegalArgumentException("数组的长度不可低于0");
        }
        this.len = len;
    }

    public GenerateReversedArrayStrategy(int len, int min, int max) {
        if (len <= 0) throw new IllegalArgumentException("数组长度必须大于 0");
        if (min > max) throw new IllegalArgumentException("min 必须小于等于 max");

        this.len = len;
        this.min = min;
        this.max = max;
    }

    @Override
    public String getFeature() {
        return "逆序数组";
    }

    @Override
    public int[] generateArray() {
        int[] array = new int[len];
        // 逆序填充数组，范围在 [min, max]
        int step = (max - min) / (len - 1);
        for (int i = 0; i < len; i++) {
            array[i] = max - i * step; // 逆序填充
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
