<!-- TOC -->
* [高级排序算法](#高级排序算法)
  * [归并排序](#归并排序)
    * [「力扣」第 88 题：合并两个有序数组](#力扣第-88-题合并两个有序数组)
      * [解题思路：从后向前归并](#解题思路从后向前归并)
        * [核心思路](#核心思路)
    * [「力扣」第 189 题：旋转数组](#力扣第-189-题旋转数组)
      * [归并思路与三次反转法](#归并思路与三次反转法)
        * [工作原理分析](#工作原理分析)
    * [「自底向上」的「归并排序」](#自底向上的归并排序)
    * [使用「分治思想」完成「力扣」第 153 题：寻找旋转排序数组中的最小值](#使用分治思想完成力扣第-153-题寻找旋转排序数组中的最小值)
      * [为什么用二分查找？](#为什么用二分查找)
    * [使用「分治思想」完成「力扣」第 154 题：寻找旋转排序数组中的最小值 II](#使用分治思想完成力扣第-154-题寻找旋转排序数组中的最小值-ii)
      * [分治思想解法](#分治思想解法)
    * [「递归」与「分治思想」｜汉诺塔问题的实现](#递归与分治思想汉诺塔问题的实现)
      * [递归的本质](#递归的本质)
      * [分治思想](#分治思想)
      * [递归与分治的关系](#递归与分治的关系)
      * [经典分治算法示例](#经典分治算法示例)
      * [汉诺塔问题](#汉诺塔问题)
        * [问题描述](#问题描述)
        * [分治思路](#分治思路)
        * [汉诺塔的数学分析](#汉诺塔的数学分析)
        * [时间与空间复杂度](#时间与空间复杂度)
        * [分治与递归的优缺点](#分治与递归的优缺点)
          * [优点](#优点)
          * [缺点](#缺点)
  * [归并排序的优化](#归并排序的优化)
    * [代码编写](#代码编写)
      * [「力扣」《剑指 Offer》第 51 题：数组中的逆序对 (对应493：翻转对，但略有不同)](#力扣剑指-offer第-51-题数组中的逆序对-对应493翻转对但略有不同)
        * [翻转对的准确定义](#翻转对的准确定义)
        * [合并过程](#合并过程)
        * [第二步：合并单个元素](#第二步合并单个元素)
        * [第三步：合并更大子数组](#第三步合并更大子数组)
        * [计数](#计数)
<!-- TOC -->

# 高级排序算法

## 归并排序

[../src/sort/MergeSort.java](../src/sort/MergeSort.java)

```java
public class MergeSort {

    public void sort(int[] arr) {
        int len = arr.length;
        mergeSort(arr, 0, len - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left == right) return;

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        mergeOfTwoSortedArray(nums, left, mid, right);
    }

    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right) {
        int len = right - left + 1;
        int[] temp = new int[len];

        for (int i = 0; i < len; i++)
            temp[i] = nums[left + i];

        int i = 0;
        int j = mid - left + 1;
        for (int k = 0; k < len; k++) {
            if (i == mid - left + 1) {
                nums[left + k] = temp[j];
                j++;
            } else if (j == right - left + 1) {
                nums[left + k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[left + k] = temp[i];
                i++;
            } else {
                nums[left + k] = temp[j];
                j++;
            }
        }
    }
}
```

假设我们有 $n$ 个元素的数组，归并排序会进行如下分解：

* 第1层：1个大小为 $n$ 的问题
* 第2层：2个大小为 $\frac{n}{2}$ 的问题
* 第3层：4个大小为 $\frac{n}{4}$ 的问题
* ...
* 第 $h$ 层： $2^{h-1}$ 个大小为 $\frac{n}{2^{h-1}}$ 的问题

当分解到最底层时，每个子数组只有1个元素，也就是 $\frac{n}{2^{h-1}} = 1$

求解这个等式：

$\frac{n}{2^{h-1}} = 1$

$n = 2^{h-1}$

$h-1 = \log_2(n)$

$h = \log_2(n) + 1$

这意味着递归树的高度为 $\log_2(n) + 1$。

归并排序每层的合并操作是线性的 $O(n)$，共有 $\log_2(n)$ 层，因此总时间复杂度为 $O(n \log n)$。

|      | 最坏时间复杂度       | 平均时间复杂度                            | 最好时间复杂度       | 额外空间复杂度 | 稳定性 | 是否原地排序 |
|------|---------------|------------------------------------|---------------|---------|-----|--------|
| 选择排序 | $O(N^2)$      | $O(N^2)$                           | $O(N^2)$      | $O(1)$  | 不稳定 | 原地排序   |
| 冒泡排序 | $O(N^2)$      | $O(N^2)$                           | $O(N)$        | $O(1)$  | 稳定  | 原地排序   |
| 插入排序 | $O(N^2)$      | $O(N^2)$                           | $O(N)$        | $O(1)$  | 稳定  | 原地排序   |
| 希尔排序 | $O(N^2)$      | $O(n^{1.25}) \sim O(1.6 n^{1.25})$ | (没有相关研究)      | $O(1)$  | 不稳定 | 原地排序   |
| 归并排序 | $O(N \log N)$ | $O(N \log N)$                      | $O(N \log N)$ | $O(N)$  | 稳定  | 非原地排序  |

### [「力扣」第 88 题：合并两个有序数组](https://leetcode.cn/problems/merge-sorted-array/)

[../src/sort/leetcode/MergeSortedArray.java](../src/sort/leetcode/MergeSortedArray.java)

```java
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 初始化三个指针
        int p1 = m - 1; // nums1有效元素末尾
        int p2 = n - 1; // nums2末尾
        int p = m + n - 1; // nums1数组末尾

        // 从后往前填充 nums1
        while (p1 >= 0 && p2 >= 0) {
            // 取两个数组中较大的放在末尾
            if (nums1[p1] > nums2[p2]) nums1[p] = nums1[p1--];
            else nums1[p] = nums2[p2--];
            p--;
        }

        // 如果nums2还有剩余元素，需要复制到nums1中
        while (p2 >= 0) nums1[p--] = nums2[p2--];
    }
}
```

#### 解题思路：从后向前归并

虽然传统归并排序需要辅助数组，但此题有一个特点：`nums1` 后半部分是空的。我们可以利用这一特点，**从后向前**填充元素，避免覆盖未处理的数据。

##### 核心思路

1. 使用三个指针：
    * `p1`：指向 `nums1` 有效元素的末尾
    * `p2`：指向 `nums2` 的末尾
    * `p`：指向 `nums1` 待填充位置（从后往前）
2. 比较两个指针指向的元素，将较大者放入 `nums1` 的末尾，然后将对应指针前移
3. 处理可能的剩余元素

### [「力扣」第 189 题：旋转数组](https://leetcode.cn/problems/rotate-array)

[../src/sort/leetcode/RotateArray.java](../src/sort/leetcode/RotateArray.java)

```java
public class RotateArray {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
```

#### 归并思路与三次反转法

虽然题目提示用归并排序的思路，但我们可以通过"三次反转"来实现这个功能，这种方法实际上与原地归并排序的思想有相似之处，但更简单高效。

三次反转法的步骤如下：

1. 反转整个数组
2. 反转前 $k$ 个元素
3. 反转后 $n-k$ 个元素

##### 工作原理分析

以 $[0,1,2,3,4]$ 和 $k=2$ 为例：

1. 反转整个数组： $[4,3,2,1,0]$
2. 反转前 $k$ 个元素（前2个）： $[3,4,2,1,0]$
3. 反转后 $n-k$ 个元素（后3个）： $[3,4,0,1,2]$

我们可以发现数组已经正确旋转。这种方法背后的原理可以理解为"负负得正"：先反转整个数组相当于将数组"翻倒"
，然后分别对前后部分再次反转，使它们"翻正"，但位置互换了。

### 「自底向上」的「归并排序」

[../src/sort/BottomUpMergesort.java](../src/sort/BottomUpMergesort.java)

```java
 public void sortArray(int[] nums) {
    int n = nums.length;
    int[] temp = new int[n];

    // 子数组大小从1开始，每次翻倍
    for (int size = 1; size < n; size *= 2) {
        // 对于当前size，合并相邻的子数组
        for (int leftStart = 0; leftStart < n - size; leftStart += 2 * size) {
            int mid = leftStart + size - 1;
            int rightEnd = Math.min(leftStart + 2 * size - 1, n - 1);
            merge(nums, temp, leftStart, mid, rightEnd);
        }
    }
}

// 合并两个已排序的子数组
private void merge(int[] arr, int[] temp, int left, int mid, int right) {
    // 复制到辅助数组
    for (int i = left; i <= right; i++) temp[i] = arr[i];

    int i = left; // 左边数组的起始索引
    int j = mid + 1; // 右边数组的起始索引
    int k = left; // 原始数组的当前索引

    // 合并两个子数组
    while (i <= mid && j <= right) {
        if (temp[i] <= temp[j]) arr[k++] = temp[i++];
        else arr[k++] = temp[j++];
    }

    // 复制左边子数组的剩余的元素（右边数组剩余元素已经在正确的位置）
    while (i <= mid) arr[k++] = temp[i++];
}
```

自底向上的归并排序采用迭代方式，不使用递归：

1. 将数组视为n个长度为1的子数组（每个元素自成一个子数组）
2. 迭代地将相邻的子数组两两合并，每次迭代子数组长度翻倍
3. 重复合并直到得到一个完整排序的数组

### 使用「分治思想」完成「力扣」第 153 题：[寻找旋转排序数组中的最小值](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/)

[../src/sort/leetcode/FindMinimumInRotatedSortedArray.java](../src/sort/leetcode/FindMinimumInRotatedSortedArray.java)

```java
 public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
        int mid = left + (right - left) / 2;

        // 与有边界元素比较
        if (nums[mid] > nums[right]) {
            // 最小值在又半部分
            left = mid + 1;
        } else {
            // 最小值在左半部分（包括mid）
            right = mid;
        }
    }

    // 当left==right时，即找到最小值
    return nums[left];
}
```

分治思想的核心是将问题分解为更小的子问题，解决子问题后再合并结果。在这道题中，我们可以使用二分查找来实现分治：

1. 将数组一分为二
2. 判断最小值在哪个半区
3. 在包含最小值的半区继续二分查找

#### 为什么用二分查找？

旋转排序数组虽然不是完全有序的，但具有特殊结构：

* 数组被分成两个有序的子数组
* 前一部分的元素都大于或等于后一部分的元素
* 最小值是分界点

这种特殊结构适合用二分查找。

### 使用「分治思想」完成「力扣」第 154 题：[寻找旋转排序数组中的最小值 II](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii)

[../src/sort/leetcode/FindMinimumInRotatedArrayII.java](../src/sort/leetcode/FindMinimumInRotatedArrayII.java)

```java
public class FindMinimumInRotatedArrayII {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // 最小值在右半部分
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // 最小值在左半部分（包括mid）
                right = mid;
            } else {
                // nums[mid] == nums[right]，无法确定方向
                // 保守地缩小搜索范围
                right--;
            }
        }

        return nums[left];
    }
}
```

#### 分治思想解法

我们同样可以使用二分查找的分治策略，但需要处理重复元素带来的复杂性：

1. 将数组一分为二
2. 判断最小值在哪个半区
3. 在包含最小值的半区继续二分查找

关键在于如何处理重复元素的情况。

### 「递归」与「分治思想」｜汉诺塔问题的实现

#### 递归的本质

递归是一种解决问题的方法，它通过函数调用自身来解决问题的更小实例。递归具有两个基本特性：

1. **基本情形（终止条件）**：当问题足够小，可以直接求解的情况
2. **递归关系**：将原问题分解为更小的子问题，并通过解决这些子问题来解决原问题

#### 分治思想

分治（Divide and Conquer）是一种算法设计范式，它将一个复杂问题分解为若干个规模较小但类似的子问题，递归解决这些子问题，然后将结果合并以得到原问题的解。分治策略包含三个步骤：

1. **分解（Divide）**：将原问题分解为若干个规模较小、相互独立、与原问题形式相同的子问题
2. **解决（Conquer）**：递归地解决各个子问题
3. **合并（Combine）**：将子问题的解组合成原问题的解

#### 递归与分治的关系

* **递归**是一种编程技术或函数实现方式
* **分治**是一种问题解决的策略或思想
* 分治算法通常使用递归来实现，但不是所有的递归都是分治法
* 分治强调问题的分解和结果的合并，而递归强调的是函数调用自身的机制

#### 经典分治算法示例

1. **归并排序**：将数组分成两半，分别排序，然后合并
2. **快速排序**：选择一个基准元素，将数组分为两部分，分别排序
3. **二分查找**：将搜索区间分成两半，决定在哪一半继续搜索
4. **大整数乘法**（如Karatsuba算法）
5. **汉诺塔问题**：将问题分解为移动较小的盘子组

#### 汉诺塔问题

##### 问题描述

汉诺塔问题是递归的经典应用：

* 有三根柱子A、B和C
* A柱上有n个大小不等的圆盘，从下到上按照从大到小的顺序叠放
* 目标是将所有圆盘从A柱移动到C柱
* 每次只能移动一个圆盘
* 任何时刻都不能将大圆盘放在小圆盘上面

##### 分治思路

解决汉诺塔问题的关键是将其分解为更小的问题：

1. 将前 n-1 个盘子从起始柱（A）移到辅助柱（B）
2. 将第 n 个盘子（最大的）从起始柱（A）移到目标柱（C）
3. 将前 n-1 个盘子从辅助柱（B）移到目标柱（C）

```java
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
```

##### 汉诺塔的数学分析

对于n个盘子，最少需要移动 $2^n - 1$ 次：

* n=1时，需要移动1次： $2^1-1=1$
* n=2时，需要移动3次： $2^2-1=3$
* n=3时，需要移动7次： $2^3-1=7$

##### 时间与空间复杂度

* **时间复杂度**： $O(2^n)$ - 因为需要移动 $2^n-1$ 次盘子
* **空间复杂度**： $O(n)$ - 递归调用栈的最大深度为n

##### 分治与递归的优缺点

###### 优点

1. 问题分解使复杂问题更易于理解和解决
2. 许多自然问题适合分治方法
3. 通常能产生高效算法（如归并排序、快速排序）
4. 代码通常简洁、易于理解

###### 缺点

1. 有时存在大量重复计算（可通过记忆化搜索或动态规划解决）
2. 递归调用有开销（系统栈空间）
3. 对于小规模问题，递归可能不如迭代高效
4. 可能导致栈溢出（如果递归深度过大）

## 归并排序的优化

1. 在小区间里使用插入排序 （超参数，目前Java语言库函数定义为47）
2. 如果前有序数组与后有序数组已经有序，无需归并
3. 全局使用一个临时数组用于归并

### 代码编写

```java
public class Solution {

    /**
     * 列表大小等于或小于该大小，将优先于 mergesort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 47;

    public int[] sortArray(int[] nums) {
        int len = nums.length;

        // 优化 3：全局使用一份临时数组
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }


    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        // 优化 1：小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        // 优化 2：数组已经有序的情况下，不再合并
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }


    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 注意：这里一定要写成 <=，否则就变成了非稳定排序
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
    }

    /**
     * 对数组给定的部分使用插入排序
     *
     * @param arr   给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i;
            while (j > left && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
```

#### 「力扣」《剑指 Offer》第 51 题：数组中的逆序对 (对应[493：翻转对](https://leetcode.cn/problems/reverse-pairs)，但略有不同)

[../src/sort/leetcode/ReversePairs.java](../src/sort/leetcode/ReversePairs.java)

```java
public class ReversePairs {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    private int mergeSort(int[] nums, int left, int right, int[] temp) {
        // 基本情况：单个元素没有翻转对
        if (left >= right) return 0;

        // 分治：将数组分成两半
        int mid = left + (right - left) / 2;

        // 递归解决左右两半，并累加翻转对数量
        int count = mergeSort(nums, left, mid, temp) +
                mergeSort(nums, mid + 1, right, temp);

        // 计算跨越左右两部分的翻转对
        count += countCrossPairs(nums, left, mid, right);

        // 合并两个有序的子数组
        merge(nums, left, mid, right, temp);

        return count;
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        // 复制到临时数组
        for (int i = left; i <= right; i++) temp[i] = nums[i];

        // 合并回原数组
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                nums[k] = temp[j++];
            } else if (j > right) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }
    }

    private int countCrossPairs(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        // 对于左半部分的每个元素
        for (int i = left; i <= mid; i++) {
            // 找出右半部分的每个元素
            while (j <= right && nums[i] > 2L * nums[j]) j++;
            // j - 1 是最后一个满足条件的位置
            // 从 mid + 1 到 j - 1 的所有元素都能与 nums[i] 构成翻转对
            count += (j - (mid + 1));
        }
        return count;
    }
}
```

##### 翻转对的准确定义

首先明确翻转对的定义：如果 `i < j` 且 `nums[i] > 2 * nums[j]`，则 `(i, j)` 是一个翻转对。

##### 合并过程

对于数组 `[1,3,2,3,1]`：

##### 第二步：合并单个元素

1. 合并 `[1]` 和 `[3]`：
    * 检查：`1 > 2*3 = 6`? 不满足，无翻转对
2. 合并 `[2]` 和 `[3]`：
    * 检查：`2 > 2*3 = 6`? 不满足，无翻转对
3. 合并 `[2,3]` 和 `[1]`：
    * 对于 `2`：`2 > 2*1 = 2`? **等于不满足**，不是翻转对
    * 对于 `3`：`3 > 2*1 = 2`? 满足，count+1 (原索引3比4小)

##### 第三步：合并更大子数组

* 合并 `[1,3]` 和 `[1,2,3]`：
    * 对于 `1`：`1 > 2*1 = 2`? 不满足
    * 对于 `3`：`3 > 2*1 = 2`? 满足，count+1 (原索引1比4小)
    * 对后面的元素无满足条件的

##### 计数

从正确的计算中，我们只有两个翻转对：

1. `(3,4)`：`nums[3]=3 > 2*nums[4]=2`
2. `(1,4)`：`nums[1]=3 > 2*nums[4]=2`

---

[返回](../README.md)