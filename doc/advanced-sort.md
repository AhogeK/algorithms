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
      * [力扣 - 315. 计算右侧小于当前元素的个数](#力扣---315-计算右侧小于当前元素的个数)
      * [「索引数组」技巧](#索引数组技巧)
  * [快速排序](#快速排序)
    * [理解什么是划分（partition）](#理解什么是划分partition)
      * [划分的基本步骤](#划分的基本步骤)
      * [划分的工作原理](#划分的工作原理)
      * [划分的两种常见实现方案](#划分的两种常见实现方案)
        * [1. Hoare划分方案](#1-hoare划分方案)
        * [2. Lomuto划分方案](#2-lomuto划分方案)
    * [循环不变量](#循环不变量)
      * [快速排序划分函数中的循环不变量](#快速排序划分函数中的循环不变量)
        * [Lomuto 划分方案的循环不变量](#lomuto-划分方案的循环不变量)
        * [Hoare 划分方案的循环不变量](#hoare-划分方案的循环不变量)
      * [如何证明循环不变量](#如何证明循环不变量)
    * [代码实现(Lomuto 划分方案)](#代码实现lomuto-划分方案)
    * [快速排序的最坏时间复杂度为 $O(N^2)$](#快速排序的最坏时间复杂度为-on2)
      * [「快速排序」比一般排序算法快的原因](#快速排序比一般排序算法快的原因)
        * [平均时间复杂度](#平均时间复杂度)
        * [空间复杂度优势](#空间复杂度优势)
        * [随机选择基准值](#随机选择基准值)
        * [单次划分的最坏情况概率](#单次划分的最坏情况概率)
        * [连续出现最坏情况的概率](#连续出现最坏情况的概率)
    * [时间复杂度与空间复杂度](#时间复杂度与空间复杂度)
      * [时间复杂度分析](#时间复杂度分析)
      * [空间复杂度分析](#空间复杂度分析)
      * [原地排序与空间复杂度的区别](#原地排序与空间复杂度的区别)
    * [练习](#练习)
      * [使用「三数取中法」选择 partition 过程的切分元素](#使用三数取中法选择-partition-过程的切分元素)
      * [自行编写测试用例，完成下面的实验：在输入数据接近有序的时候，没有实现「随机选择切分元素」的快速排序比归并排序慢很多](#自行编写测试用例完成下面的实验在输入数据接近有序的时候没有实现随机选择切分元素的快速排序比归并排序慢很多)
      * [完成「力扣」第 215 题：数组中的第 K 个最大元素](#完成力扣第-215-题数组中的第-k-个最大元素)
        * [核心思想](#核心思想)
        * [算法细节与优化](#算法细节与优化)
        * [时间复杂度分析](#时间复杂度分析-1)
      * [完成「力扣」第 26 题：删除排序数组中的重复项](#完成力扣第-26-题删除排序数组中的重复项)
        * [算法步骤](#算法步骤)
        * [复杂度分析](#复杂度分析)
      * [完成「力扣」第 80 题：删除排序数组中的重复项 II](#完成力扣第-80-题删除排序数组中的重复项-ii)
        * [循环不变量定义](#循环不变量定义)
        * [循环不变量的维护](#循环不变量的维护)
        * [算法步骤](#算法步骤-1)
        * [复杂度分析](#复杂度分析-1)
    * [指针对撞的快速排序](#指针对撞的快速排序)
      * [指针对撞分区步骤](#指针对撞分区步骤)
      * [算法的关键点](#算法的关键点)
    * [练习-2](#练习-2)
      * [自行编写测试用例，完成下面的实验：在输入数据有大量重复元素的时候，这一节介绍的快速排序能起到优化的效果](#自行编写测试用例完成下面的实验在输入数据有大量重复元素的时候这一节介绍的快速排序能起到优化的效果)
    * [三向切分的快速排序](#三向切分的快速排序)
      * [基本原理](#基本原理)
      * [三向划分的核心机制](#三向划分的核心机制)
      * [三向切分的优势](#三向切分的优势)
      * [算法复杂度](#算法复杂度)
    * [练习-3](#练习-3)
      * [自行编写测试用例，完成下面的实验：在输入数据有大量重复元素的时候，这一节介绍的三向切分的快速排序能起到优化的效果](#自行编写测试用例完成下面的实验在输入数据有大量重复元素的时候这一节介绍的三向切分的快速排序能起到优化的效果)
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

#### 力扣 - [315. 计算右侧小于当前元素的个数](https://leetcode.cn/problems/count-of-smaller-numbers-after-self)

[../src/sort/leetcode/CountOfSmallerNumbersAfterSelf.java](../src/sort/leetcode/CountOfSmallerNumbersAfterSelf.java)

```java
public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();

        int[] index = new int[len]; // 存储原始索引
        int[] temp = new int[len];  // 归并排序临时数组
        int[] ans = new int[len];   // 存储每个元素对应的计数结果

        // 初始化索引数组用于间接排序
        for (int i = 0; i < len; i++) index[i] = i;

        // 执行归并排序，同时统计计数
        mergeSorted(nums, 0, len - 1, temp, index, ans);

        for (int count : ans) res.add(count);
        return res;
    }

    private void mergeSorted(int[] nums, int left, int right, int[] temp, int[] index, int[] ans) {
        // 递归终止条件
        if (right == left) return;

        // 计算区间中点，分治处理
        int mid = left + (right - left) / 2;
        mergeSorted(nums, left, mid, temp, index, ans);
        mergeSorted(nums, mid + 1, right, temp, index, ans);

        // 如果区间已经有序，可以跳过合并
        // 比较左半部分最大值与右半部分最小值
        if (nums[index[mid]] <= nums[index[mid + 1]]) return; // 已经有序无序合并

        // 合并两个子区间，并统计右侧小于当前元素数量
        mergeArrays(nums, left, mid, right, temp, index, ans);
    }

    private void mergeArrays(int[] nums, int left, int mid, int right, int[] temp, int[] index, int[] ans) {
        // 复制索引数组到临时数组，用于合并过程
        System.arraycopy(index, left, temp, left, right - left + 1);

        int i = left; // 左子数组的当前处理位置
        int j = mid + 1; // 右子数组当前处理位置

        // 合并两个有序子数组
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                // 左子数组已处理完，直接取右子数组的元素
                index[k] = temp[j++];
            } else if (j > right) {
                // 右子数组已处理完，取左子数组的元素并更新计数
                index[k] = temp[i];
                // 右子数组全部元素已处理，且都合并到左侧元素之前
                // j 指向右子数组中下一个要处理的元素， mid + 1 表示右子数组起始，相减得到元素个数
                ans[temp[i]] += j - mid - 1;
                i++;
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                // 左子数组当前元素 <= 右子数组当前元素
                index[k] = temp[i];
                // 统计右子数组中已处理的元素个数（它们都小于当前元素）
                ans[temp[i]] += j - mid - 1;
                i++;
            } else {
                // 右子数组当前元素 < 左子数组当前元素
                index[k] = temp[j++];
                // 无需更新计数，因为我们只关心"右侧小于当前元素"的数量
            }
        }
    }
}
```

#### 「索引数组」技巧

1. 什么是索引数组技巧

   **索引数组技巧**（Index Array Technique）是一种优化算法的方法，特别是在排序问题中，它的核心思想是：
   > "不直接对原始数据进行排序，而是创建并操作一个存储原始数据索引的辅助数组，通过这个索引数组间接地表示排序结果。"
2. 索引数组的基本实现

    ```java
    class IndexArrayTechnique {
   
        public static void main(String[] args) {
            // 原始数组
            int[] nums = {10, 5, 30, 12};

            // 创建索引数组 - 初始为[0,1,2,3]
            int[] index = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                index[i] = i;
            }

            // 通过索引数组访问原数组
            // 例如访问nums[index[0]] = nums[0] = 10
   
            // 假设排序后index变为[1,3,0,2]
            // 说明排序后的顺序是nums[1],nums[3],nums[0],nums[2]
            // 即[5,12,10,30]
            // 而原始index[0]=1表示，排序后第0个位置的元素原来在位置1
   
            // 交换数据时
            // 传统方法: swap(nums[i], nums[j]);  // 可能移动大量数据
            // 索引方法: swap(index[i], index[j]); // 只移动索引（整数）
   
            // 同时维护多种排序顺序
            int[] indexByValue = new int[n];   // 按值排序的索引
            int[] indexByWeight = new int[n];  // 按权重排序的索引
        }
    }
    ```

*索引数组技巧是算法优化中一个强大而常用的工具，掌握它不仅能提高特定问题的解决效率，更能帮助我们以不同的思维方式看待数据操作和算法设计。*

## 快速排序

> 「快速排序：算法天才的简洁馈赠」快速排序（Quicksort）由英国计算机科学家**托尼·霍尔**（Tony
> Hoare）在1959年开发，并于1961年正式发表。这一发明有着有趣的起源故事：
> 霍尔当时是莫斯科国立大学的访问学生，正为英国国家物理实验室（National Physical
> Laboratory）的机器翻译项目工作。他的任务是需要对俄语句子中的单词进行排序，然后在按字母顺序排列的磁带上查找俄英词典。
> 最初，霍尔考虑使用插入排序，但很快意识到这种方法效率太低。在寻找更高效算法的过程中，他灵光一现，开发出了快速排序的基本思想。

快速排序是一种使用分治策略的高效通用排序算法：

1. 选择一个"枢轴"（pivot）元素
2. 将其他元素分为两个子数组：小于枢轴的元素和大于枢轴的元素
3. 递归地对这两个子数组进行排序

对于随机数据，快速排序的平均时间复杂度为 $O(n log n)$ ，略优于归并排序和堆排序，特别是在大型数据集上。

快速排序的发明充分展示了如何从实际问题中抽象出优雅解决方案的过程，也是计算机科学中算法设计的经典案例。

### 理解什么是划分（partition）

划分（Partition）是快速排序算法的核心操作，它决定了快速排序的效率和正确性。本质上，划分操作就是将一个数组重新排列，以某个元素（称为"
基准值"或"枢轴值"pivot）为分界点，使得：

1. 基准值放在其最终应该在的位置
2. 所有小于基准值的元素都在基准值的左边
3. 所有大于基准值的元素都在基准值的右边

#### 划分的基本步骤

1. 选择一个元素作为基准值（pivot）
2. 从数组的两端开始向中间扫描
3. 找到左边大于基准值的元素和右边小于基准值的元素，交换它们
4. 重复步骤3，直到左右指针相遇
5. 将基准值放到最终位置（通常是与左子数组的最右边元素交换）

#### 划分的工作原理

假设我们有以下数组需要排序：`[10, 7, 8, 9, 1, 5]`

1. 选择基准值：通常选择第一个元素（这里是10）作为基准值

2. 初始化左指针指向第一个元素的下一个位置，右指针指向最后一个元素

3. 划分过程：

    * 左指针向右移动，直到找到大于等于基准值的元素
    * 右指针向左移动，直到找到小于等于基准值的元素
    * 如果左指针小于右指针，交换这两个元素；否则结束

4. 最后，将基准值与右指针指向的元素交换位置

#### 划分的两种常见实现方案

##### 1. Hoare划分方案

这是Tony Hoare（快速排序的发明者）最初设计的方案，使用两个指针从数组两端向中间移动。

##### 2. Lomuto划分方案

这种方案使用单向扫描，维护一个小于基准值区域的边界，然后将基准值放在正确的位置。

### 循环不变量

#### 快速排序划分函数中的循环不变量

以经典的划分算法为例，通常具有以下循环不变量：

##### Lomuto 划分方案的循环不变量

对于每次循环迭代的开始：

1. 对于所有 $p \leq k \leq i$ ，有 $A[k] \leq x$（其中 x 是基准值）
2. 对于所有 $i+1 \leq k \leq j-1$ ，有 $A[k] > x$
3. $A[r] = x$（基准元素保存在最右侧）

这里，p 是子数组的起始位置，r 是结束位置，i 是已处理的小于等于基准值的元素的最后位置，j 是当前正在检查的元素位置。

##### Hoare 划分方案的循环不变量

对于每次外部循环迭代的开始：

1. 对于所有 $p \leq k \leq i$ ，有 $A[k] \leq x$
2. 对于所有 $j \leq k \leq r$ ，有 $A[k] \geq x$

这里，i 和 j 是从数组两端向中间移动的指针。

#### 如何证明循环不变量

证明循环不变量需要遵循以下三个步骤：

1. **初始化（Initialization）**：证明循环开始前循环不变量为真

    * 例如，在 Lomuto 方案中，初始时 i = p-1，此时条件 1 为真（因为区间为空）
    * 初始时 j = p，条件 2 也为真（因为区间为空）

2. **保持（Maintenance）**：证明每次迭代后循环不变量仍然为真

    * 例如，在 Lomuto 方案中，如果 A\[j] ≤ x，我们增加 i 并交换 A\[i] 和 A\[j]，保持条件 1 和 2 成立

3. **终止（Termination）**：证明循环结束时，循环不变量能帮助我们证明算法的正确性

    * 例如，在 Lomuto 方案中，循环结束时 j = r，最后将 A\[i+1] 与 A\[r] 交换，使基准值处于正确位置

### 代码实现(Lomuto 划分方案)

[../src/sort/QuickSort.java](../src/sort/QuickSort.java)

```java
public class QuickSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int p = partition(nums, left, right);

        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        // 循环不变量：lt 即 less than
        // [left + 1, lt] < pivot
        // [lt + 1, i) >= pivot
        int lt = left;
        // 注意这里取等号
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 交换当前元素与lt的位置
                lt++;
                swap(nums, i, lt);
            }
        }
        // 最后这一步要记得交换切分元素
        swap(nums, left, lt);
        return lt;
    }
}
```

*注意：**越有序**的数组，快速排序的消耗时间就越长，与插入排序相反*

### 快速排序的最坏时间复杂度为 $O(N^2)$

以一个升序排列的数组为例：`[1, 2, 3, 4, 5]`

1. **极度不平衡的划分**：

    * 选择第一个元素 1 作为基准值
    * 划分后，没有元素比基准值小（左子数组为空）
    * 所有其他元素 `[2, 3, 4, 5]` 都在基准值右侧

2. **递归深度退化**：

    * 对右子数组 `[2, 3, 4, 5]` 递归
    * 同样选择第一个元素 2 作为基准值
    * 又得到一个空的左子数组和一个右子数组 `[3, 4, 5]`
    * 这个过程一直持续...

3. **时间复杂度**：

    * 在这种情况下，每次划分只能排除一个元素（基准值）
    * 递归深度变成了 $O(n)$ 而非理想的 $O(\log n)$
    * 每次划分需要 $O(n)$ 的时间
    * 总时间复杂度退化为 $O(n^2)$

降序排列的数组同样会导致类似问题。

#### 「快速排序」比一般排序算法快的原因

##### 平均时间复杂度

快速排序的平均时间复杂度为 $O(n \log n)$ ，与其他高效排序算法（如归并排序、堆排序）相同。但关键在于：

* **常数因子小**：虽然同样是 $O(n \log n)$，但快速排序的常数系数通常比其他算法小
* **内部循环简单**：比较和交换操作非常简洁，可以被编译器高度优化

##### 空间复杂度优势

快速排序是原地（in-place）排序算法，只需要 $O(\log n)$ 的额外空间（用于递归调用栈），而归并排序需要 $O(n)$ 的额外空间。

快速排序之所以快，是因为它结合了多方面的优势：

* 良好的平均时间复杂度 $O(n \log n)$
* 原地排序，空间效率高
* 对现代计算机架构友好（缓存利用率高）
* 内部循环简单高效
* 可以与多种优化策略结合
* 适应性强，可以针对不同数据特性调整策略

这些因素综合起来，使得快速排序在各种实际应用场景中表现出色，成为最受欢迎的排序算法之一。

为避免在有序数组上的性能下降，可以采取以下策略：

##### 随机选择基准值

```java
private int partition(int[] nums, int left, int right) {
    // 随机选择一个索引作为基准
    int randomIndex = left + (int) (Math.random() * (right - left + 1));
    swap(nums, left, randomIndex);  // 将随机选择的元素交换到最左边

    // 后续代码保持不变
    int pivot = nums[left];
    // ...
}
```

虽然概率不高，但这样的解决方法依旧有最坏情况的概率：

* 一侧子数组为空
* 另一侧子数组大小为 $n-1$（原数组大小减1）

这种情况通常发生在选择的 pivot 是数组中的最小值或最大值时。

##### 单次划分的最坏情况概率

当从一个长度为 $n$ 的数组中随机选择 pivot 时：

* pivot 是数组中最小元素的概率： $\frac{1}{n}$
* pivot 是数组中最大元素的概率： $\frac{1}{n}$
* pivot 是最小或最大元素的概率： $\frac{2}{n}$

所以单次划分遇到最极端不平衡的概率是 $\frac{2}{n}$。

##### 连续出现最坏情况的概率

要使快速排序达到 $O(n^2)$ 的最坏时间复杂度，需要在多次递归划分中连续遇到极度不平衡的情况。

假设我们需要连续 $k$ 次选择到数组的最小或最大元素，此时的概率是：

$$P(\text{连续 k 次最坏情况}) = \frac{2}{n} \times \frac{2}{n-1} \times \frac{2}{n-2} \times ... \times \frac{2}{n-k+1}$$

对于完全的最坏情况（需要连续 $n-1$ 次），这个概率是：

$$P(\text{完全最坏情况}) = \frac{2^{n-1}}{n!}$$

### 时间复杂度与空间复杂度

#### 时间复杂度分析

在此我们讨论的是「随机选择切分元素」版本的快速排序。通过随机选择pivot，可以有效避免最坏情况的发生。

快速排序的时间复杂度是 $O(N \log N)$ ，其中 $N$ 是输入数组的长度。这一点可以通过与「归并排序」对比来理解：

归并排序与快速排序都采用了分治思想，但工作重点恰好相反：

* 归并排序在「分」的阶段几乎不做任何工作，主要工作量在「合」的阶段
* 快速排序则将主要工作量放在「分」的阶段（partition过程），「合」的阶段不需要额外操作

在理想情况下，每次partition都能将数组平均分成两半，这样递归树的深度是 $\log N$ ，每一层的总操作量是 $O(N)$
（因为每层都要处理所有元素），所以总时间复杂度是 $O(N \log N)$ 。

#### 空间复杂度分析

快速排序使用了递归实现，因此主要的额外空间消耗来自于递归调用栈。在平均情况下，递归调用栈的深度接近 $\log N$
，因此空间复杂度是 $O(\log N)$ （不计算输入数组所占的空间）。

在最坏情况下（每次都划分出一个空子数组），递归调用栈的深度会达到 $N$ ，此时空间复杂度为 $O(N)$ 。但通过随机选择pivot，这种情况的概率极低。

#### 原地排序与空间复杂度的区别

值得注意的是，快速排序虽然是一种原地排序算法（不需要额外的数组空间来存储排序结果），但它的空间复杂度并不是 $O(1)$
。这一点表明了「原地排序」与「空间复杂度 $O(1)$ 」实际上是两个不同的概念：

* 原地排序：指的是算法在排序过程中不需要额外的数组来存储元素
* 空间复杂度 $O(1)$ ：指的是算法所需的额外空间与输入规模无关

快速排序虽然是原地排序，但由于递归调用需要栈空间，因此其空间复杂度是 $O(\log N)$ 。

|      | 最坏时间复杂度       | 平均时间复杂度                            | 最好时间复杂度       | 额外空间复杂度     | 稳定性 | 是否原地排序 |
|------|---------------|------------------------------------|---------------|-------------|-----|--------|
| 选择排序 | $O(N^2)$      | $O(N^2)$                           | $O(N^2)$      | $O(1)$      | 不稳定 | 原地排序   |
| 冒泡排序 | $O(N^2)$      | $O(N^2)$                           | $O(N)$        | $O(1)$      | 稳定  | 原地排序   |
| 插入排序 | $O(N^2)$      | $O(N^2)$                           | $O(N)$        | $O(1)$      | 稳定  | 原地排序   |
| 希尔排序 | $O(N^2)$      | $O(n^{1.25}) \sim O(1.6 n^{1.25})$ | （没有相关研究）      | $O(1)$      | 不稳定 | 原地排序   |
| 归并排序 | $O(N \log N)$ | $O(N \log N)$                      | $O(N \log N)$ | $O(N)$      | 稳定  | 非原地排序  |
| 快速排序 | $O(N^2)$      | $O(N \log N)$                      | $O(N \log N)$ | $O(\log N)$ | 不稳定 | 原地排序   |

### 练习

#### 使用「三数取中法」选择 partition 过程的切分元素

[../src/sort/MedianOfThreeQuickSort.java](../src/sort/MedianOfThreeQuickSort.java)

```java
public class MedianOfThreeQuickSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int p = partition(nums, left, right);

        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        // 使用三数取中法选择pivot
        int mid = left + (right - left) / 2;

        // 将三个元素按顺序排列
        // 保证 nums[left] <= nums[mid] <= nums[right]
        if (nums[left] > nums[mid]) swap(nums, left, mid);
        if (nums[left] > nums[right]) swap(nums, left, right);
        if (nums[mid] > nums[right]) swap(nums, mid, right);

        // 此时 nums[mid] 是三个数种的中间值
        // 将中间值与 left + 1 位置交换，作为pivot
        swap(nums, mid, left + 1);

        // 使用 left + 1 位置的元素作为 pivot
        int pivot = nums[left + 1];
        swap(nums, left, left + 1);

        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }

        swap(nums, left, lt);
        return lt;
    }
}
```

*在取中的方法上还可以使用异或的方式：*

[../src/sort/SpecialMedianOfThreeQuickSort.java](../src/sort/SpecialMedianOfThreeQuickSort.java)

```java
public class SpecialMedianOfThreeQuickSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int p = partition(nums, left, right);

        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        // 使用三数取中法选择pivot
        if (right - left > 2) {
            int mid = left + (right - left) / 2;
            int medianIndex = medianOfThree(nums, left, mid, right);
            // 将中间值与left位置交换
            swap(nums, left, medianIndex);
        }

        int pivot = nums[left];
        int lt = left;

        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }

        swap(nums, left, lt);
        return lt;
    }

    private int medianOfThree(int[] nums, int a, int b, int c) {
        // 使用异或运算判断中间值
        // 如果a大于b和c中的一个（且仅一个），那么a就是中间值
        if ((nums[a] > nums[b]) ^ (nums[a] > nums[c])) return a;

            // 如果b小于a和c中的一个（且仅一个），那么b就是中间值
        else if ((nums[b] < nums[a]) ^ (nums[b] < nums[c])) return b;

            // 否则c是中间值
        else return c;
    }
}
```

#### 自行编写测试用例，完成下面的实验：在输入数据接近有序的时候，没有实现「随机选择切分元素」的快速排序比归并排序慢很多

[../test/sort/QuickSortTest.java](../test/sort/QuickSortTest.java)

```java

@Test
void orderedComparisonSortTest() {
    // 测试在输入数据接近有序的时候，没有实现「随机选择切分元素」的快速排序比归并排序慢很多
    Assertions.assertDoesNotThrow(() -> SortingUtil.compareSortingAlgorithms(
            new GenerateNearlySortedArrayStrategy(31_000), new QuickSort(), new MergeSort())
    );
}
```

输出：

```text
16:55:56 [INFO] sort.common.SortingUtil: 排序算法比较：
16:55:56 [INFO] sort.common.SortingUtil: 测试用例特点：接近有序（有序程度百分比 90.00%)，规模：31000，最小值：0，最大值：30999。
16:55:56 [INFO] sort.common.SortingUtil: sort.QuickSort@1139b2f3：
16:55:56 [INFO] sort.common.SortingUtil: 耗时 0.08885000 秒 / 88.85000000 毫秒 / 88850000 纳秒
16:55:56 [INFO] sort.common.SortingUtil: 归并排序：
16:55:56 [INFO] sort.common.SortingUtil: 耗时 0.00204300 秒 / 2.04300000 毫秒 / 2043000 纳秒
```

*注意：过大的数组规模会导致快速排序在接近有序的数组中出现栈溢出问题*

#### 完成「力扣」第 215 题：[数组中的第 K 个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/)

[../src/sort/leetcode/KthLargestElementInAnArray.java](../src/sort/leetcode/KthLargestElementInAnArray.java)

```java
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int targetIndex) {
        if (left == right) return nums[left];

        // 随机选择pivot
        int randomIndex = left + (int) (Math.random() * (right - left + 1));
        swap(nums, left, randomIndex);

        // 三向切分
        int[] equalRange = threeWayPartition(nums, left, right);
        int ltPivot = equalRange[0]; // less than pivot的右边界
        int gtPivot = equalRange[1]; // greater than pivot的左边界

        // 根据目标索引位置，决定在哪个区域继续查找
        if (targetIndex >= ltPivot && targetIndex <= gtPivot) {
            // 目标在等于pivot的区域内，直接返回pivot值
            return nums[ltPivot];
        } else if (targetIndex < ltPivot) {
            // 目标在小于pivot的区域
            return quickSelect(nums, left, ltPivot - 1, targetIndex);
        } else {
            // 目标在大于pivot的区域
            return quickSelect(nums, gtPivot + 1, right, targetIndex);
        }
    }

    /**
     * 三向切分
     *
     * @return 返回等于pivot区域的[开始索引, 结束索引]
     */
    private int[] threeWayPartition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int lt = left;      // less than pivot右边界（初始为left）
        int i = left + 1;   // 当前处理的元素
        int gt = right;     // greater than pivot左边界（初始为right）

        // 将数组分成三部分：<pivot, =pivot, >pivot
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, lt, i);
                lt++;
                i++;
            } else if (nums[i] > pivot) {
                swap(nums, i, gt);
                gt--;
                // 注意：这里i不增加，因为交换后i位置的元素还未处理
            } else {
                // nums[i] == pivot
                i++;
            }
        }

        return new int[]{lt, gt};
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

本题代码采用了**快速选择(Quick Select)算法**，特别是使用了三向切分的变体，能更好地处理有重复元素的情况。

##### 核心思想

1. 第 $k$ 大的元素等价于第 $(n-k)$ 小的元素（索引为 $n-k$ ）
2. 利用快速选择，只需要递归地在一边继续查找，而不需要完整排序

关键点：

1. 随机选择pivot，避免最坏情况下的 $O(n^2)$ 时间复杂度
2. 使用三向切分将数组分为 $\<pivot$ 、 $=pivot$ 、 $>pivot$ 三部分
3. 根据目标索引的位置，决定在哪个区域继续递归查找

三向切分的重点：

1. lt指针：小于pivot区域的右边界
2. gt指针：大于pivot区域的左边界
3. i指针：当前处理的元素

经过切分后，数组被分为三部分：

* 索引 $[left, lt-1]$ 的元素 $< pivot$
* 索引 $[lt, gt]$ 的元素 $= pivot$
* 索引 $[gt+1, right]$ 的元素 $> pivot$

##### 算法细节与优化

1. **随机选择pivot**：避免最坏情况下的 $O(n^2)$ 时间复杂度，使平均时间复杂度保持在 $O(n)$
2. **三向切分**：
    * 普通的快速选择在处理有大量重复元素的数组时效率较低
    * 三向切分可以将相等的元素归为一组，减少不必要的递归
3. **交换操作的顺序**：
    * 处理 $nums[i] > pivot$ 时，i不自增，因为交换后的元素还未被处理
    * 处理 $nums[i] < pivot$ 和 $nums[i] == pivot$ 时，i自增，继续处理下一个元素
4. **边界情况处理**：
    * 当left==right时，表示区间内只有一个元素，直接返回
    * 当目标索引位于pivot相等区域时，直接返回pivot值，无需继续递归

##### 时间复杂度分析

* 平均时间复杂度： $O(n)$
* 最坏时间复杂度： $O(n^2)$ （极少出现，因为使用了随机pivot）
* 空间复杂度： $O(\log n)$ （递归调用栈的深度）

#### 完成「力扣」第 26 题：[删除排序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array)

[../src/sort/leetcode/RemoveDuplicatesFromSortedArray.java](../src/sort/leetcode/RemoveDuplicatesFromSortedArray.java)

```java
public int removeDuplicates(int[] nums) {
    // 处理空数组情况
    if (nums.length == 0) return 0;

    int slow = 0; // 慢指针，指向新数组的末尾

    // 从第二个元素开始遍历
    for (int fast = 1; fast < nums.length; fast++) {
        // 发现不重复的元素
        if (nums[fast] != nums[slow]) {
            // 慢指针向前移动，并保存这个不重复的元素
            slow++;
            nums[slow] = nums[fast];
        }
        // 重复元素会被跳过
    }

    // 新数组的长度
    return slow + 1;
}
```

**循环不变量**是一个在循环执行过程中始终保持为真的条件。它帮助我们:

* 验证算法的正确性
* 理清循环的目的和边界条件
* 保证循环结束时能得到预期结果

在解决这个问题时，我们可以定义如下循环不变量：

> 对于索引范围 $[0, slow]$ 的元素，它们都是没有重复的原数组元素，且保持有序

* **初始状态**：循环开始前，`slow = 0`，`nums[0...0]`（即只有`nums[0]`）是无重复的。
* **维护过程**：每次迭代中，当发现 `nums[fast] != nums[slow]` 时：
    * 将 `slow` 加 1
    * 将 `nums[fast]` 复制到 `nums[slow]`
    * 保证 `nums[0...slow]` 仍然是无重复的
* **结束状态**：循环结束后，`nums[0...slow]` 包含原数组中所有不重复的元素

我们采用快慢指针技术来解决这个问题：

* `slow` 指针：指向当前无重复元素的数组的末尾位置
* `fast` 指针：用于遍历原始数组

##### 算法步骤

1. 如果数组为空，直接返回 0
2. 初始化 `slow = 0`（因为第一个元素肯定是不重复的）
3. 从索引 1 开始，使用 `fast` 指针遍历数组
4. 比较 `nums[fast]` 和 `nums[slow]`：
    * 如果不相等，说明找到一个新的不重复元素
    * 将 `slow` 指针前进一位，并将新元素复制到 `slow` 指针位置
5. 返回 `slow + 1`（新数组长度）

##### 复杂度分析

* **时间复杂度**： $O(n)$ ，其中 $n$ 是数组长度，只需遍历一次数组
* **空间复杂度**： $O(1)$ ，只使用了两个指针，不需要额外空间

#### 完成「力扣」第 80 题：[删除排序数组中的重复项 II](https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii)

[../src/sort/leetcode/RemoveDuplicatesFromSortedArrayII.java](../src/sort/leetcode/RemoveDuplicatesFromSortedArrayII.java)

```java
public int removeDuplicates(int[] nums) {
    // 处理特殊情况
    if (nums.length <= 2) return nums.length;

    int slow = 2; // 慢指针，指向应该放置新元素的位置

    // 从第三个元素开始遍历
    for (int fast = 2; fast < nums.length; fast++) {
        // 判断当前元素是否应该保留
        if (nums[fast] != nums[slow - 2]) {
            nums[slow] = nums[fast];
            slow++;
        }
        // 如果当前元素与slow-2位置的元素相同，说明是第3次出现，跳过
    }

    return slow; // 新数组的长度
}
```

这道题同样使用双指针策略，但需要调整判断条件以允许元素最多出现两次。

##### 循环不变量定义

我们定义循环不变量为：

> 对于索引范围 $[0, slow-1]$ 的元素，它们都是满足"每个元素最多出现两次"要求的部分。

##### 循环不变量的维护

1. **初始状态**：循环开始前，`slow = 2`，`nums[0...1]` 满足每个元素最多出现两次
2. **维护过程**：每次迭代中，如果 `nums[fast] != nums[slow-2]`：
    * 复制 `nums[fast]` 到 `nums[slow]` 位置
    * 增加 `slow`
    * 保证 `nums[0...slow-1]` 中每个元素最多出现两次
3. **结束状态**：循环结束后，`nums[0...slow-1]` 包含所有符合要求的元素

##### 算法步骤

1. 如果数组长度 $\leq 2$ ，直接返回数组长度（因为无论如何都符合"最多出现两次"的要求）
2. 初始化 `slow = 2`（因为前两个元素无论如何都可以保留）
3. 从索引 2 开始，用 `fast` 指针遍历数组
4. 对于每个 `fast` 指向的元素，判断它是否应该保留：
    * 如果 `nums[fast] != nums[slow-2]`，说明当前元素不是第三次出现，应该保留
    * 否则，说明当前元素是第三次或更多次出现，应该跳过
5. 返回 `slow` 作为新数组长度

##### 复杂度分析

* **时间复杂度**：$O(n)$，其中 $n$ 是数组长度，只需遍历一次数组
* **空间复杂度**：$O(1)$，只使用了常数额外空间

### 指针对撞的快速排序

> "指针对撞"（双指针或Hoare分区方案）是实现快速排序中分区操作的一种经典方法。

"指针对撞"是指在分区过程中使用两个指针从数组两端向中间移动，完成元素交换的技术。

#### 指针对撞分区步骤

1. 选择一个元素作为基准(通常是第一个元素或随机选择)
2. 设置两个指针：左指针(`left`)从数组左端开始，右指针(`right`)从数组右端开始
3. 右指针向左移动寻找**小于**基准的元素
4. 左指针向右移动寻找**大于**基准的元素
5. 如果左指针小于右指针，交换这两个元素
6. 重复步骤3-5，直到左右指针相遇
7. 交换基准元素与左指针所指向的元素（将基准放到最终位置）
8. 返回基准元素的最终位置，用于递归排序

[../src/sort/TwoWayQuickSort.java](../src/sort/TwoWayQuickSort.java)

```java
public class TwoWayQuickSort implements ISortingAlgorithm {

    private static final Random RANDOM = new Random();

    @Override
    public void sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int p = partition(nums, left, right);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        // 循环不变量
        // all in [left + 1, le) <= pivot
        // all in (ge, right] >= pivot
        // le > ge 的时候终止
        int pivot = nums[left];
        int le = left + 1;
        int ge = right;
        while (true) {
            // 注意：这里一定是 nums[le] < pivot，等于 pivot 的元素是被交换过来得到的
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            // 此时 le 来到第1个大于等于 pivot 的位置
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }
            // 此时 ge 来到第一个小于等于 pivot 的位置
            if (le > ge) {
                break;
            }

            swap(nums, le, ge);
            le++;
            ge--;
        }
        swap(nums, left, ge);
        return ge;
    }
}
```

#### 算法的关键点

1. **双指针对撞**：这种双指针从两端向中间移动的方式是快速排序的经典实现之一。
2. **随机选择pivot**
   ：这是一个重要的优化措施。直接选择第一个或最后一个元素作为pivot可能导致在已排序数组上达到最坏的$O(n^2)$
   时间复杂度。随机化可以有效避免这种情况。
3. **元素相等时的处理**：代码中的实现在遇到等于pivot的元素时，将其分散到数组两侧，这有助于避免在有大量重复元素时的性能退化。

### 练习-2

#### 自行编写测试用例，完成下面的实验：在输入数据有大量重复元素的时候，这一节介绍的快速排序能起到优化的效果

通过新写的数组生成策略生成大量重复的数组

```java
package sort.common;

/**
 * 用于生成包含大量重复元素的随机数组
 *
 * @author AhogeK
 * @since 2025-03-11 16:58:51
 */
public class GenerateDuplicateArrayStrategy implements IGenerateArrayStrategy {

    private final int len;
    // 主要重复的元素值
    private final int dominantValue;
    private int min = 0;
    private int max;
    // 主要重复元素的占比，默认为90%
    private double duplicateRatio = 0.9;

    /**
     * 默认构造函数
     * 随机长度，90%元素相同
     */
    public GenerateDuplicateArrayStrategy() {
        this.len = SortingUtil.RANDOM.nextInt(1000) + 100; // 避免太大的随机值
        this.max = len;
        this.dominantValue = min + SortingUtil.RANDOM.nextInt(max - min + 1);
    }

    /**
     * 指定数组长度，90%元素相同
     *
     * @param len 自定义的数组长度
     */
    public GenerateDuplicateArrayStrategy(int len) {
        this.len = len;
        this.max = len;
        this.dominantValue = min + SortingUtil.RANDOM.nextInt(max - min + 1);
    }

    /**
     * 指定数组长度和范围，90%元素相同
     *
     * @param len 自定义数组长度
     * @param min 自定义最小值
     * @param max 自定义最大值
     */
    public GenerateDuplicateArrayStrategy(int len, int min, int max) {
        this.len = len;
        this.min = min;
        this.max = max;
        this.dominantValue = min + SortingUtil.RANDOM.nextInt(max - min + 1);
    }

    /**
     * 指定数组长度、范围和重复元素占比
     *
     * @param len            自定义数组长度
     * @param min            自定义最小值
     * @param max            自定义最大值
     * @param duplicateRatio 重复元素的占比(0.0-1.0)
     */
    public GenerateDuplicateArrayStrategy(int len, int min, int max, double duplicateRatio) {
        this.len = len;
        this.min = min;
        this.max = max;
        this.duplicateRatio = Math.clamp(duplicateRatio, 0.0, 1.0); // 确保在0到1之间
        this.dominantValue = min + SortingUtil.RANDOM.nextInt(max - min + 1);
    }

    /**
     * 指定数组长度、范围、重复元素占比和主要重复值
     *
     * @param len            自定义数组长度
     * @param min            自定义最小值
     * @param max            自定义最大值
     * @param duplicateRatio 重复元素的占比(0.0-1.0)
     * @param dominantValue  主要重复的元素值
     */
    public GenerateDuplicateArrayStrategy(int len, int min, int max, double duplicateRatio, int dominantValue) {
        this.len = len;
        this.min = min;
        this.max = max;
        this.duplicateRatio = Math.clamp(duplicateRatio, 0.0, 1.0); // 确保在0到1之间
        this.dominantValue = dominantValue;
    }

    @Override
    public String getFeature() {
        return String.format("大量连续重复元素(%.0f%%为%d)", duplicateRatio * 100, dominantValue);
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

        int[] array = new int[len];

        // 计算重复元素的数量
        int duplicateCount = (int) (len * duplicateRatio);

        // 1. 先填充主要重复元素
        for (int i = 0; i < duplicateCount; i++) {
            array[i] = dominantValue;
        }

        // 2. 其余位置填充随机值
        for (int i = duplicateCount; i < len; i++) {
            // 生成一个不等于dominantValue的随机值
            int randomValue;
            do {
                randomValue = min + SortingUtil.RANDOM.nextInt(max - min + 1);
            } while (randomValue == dominantValue && max > min); // 如果可能，避免生成与主要值相同的数

            array[i] = randomValue;
        }

        // 3. 打乱数组，创建一些连续区段（可选）
        shuffleWithBias(array, duplicateCount);

        return array;
    }

    /**
     * 特殊打乱算法，倾向于保持一些连续的重复元素片段
     *
     * @param array          要打乱的数组
     * @param duplicateCount 重复元素的数量
     */
    private void shuffleWithBias(int[] array, int duplicateCount) {
        // 决定是否创建长连续段
        boolean createLongSequences = SortingUtil.RANDOM.nextBoolean();

        if (createLongSequences) {
            // 创建较少但较长的连续段
            int segmentCount = Math.max(1, len / 20); // 大约5%的位置作为段的起点

            for (int i = 0; i < segmentCount; i++) {
                int start = SortingUtil.RANDOM.nextInt(len);
                int segmentLength = Math.min(duplicateCount / segmentCount, len - start);

                // 确保这个位置开始有足够空间放置一个段
                if (segmentLength > 3) { // 只有当段长度至少为3时才创建
                    for (int j = 0; j < segmentLength; j++) {
                        if (start + j < len) {
                            array[start + j] = dominantValue;
                        }
                    }
                }
            }
        } else {
            // 标准的Fisher-Yates洗牌算法
            for (int i = len - 1; i > 0; i--) {
                int j = SortingUtil.RANDOM.nextInt(i + 1);
                SortingUtil.swap(array, i, j);
            }
        }
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

    /**
     * 获取重复元素的占比
     *
     * @return 重复元素的占比
     */
    public double getDuplicateRatio() {
        return duplicateRatio;
    }

    /**
     * 获取主要重复的元素值
     *
     * @return 主要重复的元素值
     */
    public int getDominantValue() {
        return dominantValue;
    }
}
```

然后即可测试

```java

@Test
void orderedComparisonSortTest() {
    // 大量重复元素的数组比较对撞与普通
    Assertions.assertDoesNotThrow(() -> SortingUtil.compareSortingAlgorithms(
            new GenerateDuplicateArrayStrategy(20_000), new QuickSort(), new TwoWayQuickSort())
    );
}
```

输出：

```text
17:21:12 [INFO] sort.common.SortingUtil: 排序算法比较：
17:21:12 [INFO] sort.common.SortingUtil: 测试用例特点：大量连续重复元素(90%为9542)，规模：20000，最小值：0，最大值：20000。
17:21:12 [INFO] sort.common.SortingUtil: sort.QuickSort@64cd705f：
17:21:12 [INFO] sort.common.SortingUtil: 耗时 0.08936900 秒 / 89.36900000 毫秒 / 89369000 纳秒
17:21:12 [INFO] sort.common.SortingUtil: sort.TwoWayQuickSort@9225652：
17:21:12 [INFO] sort.common.SortingUtil: 耗时 0.00170500 秒 / 1.70500000 毫秒 / 1705000 纳秒
```

可以看到面对大量的重复元素，优化效果非常明显，速度提升了 $\boxed{52.42 \text{ 倍}}$ ，节省了 $\boxed{98.08 \text{ %}}$ 的时间

### 三向切分的快速排序

[../src/sort/ThreeWayQuickSort.java](../src/sort/ThreeWayQuickSort.java)

```java
public class ThreeWayQuickSort implements ISortingAlgorithm {

    private static final int INSERTION_THRESHOLD = 16; // 插入排序阈值

    @Override
    public void sortArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        // 小数组使用插入排序优化
        if (right - left < INSERTION_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        // 调用三数取中算法获取枢轴索引
        int pivotIndex = medianOfThree(nums, left, (left + right) >>> 1, right);
        swap(nums, left, pivotIndex); // 将枢轴交换到首位

        int pivotValue = nums[left];
        int lt = left;      // 小于区的右边界
        int gt = right;     // 大于区的左边界
        int i = left + 1;   // 当前元素指针

        // 三向分区操作（Dijkstra三路划分法）
        while (i <= gt) {
            int cmp = nums[i] - pivotValue;
            if (cmp < 0) {
                swap(nums, lt++, i++);
            } else if (cmp > 0) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }

        // 递归处理子区间
        quickSort(nums, left, lt - 1);
        quickSort(nums, gt + 1, right);
    }

    private int medianOfThree(int[] nums, int a, int b, int c) {
        int aVal = nums[a], bVal = nums[b], cVal = nums[c];

        // 异或运算判断中间值 (等价于两次比较)
        if ((aVal < bVal) ^ (aVal < cVal)) return a;
        if ((bVal > aVal) ^ (bVal > cVal)) return b;
        return c;
    }

    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= left && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

三向切分的快速排序(Three-way QuickSort)是快速排序的一种变体，也被称为"荷兰国旗问题算法"(Dutch National Flag)
。这种算法由计算机科学家Dijkstra提出，特别适合处理含有大量重复元素的数组。

#### 基本原理

与传统快速排序将数组分成两部分(小于枢轴和大于枢轴)不同，三向切分快速排序将数组分成三部分：

1. 小于枢轴的元素
2. 等于枢轴的元素
3. 大于枢轴的元素

这种方法在处理有大量重复元素的数组时特别高效，因为等于枢轴的元素不需要再参与排序。

#### 三向划分的核心机制

三向划分是该算法的核心，它使用三个指针维护数组的四个区域：

* `lt` (less than)：指向小于区域的右边界
* `gt` (greater than)：指向大于区域的左边界
* `i`：当前扫描的元素位置

在任意时刻，数组被划分为以下四个区域：

1. `[left, lt-1]`：小于枢轴的元素
2. `[lt, i-1]`：等于枢轴的元素
3. `[i, gt]`：待处理的元素
4. `[gt+1, right]`：大于枢轴的元素

算法处理逻辑如下：

* 如果当前元素 `< 枢轴`：交换 `lt` 和 `i` 位置的元素，然后 `lt++` 和 `i++`
* 如果当前元素 `> 枢轴`：交换 `i` 和 `gt` 位置的元素，然后 `gt--`（注意此时 `i` 不变，因为交换来的元素还未检查）
* 如果当前元素 `= 枢轴`：只移动 `i++`，保持元素在原位置

这种方式确保了相等元素会被聚集在一起，而且这些相等元素不需要再参与后续的递归排序

#### 三向切分的优势

1. **重复元素处理更高效**：当数组包含大量重复元素时，传统快排会对所有元素进行排序，而三向切分快排只需要处理不等于枢轴的部分。
2. **减少比较次数**：由于等于枢轴的元素被直接放置到最终位置，不需要再参与比较，可以大幅减少比较和交换操作的次数。
3. **改进最坏情况行为**：通过三数取中法和三向划分，算法在处理各类数据时表现更稳定。

#### 算法复杂度

* **时间复杂度**：
    * 平均情况： $O(n \log n)$
    * 最坏情况： $O(n^2)$ ，但通过枢轴选择优化，这种情况出现概率大大降低
    * 对于大量重复元素的数组，可以接近线性时间 $O(n)$
* **空间复杂度**：
    * $O(\log n)$ ，递归调用栈的开销

### 练习-3

#### 自行编写测试用例，完成下面的实验：在输入数据有大量重复元素的时候，这一节介绍的三向切分的快速排序能起到优化的效果

依旧是利用之前用过的测试用例，可直接测试三向切分

```java
@Test
void orderedComparisonSortTest() {
    // 大量重复元素的数组比较对撞与普通
    Assertions.assertDoesNotThrow(() -> SortingUtil.compareSortingAlgorithms(
            new GenerateDuplicateArrayStrategy(20_000), new QuickSort(), new TwoWayQuickSort(), new ThreeWayQuickSort())
    );
}
```

输出

```text
21:34:39 [INFO] sort.common.SortingUtil: 测试用例特点：大量连续重复元素(90%为16039)，规模：20000，最小值：0，最大值：20000。
21:34:39 [INFO] sort.common.SortingUtil: sort.QuickSort@7a69b07：
21:34:39 [INFO] sort.common.SortingUtil: 耗时 0.08459600 秒 / 84.59600000 毫秒 / 84596000 纳秒
21:34:39 [INFO] sort.common.SortingUtil: sort.TwoWayQuickSort@5e82df6a：
21:34:39 [INFO] sort.common.SortingUtil: 耗时 0.00199600 秒 / 1.99600000 毫秒 / 1996000 纳秒
21:34:39 [INFO] sort.common.SortingUtil: sort.ThreeWayQuickSort@3f197a46：
21:34:39 [INFO] sort.common.SortingUtil: 耗时 0.00079000 秒 / 0.79000000 毫秒 / 790000 纳秒
```

可以看到三向切分比指针对撞又快了一个档次。速度提升了 $\boxed{2.53 \text{ 倍}}$ ，节省了 $\boxed{60.42 \text{ %}}$ 的时间

---

[返回](../README.md)