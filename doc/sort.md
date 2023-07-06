<!-- TOC -->
* [基础排序算法](#基础排序算法)
  * [选择排序](#选择排序)
    * [相关阅读](#相关阅读)
<!-- TOC -->

# 基础排序算法

排序算法包括如「选择排序」「冒泡排序」「插入排序」（插入排序可以作为高级排序的子过程，是一个需要重点学习的排序算法）
「希尔排序」（希尔排序是插入排序的优化）「归并排序」（理解递归，也是重点学习的排序算法）「快速排序」(
同样是理解递归，重点学习的排序算法)
「堆排序」（选择排序的优化，也是重点学习的排序算法）

除此之外还有非比较排序，包括「计数排序」「基数排序」「桶排序」

> 虽然现在计算机编程语言基本都带了排序的库，但学习理解经典的排序的算法可以帮助我们更好的理解算法的思想，以及如何优化算法。

在基础排序算法中，我们可以学到的算法思想包括「分治」「贪心」「假设修正法」「打擂台」「哨兵」「双指针」「循环不变量」

在排序算法的学习中，也能进一步对时间复杂度的理解

这里有个关于数组的知识点，数组在内存中是连续存储的，我们可以通过下标直接访问，我们可以以O(1)的复杂度访问到元素，而这个特性叫作随机访问

## 选择排序

基本思想：从小到大依次选择出最小元素，通过交换达到选择排序的目的

特点：运行时间与输入无关，交换次数最少

思想：减而治之，贪心算法

技巧：假设修正法（打擂台算法）

循环不变式：证明贪心算法的依据

优化：堆排序

*参考案例*

```java
public class Solution {

    // 「力扣」第 912 题：排序数组

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 最后一轮只有一个元素，一定是最大的元素，因此写 i < len - 1
        for (int i = 0; i < len - 1; i++) {
            // 在 [i + 1, len - 1] 区间里选择最小的元素的下标
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
        }
        return nums;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
```

时间复杂度：O(n^2) 等差数列公式得出 (N−1)+(N−2)+⋯+1 = 1/2N(N-1) -> 1/2N(N-1) + (N-1) -> O(N^2)

$$\displaystyle \sum _{i=1}^{n-1}i={\frac {(n-1)+1}{2}}(n-1)={\frac {1}{2}}n(n-1)={\frac {1}{2}}(n^{2}-n)$$

空间复杂度：O(1) 原地排序

* [「力扣」1. 两数之和 （暴力求解）](https://leetcode.cn/problems/two-sum)

[TwoSum.java](src/sort/leetcode/select/TwoSum.java)

```java
package sort.leetcode;

/**
 * <a href="https://leetcode.cn/problems/two-sum">
 * 1. 两数之和 (选择排序思维，暴力求解)
 * </a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-28 11:21:09
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((nums[i] + nums[j]) == target) return new int[]{i, j};
            }
        }
        return new int[]{};
    }
}
```

* [「力扣」11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water)

[ContainerWithMostWater.java](src/sort/leetcode/select/ContainerWithMostWater.java)

```java
package sort.leetcode.select;

/**
 * <a href="https://leetcode.cn/problems/container-with-most-water">
 * 11. 盛最多水的容器 (双指针)
 * </a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-28 14:27:53
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = Integer.MIN_VALUE;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return ans;
    }
}
```

* [使用冒泡排序完成「力扣」第 912 题：排序数组](https://leetcode-cn.com/problems/sort-an-array/)

[BubbleSort.java](src/sort/leetcode/select/BubbleSort.java)

```java
package sort.leetcode.select;

/**
 * 使用冒泡排序完成 「力扣」912. 排序数组
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-29 20:55:40
 */
public class BubbleSort {

    public int[] sortArray(int[] nums) {
        int size = nums.length;

        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }

        return nums;
    }
}
```

**上面的冒泡排序使用了优化，如果已经排序好了会提前终止算法**

### 相关阅读

* [Selection Sort Algorithm](https://www.programiz.com/dsa/selection-sort)
* [Selection sort Wiki](https://en.wikipedia.org/wiki/Selection_sort)
* [Bubble Sort](https://www.programiz.com/dsa/bubble-sort)
* [Bubble sort Wiki](https://en.wikipedia.org/wiki/Bubble_sort)