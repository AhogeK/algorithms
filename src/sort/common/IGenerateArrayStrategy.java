package sort.common;

/**
 * 生成用于验证排序算法测试用例的接口，采用策略设计模式
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-07 10:59:03
 */
public interface IGenerateArrayStrategy {

    /**
     * @return 测试用例特征的文字描述
     */
    String getFeature();

    /**
     * @return 测试用例数组
     */
    int[] generateArray();

    /**
     * @return 测试用例数组的长度
     */
    int getLen();

    /**
     * @return 测试用例数组的最小值，默认值是 1
     */
    int getMin();

    /**
     * @return 测试用例数组的最大值，默认值是数组的长度
     */
    int getMax();
}
