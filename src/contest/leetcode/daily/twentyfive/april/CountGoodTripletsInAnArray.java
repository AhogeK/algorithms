package contest.leetcode.daily.twentyfive.april;

/**
 * @author AhogeK
 * @since 2025-04-15 18:59:47
 */
public class CountGoodTripletsInAnArray {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // 记录nums1中每个值的位置
        int[] p = new int[n];

        // 建立nums1中值到位置的映射
        for (int i = 0; i < n; i++) p[nums1[i]] = i;

        long ans = 0;
        FenwickTree t = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            // 当前值在nums1中的位置
            int y = p[nums2[i]];
            // 已遍历的数中比y小的数量
            int less = t.pre(y);
            // 计算比y大的数的数量
            // (n - 1 - y) 是 nums1 中比y大的总数
            // (i - less) 是已遍历的数中比 y 大的数量
            int greater = (n - 1 - y) - (i - less);
            ans += (long) less * greater;
            // 标记 y 已被访问
            t.update(y + 1, 1);
        }
        return ans;
    }
}

class FenwickTree {
    // 树状数组
    private final int[] tree;

    public FenwickTree(int n) {
        // 1-based索引
        tree = new int[n + 1];
    }

    // 更新操作，将位置i的值增加val
    public void update(int i, int val) {
        for (; i < tree.length; i += i & -i) {
            tree[i] += val;
        }
    }

    // 查询操作求a[1..i]的前缀和
    public int pre(int i) {
        int res = 0;
        for (; i > 0; i &= i - 1) {
            res += tree[i];
        }
        return res;
    }
}


