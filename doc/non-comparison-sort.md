<!-- TOC -->
* [非比较排序算法](#非比较排序算法)
  * [计数排序](#计数排序)
    * [核心原理](#核心原理)
    * [适用条件](#适用条件)
    * [思路](#思路)
    * [代码](#代码)
      * [示例](#示例)
    * [复杂度（输入数组arr，长度n，最大值k）](#复杂度输入数组arr长度n最大值k)
      * [关键说明：](#关键说明)
  * [基数排序](#基数排序)
    * [核心特点](#核心特点)
    * [高位优先（不推荐）](#高位优先不推荐)
      * [示例](#示例-1)
      * [不推荐的原因](#不推荐的原因)
    * [低位优先（推荐）](#低位优先推荐)
      * [步骤](#步骤)
      * [代码](#代码-1)
      * [执行过程可视化](#执行过程可视化)
        * [第1轮（个位排序）：](#第1轮个位排序)
        * [第2轮（十位排序）：](#第2轮十位排序)
        * [第3轮（百位排序）：](#第3轮百位排序)
      * [复杂度分析](#复杂度分析)
  * [桶排序](#桶排序)
    * [基本流程](#基本流程)
    * [适用条件](#适用条件-1)
    * [代码](#代码-2)
    * [复杂度](#复杂度)
      * [时间复杂度分析](#时间复杂度分析)
      * [空间复杂度](#空间复杂度)
    * [完成「力扣」第 41 题：缺失的第一个正数](#完成力扣第-41-题缺失的第一个正数)
      * [1. 理论基础：鸽巢原理](#1-理论基础鸽巢原理)
      * [2. 算法核心思想](#2-算法核心思想)
      * [复杂度分析](#复杂度分析-1)
    * [完成「力扣」第 268 题：缺失数字](#完成力扣第-268-题缺失数字)
      * [核心规律](#核心规律)
    * [完成「力扣」第 287 题：寻找重复数](#完成力扣第-287-题寻找重复数)
      * [算法步骤](#算法步骤)
      * [举例](#举例)
    * [完成「力扣」第 442 题：数组中重复的数据](#完成力扣第-442-题数组中重复的数据)
      * [核心思路](#核心思路)
      * [算法步骤](#算法步骤-1)
      * [细节与注意事项](#细节与注意事项)
      * [复杂度分析](#复杂度分析-2)
<!-- TOC -->

# 非比较排序算法

## 计数排序

> 计数排序是一种非比较型的排序算法，它通过计算数组中每个元素出现的次数来进行排序。这种算法特别适用于对一定范围内的整数进行排序。

### 核心原理

* **统计频率**：统计每个数值出现的次数
* **累计定位**：计算每个数值的最终位置
* **反向填充**：逆向遍历原数组保持稳定性

### 适用条件

1. 要求待排序元素必须是 **非负整数** 或 **可映射到非负整数**（如字符 ASCII 码、有限范围的浮点数定点表示等）
2. 数据范围（值域）较小
3. 需要稳定排序
4. 有线性时间复杂度要求
5. 内存空间充足

### 思路

* **确定范围**

  找到待排序数组中的最大值 $k$ ，确定统计范围 $[0, k]$ 。

* **统计频率**

  创建长度为 $k+1$ 的计数数组 `count` ，遍历原数组统计每个元素出现的次数：\
  $\text{count}[i] = \text{元素} \ i \ \text{出现的次数}$ \
  例如数组 `[3,1,2,3]` 统计后得到 `count = [0,1,1,2]`。

* **计算前缀和**

  将 `count` 数组转换为累积计数（前缀和），此时：\
  $\text{count}[i] = \text{小于等于} \ i \ \text{的元素总个数}$ \
  例如 `count = [0,1,2,4]` 表示元素 3 的最后位置是索引 3。

* **反向填充**

  从原数组**末尾向前遍历**，根据 `count` 数组确定每个元素的最终位置，填充到结果数组后递减对应计数值。\
  **反向遍历保证稳定性**（相同元素的相对顺序不变）。

### 代码

[../src/sort/CountingSort.java](../src/sort/CountingSort.java)

```java
public class CountingSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        if (nums.length == 0) return;

        // 找最大值
        int max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
        }

        // 初始化计数数组
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }

        // 累加计数（计算最终位置）
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // 反向填充结果数组
        int[] output = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            // 最小就是只出现1次，放在下标0，所以-1
            output[count[current] - 1] = current;
            count[current]--;
        }

        // 拷贝回原数组，使用System.arraycopy是因为`System.arraycopy` 是
        // JVM 内置的本地方法（native method），底层通过内存块复制实现，
        // 时间复杂度 $O(1)$
        System.arraycopy(output, 0, nums, 0, nums.length);
    }
}
```

#### 示例

让我们一步一步分析对数组 `[4, 2, 2, 8, 3, 3, 1]` 进行计数排序的过程：

1. 统计频率

    ```text
    count[0] = 0   (0出现0次)
    count[1] = 1   (1出现1次)
    count[2] = 2   (2出现2次)
    count[3] = 2   (3出现2次)
    count[4] = 1   (4出现1次)
    count[5] = 0   (5出现0次)
    count[6] = 0   (6出现0次)
    count[7] = 0   (7出现0次)
    count[8] = 1   (8出现1次)
    ```

2. 累计次数

    * `count[1] = count[1] + count[0] = 1 + 0 = 1`
    * `count[2] = count[2] + count[1] = 2 + 1 = 3`
    * `count[3] = count[3] + count[2] = 2 + 3 = 5`
    * `count[4] = count[4] + count[3] = 1 + 5 = 6`
    * `count[5] = count[5] + count[4] = 0 + 6 = 6`
    * `count[6] = count[6] + count[5] = 0 + 6 = 6`
    * `count[7] = count[7] + count[6] = 0 + 6 = 6`
    * `count[8] = count[8] + count[7] = 1 + 6 = 7`
    * 累计次数表示的是：**有多少个元素的值小于或等于索引值**。
    * 例如：``count[3] = 5`` 意味着原数组中有5个元素的值 ≤ 3（包括1个值为1的元素，2个值为2的元素和2个值为3的元素）。

3. 构建排序后的数组

    1. 处理元素 `1`：

        * `count[1] = 1`，表示有1个元素 ≤ 1
        * 将 `1` 放在位置 `count[1]-1 = 0` 上
        * 更新 `count[1] = 0`

    2. 处理第二个元素 `3`：

        * `count[3] = 5`，表示有5个元素 ≤ 3
        * 将 `3` 放在位置 `count[3]-1 = 4` 上
        * 更新 `count[3] = 4`

    3. 处理第一个元素 `3`：

        * `count[3] = 4`，表示现在有4个元素 ≤ 3
        * 将 `3` 放在位置 `count[3]-1 = 3` 上
        * 更新 `count[3] = 3`

    4. 处理元素 `8`：

        * `count[8] = 7`，表示有7个元素 ≤ 8
        * 将 `8` 放在位置 `count[8]-1 = 6` 上
        * 更新 `count[8] = 6`

    5. 依此类推，最终得到排序数组：`[1, 2, 2, 3, 3, 4, 8]`

### 复杂度（输入数组arr，长度n，最大值k）

$$\text{时间复杂度：} O(n + k) \\\ \text{空间复杂度：} O(n + k)$$

#### 关键说明：

* ${n}$：待排序元素个数
* ${k}$：元素的取值范围（最大值与最小值之差 + 1）

1. **时间复杂度分析**

    * **统计阶段**：遍历 ${n}$ 个元素，耗时 ${O(n)}$
    * **累加阶段**：遍历 ${k}$ 个计数单元，耗时 ${O(k)}$
    * **回填阶段**：再次遍历 ${n}$ 个元素，耗时 ${O(n)}$
    * 总时间 ${O(n + k)}$

2. **空间复杂度分析**

    * 需要 ${k}$ 大小的计数数组
    * 需要 ${n}$ 大小的输出数组
    * 总空间 ${O(n + k)}$

|      | 最坏时间复杂度       | 平均时间复杂度                            | 最好时间复杂度       | 额外空间复杂度     | 稳定性 | 是否原地排序 |
|------|---------------|------------------------------------|---------------|-------------|-----|--------|
| 选择排序 | $O(N^2)$      | $O(N^2)$                           | $O(N^2)$      | $O(1)$      | 不稳定 | 原地排序   |
| 冒泡排序 | $O(N^2)$      | $O(N^2)$                           | $O(N)$        | $O(1)$      | 稳定  | 原地排序   |
| 插入排序 | $O(N^2)$      | $O(N^2)$                           | $O(N)$        | $O(1)$      | 稳定  | 原地排序   |
| 希尔排序 | $O(N^2)$      | $O(n^{1.25}) \sim O(1.6 n^{1.25})$ | （没有相关研究）      | $O(1)$      | 不稳定 | 原地排序   |
| 归并排序 | $O(N \log N)$ | $O(N \log N)$                      | $O(N \log N)$ | $O(N)$      | 稳定  | 非原地排序  |
| 快速排序 | $O(N^2)$      | $O(N \log N)$                      | $O(N \log N)$ | $O(\log N)$ | 不稳定 | 原地排序   |
| 计数排序 | $O(N + K)$    | $O(N + K)$                         | $O(N + K)$    | $O(N + K)$  | 稳定  | 非原地排序  |

## 基数排序

> 基数排序（Radix Sort）是一种非比较型整数排序算法，通过逐位处理数字的各个位数实现排序。
> 它的核心思想是将整数按位数切割成不同数字，然后按每个位数分别进行排序。

### 核心特点

* **非比较排序**\
  不通过元素间的直接比较，而是通过**位值分配**实现排序。

* **多轮稳定排序**\
  每一轮按某一位的值分组（常用计数排序），且**保持稳定性**（相同值的原始顺序不变）。

* **两种方向**

    * **LSD（Least Significant Digit）**：从最低位（个位）开始排序（常用）
    * **MSD（Most Significant Digit）**：从最高位开始排序（类似字典序）

**基数排序同样只适用于非负整数排序**

### 高位优先（不推荐）

高位优先基数排序采用分治策略

```java
void msdSort(int[] arr, int left, int right, int digit) {
    if (digit < 0 || left >= right) return;

    // 按当前digit位的值分组
    int[] boundaries = partitionByDigit(arr, left, right, digit);

    // 递归处理每个分组（digit-1位）
    for (int i = 0; i < boundaries.length - 1; i++) {
        msdSort(arr, boundaries[i], boundaries[i + 1] - 1, digit - 1);
    }
}
```

#### 示例

以数字数组`[329, 457, 657, 839, 436, 720, 355]`处理百位（digit=2）：

1. **第一轮分组**（百位）：
   ```text
   3xx组: [329, 355]
   4xx组: [457, 436]
   6xx组: [657]
   7xx组: [720]
   8xx组: [839]
   ```
2. **递归处理十位**：
   ```text
   处理3xx组（十位）：
     32x: [329]
     35x: [355]
   ```

#### 不推荐的原因

1. 空间复杂度爆炸，递归栈深度与位数成正比
2. 内存碎片化严重，每组都要分配独立空间，导致内存访问率下降
3. 实现复杂度大，有需要大量处理的边界，如前导零，递归终止条件，空桶处理

*在《算法导论》（第4版）第8.3节明确指出：**除非处理特殊数据类型（如字符串），否则应优先选择LSD实现**。*

### 低位优先（推荐）

> 算法原理的核心思想：将整数视为多位数组成的序列，从最低有效位（个位）到最高有效位，依次进行稳定排序。
> 每轮排序仅关注当前位的数值，通过多轮叠加最终实现整体有序。

#### 步骤

1. 确定最大位数
    ```java
    int max = getMax(arr); // 获取数组最大值
    int maxDigit = (int) Math.log10(max) + 1; // 计算最大位数
    ```
2. 逐位排序（从个位开始）
    ```text
    for (exp = 1; max / exp > 0; exp *= 10) {
        a. 提取当前位数字：digit = (num / exp) % 10
        b. 统计每个digit的出现次数 → count[digit]++
        c. 累加计数 → count[i] += count[i-1]
        d. 反向填充 → output[--count[digit]] = num
        e. 复制回原数组
    }
    ```
3. 稳定性保证机制
    * **反向填充**：从数组末尾向前遍历，确保相同digit值的元素保持原有顺序
    * **累加计数数组**：通过`count[i]`存储当前digit值的元素最终位置

#### 代码

[../src/sort/LSDRadixSort.java](../src/sort/LSDRadixSort.java)

```java
public class LSDRadixSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        // 获取最大值与最大位数
        int max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
        }

        int maxDigit;
        if (max == 0) maxDigit = 1;
        else maxDigit = (int) (Math.log10(max) + 1);

        // 初始化exp（指数，代表当前处理位：1-个位，10-十位）
        int exp = 1;
        int[] output = new int[nums.length];

        // 逐位排序
        while (maxDigit-- > 0) {
            int[] count = new int[10]; // 十进制 0-9

            // 统计当前位出现的个数
            for (int num : nums) {
                int digit = (num / exp) % 10;
                count[digit]++;
            }

            // 计算累加次数
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // 反向填充（关键稳定性保证）
            for (int i = nums.length - 1; i >= 0; i--) {
                int digit = (nums[i] / exp) % 10;
                output[--count[digit]] = nums[i];
            }

            // 复制回原数组
            System.arraycopy(output, 0, nums, 0, nums.length);

            // 处理下一位
            exp *= 10;
        }
    }
}
```

#### 执行过程可视化

以数组`[329, 457, 657, 839, 436, 720, 355]`为例：

##### 第1轮（个位排序）：

```
原始数据：329 457 657 839 436 720 355
提取个位：9   7   7   9   6   0   5
分组排序：
   0: 720
   5: 355
   6: 436
   7: 457, 657
   9: 329, 839
排序结果：[720, 355, 436, 457, 657, 329, 839]
```

##### 第2轮（十位排序）：

```
当前数据：720 355 436 457 657 329 839
提取十位：2   5   3   5   5   2   3
分组排序：
   2: 720, 329
   3: 436, 839
   5: 355, 457, 657
排序结果：[720, 329, 436, 839, 355, 457, 657]
```

##### 第3轮（百位排序）：

```
当前数据：720 329 436 839 355 457 657
提取百位：7   3   4   8   3   4   6
分组排序：
   3: 329, 355
   4: 436, 457
   6: 657
   7: 720
   8: 839
最终结果：[329, 355, 436, 457, 657, 720, 839]
```

#### 复杂度分析

| 维度      | 公式                   | 说明                     |
|---------|----------------------|------------------------|
| **时间**  | $O(d \cdot (n + k))$ | d:最大位数，k:基数（如10进制k=10） |
| **空间**  | $O(n + k)$           | 需要output数组和count数组     |
| **稳定性** | 稳定                   | 依赖子排序算法的稳定性            |

|      | 最坏时间复杂度       | 平均时间复杂度                            | 最好时间复杂度       | 额外空间复杂度     | 稳定性 | 是否原地排序 |
|------|---------------|------------------------------------|---------------|-------------|-----|--------|
| 选择排序 | $O(N^2)$      | $O(N^2)$                           | $O(N^2)$      | $O(1)$      | 不稳定 | 原地排序   |
| 冒泡排序 | $O(N^2)$      | $O(N^2)$                           | $O(N)$        | $O(1)$      | 稳定  | 原地排序   |
| 插入排序 | $O(N^2)$      | $O(N^2)$                           | $O(N)$        | $O(1)$      | 稳定  | 原地排序   |
| 希尔排序 | $O(N^2)$      | $O(n^{1.25}) \sim O(1.6 n^{1.25})$ | (没有相关研究)      | $O(1)$      | 不稳定 | 原地排序   |
| 归并排序 | $O(N \log N)$ | $O(N \log N)$                      | $O(N \log N)$ | $O(N)$      | 稳定  | 非原地排序  |
| 快速排序 | $O(N^2)$      | $O(N \log N)$                      | $O(N \log N)$ | $O(\log N)$ | 不稳定 | 原地排序   |
| 计数排序 | $O(N + K)$    | $O(N + K)$                         | $O(N + K)$    | $O(N + K)$  | 稳定  | 非原地排序  |
| 基数排序 | $O(KN)$       | $O(KN)$                            | $O(N^2)$      | $O(K + N)$  | 稳定  | 非原地排序  |

## 桶排序

> 桶排序是一种将数据分到有限数量的容器（桶）中，再对每个桶单独排序的分布式排序算法。
> 其核心思想是通过合理的数据分布策略，将排序任务分解为多个小规模问题处理。

### 基本流程

1. **分桶策略**：根据数据范围创建空桶
2. **数据分配**：将元素映射到对应桶中
3. **桶内排序**：对每个非空桶单独排序
4. **合并结果**：按桶顺序拼接结果

### 适用条件

1. 数据分布必须满足均匀分布
2. 需提前知道数据范围
3. 非负整数(负数需要调整分桶公式)

### 代码

[../src/sort/BucketSort.java](../src/sort/BucketSort.java)

```java
public class BucketSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // 1. 找到最大值和最小值
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // 2. 计算桶大小和数量
        int n = nums.length;
        int bucketSize = Math.max(1, (max - min) / (int) Math.sqrt(n)); // 避免bucketSize为0
        int bucketCount = (max - min) / bucketSize + 1;

        // 3. 统计每个桶需要的大小
        int[] bucketSizes = new int[bucketCount];
        for (int num : nums) {
            int bucketIndex = (num - min) / bucketSize; // 使用bucketSize计算
            bucketSizes[bucketIndex]++;
        }

        // 4. 创建桶
        int[][] buckets = new int[bucketCount][];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new int[bucketSizes[i]];
            bucketSizes[i] = 0; // 重置计数器
        }

        // 5. 将元素放入桶中
        for (int num : nums) {
            int bucketIndex = (num - min) / bucketSize; // 使用bucketSize计算
            buckets[bucketIndex][bucketSizes[bucketIndex]++] = num;
        }

        // 6. 对每个桶进行排序 (使用插入排序保持稳定性)
        for (int[] bucket : buckets) {
            insertionSort(bucket);
        }

        // 7. 将排序后的元素收集回原数组
        int index = 0;
        for (int[] bucket : buckets) {
            for (int num : bucket) {
                nums[index++] = num;
            }
        }
    }

    private void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i;

            while (j > 0 && arr[j - 1] > current) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = current;
        }
    }
}
```

### 复杂度

#### 时间复杂度分析

$$\begin{aligned} \text{最佳情况} & : O(n + k) \quad (\text{均匀分布且桶数量 } k \approx n) \\\ \text{平均情况} & : O(n + \frac{n^2}{k} + k) \quad (\text{一般分布}) \\\ \text{最坏情况} & : O(n^2) \quad (\text{极端集中分布}) \end{aligned}$$

#### 空间复杂度

$$O(n + k)$$

* $n$：存储元素的额外空间
* $k$：桶指针数组空间

|      | 最坏时间复杂度       | 平均时间复杂度                            | 最好时间复杂度       | 额外空间复杂度     | 稳定性 | 是否原地排序 |
|------|---------------|------------------------------------|---------------|-------------|-----|--------|
| 选择排序 | $O(N^2)$      | $O(N^2)$                           | $O(N^2)$      | $O(1)$      | 不稳定 | 原地排序   |
| 冒泡排序 | $O(N^2)$      | $O(N^2)$                           | $O(N)$        | $O(1)$      | 稳定  | 原地排序   |
| 插入排序 | $O(N^2)$      | $O(N^2)$                           | $O(N)$        | $O(1)$      | 稳定  | 原地排序   |
| 希尔排序 | $O(N^2)$      | $O(n^{1.25}) \sim O(1.6 n^{1.25})$ | (没有相关研究)      | $O(1)$      | 不稳定 | 原地排序   |
| 归并排序 | $O(N \log N)$ | $O(N \log N)$                      | $O(N \log N)$ | $O(N)$      | 稳定  | 非原地排序  |
| 快速排序 | $O(N^2)$      | $O(N \log N)$                      | $O(N \log N)$ | $O(\log N)$ | 不稳定 | 原地排序   |
| 计数排序 | $O(N + K)$    | $O(N + K)$                         | $O(N + K)$    | $O(N + K)$  | 稳定  | 非原地排序  |
| 基数排序 | $O(KN)$       | $O(KN)$                            | $O(N^2)$      | $O(K + N)$  | 稳定  | 非原地排序  |
| 桶排序  | $O(N^2)$      | $O(N)$                             | $O(N)$        | 根据情况定       | 稳定  | 非原地排序  |

### 完成「力扣」第 41 题：[缺失的第一个正数](https://leetcode.cn/problems/first-missing-positive/)

[../src/sort/leetcode/FirstMissingPositive.java](../src/sort/leetcode/FirstMissingPositive.java)

```java
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 将每个数值交换到正确的位置
        for (int i = 0; i < n; i++) {
            // 持续交换直到当前元素无法再移动
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 查找第一个不匹配的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

采用原地哈希算法的思路解题

#### 1. 理论基础：鸽巢原理

假设数组长度为 $n$，则答案范围必定是：

$$\text{缺失的正数} \in \\{1, 2, ..., n+1\\}$$

**证明**：

* 若数组中包含 $1$ 到 $n$ → 返回 $n+1$
* 若缺失某个数 → 返回最小的缺失数

#### 2. 算法核心思想

将数值 $x$ 映射到索引 $x-1$，构建理想状态：

$$\forall i \in [0,n), \quad \text{目标：} \ nums[i] = i+1$$

#### 复杂度分析

| 步骤       | 时间复杂度  | 空间复杂度  |
|----------|--------|--------|
| 数组预处理    | $O(n)$ | $O(1)$ |
| 查找缺失值    | $O(n)$ | $O(1)$ |
| **总复杂度** | $O(n)$ | $O(1)$ |

### 完成「力扣」第 268 题：[缺失数字](https://leetcode.cn/problems/missing-number/)

[../src/sort/leetcode/MissingNumber.java](../src/sort/leetcode/MissingNumber.java)

```java
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        long total = (long) n * (n + 1) / 2; // 避免整数溢出
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (int) (total - sum);
    }
}
```

本题采用了数学求合法解决

**公式推导**：计算 $0$ 到 $n$ 的总和（即 $\frac{n(n+1)}{2}$），减去数组元素的总和，差值即为缺失数字。

* **时间复杂度**：$O(n)$
* **空间复杂度**：$O(1)$

其核心来源于**高斯在童年时期发现的等差数列求和公式**:

**具体公式**：

$$\sum\limits_{k=1}^{n} k = \frac{n(n+1)}{2} \quad \text{（高斯求和公式）}$$

#### 核心规律

无论n是奇数还是偶数，都存在：

$$\text{总对数} = \frac{n}{2} \quad \text{每对和} = n+1$$

因此：

$$总和 = \frac{n}{2} × (n+1) = \frac{n(n+1)}{2}$$

### 完成「力扣」第 287 题：[寻找重复数](https://leetcode.cn/problems/find-the-duplicate-number/)

[../src/sort/leetcode/FindTheDuplicateNumber.java](../src/sort/leetcode/FindTheDuplicateNumber.java)

```java
public class Solution {
    public int findDuplicate(int[] nums) {
        // 初始化快慢指针
        int slow = nums[0];
        int fast = nums[0];

        // 第一阶段：检测环的存在
        do {
            slow = nums[slow];          // 慢指针步长1
            fast = nums[nums[fast]];    // 快指针步长2
        } while (slow != fast);

        // 第二阶段：寻找环入口
        fast = nums[0]; // 重置快指针到起点
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;    // 环入口即重复数
    }
}
```

这道题利用快慢指针的方式实现，一开始理解这里的快慢指针思路可能会有点混乱

#### 算法步骤

1. **检测环的存在**：
    * 快指针（每次两步）和慢指针（每次一步）从起点出发
    * 当两指针相遇时，确认存在环
      $$\begin{aligned} slow &= nums[slow] \quad \text{(步长1)} \\\ fast &= nums[nums[fast]] \quad \text{(步长2)} \end{aligned}$$
2. **寻找环入口**：
    * 将快指针重置到起点
    * 两指针以相同步长移动，再次相遇点即为环入口
      $$\begin{cases} fast &= nums[0] \\\ slow &= \text{相遇点位置} \end{cases}$$

本身这是一个链表的思路，不过可以利用数组下标与值的对应关系来形成隐式链表:

* **节点定义**：下标 $i$ 表示节点，值 $nums[i]$ 表示指向的下一个节点
* **重复数效应**：至少两个不同节点指向同一后继节点，形成环

#### 举例

数组 ``[1,3,4,2,2]``

```text
初始位置：
slow = 0  # 起点
fast = 0  # 起点

第1轮循环：
slow = nums[0] → 1  # 慢指针跳到索引1
fast = nums[nums[0]] → nums[1] → 3  # 快指针跳两次：0→1→3
位置：slow在1（值3），fast在3（值2）

第2轮循环：
slow = nums[1] → 3  # 1→3
fast = nums[nums[3]] → nums[2] → 4  # 3→2→4
位置：slow在3（值2），fast在4（值2）

第3轮循环：
slow = nums[3] → 2  # 3→2
fast = nums[nums[4]] → nums[2] → 4  # 4→2→4
位置：slow在2（值4），fast在4（值2）

第4轮循环：
slow = nums[2] → 4  # 2→4
fast = nums[nums[4]] → nums[2] → 4  # 4→2→4（第二次跳仍在4）
位置：slow和fast都在4 → 相遇了！即检测到了环
```

* **快指针像兔子跑得快**：
    * 每次比慢指针多跑1步（相对速度）
    * 遇到环时，兔子会不断绕圈，最终被乌龟追上
* **为什么能检测环**：
    * 如果没有环 → 兔子会跑到终点（但在本题不可能）
    * 如果有环 → 兔子会绕圈，乌龟最终会进入环被追上

随后就是第二阶段，环的存在还不能证明重复

```text
阶段二操作：
让两个指针：
1. 一个从起点0出发
2. 一个从相遇点4出发
都走L=3步（示例中L=3）：
   - 起点指针：0→1→3→2（到达入口）
   - 相遇点指针：4→2→4→2（绕环1圈后也到入口）
```

算法中我们需要让一个指针重新走一次"起点到入口"的路径，才能计算出准确距离。所以算法需要重制快指针而不是让快指针留在相遇点。

因为重复数是环的唯一入口，这个方法必然会在入口相遇。因此算法不会漏掉重复数。

```text
        环入口（重复数）
        ↓
0 → 1 → 3 → 2 → 4 → 2...
```

### 完成「力扣」第 442 题：[数组中重复的数据](https://leetcode.cn/problems/find-all-duplicates-in-an-array)

[../src/sort/leetcode/FindAllDuplicatesInAnArray.java](../src/sort/leetcode/FindAllDuplicatesInAnArray.java)

```java
public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);   // 取绝对值确保索引正确
            int index = num - 1;           // 计算实际索引
            if (nums[index] < 0) {
                result.add(num);           // 重复时加入结果
            } else {
                nums[index] = -nums[index];// 标记为已访问
            }
        }
        return result;
    }
}
```

#### 核心思路

利用数组本身的正负性标记元素是否重复。遍历数组时，将元素对应的索引位置取反作为标记。
如果第二次遇到同一元素时发现对应索引位置已为负数，则说明该元素重复。

#### 算法步骤

1. **遍历数组**：逐个处理元素，用绝对值获取原始值。
2. **索引计算**：元素值 $num$ 对应的索引为 $index = \text{abs}(num) - 1$ 。
3. **标记与检测**：
    * 若`nums[index]`为正数，将其取反（标记为已出现）。
    * 若`nums[index]`为负数，说明该元素已出现过一次，将 $\text{abs}(num)$ 加入结果。

#### 细节与注意事项

1. **绝对值的必要性**：元素可能在遍历中被修改为负数，因此必须用`Math.abs()`获取原始值。
2. **索引范围**：元素值范围是 $[1, n]$ ，转换为索引 $[0, n-1]$ 不会越界。
3. **空间复杂度**：结果列表不占用额外空间复杂度，算法满足 $O(1)$ 要求。
4. **重复判断**：仅当第二次遇到元素时才会加入结果，确保每个重复元素只记录一次。

#### 复杂度分析

* **时间复杂度**： $O(n)$ ，仅需一次遍历。
* **空间复杂度**： $O(1)$ ，除结果列表外无额外存储。
