package sort;

/**
 * @author AhogeK
 * @since 2025-03-03 13:55:36
 */
public class HanoiTower {

    public static void hanoi(int n, char source, char auxiliary, char target) {
        // 基本情形：只有一个盘子时
        if (n == 1) {
            System.out.println("移动盘子 1 从 " + source + " 到 " + target);
            return;
        }

        // 将n-1个盘子从source移到auxiliary，借助target
        hanoi(n - 1, source, target, auxiliary);

        // 将最大的盘子从source移到target
        System.out.println("移动盘子 " + n + " 从 " + source + " 到 " + target);

        // 将n-1个盘子从auxiliary移到target，借助source
        hanoi(n - 1, auxiliary, source, target);
    }

    public static void main(String[] args) {
        int n = 3; // 盘子数量
        hanoi(n, 'A', 'B', 'C');
    }
}
