package daily.twentyfive.aug;

/**
 * 904. 水果成篮
 *
 * @author AhogeK
 * @since 2025-08-04 21:03:39
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int count = 0;
        int[] hash = new int[n];
        int max = 0;
        for (int left = 0, right = 0; right < n; right++) {
            int num = fruits[right];
            if (hash[num]++ == 0) count++;
            while (count >= 3)
                if (--hash[fruits[left++]] == 0)
                    count--;
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
