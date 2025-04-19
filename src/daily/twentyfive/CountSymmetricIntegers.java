package daily.twentyfive;

/**
 * @author AhogeK
 * @since 2025-04-11 17:00:12
 */
public class CountSymmetricIntegers {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        // 直接从第一个可能的对称数开始（至少两位数）
        int a = Math.max(low, 11);
        while (a <= high) {
            if (a < 100) { // 处理2位数
                if (a % 11 == 0) { // 11, 22, ..., 99
                    res++;
                    a += 11; // 跳跃到下一个可能的对称数
                } else {
                    a++; // 非对称数则逐个检查
                }
            } else if (1000 <= a && a < 10000) { // 处理4位数
                int left = (a / 1000) + (a / 100 % 10); // 千位 + 百位
                int right = (a % 100 / 10) + (a % 10);  // 十位 + 个位
                if (left == right) {
                    res++;
                    a += 9; // 对称数间隔为9
                } else if (right > left) {
                    // 右半和更大时，跳到下一个百位数的起点
                    a = ((a / 100) + 1) * 100;
                } else {
                    // 左半和更大时，动态步长跳跃
                    a += left - right;
                }
            } else { // 处理非2/4位数
                a++; // 跳到下一个可能的对称数范围
            }
        }
        return res;
    }
}
