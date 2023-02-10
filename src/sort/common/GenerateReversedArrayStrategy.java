package sort.common;

/**
 * 生成一个逆序数组，这是一个极端测试用例
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-09 19:30:08
 */
public class GenerateReversedArrayStrategy implements IGenerateArrayStrategy {

    int len = 1_000;

    public GenerateReversedArrayStrategy() {
    }

    public GenerateReversedArrayStrategy(int len) {
        if (len <= 0) {
            throw new IllegalArgumentException("数组的长度不可低于0");
        }
        this.len = len;
    }

    @Override
    public String getFeature() {
        return "逆序数组";
    }

    @Override
    public int[] generateArray() {
        int[] reversedArray = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            reversedArray[i] = i;
        }
        return reversedArray;
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
