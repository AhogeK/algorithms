<!-- TOC -->
* [优先队列](#优先队列)
    * [优先队列与堆](#优先队列与堆)
      * [优先队列的实现](#优先队列的实现)
    * [树形结构](#树形结构)
      * [完全二叉树与满二叉树](#完全二叉树与满二叉树)
      * [使用数组表示完全二叉树](#使用数组表示完全二叉树)
    * [堆有序](#堆有序)
  * [堆的基本操作](#堆的基本操作)
    * [基本概念](#基本概念)
    * [数组存储方式](#数组存储方式)
    * [基本操作](#基本操作)
      * [构建堆（heapify/build-heap）](#构建堆heapifybuild-heap)
      * [插入元素（insert）](#插入元素insert)
      * [弹出堆顶（extract/top/pop）](#弹出堆顶extracttoppop)
      * [获取堆顶元素（peek）](#获取堆顶元素peek)
    * [复杂度分析](#复杂度分析)
    * [最大堆的抽象数据类型](#最大堆的抽象数据类型)
      * [重点说明](#重点说明)
  * [将数组整理成堆](#将数组整理成堆)
    * [堆的数组表示](#堆的数组表示)
    * [操作思路](#操作思路)
    * [下沉操作（以最大堆为例）](#下沉操作以最大堆为例)
    * [关于复杂度](#关于复杂度)
    * [代码示例](#代码示例)
  * [堆排序](#堆排序)
    * [堆排序的基本思想](#堆排序的基本思想)
    * [核心步骤与流程（以最大堆为例）](#核心步骤与流程以最大堆为例)
    * [复杂度分析](#复杂度分析-1)
    * [代码示例](#代码示例-1)
  * [典型问题1: 合并K个排序链表](#典型问题1-合并k个排序链表)
    * [例题：「力扣」第 23 题：合并 K 个排序链表 （使用优先队列思想）](#例题力扣第-23-题合并-k-个排序链表-使用优先队列思想)
      * [算法思路](#算法思路)
      * [代码](#代码)
      * [复杂度分析](#复杂度分析-2)
  * [典型问题2: top K 问题](#典型问题2-top-k-问题)
    * [例：「力扣」第 215 题：数组中的第 K 个最大元素](#例力扣第-215-题数组中的第-k-个最大元素)
      * [算法思路](#算法思路-1)
      * [代码示例](#代码示例-2)
      * [复杂度分析](#复杂度分析-3)
    * [完成「力扣」第 347 题：前 K 个高频元素](#完成力扣第-347-题前-k-个高频元素)
      * [算法思路](#算法思路-2)
      * [核心知识点与技巧](#核心知识点与技巧)
      * [代码示例](#代码示例-3)
      * [复杂度分析](#复杂度分析-4)
    * [完成「力扣」第 295 题：数据流的中位数](#完成力扣第-295-题数据流的中位数)
      * [算法思路](#算法思路-3)
      * [核心知识点与技巧](#核心知识点与技巧-1)
      * [代码示例](#代码示例-4)
      * [复杂度分析](#复杂度分析-5)
    * [完成「力扣」第 451 题：根据字符出现频率排序](#完成力扣第-451-题根据字符出现频率排序)
      * [算法思路](#算法思路-4)
      * [核心知识点与技巧](#核心知识点与技巧-2)
      * [代码示例](#代码示例-5)
      * [复杂度分析](#复杂度分析-6)
    * [完成「力扣」第 973 题：接近原点的 K 个点](#完成力扣第-973-题接近原点的-k-个点)
      * [算法思路](#算法思路-5)
      * [核心知识点与技巧](#核心知识点与技巧-3)
      * [代码示例](#代码示例-6)
      * [复杂度分析](#复杂度分析-7)
    * [完成「力扣」第 218 题：天际线问题](#完成力扣第-218-题天际线问题)
      * [算法思路概览](#算法思路概览)
      * [完整代码](#完整代码)
      * [复杂度分析](#复杂度分析-8)
  * [堆索引](#堆索引)
    * [什么是堆？](#什么是堆)
    * [堆的数组表示与索引换算](#堆的数组表示与索引换算)
    * [堆索引的常见用途](#堆索引的常见用途)
  * [为索引堆添加反向查找](#为索引堆添加反向查找)
    * [核心思想](#核心思想)
    * [代码案例](#代码案例)
<!-- TOC -->
# 优先队列

> 优先队列是一种“谁优先级高谁先出来”的队列，一般用二叉堆等结构高效实现，适合做每次要动态找“最值”的问题。

优先队列（Priority Queue）是一种基础数据结构。与普通队列（Queue）不同，优先队列里的元素每一个都有“优先级”，
出队顺序不是先进先出，而是谁的优先级高谁先出队。

1. 基本概念
    * 优先队列是一种“每次取出的总是当前优先级最高的元素”的数据结构。
    * 常用于需要频繁找“最值”的场景，比如贪心算法、Dijkstra最短路、A\*寻路等。
2. 基本操作
    * 插入元素（Insert）：将一个带有优先级的元素加入队列
    * 删除（取出）优先级最高的元素（Pop/Extract）：每次都取出当前优先级最高的那个元素
    * 查看优先级最高的元素（Peek/Top）：不删除，只返回当前最高的元素
3. 实现方式
    * 用数组/链表实现时，最坏时间复杂度很高
    * 常用 **堆（Heap）** 实现，比如二叉堆（binary heap）
    * 堆实现下，插入和删除操作都是 $\mathcal{O}(\log n)$ 复杂度
    * STL/Java等标准库里的 `priority_queue` 就是基于堆实现的
4. 简单类比
    * 普通队列就像排队买票，谁先来谁先上车
    * 优先队列就像急诊挂号，每来一个病人都标记严重程度，医生优先处理更严重的
5. 常见用法举例
    * 最高分优先、最小距离优先等场景
    * 算法刷题中只要遇到“每次拿出当前最大/最小/最急/最重要的”，都能想到用优先队列

### 优先队列与堆

#### 优先队列的实现

优先队列的常见实现有三种方法，核心在于“如何同时兼顾效率和正确性（谁优先谁先出）”。下面按照从简单到高效的顺序讲解，并且会结合上面你说到的内容。

1. **无序数组实现**

    * 入队（添加元素）直接往数组末尾加；\
      时间复杂度： $\mathcal{O}(1)$
    * 出队（取出优先级最高）：每次都需要遍历一遍整个数组，找出优先级最高的那个元素再移除；\
      时间复杂度： $\mathcal{O}(n)$
    * 适用场景：入队特别频繁但出队很少的场景

2. **有序数组实现**

    * 保证数组始终有序（如降序排列），每次入队时找好位置后插入；\
      时间复杂度： $\mathcal{O}(n)$（通常需要移动元素）
    * 出队时，优先级最高元素一定在数组头/尾，一次操作即可；\
      时间复杂度： $\mathcal{O}(1)$
    * 适用场景：出队很频繁但入队不多的场景

3. **堆（heap）实现**

    * 堆是一种完全二叉树结构，可以高效地维护“当前优先级最高的元素”；
    * 入队和出队操作都可以在 $\mathcal{O}(\log n)$ 时间完成；
    * 二叉堆（binary heap）应用最广（如大顶堆/小顶堆，根据需求调整）；
    * 这样就做到了入队、出队都高效，效率远高于前两种方式！
    * 主流编程语言的 `priority_queue` 等库就是堆实现

4. **效率对比表（归纳）**

    | 实现方式 | 入队                    | 出队                    |
    |------|-----------------------|-----------------------|
    | 无序数组 | $\mathcal{O}(1)$      | $\mathcal{O}(n)$      |
    | 有序数组 | $\mathcal{O}(n)$      | $\mathcal{O}(1)$      |
    | 堆    | $\mathcal{O}(\log n)$ | $\mathcal{O}(\log n)$ |

### 树形结构

树形结构就是“每层分叉、层层递进”的数据结构，让数据的查找、插入、删除等操作更高效。
优先队列常用的“堆”就是一种特殊的二叉树，让找“优先级最高（或最低）”的操作极快。

#### 完全二叉树与满二叉树

简单来说，完全二叉树和满二叉树都是二叉树的特殊情况。

* **完全二叉树**
 
    * 概念：完全二叉树是一种特殊的二叉树，要求从上到下、从左到右，除了最后一层之外，都必须被填满，
      最后一层的结点集中在最左侧，不能有“中间空位”。
    * 形象比喻：就像阶梯似的，一层一层铺满，最后那一层即使没铺满，也一定是“一块一块从左往右铺的”，不能出现空缺。
    * 特点：适合用连续的数组存储，没有“左有右无”或“右有左无”的疏漏。
     
* **满二叉树**
 
    * 概念：满二叉树是更理想、更整齐的二叉树，每一层的结点数都达到最大值，即每个非叶子节点一定都有两个子节点，并且所有叶子节点全部在最后一层。
    * 形象比喻：像完美的三角形金字塔，最底下一行结点数是最多的，每一行都是“铺满”的。
    * 数学特性：深度为 $k$ 的满二叉树共有 $2^k - 1$ 个结点，每一层结点数是 $2^{层号-1}$。这是一个等比数列。
     
* **简明对比**
 
    |    | 完全二叉树              | 满二叉树                      |
    |----|--------------------|---------------------------|
    | 结构 | 除最后一层，无空位，最后一层左边紧凑 | 每层都满，没有空位，所有叶子都在同一层       |
    | 关系 | 满二叉树一定是完全二叉树       | 完全二叉树不一定是满二叉树             |
    | 举例 | 最后一层可能不满，但只要填的紧凑即可 | 每层都“满员”，一棵三层满二叉树有 $7$ 个节点 |

#### 使用数组表示完全二叉树

“使用数组表示完全二叉树”是因为完全二叉树结构非常规整，没有“空洞”和偏移，非常适合用连续的数组来存储。

1. **编号方式**

    * 按照“从上到下、从左到右”的顺序，依次编号每个节点。
    * 可以选择从下标 $0$ 或 $1$ 开始编号。

2. **下标的规律**

    * 假设节点编号（下标）为 $i$，数组存储为 `arr[i]`。
    * **从 $0$ 开始编号时：**
        * 父节点 $i$ 的左孩子下标是 $2i+1$，右孩子下标是 $2i+2$。
        * 子节点 $i$ 的父亲下标是 $\left\lfloor \frac{i-1}{2} \right\rfloor$。
    * **从 $1$ 开始编号时：**
        * 父节点 $i$ 的左孩子下标是 $2i$，右孩子下标是 $2i+1$。
        * 子节点 $i$ 的父亲下标是 $\left\lfloor \frac{i}{2} \right\rfloor$。

3. **优点**

    * 内存连续、定位高效。
    * 无需存储左右孩子的引用关系，用下标就能算出父子关系，减少空间和时间消耗。

4. **实际应用**

    * 特别适合二叉堆这类完全二叉树的结构，比如实现优先队列。
    * 使用数组后，可以用简单的下标关系完成“上浮”“下沉”等操作，提高各种操作的效率。

### 堆有序

“堆有序”就是堆（Heap）这种特殊完全二叉树一直满足的排序规则。它有两种基本形态：最大堆和最小堆。

1. **最大堆（大顶堆）**

    * **定义**：对于任意一个非根节点，其父节点的值 $\geq$自己的值。
    * **特点**：根节点（最顶端的那个）一定是全树中最大的值。
    * **形象理解**：每棵小树的“头”都比下面“身体”要大。
    * **举例**：

      ```
             9
            / \
           7   5
          / \
         6   3
      ```

        * 这里 $9 > 7,9 > 5,7 > 6,7 > 3$，都满足最大堆的堆有序性质。

2. **最小堆（小顶堆）**

    * **定义**：对于任意一个非根节点，其父节点的值 $\leq$自己的值。
    * **特点**：根节点一定是全树最小的值。
    * **举例**：

      ```
             1
            / \
           3   5
          / \
         7   6
      ```

        * 这里 $1 < 3,1 < 5,3 < 7,3 < 6$，都满足最小堆的堆有序性质。

3. **“堆有序”的本质**

    * 无论新增还是删除元素，始终保持父子之间“优先级递减/递增”的顺序。
    * 只保证“沿着从父到子”的顺序。**堆内所有节点之间并不是完全有序！**
    * 只需维护“父子之间”的有序关系，不需要像完全排序那样每个元素都比较过。

4. **直白归纳**

    * 堆有序 ≠ 全局有序
    * 最大堆/最小堆都只保证每一个父节点“比自己的所有子节点更有优先级（大或小）”
    * 所以堆顶永远是“最大（优先最大）”或“最小（优先最小）”的元素

5. **为什么重要?**

    * 这样结构一旦被打破，可以用“上浮/下沉”操作 $\mathcal{O}(\log n)$时间快速恢复。
    * 这正是堆能高效做优先队列、堆排序的核心原因。

## 堆的基本操作

> 堆（Heap）是一种特殊的完全二叉树（完全二叉堆），常用于实现优先队列以及高效求解最大值或最小值的场景。它分为**最大堆**和**最小堆**两种。

### 基本概念

1. **完全二叉树**：除了最后一层其它层都被填满，最后一层节点都集中在左边。
2. **最大堆（Max Heap）**：每个节点的值都大于等于其左右孩子节点的值，根节点是**最大值**。
3. **最小堆（Min Heap）**：每个节点的值都小于等于其左右孩子节点的值，根节点是**最小值**。

### 数组存储方式

堆一般用数组实现，不使用指针连接。

* 根节点下标： $0$
* 某个节点下标为 $i$，则
    * 左孩子下标为： $2i+1$
    * 右孩子下标为： $2i+2$
    * 父节点下标为： $\left\lfloor \frac{i-1}{2} \right\rfloor$

### 基本操作

#### 构建堆（heapify/build-heap）

假设有一个无序数组，把它调整成堆（最大或最小）。

**下沉（heapify-down）操作：**

* 从最后一个非叶子节点开始，依次让每个节点往下沉到合适位置，使其满足堆性质。

代码思路（以最大堆为例）：

```java
void heapify(int[] a, int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    if (l < n && a[l] > a[largest]) largest = l;
    if (r < n && a[r] > a[largest]) largest = r;
    if (largest != i) {
        swap(a, i, largest);
        heapify(a, n, largest);
    }
}
```

整体建堆：

```java
for (int i = n / 2 - 1; i >= 0; i--) {
    heapify(a, n, i);
}
```

#### 插入元素（insert）

* 把新元素插到数组末尾
* 用 **上浮（heapify-up）** 操作维护堆性质

思路如下（以最大堆为例）：

```java
void insert(int[] a, int n, int val) {
    a[n] = val;
    int i = n;
    while (i > 0 && a[i] > a[(i - 1) / 2]) {
        swap(a, i, (i - 1) / 2);
        i = (i - 1) / 2;
    }
}
```

#### 弹出堆顶（extract/top/pop）

一般操作是**删除根节点**，即最大堆弹出最大值、最小堆弹出最小值。

* 把根节点和最后一个节点交换
* 删除最后一个节点
* 对新的根节点执行 **下沉（heapify-down）** 操作

代码思路（以最大堆为例）：

```java
int extractMax(int[] a, int n) {
    int max = a[0];
    a[0] = a[n - 1];
    heapify(a, n - 1, 0);
    return max;
}
```

#### 获取堆顶元素（peek）

* 最大堆获取最大值：`a[0]`
* 最小堆获取最小值：`a[0]`
* 复杂度都是 $\mathcal{O}(1)$

### 复杂度分析

| 操作   | 最坏时间复杂度               |
|------|-----------------------|
| 建堆   | $\mathcal{O}(n)$      |
| 插入   | $\mathcal{O}(\log n)$ |
| 删除堆顶 | $\mathcal{O}(\log n)$ |
| 获取堆顶 | $\mathcal{O}(1)$      |

### 最大堆的抽象数据类型

| 返回值      | 方法名               | 方法描述            |
|----------|-------------------|-----------------|
| 构造函数无返回值 | `MaxHeap(int N)`  | 初始化优先队列         |
| `void`   | `isEmpty()`       | 队列是否为空          |
| `int`    | `size()`          | 返回优先队列中元素的个数    |
| `void`   | `offer(int x)`    | 向队列添加一个元素       |
| `int`    | `poll()`          | 将一个元素出队         |
| `int`    | `peek()`          | 返回队首元素          |
| `void`   | `replace(int x);` | 将当前队首元素替换成为 `x` |

#### 重点说明

* 最大堆的ADT仅规定了支持哪些操作和这些操作的行为，而不限定如何具体实现（实现通常用数组或完全二叉树结构实现）。
* 操作的**复杂度**一般定义为：插入、删除堆顶、调整都是 $\mathcal{O}(\log n)$，取堆顶是 $\mathcal{O}(1)$。

## 将数组整理成堆

> 将数组整理成堆（Heapify, 或叫建堆/堆化）是优先队列、堆排序等算法中的一个基础操作。
> 它的核心目的是把一个无序的数组调整成一个满足堆性质的数据结构，常见的是**最大堆**
> （每个节点都大于等于其子节点）和**最小堆**（每个节点都小于等于其子节点）。

### 堆的数组表示

对于长度为 $n$ 的数组 `arr`：

* 下标为 $i$ 的节点，其左孩子下标为 $2i+1$，右孩子下标为 $2i+2$。
* 父节点下标为 $\frac{i-1}{2}$（向下取整）。

### 操作思路

目标：将一个无序数组一次性调整成堆结构（而不是一个一个插入）

**过程简述**：

1. 从最后一个“非叶子节点”开始，向前遍历，对每一个节点执行 **下沉（sift down 或 heapify-down）** 操作。
2. 一直到根节点，将每个子树都整理为合法堆，最终整个数组成为堆。

**非叶子节点的范围**：

* 叶节点在 $[\lfloor \frac{n}{2} \rfloor, \, n-1]$ （下标从 $0$ 开始）；
* 因此，从 $\lfloor \frac{n}{2} \rfloor - 1$ 开始逆序处理，到下标 $0$ 为止。

### 下沉操作（以最大堆为例）

下沉（也叫堆化/heapify）：对于某个节点 $i$，如果 `arr[i]` 小于其左右孩子中较大者，就与之交换，不断重复直到该子树满足堆性质。

### 关于复杂度

一次建堆的时间复杂度为 $\mathcal{O}(n)$（不是 $\mathcal{O}(n\log n)$，这是经典面试高频点！）

### 代码示例

```java
public class Heapify {
    public static void heapify(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            down(arr, n, i);
        }
    }

    private static void down(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            down(arr, n, largest);
        }
    }
}
```

## 堆排序

> 堆排序（Heap Sort）是一种利用堆（完全二叉树）结构来排序的数据结构优先队列思想的排序算法。它是一个**原地排序算法**，
> 能保证最坏情况下的时间复杂度为 $\mathcal{O}(n \log n)$，不稳定。

### 堆排序的基本思想

1. **建堆**：首先将整个数组整理成最大堆（或最小堆，本文以最大堆为例）。

2. **排序过程**：

    * 将堆顶元素（最大值）与最后一个元素交换，现在最大值到了数组的最后面。
    * 缩小堆的有效大小（去掉最后一个最大值），对新的堆顶元素做下沉（down/heapify），恢复堆的最大堆性质。
    * 重复上一步直到堆的大小为 $1$。

### 核心步骤与流程（以最大堆为例）

* **初始化最大堆**，让整个区间 $[0, n-1]$ 满足最大堆性质。

* 依次将堆顶（最大元素）放到"已排序区间"的最前面：

    * 交换 $arr[0]$ 与 $arr[n-1]$，最大值固定在 $arr[n-1]$。
    * 对 $[0,n-2]$ 区间做下沉调整，继续保持最大堆。
    * 交换 $arr[0]$ 与 $arr[n-2]$，再调整前 $n-2$ 个元素……依此类推。

### 复杂度分析

* **时间复杂度：** $\mathcal{O}(n \log n)$

    * 建堆 $\mathcal{O}(n)$
    * 每次取最大 $\mathcal{O}(\log n)$，共 $n-1$次

* **空间复杂度：** $\mathcal{O}(1)$，原地排序，不需要额外空间

* **稳定性：** 不稳定，因为会发生交换导致相同元素相对次序变化

### 代码示例

```java
public class HeapSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        // 建堆
        for (int i = n / 2 - 1; i >= 0; i--) down(arr, n, i);
        // 排序
        for (int i = n - 1; i > 0; i--) {
            int tmp = arr[0]; arr[0] = arr[i]; arr[i] = tmp;
            down(arr, i, 0);
        }
    }
    private static void down(int[] arr, int n, int i) {
        int largest = i, l = i * 2 + 1, r = i * 2 + 2;
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            int tmp = arr[i]; arr[i] = arr[largest]; arr[largest] = tmp;
            down(arr, n, largest);
        }
    }
}
```

## 典型问题1: 合并K个排序链表

### 例题：「力扣」第 23 题：[合并 K 个排序链表](https://leetcode.cn/problems/merge-k-sorted-lists) （使用优先队列思想）

#### 算法思路

1. **归并思想**\
  类似归并排序的 $k$ 路归并，每次都把所有当前链表的头节点放到**最小堆（优先队列）**，弹出最小的节点作为结果链表的新节点，再把弹出节点的下一个节点放入堆中，循环直到堆空。

2. **为什么选优先队列？**

    * 每次能够在 $\mathcal{O}(1)$ 时间获得最小节点（堆顶）。
    * 新节点只有 $k$ 种候选（每个链表的当前头指针），堆大小最多 $k$，所以堆相关操作 $\mathcal{O}(\log k)$。
    * 总结：**整体复杂度 $\mathcal{O}(N \log k)$**， $N$ 为所有节点总数。

#### 代码

```java
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists)
            if (node != null)
                pq.offer(node);
        ListNode dummy = new ListNode(-1), cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = node;
            if (node.next != null)
                pq.offer(node.next);
        }
        return dummy.next;
    }
}
```

#### 复杂度分析

* **时间复杂度**： $N = \sum\limits_{i=1}^{k} l_i$（所有节点数量）

    * 每个节点至多进一次堆，堆操作 $\mathcal{O}(\log k)$
    * 整体 $\mathcal{O}(N \log k)$

* **空间复杂度**： $\mathcal{O}(k)$（堆至多存 $k$ 个链表头节点，不新建节点）

## 典型问题2: top K 问题

### 例：「力扣」第 215 题：[数组中的第 K 个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array)

#### 算法思路

**优先队列（小根堆）方案**

* 用一个**容量为 $k$ 的小根堆**，维护目前最大的 $k$ 个数。

* 遍历数组：

    1. 将前 $k$ 个元素依次加入小根堆。
    2. 对于第 $k+1 \sim n$ 个元素，若比堆顶大，则弹出堆顶，加入新元素（保持堆里始终是最大的 $k$ 个数）。

* 堆顶总是第 $k$ 大的元素。

* 时间复杂度： $n$ 个元素，每次堆操作 $\mathcal{O}(\log k)$，总共 $\mathcal{O}(n\log k)$，当 $k$ 远小于 $n$ 实际效率极高，实际比赛/工程极常用。

> $\mathcal{O}(n)$ 理论最优只能用快排变形（快速选择/Partition），“堆法”是竞赛实用最优法之一，不要求极致 $O(n)$时强烈推荐。

#### 代码示例

```java
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}
```

#### 复杂度分析

* **时间复杂度**： $\mathcal{O}(n \log k)$，实际工程数据 $k \ll n$，极快
* **空间复杂度**： $\mathcal{O}(k)$，堆中最大为 $k$个元素

### 完成「力扣」第 347 题：[前 K 个高频元素](https://leetcode.cn/problems/top-k-frequent-elements)

#### 算法思路

代码采用了一种高效的方法来解决问题：

1. 首先对数组进行排序，使相同的元素相邻
2. 遍历排序后的数组，统计每个不同元素的出现频率
3. 将每个元素及其频率存入最大堆（优先队列）
4. 从最大堆中取出前 $k$ 个元素作为结果

#### 核心知识点与技巧

1. **排序后计数**：排序使得相同的元素相邻，便于在一次遍历中统计频率
2. **最大堆（优先队列）**：使用优先队列快速获取频率最高的元素
3. **自定义比较器**：通过比较器使优先队列按元素频率降序排列
4. **二维数组表示元素-频率对**：使用 `int[]` 存储元素及其频率

#### 代码示例

```java
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 1;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                count++;
            else {
                pq.add(new int[]{nums[i - 1], count});
                count = 1;
            }
        }
        pq.add(new int[]{nums[n - 1], count});
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = Objects.requireNonNull(pq.poll())[0];
        return res;
    }
}
```

#### 复杂度分析

1. **时间复杂度**： $\mathcal{O}(n \log n)$

    * 排序操作： $\mathcal{O}(n \log n)$，其中 $n$ 是数组长度
    * 遍历数组统计频率： $\mathcal{O}(n)$
    * 堆操作：每次插入操作是 $\mathcal{O}(\log m)$，总共有 $m$ 次插入，其中 $m$ 是不同元素的个数
    * 提取前 $k$ 个元素： $\mathcal{O}(k \log m)$
    * 总体时间复杂度受排序操作主导，为 $\mathcal{O}(n \log n)$

2. **空间复杂度**： $\mathcal{O}(m)$

    * 优先队列存储 $m$ 个元素，其中 $m$ 是不同元素的个数
    * 结果数组需要 $\mathcal{O}(k)$ 的空间
    * 总体空间复杂度为 $\mathcal{O}(m)$

### 完成「力扣」第 295 题：[数据流的中位数](https://leetcode.cn/problems/find-median-from-data-stream)

#### 算法思路

要高效地解决这个问题，关键在于如何在添加新元素后快速找到中位数。如果使用排序，
每次插入后的时间复杂度会是 $\mathcal{O}(n\log n)$，这显然不够高效。

我们可以使用两个堆来维护数据流的中位数：

1. 一个最大堆 `smaller` 存储较小的一半元素
2. 一个最小堆 `larger` 存储较大的一半元素

通过维护这两个堆的平衡，可以使得：

* `smaller` 的堆顶是较小一半中的最大元素
* `larger` 的堆顶是较大一半中的最小元素

这样，中位数就可以通过堆顶元素直接获得。

#### 核心知识点与技巧

1. **双堆结构**：使用两个优先队列（堆）分别存储数据的两部分

2. **堆的平衡维护**：

    * 维持 `smaller.size() >= larger.size()` 且差值最多为1
    * 这样可以确保在奇数个元素时，中位数就是 `smaller` 堆顶
    * 偶数个元素时，中位数是两个堆顶的平均值

3. **比较器使用**：

    * 使用Lambda表达式创建最大堆：`(a, b) -> b - a`
    * 默认的优先队列是最小堆

4. **特殊情况处理**：

    * 数据结构为空时的处理
    * 奇偶数判断

#### 代码示例

```java
public class MedianFinder {
    private final PriorityQueue<Integer> smaller;
    private final PriorityQueue<Integer> larger;

    public MedianFinder() {
        smaller = new PriorityQueue<>((a, b) -> b - a);
        larger = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (smaller.isEmpty() || smaller.peek() >= num) smaller.offer(num);
        else larger.offer(num);
        if (smaller.size() > larger.size() + 1) larger.offer(smaller.poll());
        else if (larger.size() > smaller.size()) smaller.offer(larger.poll());
    }

    public double findMedian() {
        int size = smaller.size() + larger.size();
        if (size == 0) return 0.0;
        if (size % 2 == 0) return (smaller.peek() + larger.peek()) / 2.0;
        else return smaller.peek();
    }
}
```

#### 复杂度分析

1. **时间复杂度**：

    * `addNum()`: $\mathcal{O}(\log n)$ - 堆的插入和删除操作
    * `findMedian()`: $\mathcal{O}(1)$ - 直接访问堆顶元素

2. **空间复杂度**：
    * $\mathcal{O}(n)$ - 需要存储所有元素

### 完成「力扣」第 451 题：[根据字符出现频率排序](https://leetcode.cn/problems/sort-characters-by-frequency)

#### 算法思路

使用优先队列（大顶堆）求解此题是一种高效的方法。具体步骤如下：

1. 使用哈希表统计每个字符出现的频率
2. 将字符和对应频率存入优先队列，按频率降序排列
3. 从优先队列依次取出字符，按照其频率重复添加到结果字符串中

#### 核心知识点与技巧

1. **频率统计**：使用HashMap或数组快速统计字符出现频率
2. **优先队列**：利用优先队列按频率自动排序
3. **字符拼接**：使用StringBuilder提高字符串拼接效率
4. **自定义排序**：通过Comparator实现自定义排序规则

#### 代码示例

```java
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[][] freqPair = new int[128][2];
        for (int i = 0; i < 128; i++)
            freqPair[i][0] = i;
        for (char c : s.toCharArray())
            freqPair[c][1]++;
        Arrays.sort(freqPair, (a, b) -> b[1] - a[1]);
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < 128 && freqPair[i][1] > 0; i++) {
            char c = (char) freqPair[i][0];
            int freq = freqPair[i][1];
            sb.append(String.valueOf(c).repeat(Math.max(0, freq)));
        }
        return sb.toString();
    }
}
```

**代码对思路进行了优化：**

* 使用二维数组代替HashMap和优先队列，减少对象创建开销
* 提前分配StringBuilder的容量，减少扩容操作
* 直接使用Arrays.sort替代优先队列，在字符集有限的情况下更高效

#### 复杂度分析

* **时间复杂度**：

    * 统计频率： $\mathcal{O}(n)$，其中 $n$ 是字符串长度
    * 初始化二维数组： $\mathcal{O}(1)$，仅需128次操作
    * 排序操作： $\mathcal{O}(1)$，因为排序固定大小(128)的数组是常数时间
    * 构建结果字符串： $\mathcal{O}(n)$
    * 总体时间复杂度： $\mathcal{O}(n)$，其中统计频率和构建结果字符串是主要耗时

* **空间复杂度**：

    * 二维数组存储： $\mathcal{O}(1)$，大小固定为 $128 \times 2$
    * 结果字符串： $\mathcal{O}(n)$，需要存储原始字符串所有字符
    * 总体空间复杂度： $\mathcal{O}(n)$

相比原始的HashMap+优先队列方案，优化版本有以下性能优势：

* 避免了HashMap的哈希计算和碰撞处理开销
* 避免了优先队列的堆化操作和动态调整
* 使用连续内存布局，提高缓存命中率
* 减少了对象创建和垃圾回收压力

### 完成「力扣」第 973 题：[接近原点的 K 个点](https://leetcode.cn/problems/k-closest-points-to-origin)

#### 算法思路

该问题实质要求在 $n$ 个点中选出 $k$ 个距离原点最近的点，本质是 **“找前 $k$小”问题**，常见三种思路：

1. **直接排序法**（直接全排序，取前 $k$）。

2. **优先队列法（堆法）**：

    * 用小根堆一次性放入所有点，再弹 $k$次，返回结果。
    * 或用大根堆只维护 $k$个最近点，但在LeetCode常用数据量下小根堆简洁且常数优势明显。

3. **快速选择法**（快排思想的“找第 $k$小”）。

因为学习快速队列，这里采用**小根堆优先队列法**，即对所有点按“距离原点的平方”非降序入堆，
再弹出前 $k$个，直接得到最近点。

#### 核心知识点与技巧

* **距离平方比较**：比较距离不需要真的开平方， $x^2+y^2$即可，单调性等价且避免不必要的慢速浮点计算。

* **优先队列/堆**：Java 的 `PriorityQueue` 本质就是小根堆，支持快速插入和弹出最小元素，时间复杂度 $\mathcal{O}(\log n)$。

* **结果顺序无要求**：本题允许点顺序任意，简化了实现。

* **比较器写法**：自定义`Comparator<int[]>`实现对点距离的排序。

#### 代码示例

```java
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1])
        );
        for (int[] p : points) pq.offer(p);
        int[][] res = new int[k][];
        for (int i = 0; i < k; i++)
            res[i] = pq.poll();
        return res;
    }
}
```

#### 复杂度分析

* **时间复杂度**：

    * 全部 $n$点入堆： $\mathcal{O}(n\log n)$
    * 弹出 $k$次最小： $\mathcal{O}(k\log n)$
    * 总复杂度： $\mathcal{O}(n\log n)$（常数优势明显，实际LeetCode表现优）

* **空间复杂度**：
    * $\mathcal{O}(n)$，所有点都进堆

### 完成「力扣」第 218 题：[天际线问题](https://leetcode.cn/problems/the-skyline-problem)

#### 算法思路概览

**整体思路**

1. 取出所有建筑的左右端点（所有可能的 $x$），排序，作为“扫描线”。

2. 每次处理当前扫描线 $x$：

    * 将左端点 $\leq x$的所有建筑插入最大堆（按右端和高度）
    * 堆中剔除右端 $\leq x$的（已经结束的楼）。
    * 堆顶就是当前位置的最大高度
    * 若最大高度变化，则记为天际线关键点。

**技术要点**

* 堆存储的是三元组`[right, height]`，堆顶为最高、未结束的楼。

* $x$的枚举序列只取建筑物左右端点，能极大降低枚举量/复杂度。

* 最大高度不连跳，无需频繁出入堆，而是合并处理。

#### 完整代码

```java
public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        int[] boundaries = new int[n * 2];
        for (int i = 0; i < n; i++) {
            boundaries[i * 2] = buildings[i][0];
            boundaries[i * 2 + 1] = buildings[i][1];
        }
        Arrays.sort(boundaries);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        for (int b : boundaries) {
            while (index < n && buildings[index][0] <= b) {
                pq.offer(new int[]{buildings[index][1], buildings[index][2]});
                index++;
            }
            while (!pq.isEmpty() && pq.peek()[0] <= b) pq.poll();
            int maxHeight = pq.isEmpty() ? 0 : pq.peek()[1];
            if (ans.isEmpty() || ans.getLast().get(1) != maxHeight) {
                ans.add(Arrays.asList(b, maxHeight));
            }
        }
        return ans;
    }
}
```

#### 复杂度分析

* 时间复杂度：
    * $2n$个端点排序： $\mathcal{O}(n\log n)$
    * 每个建筑最多只入堆一次，最多出堆一次，完全 $\mathcal{O}(n \log n)$
* 空间复杂度： $\mathcal{O}(n)$

## 堆索引

> “堆索引”这个概念一般出现在堆（Heap）这种数据结构的教学和应用中，常用在通过数组实现堆时描述节点之间的关系。

### 什么是堆？

堆是一种完全二叉树结构（通常用数组实现），满足下面的性质：

* **大根堆（最大堆）**：每个节点的值都大于等于其左右子节点的值。
* **小根堆（最小堆）**：每个节点的值都小于等于其左右子节点的值。

### 堆的数组表示与索引换算

完全二叉树可以**用数组紧凑地存储**，通常定根节点为下标 $0$（有些教材用 $1$，但主流代码用 $0$）。

对于任意节点的 **索引为 $i$**，其与父、子节点的索引换算如下：

* **父节点索引**： $\left\lfloor \frac{i-1}{2} \right\rfloor$
* **左孩子节点索引**： $2i + 1$
* **右孩子节点索引**： $2i + 2$

### 堆索引的常见用途

* **定位节点**：用来快速找到父节点或子节点。
* **堆调整（heapify）**：向上或向下调整时，涉及索引间的跳转。
* **堆排序**等算法的核心操作也都是围绕“堆索引”展开的。

## 为索引堆添加反向查找

> 我们先明确，“索引堆”（Indexed Heap）是一种堆结构：不是直接存放数据，而是**存放数据下标**，
> 这样可以快速动态修改某个指定位置的元素，同时维护堆序性。\
> 为**索引堆**“添加反向查找”，主要目的是：**高效地找到某个元素在堆中的具体位置**，
> 进而支持如“给数组第 $k$ 个元素调整新值并重新堆化”的快速操作。

### 核心思想

传统索引堆有两个数组：

* `data[]`：存放实际的数据（或权值）。
* `indexes[]`：堆结构本身，维护的是 `data[]` 的下标。即满足堆序性的是 `indexes[]`，而不是直接操作 `data[]`。

**为索引堆添加反向查找**就是再维护一个 `reverse[]` 数组，满足：

* `reverse[i]` 表示 **`data[i]` 当前存放在堆的什么位置**（即 `indexes[]` 的哪一位）。
* 有了 `reverse[]`，你可以 $O(1)$ 找到 `data[k]` 在 `indexes[]` 里的具体下标，从而高效地调整（堆化）和定位。

### 代码案例

```java
// ——核心数据——
int[] data;      // 存放元素
int[] indexes;   // 堆：存放data的下标
int[] reverse;   // 反向查找，reverse[i]=x表示data[i]在堆的x号位

// ——反向查找的核心用法示例——

// 修改data[i]的值并自动维护堆序性
void change(int i, int newValue) {
    data[i] = newValue;
    int j = reverse[i];       // 关键：O(1)查找data[i]在堆中位置
    siftUp(j);
    siftDown(j);
}

// 每次交换indexes时，反向同步reverse
void swapIndexes(int a, int b) {
    int temp = indexes[a];
    indexes[a] = indexes[b];
    indexes[b] = temp;
    reverse[indexes[a]] = a;
    reverse[indexes[b]] = b;
}
```

---

[返回](../README.md)