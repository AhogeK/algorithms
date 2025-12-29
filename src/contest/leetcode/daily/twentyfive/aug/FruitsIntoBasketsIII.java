package contest.leetcode.daily.twentyfive.aug;

/**
 * 3479. 水果成篮 III
 *
 * @author AhogeK
 * @since 2025-08-06 23:53:17
 */
public class FruitsIntoBasketsIII {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        SegTree st = build(0, n - 1, baskets);
        int ans = 0;

        for (int fruit : fruits) {
            if (st.max < fruit) {
                ans++;
            } else {
                modify(st, fruit);
            }
        }
        return ans;
    }

    SegTree build(int l, int r, int[] baskets) {
        SegTree st = new SegTree(0);
        if (l == r) {
            return new SegTree(baskets[l]);
        } else {
            int m = (l + r) / 2;
            st.l = build(l, m, baskets);
            st.r = build(m + 1, r, baskets);
        }
        st.max = Math.max(st.l.max, st.r.max);
        return st;
    }

    void modify(SegTree st, int fruit) {
        if (st.l == null && st.r == null) {
            st.max = 0;
            return;
        }
        if (st.l.max >= fruit) {
            modify(st.l, fruit);
        } else {
            modify(st.r, fruit);
        }
        st.max = Math.max(st.l.max, st.r.max);
    }

    static class SegTree {
        SegTree l;
        SegTree r;
        int max;

        public SegTree(int max) {
            this.max = max;
        }
    }
}
