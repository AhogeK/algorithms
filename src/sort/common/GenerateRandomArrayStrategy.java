package sort.common;

/**
 * 生成随机数组
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-07 11:00:24
 */
public class GenerateRandomArrayStrategy implements IGenerateArrayStrategy {
    private int len = SortingUtil.RANDOM.nextInt(Integer.MAX_VALUE) + 1;
    private int min = 0;
    private int max = SortingUtil.RANDOM.nextInt(Integer.MAX_VALUE);

    public GenerateRandomArrayStrategy() {
    }

    /**
     * 如果只指定了数组的长度，数组内的随机数值取 [1, len]
     *
     * @param len 自定义的数组长度
     */
    public GenerateRandomArrayStrategy(int len) {
        this.len = len;
        this.max = len;
    }

    /**
     * 同时指定数组长度，数组中的最小值，数组中的最大值 [min, max]
     *
     * @param len 自定义数组长度
     * @param min 自定义最小值
     * @param max 自定义最大值
     */
    public GenerateRandomArrayStrategy(int len, int min, int max) {
        this.len = len;
        this.min = min;
        this.max = max;
    }

    @Override
    public String getFeature() {
        return "完全随机";
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
        int[] randomArray = new int[len];
        for (int i = 0; i < len; i++) {
            // nextInt(n) 生成 [0, n) 的随机整数
            randomArray[i] = min + SortingUtil.RANDOM.nextInt(max - min + 1);
        }
        return randomArray;
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
}
