<!-- TOC -->
* [并查集](#并查集)
  * [并查集简介](#并查集简介)
    * [并查集的基本思想](#并查集的基本思想)
    * [数据结构实现](#数据结构实现)
    * [基本代码](#基本代码)
    * [应用举例](#应用举例)
    * [并查集是树的集合](#并查集是树的集合)
    * [连通分量](#连通分量)
    * [理解「连通性」与「路径问题」](#理解连通性与路径问题)
    * [并查集的抽象数据类型](#并查集的抽象数据类型)
  * [并查集的 quick-find 实现](#并查集的-quick-find-实现)
    * [原理说明](#原理说明)
    * [例子](#例子)
    * [代码实现](#代码实现)
    * [复杂度分析](#复杂度分析)
    * [优缺点](#优缺点)
    * [例：「力扣」第 547 题：朋友圈（ps. 现题目为省份数量）](#例力扣第-547-题朋友圈ps-现题目为省份数量)
      * [算法思路](#算法思路)
      * [核心知识点与技巧](#核心知识点与技巧)
      * [代码实现](#代码实现-1)
      * [复杂度分析](#复杂度分析-1)
  * [并查集的 quick-union 实现](#并查集的-quick-union-实现)
    * [基本思想](#基本思想)
    * [操作详解](#操作详解)
    * [代码实现（未优化版本）](#代码实现未优化版本)
    * [复杂度分析](#复杂度分析-2)
    * [优缺点](#优缺点-1)
      * [优点](#优点)
      * [缺点](#缺点)
    * [完成「力扣」第 547 题：朋友圈(即省份数量，用quick-union实现)](#完成力扣第-547-题朋友圈即省份数量用quick-union实现)
      * [quick-union 思路](#quick-union-思路)
      * [整体步骤](#整体步骤)
      * [时间复杂度](#时间复杂度)
  * [quick-union 实现优化 1：按秩合并](#quick-union-实现优化-1按秩合并)
    * [为什么需要按秩合并优化？](#为什么需要按秩合并优化)
    * [按秩合并（Rank-Based Union）](#按秩合并rank-based-union)
    * [实现按秩合并的并查集](#实现按秩合并的并查集)
    * [时间复杂度分析](#时间复杂度分析)
    * [通过在按秩合并优化完成「力扣」第 547 题：朋友圈](#通过在按秩合并优化完成力扣第-547-题朋友圈)
    * [除按`rank`合并外还有按`size`合并](#除按rank合并外还有按size合并)
      * [代码实现](#代码实现-2)
      * [何时选择按秩合并：](#何时选择按秩合并)
      * [何时选择按大小合并：](#何时选择按大小合并)
  * [quick-union 实现优化 2：路径压缩](#quick-union-实现优化-2路径压缩)
    * [路径压缩的基本思想](#路径压缩的基本思想)
    * [为什么需要路径压缩？](#为什么需要路径压缩)
    * [路径压缩的实现方式](#路径压缩的实现方式)
      * [递归实现（完全路径压缩）](#递归实现完全路径压缩)
      * [迭代实现（两遍查找）](#迭代实现两遍查找)
      * [路径减半（Path Halving）](#路径减半path-halving)
      * [路径分裂（Path Splitting）](#路径分裂path-splitting)
    * [时间复杂度分析](#时间复杂度分析-1)
      * [单独使用路径压缩](#单独使用路径压缩)
      * [结合按秩/按大小合并与路径压缩](#结合按秩按大小合并与路径压缩)
    * [完整的优化并查集实现](#完整的优化并查集实现)
    * [参考](#参考)
    * [完成「力扣」第 684 题：冗余连接](#完成力扣第-684-题冗余连接)
      * [算法思路](#算法思路-1)
      * [代码实现](#代码实现-3)
      * [复杂度分析](#复杂度分析-3)
    * [完成「力扣」第 1319 题：连通网络的操作次数](#完成力扣第-1319-题连通网络的操作次数)
      * [算法思路](#算法思路-2)
      * [核心知识点与技巧](#核心知识点与技巧-1)
      * [代码实现](#代码实现-4)
      * [复杂度分析](#复杂度分析-4)
  * [典型问题 1：等式方程的可满足性](#典型问题-1等式方程的可满足性)
    * [问题理解](#问题理解)
    * [并查集思想](#并查集思想)
    * [「力扣」第 990 题：等式方程的可满足性](#力扣第-990-题等式方程的可满足性)
      * [算法思路](#算法思路-3)
      * [核心知识点与技巧](#核心知识点与技巧-2)
      * [代码实现](#代码实现-5)
      * [复杂度分析](#复杂度分析-5)
    * [完成「力扣」第 952 题：按公因数计算最大组件大小](#完成力扣第-952-题按公因数计算最大组件大小)
      * [算法思路](#算法思路-4)
      * [代码](#代码)
      * [复杂度分析](#复杂度分析-6)
  * [典型问题 2：岛屿数量](#典型问题-2岛屿数量)
    * [「力扣」第 200 题：岛屿数量](#力扣第-200-题岛屿数量)
      * [算法思路](#算法思路-5)
      * [核心知识点与技巧](#核心知识点与技巧-3)
      * [代码](#代码-1)
      * [复杂度分析](#复杂度分析-7)
    * [完成「力扣」第 130 题：被围绕的区域](#完成力扣第-130-题被围绕的区域)
      * [算法思路（并查集解法）](#算法思路并查集解法)
      * [核心知识点与技巧](#核心知识点与技巧-4)
      * [完整代码](#完整代码)
      * [复杂度分析](#复杂度分析-8)
    * [完成「力扣」第 959 题：由斜杠划分区域](#完成力扣第-959-题由斜杠划分区域)
      * [算法思路（顶点并查集+冗余环计数）](#算法思路顶点并查集冗余环计数)
      * [核心知识点与技巧](#核心知识点与技巧-5)
      * [完整代码](#完整代码-1)
      * [复杂度分析](#复杂度分析-9)
<!-- TOC -->

# 并查集

## 并查集简介

> 并查集（Union-Find Set，Disjoint Set Union，简称 DSU）是一种常用于解决“集合合并”与“查找连通性”问题的数据结构。
> 常见于处理“动态连通性”、“判断是否在同一集合”、“无向图判环”等场景，比如 Kruskal 最小生成树算法。

### 并查集的基本思想

主要支持两个操作：

1. **合并操作（Union）**：把两个集合合并为一个集合。
2. **查找操作（Find）**：判断某个元素属于哪个集合，通常找“代表元”或“根节点”。

### 数据结构实现

* 用数组 `parent[]` 记录每个元素的“父节点”。初始时，每个元素是自己的父节点，即独立集合。
* 查找时一路递归/迭代向上找，直到到达自己的根（即`parent[x] == x`）。
* 合并时，把一个元素的根节点挂到另一个根节点下。

**优化：路径压缩 + 按秩合并**

* 路径压缩：在`find`操作时，把沿途的点全部直接挂到根上，大大加速后续查找。
* 按秩/按大小合并：总是把个数少的/高度矮的集合并到多的/高的集合下，避免树变高。

这两个优化使得每次操作的均摊复杂度几乎是常数 $\mathcal{O}(1)$，实际上是 $\mathcal{O}(\alpha(n))$，
其中 $\alpha$是[反阿克曼函数](https://www.geeksforgeeks.org/inverse-ackermann-function/)。

### 基本代码

```java
// 初始化
int[] parent = new int[n];
for(
int i = 0;
i<n;i++){
parent[i]=i;
}

// 查找根节点 + 路径压缩
int find(int x) {
    if (parent[x] != x) {
        parent[x] = find(parent[x]);
    }
    return parent[x];
}

// 合并
void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
        parent[rootX] = rootY;
    }
}
```

### 应用举例

* 判断两个元素是否属于同一个集合：比较`find(x)`和`find(y)`
* 求连通分量数量（如“朋友圈”问题）
* 动态连通性维护（如 Kruskal）

### 并查集是树的集合

* 每个集合对应“一棵树”。
* 树的每个节点代表一个元素，树的根节点代表这个集合的代表元（根）。
* 多个集合，实际上就是多棵互不相交的树的集合。

比如 $n$ 个初始元素，各自成集，每个都是单独的一棵树（单节点树）；随着合并过程，不断把树合并成更大的树，最终可能只剩下一棵大树（即所有元素全连通）。

**为什么用树？**

* 节点只需要记录“父节点是谁”，只需一个 `parent[]` 数组，空间和实现都很高效。
* 查找某元素属于哪个集合，只需往上查找其父亲直到根节点（树的根就是代表这个集合的标记）。
    * “查找”就是“向上找根结点”的过程。
* 合并两个集合，只需把一棵树的根挂到另一棵树的根下面。

### 连通分量

* 一个[无向图](https://sylvanassun.github.io/2017/07/18/2017-07-18-Graph_UndirectedGraph/)中的“连通分量”指的是：极大地连通的子图。
* 在同一个连通分量里的任意两个顶点之间，都有路径能够互通。
* 不同连通分量之间，任意一对顶点都不连通。

1. **更通俗的理解**

   把无向图的所有节点想象成一群点，通过边连起来。如果一群点之间可以互相走到，那么它们属于同一个连通分量；走不到的，属于不同的连通分量。\
   比如下面这个无向图：

    ```
    A --- B --- C

    D --- E

    F
    ```

   这个图有：
    * $3$ 个连通分量：
        * ${A, B, C}$
        * ${D, E}$
        * ${F}$

2. **形式化定义**

   对于无向图 $G = (V, E)$：

    * 连通分量是极大的连通子图。极大是指：没有更多的顶点能加入当前子图而保持连通。

3. **和并查集的关系**

    * 用并查集维护连通分量时，每个连通分量就是并查集中一棵树。
    * 当我们对边 $(u, v)$ 执行合并操作时，就是把 $u$ 和 $v$ 两个连通分量合成一个。
    * 最终，树的数量（根结点的数量）就是连通分量数量。

   比如代码求无向图的连通分量个数：

    ```java
    int count = 0;
    for (int i = 0; i < n; i++) {
        if (parent[i] == i) {
            count++; // 每个根就是一个连通分量
        }
    }
    ```

**总之连通分量就是一副图里“任意两点互通”的最大分组。用并查集，每个集合对应一个连通分量。**

### 理解「连通性」与「路径问题」

*这两个概念都与图论密不可分，是学习并查集以及常见算法题的基础。*

1. **连通性（Connectivity）**

   **定义：**

    * 连通性指的是图中任意两个点之间能否通过若干条边互相到达。
    * 在**无向图**里，只要有一条路径可以连接起 $u$ 和 $v$，则它们“连通”。
    * 如果图被分成了几块（连通分量），则不同分量之间任意两个点都无法互通。

   **例1：**

    * 下面的无向图中 $A, B, C, D$ 连通， $E, F$ 连通，但AB能不能走到E？不能——它们不连通。

      ```
      A---B---C
          |
          D     E---F
      ```

   **应用：**

    * 判断网络是否“整体连通”？
    * 两个人在朋友圈里是否能通过朋友关系互相认识？
    * 地图上岛屿块的数量

2. **路径问题（Path Problem）**

   **定义：**

    * 路径问题研究的是：从一个点 $u$ 到另一个点 $v$，是否存在一条边路径？如果有，路径最短是多少？一共有多少条？等等。
    * 路径可以有多种约束：最短路径、最大权路径、固定长度的路径等。

   **常见类型：**

    * 判断路径是否存在（可达问题）
    * 求最短/最长路径长度
    * 计算所有可能路径条数

   **例2：**

    * 在下图中，从 $A$ 到 $D$ 是否有路径？
      ```
      A---B---C
          |
          D
      ```
      可以走 $A \to B \to D$ 或 $A \to B \to C \to B \to D$（但第二条包含环，通常只关心最短路径）。

   **算法工具：**

    * 并查集解决“可达性/连通性”问题，即问“ $u$ 到 $v$ 有无路”。
    * BFS/DFS 或 Dijkstra 算法解决“路径长度/方案数/最短距离”等。

3. **两者区别和联系**

    * “连通性”问的是**能不能到**，简称“可达”（有路径即可，不关心具体路线）。
        * 只关心有无，典型用并查集、Flood Fill等方法。
    * “路径问题”关注**怎么到**、**多远**、有几种走法等。
        * 可能需要具体路线、最短距离、经过哪些节点等。

### 并查集的抽象数据类型

| 返回值       | 方法名                         | 方法描述                               |
|-----------|-----------------------------|------------------------------------|
| 构造函数无返回值  | `UnionFind(int N)`          | 初始化并查集                             |
| `void`    | `union(int x, int y)`       | 在 `x` 和 `y` 之间添加一条连接               |
| `int`     | `find(int x)`               | 返回 `x` 所在的连通分量的标识                  |
| `boolean` | `isConnected(int x, int y)` | 如果 `x` 和 `y` 存在于同一个连通分量中则返回 `true` |
| `int`     | `getCount()`                | 返回连通分量的数量                          |

## 并查集的 quick-find 实现

### 原理说明

* 用数组 `id[]` 记录，每个元素的“集合编号”或“代表元”。初始时 `id[i] = i`，各自为一集。
* **查找**：直接返回 `id[x]`，即 $x$ 属于哪个集合，**时间复杂度为 $\mathcal{O}(1)$**。
* **合并**：把两个集合的所有元素编号统一（即全体替换）。遍历一遍整个 `id[]`，
  把所有属于某集合的元素的集合编号都改掉，**时间复杂度为 $\mathcal{O}(n)$**。

### 例子

假如我们有如下初始状态（5个元素）：

| 下标 $i$ | 0 | 1 | 2 | 3 | 4 |
|--------|---|---|---|---|---|
| id\[i] | 0 | 1 | 2 | 3 | 4 |

* 合并(0,1)：
    * 把所有`id[]`值为`id[0]=0`的元素改为`id[1]=1`
* 合并(1,2)：
    * 把所有`id[]`值为`id[1]=1`的元素改为`id[2]=2`

如合并每一步后`id[]`的变化如下：

| 操作         | id\[]     |
|------------|-----------|
| 初始         | 0 1 2 3 4 |
| union(0,1) | 1 1 2 3 4 |
| union(1,2) | 2 2 2 3 4 |

### 代码实现

```java
// 初始化
int[] id = new int[n];
for(
int i = 0;
i<n;i++)id[i]=i;

// 查找集合编号
int find(int x) {
    return id[x];
}

// 合并
void union(int x, int y) {
    int idx = id[x], idy = id[y];
    if (idx == idy) return;
    for (int i = 0; i < id.length; i++) {
        if (id[i] == idx) id[i] = idy;
    }
}
```

### 复杂度分析

* 查找 $\mathcal{O}(1)$
* 合并 $\mathcal{O}(n)$（每次可能修改整个数组）

### 优缺点

* 优点：查找超快
* 缺点：合并十分慢，枚举所有点替换集合编号，**很难扩展到大数据场景**
* 实际工程/算法竞赛中，通常不用 quick-find，而用“树结构”实现的 quick-union + 路径压缩

### 例：「力扣」第 547 题：[朋友圈](https://leetcode.cn/problems/number-of-provinces)（ps. 现题目为省份数量）

#### 算法思路

1. **建模为图连通分量**

    * 每个城市为一个节点。
    * 依据 `isConnected` 构建图。
    * 目标：计算连通分量数量。

2. **并查集思想适用性**

    * 并查集非常适合用来维护“集合合并”的场景，能动态合并和查询城市归属的省份。
    * 省份个数即并查集的集合数，即不同根节点的数量。

3. **quick-find 并查集实现方案**

    * 使用一维数组 `id[]`，`id[i]` 表示**第 $i$ 个城市所属的省份编号**（代表元）。
    * 初始时各自唯一：`id[i]=i`
    * 若城市 $i$ 和 $j$ 直接连通，执行 quick-find 的合并操作（全体编号替换），把 $i$、 $j$ 所在的省份合并为一个。

#### 核心知识点与技巧

* **quick-find**：`id[x]` 存放集合编号，查找快（ $\mathcal{O}(1)$），合并慢（ $\mathcal{O}(n)$），每次合并需遍历所有元素。
* **连通分量数**：最终`id[]`中有多少不同数字，就是省份个数。
* **无向图**且输入对称，所以只需遍历 $i < j$ 的一半矩阵，不重复合并。

#### 代码实现

```java
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1 && id[i] != id[j]) {
                    int from = id[i];
                    int to = id[j];
                    for (int k = 0; k < n; k++)
                        if (id[k] == from)
                            id[k] = to;
                }
            }
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[id[i]]) {
                count++;
                vis[id[i]] = true;
            }
        }
        return count;
    }
}
```

#### 复杂度分析

* 初始化： $\mathcal{O}(n)$
* 枚举城市对： $\mathcal{O}(n^2)$
* 每次合并最坏要遍历全体：合并操作最坏 $\mathcal{O}(n)$，总合并次数最大 $\mathcal{O}(n^2)$。
* **总时间复杂度： $\mathcal{O}(n^3)$**（理论最坏）
    * 不如路径压缩版高效，但学习 quick-find 推荐！
* 空间复杂度： $\mathcal{O}(n)$

## 并查集的 quick-union 实现

### 基本思想

* quick-union 是“树形结构”的并查集，核心思想是**只改变根结点，合并时只做一次父指针修改**，合并和查找都沿指针树走，不需要遍历全体。
* 用一维数组 `parent[]`，`parent[x]` 记录 $x$ 的父节点。
    * 如果 $x = parent[x]$，说明 $x$ 是自己的根（即集合代表元）。

### 操作详解

1. **查找（find 操作）**
    * 查找某个元素 $x$ 所属的集合代表元（根节点），不断向上查：
        * `while (x != parent[x]) x = parent[x];`
    * 路径：不断找父亲，直至树的根。

2. **合并（union 操作）**
    * 将两个不同集合合并，就是将一棵树的根挂到另一棵树的根下（合并“祖先”）。
        * 找到 $x$、 $y$ 的根（`find(x)`, `find(y)`），若两者不同，强制把一个根挂到另一个根即可（如`parent[rootX] = rootY`）。

3. **优化（可选：路径压缩、按秩合并）**
    * 基础 quick-union 不做路径压缩和按秩合并，树可能退化成链。
    * 但加了路径压缩/按秩优化后，性能极高，这也是现代模板。

### 代码实现（未优化版本）

```java
class QuickUnionUF {
    int[] parent;

    // 初始化
    public QuickUnionUF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    // 查找根
    public int find(int x) {
        while (x != parent[x]) x = parent[x];
        return x;
    }

    // 合并
    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return;
        parent[rootX] = rootY;
    }

    // 判断是否同一集合
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
```

### 复杂度分析

* **初始化**： $\mathcal{O}(n)$
* **查找**：最坏 $\mathcal{O}(n)$（树可能退化成链）
* **合并**：最坏 $\mathcal{O}(n)$
* 若采用路径压缩/按秩合并，性能可达近乎 $\mathcal{O}(1)$。

### 优缺点

#### 优点

* 合并操作只需父结点指针修改，无需全体遍历
* 数据量大时，比 quick-find 实用得多
* 基础框架容易加路径压缩/按秩优化

#### 缺点

* 若不优化，树可能退化成链，导致性能变差
* 真实竞赛/工程都推荐加路径压缩与按秩

### 完成「力扣」第 547 题：[朋友圈](https://leetcode.cn/problems/number-of-provinces)(即省份数量，用quick-union实现)

```java
public class NumberOfProvincesV2 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                provinces++;
            }
        }
        return provinces;
    }

    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    private int find(int[] parent, int x) {
        while (x != parent[x]) x = parent[x];
        return x;
    }
}
```

#### quick-union 思路

quick-union 是一种并查集实现方式，它通过"向上查找父节点"来确定元素所属的集合。在这个问题中：

* 每个城市初始化为自己的集合
* 当两个城市连通时，将它们合并到同一集合
* 最后计算有多少个不同的集合，即为省份数

#### 整体步骤

1. 初始化并查集，每个城市指向自己作为根
2. 遍历邻接矩阵，将有连接的城市合并
3. 统计并查集中根节点的数量，即为省份数

#### 时间复杂度

* **时间复杂度**： $\mathcal{O}(n^3)$

    * 遍历邻接矩阵需要 $\mathcal{O}(n^2)$
    * 每次 find 操作最坏情况下需要 $\mathcal{O}(n)$

* **空间复杂度**： $\mathcal{O}(n)$，存储父节点数组

***注意这里的 quick-union 是基础版本，而非使用了路径压缩+按秩合并的优化版本***

## quick-union 实现优化 1：按秩合并

### 为什么需要按秩合并优化？

在基本的Quick-Union实现中，合并两个集合时，我们简单地将一个集合的根节点指向另一个集合的根节点，没有考虑两个树的结构。
这可能导致树变得很高（深度增加），进而使`find`操作的效率降低。

例如，考虑以下情况：我们依次合并元素1和2，2和3，3和4...，如果每次都是将前一个集合的根节点指向后一个集合的根节点，
最终会形成一条链，`find`操作的时间复杂度会达到 $\mathcal{O}(n)$。

### 按秩合并（Rank-Based Union）

按秩合并的核心思想是：**总是将较小的树连接到较大的树上**。这样可以避免树高度的无谓增加。

在这里，"秩"(rank)通常表示树的高度或大致高度的上界。我们在合并两棵树时，根据它们的秩做出决策：

* 如果一棵树的秩小于另一棵，则将秩小的树的根连接到秩大的树的根上
* 如果两棵树的秩相等，则任选一棵树的根作为新的根，并将合并后树的秩加1

### 实现按秩合并的并查集

```java
class UnionFind {
    private int[] parent;
    private int[] rank;   // 用于记录每个节点为根的子树的高度上界

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // 初始时每个节点的父节点是自己
            rank[i] = 0;    // 初始时每个节点的秩为0
        }
    }

    // 查找操作
    public int find(int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }

    // 按秩合并
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        // 按秩合并：将秩小的树连接到秩大的树上
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            // 秩相等时，任选一个作为根，并增加新根的秩
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}
```

### 时间复杂度分析

在按秩合并的并查集中：

* **查找(Find)操作**：最坏情况下的时间复杂度是 $\mathcal{O}(\log n)$
  ，因为通过按秩合并，树的高度被限制在 $\mathcal{O}(\log n)$。
* **合并(Union)操作**：因为包含了两次查找，所以时间复杂度也是 $\mathcal{O}(\log n)$。

### 通过在按秩合并优化完成「力扣」第 547 题：[朋友圈](https://leetcode.cn/problems/number-of-provinces/)

```java
/**
 * 547. 省份数量 (quick-union方案, 按秩合并优化)
 *
 * @author AhogeK
 * @since 2025-07-04 15:49:12
 */
public class NumberOfProvincesV3 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, rank, i, j);
                }
            }
        }
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                provinces++;
            }
        }
        return provinces;
    }

    private void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX == rootY) return;

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }
    }

    private int find(int[] parent, int x) {
        while (x != parent[x]) x = parent[x];
        return x;
    }
}
```

**按秩合并优化后：**

* **Find 操作**：最坏情况下为 $\mathcal{O}(\log n)$
* **Union 操作**：包含两次 Find 和常数时间的秩比较，因此也是 $\mathcal{O}(\log n)$
* **总时间复杂度**： $\mathcal{O}(n^2) \times \mathcal{O}(\log n) = \mathcal{O}(n^2 \log n)$
    * $\mathcal{O}(n^2)$ 来自遍历邻接矩阵
    * $\mathcal{O}(\log n)$ 来自每次优化后的 Union 操作

### 除按`rank`合并外还有按`size`合并

> 按大小合并是通过记录每棵树包含的节点数量，在合并时总是将节点较少的树连接到节点较多的树下。

**按大小合并的特点：**

1. **间接控制树高**：通过确保小树连接到大树，间接限制树的高度
2. **大小的更新**：每次合并都需要更新合并后树的大小
3. **附加功能**：可以轻松获取任何元素所在集合的大小
4. **理论保证**：同样可以证明使用按大小合并后，树的高度也不超过 $\log_2 n$

#### 代码实现

```java
class UnionFindBySize {
    private int[] parent;
    private int[] size;   // 用于记录子树的节点数

    public UnionFindBySize(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;  // 初始每棵树只有一个节点
        }
    }

    public int find(int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }

    // 按大小合并
    public void unionBySize(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        // 按大小合并策略
        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];  // 更新合并后树的大小
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }

    // 获取元素x所在集合的大小
    public int getSize(int x) {
        return size[find(x)];
    }
}
```

#### 何时选择按秩合并：

1. 当更关注理论上的最优性能保证时
2. 当内存使用是关键考虑因素，且不需要知道集合大小时
3. 在纯理论分析或教学场景中，按秩合并的高度增长更容易理解和证明

#### 何时选择按大小合并：

1. 当需要知道每个集合包含的元素数量时
2. 在某些特定应用中，集合大小是重要信息
3. 当实现直观性比绝对理论最优性更重要时

## quick-union 实现优化 2：路径压缩

> 路径压缩是并查集最重要的优化技术之一，它能显著提高 find 操作的效率，进而提升整个并查集的性能。

### 路径压缩的基本思想

在标准 Quick-Union 中，`find` 操作需要从当前节点一路向上遍历至根节点。路径压缩的核心思想非常简单：
**在查找过程中，将路径上的每个节点直接连接到根节点**，这样后续的查找操作就能以 $\mathcal{O}(1)$ 的时间复杂度直接到达根节点。

### 为什么需要路径压缩？

考虑以下情形：

在标准 Quick-Union 中，即使采用了按秩合并或按大小合并，树的高度依然可能达到 $\mathcal{O}(\log n)$，
这意味着每次 `find` 操作在最坏情况下需要 $\mathcal{O}(\log n)$ 的时间复杂度。

路径压缩通过"扁平化"树结构，使大多数节点直接连接到根节点，从而将平均查找时间接近 $\mathcal{O}(1)$。

### 路径压缩的实现方式

#### 递归实现（完全路径压缩）

```java
public int find(int x) {
    if (x != parent[x]) {
        parent[x] = find(parent[x]);  // 递归查找根节点，并将沿途所有节点直接连接到根
    }
    return parent[x];
}
```

#### 迭代实现（两遍查找）

```java
public int find(int x) {
    // 第一遍：找到根节点
    int root = x;
    while (root != parent[root]) {
        root = parent[root];
    }

    // 第二遍：将路径上所有节点直接连接到根节点
    while (x != root) {
        int next = parent[x];
        parent[x] = root;
        x = next;
    }

    return root;
}
```

#### 路径减半（Path Halving）

```java
public int find(int x) {
    while (x != parent[x]) {
        // 将当前节点连接到其祖父节点（跳过父节点）
        parent[x] = parent[parent[x]];
        x = parent[x];
    }
    return x;
}
```

#### 路径分裂（Path Splitting）

```java
public int find(int x) {
    while (x != parent[x]) {
        int next = parent[x];
        parent[x] = parent[next];  // 将当前节点连接到其祖父节点
        x = next;
    }
    return x;
}
```

### 时间复杂度分析

#### 单独使用路径压缩

* **不使用路径压缩时**：`find` 操作最坏情况下为 $\mathcal{O}(n)$
* **使用路径压缩后**：`find` 操作的均摊时间复杂度为 $\mathcal{O}(\log n)$

#### 结合按秩/按大小合并与路径压缩

当路径压缩与按秩合并或按大小合并结合使用时，并查集操作的均摊时间复杂度降低到接近常数级别：
$\mathcal{O}(\alpha(n))$，其中 $\alpha(n)$ 是阿克曼函数的反函数。

**阿克曼函数的反函数 $\alpha(n)$ 的特点**：

* 极其缓慢增长
* 对于任何实际应用中可能遇到的 $n$ 值， $\alpha(n) \leq 4$
* 因此在实践中，可以将 $\mathcal{O}(\alpha(n))$ 视为接近 $\mathcal{O}(1)$ 的常数时间复杂度

### 完整的优化并查集实现

```java
public class OptimizedUnionFind {
    private int[] parent;
    private int[] rank;
    private int count;  // 跟踪集合数量

    public OptimizedUnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // 带路径压缩的查找
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);  // 路径压缩
        }
        return parent[x];
    }

    // 按秩合并
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        // 按秩合并
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        count--;  // 每次合并，集合数量减1
    }

    // 检查两个元素是否属于同一个集合
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    // 获取集合数量
    public int getCount() {
        return count;
    }
}
```

### 参考

* 《算法》（第 4 版）第 1 章第 5 节：案例研究：union-find 算法（有关于复杂度的证明）
* 《算法导论》第 21 章：用于不相交集合的数据结构（有关于复杂度的证明）
*
知乎问题：《[为什么并查集在路径压缩之后的时间复杂度是阿克曼函数?](https://leetcode.cn/link/?target=https://www.zhihu.com/question/35090745)》。

### 完成「力扣」第 684 题：[冗余连接](https://leetcode.cn/problems/redundant-connection/)

#### 算法思路

**并查集（Quick Union，按秩合并 + 路径压缩）**

* 对每条边 $(a, b)$，判断 $a$、 $b$ 是否已经连通。

    * 如果已连通，则这条边必然构成环，就是多余边。
    * 如果不连通，则将 $a$、 $b$ 合并。

* 按秩合并 + 路径压缩，保证**均摊复杂度**趋于常数，非常高效。

**并查集（Disjoint Set Union，DSU）**

* 用 `parent[]` 记录每个节点的代表元素（祖先），初始都是自身。
* 用 `rank[]` 记录树的“高度”，用于按秩优化合并。

*伪代码流程*

1. 初始化：`parent[i] = i`, `rank[i] = 1`

2. 对于每条边 $(a, b)$：

    * 若 `find(a) == find(b)` 说明 $a$ 和 $b$ 已连通，本边就是答案
    * 否则合并 $a$、 $b$ 所在的集合

**知识点**

* **树的定义**： $n$ 个点 $n-1$ 条边连通无环。

* **并查集（路径压缩 + 按秩合并）**：工程与竞赛中最通用的环检测方法。

#### 代码实现

```java
public class OptimizedUnionFind {
    private int[] parent;
    private int[] rank;
    private int count;  // 跟踪集合数量

    public OptimizedUnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // 带路径压缩的查找
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);  // 路径压缩
        }
        return parent[x];
    }

    // 按秩合并
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        // 按秩合并
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        count--;  // 每次合并，集合数量减1
    }

    // 检查两个元素是否属于同一个集合
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    // 获取集合数量
    public int getCount() {
        return count;
    }
}
```

#### 复杂度分析

* 单次 `find`、`union` 均摊**常数**（Ackermann 函数极慢增长），总复杂度 $\mathcal{O}(n)$。
* 空间复杂度 $\mathcal{O}(n)$。

### 完成「力扣」第 1319 题：[连通网络的操作次数](https://leetcode.cn/problems/number-of-operations-to-make-network-connected)

#### 算法思路

**1. 判定连线数量**

要让 $n$ 个点**恰好连通**，最少需要 $n-1$ 条边（树的性质）。若初始连线数 $< n-1$，无论操作，都不可能全连通，直接返回 $-1$。

**2. 统计连通分量数（Union-Find）**

将 $n$ 个节点通过现有连线连起来，用并查集维护，操作时用**quick-union**方案，并施加**按秩合并+路径压缩**两大优化以获得极快速度。
（按秩合并用秩或大小皆可）

* 对每条连接 $[a,b]$，执行并查集合并操作。
* 最终统计集合根的数量 $cnt$，即当前连通分量数。

**3. 计算所需操作数**

每次拔一根“多的”线再插到两块之间，就能合并两个分量。所以所需操作数为 $cnt-1$。

#### 核心知识点与技巧

* **并查集**（quick-union with path compression & union by rank）—— 保证最优 $\mathcal{O}(\alpha(n))$ 性能
* **树的连通性** —— $n$ 个点至少 $n-1$ 条边全连通
* **多余边数量判断**（只要够 $n-1$）

#### 代码实现

```java
/**
 * 1319. 连通网络的操作次数
 *
 * @author AhogeK
 * @since 2025-07-20 00:14:34
 */
public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : connections) {
            uf.union(edge[0], edge[1]);
        }
        // 连通分量数-1 即为最少“插线”次数
        return uf.getCount() - 1;
    }

    // 并查集结构
    static class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            // 已连通
            if (rootX == rootY) return;
            if (rank[rootX] < rank[rootY])
                parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY])
                parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            // 合并后连通分量-1
            count--;
        }

        int getCount() {
            return count;
        }
    }
}
```

#### 复杂度分析

* 初始化 $n$ 次， $\mathcal{O}(n)$
* 所有并查集操作，总摊还 $\mathcal{O}(n + m \alpha(n))$，其中 $\alpha(n)$ 为反阿克曼函数，极慢增长，视为常数。
* 整体 $\mathcal{O}(n+m)$， $m$ 为连线数。

## 典型问题 1：等式方程的可满足性

> 给你一组形如 $a_i = b_i$ 或 $a_j \neq b_j$ 的变量比较关系，问能否给每个变量赋值，使所有关系都成立？

*常见原题：LeetCode 990. Satisfiability of Equality Equations (「力扣」第 990 题：等式方程的可满足性)*

### 问题理解

* 每个 $a_i$, $b_i$ 都代表一个变量，可能用 `'a'~'z'`。
* 你要判断：有没有办法给这些变量赋值，把所有 $=$ 和 $\neq$ 的约束都满足？

**举例：**

* 若等式为 $a = b, b = c$，那么显然 $a,b,c$ 三者都必须一样。
* 若再有 $a \neq c$，那就不可满足！（因为 $a,c$ 已经被判等了）

### 并查集思想

我们把“变量属于同一组”视作**连通性关系**。\
**等式 $a = b$**，就把 $a,b$ 合成同一组/集合。\
**不等式 $a \neq b$**，就要求 $a$ 和 $b$ 绝不能同属一组！

并查集就是维护“分组”，即快速判断“两个变量是否归为同一集合”。

**步骤：**

1. **遍历所有 $=$，用并查集把等价元素都合并到同一组。**
2. **遍历所有 $\neq$，如果两者已经同组，说明矛盾，返回不可满足。**
3. **检查完毕无冲突，说明有可行赋值方案。**

* “等式方程的可满足性”实际上就是把所有 $a = b$ 串成若干“大团”，然后检查所有 $a \neq b$ 是不是也不在一团。
* 并查集正好高效支持这种“连通性分组”的判定和管理，复杂度 $\mathcal{O}(n \alpha(n))$，非常快！

### 「力扣」第 990 题：[等式方程的可满足性](https://leetcode.cn/problems/satisfiability-of-equality-equations)

#### 算法思路

1. **并查集建等价类**
   * 对每个 $a==b$，用 **并查集（Quick-union + 路径压缩 + 按秩合并）** 连通 $a,b$，构建所有等价类。
     * 等价类中的变量含义：它们的值**必须相等**。
2. **判冲突**
   * 遍历所有 $a!=b$ 约束：若发现 $a$ 与 $b$ 在一个等价类（即 $find(a)==find(b)$），矛盾，直接返回 false。
3. **全部检查完无冲突则可行**

#### 核心知识点与技巧

* **并查集** $DSU$，合并所有 $a==b$，保持极致合并查找效率， $\mathcal{O}(\alpha(n))$。
* 变量仅 $26$ 个，全部小写可直接用 $0\sim25$ 映射。
* 必须先处理所有“==”，再统一处理“!=”，顺序反则可能留下错误。

#### 代码实现

```java
public class SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind();
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                uf.union(x, y);
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                if (uf.find(x) == uf.find(y)) return false;
            }
        }
        return true;
    }

    static class UnionFind {
        int[] parent = new int[26];
        int[] rank = new int[26];

        UnionFind() {
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx == fy) return;
            if (rank[fx] < rank[fy]) parent[fx] = fy;
            else if (rank[fx] > rank[fy]) parent[fy] = fx;
            else {
                parent[fy] = fx;
                rank[fx]++;
            }
        }
    }
}
```

#### 复杂度分析

* 每条等式/不等式 $\mathcal{O}(1)$，并查集摊还 $\mathcal{O}(\alpha(n))$。
* 总体 $\mathcal{O}(L)$（ $L$ 为方程数），极快。

### 完成「力扣」第 952 题：[按公因数计算最大组件大小](https://leetcode.cn/problems/largest-component-size-by-common-factor)

#### 算法思路

**最大公约数视图的建模**

将“是否连通”看做“是否共享某些质因数”，需要高效判定**所有可达分量**。

**用并查集归并所有有公共质因数的数**

* 拆分：对每个 $x$，把 $x$ 与其所有质因数“绑定”到并查集一个集合（通过“并查集节点合并”，实现“公共质因数传递归并”）。
* 只要 $a$、 $b$ 有某质因数 $p$，则通过 $p$将 $a$、 $b$归并。

*这样，所有能够通过质因数“传递”连通的点，都在同一并查集祖先下。*

**并查集涉及的节点**

* 只要开 $1 \sim \max(nums)$ 范围的并查集即可（无需给所有质因数也逐一开节点，省空间+节省查找次数）。

**利用线性筛优化质因数分解**

* 普通 $\sqrt{x}$ 试除分解会比较慢。
* 竞速最佳：**线性筛最小质因数法**（预处理 $[2,N)$ 区间每个 $x$ 的最小质因数）。

**每个 $x$ 只需不断用 $sieve[x]$ 拆解即可，平均不超过 $\log x$ 次。**\
极大减少分解与合并次数，复杂度压到 $\mathcal{O}(n\log x)$ 级。

#### 代码

```java
/**
 * 952. 按公因数计算最大组件大小
 *
 * @author AhogeK
 * @since 2025-07-22 09:46:22
 */
public class LargestComponentSizeByCommonFactor {
    private static final int N = 100001;
    private static final int[] SIEVE = new int[N];

    private static void linearSieve() {
        for (int i = 2; i * i < N; i++) {
            if (SIEVE[i] != 0)
                continue;
            SIEVE[i] = i;
            for (int j = i * i; j < N; j += i)
                if (SIEVE[j] == 0)
                    SIEVE[j] = i;
        }
    }

    public static int largestComponentSize(int[] nums) {
        linearSieve();
        for (int i = 2; i < N; i++)
            if (SIEVE[i] == 0)
                SIEVE[i] = i;
        int m = 0;
        for (int x : nums)
            m = Math.max(m, x);
        UnionFind uf = new UnionFind(m + 1);
        for (int x : nums) {
            int t = x;
            while (t > 1) {
                int p = SIEVE[t];
                uf.union(x, p);
                while (t % p == 0)
                    t /= p;
            }
        }
        int[] counts = new int[m + 1];
        int res = 0;
        for (int x : nums) {
            int root = uf.find(x);
            res = Math.max(res, ++counts[root]);
        }
        return res;
    }

    static class UnionFind {
        int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) return;
            if (rank[fx] < rank[fy]) parent[fx] = fy;
            else if (rank[fx] > rank[fy]) parent[fy] = fx;
            else {
                parent[fy] = fx;
                rank[fx]++;
            }
        }
    }
}
```

#### 复杂度分析

* **线性筛**: $O(N)$， $N=10^5+1$。
* **每数质因数分解**: 最多 $O(\log x)$次， $n$个数总计 $O(n\log x)$。
* **并查集**: 路径压缩+按秩合并， $\alpha(N)$ 常数极低。
* **总复杂度**： $\mathcal{O}(N + n\log{m})$， $m = \max(nums)$。
* **空间复杂度**： $O(N)$。

## 典型问题 2：岛屿数量

> “岛屿数量”这类题是并查集的经典应用场景。它可以高效地将相邻的“陆地”格子合并成一个岛屿，最终岛屿数量就是并查集中连通分量的个数。

### 「力扣」第 200 题：[岛屿数量](https://leetcode.cn/problems/number-of-islands)

***仅供学习，此题使用查集并不是最好的方案***

#### 算法思路

**核心：** 将每个陆地格子看作一个节点，相邻陆地格子合并到同一个集合，最终集合数量即为岛屿数量。

**步骤：**

1. 初始化并查集，每个陆地格子初始为一个独立集合。
2. 遍历 `grid`，将相邻陆地格子合并到同一集合。
3. 统计集合数量（根节点数量）。

**竞速优化：**

* **按秩合并：** 将秩小的集合合并到秩大的集合，避免树的高度增长过快。
* **路径压缩：** 在 `find` 操作中，将节点的父节点直接指向根节点，减少后续查找时间。

#### 核心知识点与技巧

* 并查集：`find`、`union` 操作。
* 按秩合并、路径压缩优化。
* 二维坐标到一维索引的转换： $index = row \times cols + col$。

#### 代码

```java
public class NumberOfIslands {
    private int rows, cols;
    private int[] parent, rank;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        parent = new int[rows * cols];
        rank = new int[rows * cols];
        for (int i = 0; i < rows * cols; i++) parent[i] = i;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    // 二维坐标到一维索引的转换
                    int index = i * cols + j;
                    // 上
                    if (i > 0 && grid[i - 1][j] == '1') union(index, (i - 1) * cols + j);
                    // 下
                    if (i < rows - 1 && grid[i + 1][j] == '1') union(index, (i + 1) * cols + j);
                    // 左
                    if (j > 0 && grid[i][j - 1] == '1') union(index, i * cols + j - 1);
                    // 右
                    if (j < cols - 1 && grid[i][j + 1] == '1') union(index, i * cols + j + 1);
                }
            }
        }
        int numIslands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    int index = i * cols + j;
                    if (parent[index] == index) numIslands++;
                }
            }
        }
        return numIslands;
    }

    private int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
```

#### 复杂度分析

* **时间复杂度：** $\mathcal{O}(MN\alpha(MN))$，其中 $M$ 为行数， $N$ 为列数， $\alpha(MN)$ 为反阿克曼函数，可视为常数。
* **空间复杂度：** $\mathcal{O}(MN)$，并查集数组。

### 完成「力扣」第 130 题：[被围绕的区域](https://leetcode.cn/problems/surrounded-regions)

#### 算法思路（并查集解法）

1. **建模**

    把每个 $'O'$ 当作一个点，这些点**上下左右连通**。关键在于：

    * **被包围** = 该 $'O'$ 所在连通块“不与任何边界上的 $'O'$ 直接或间接连通”。
    * 只需要区分：“能跑到边界”的 `'O'`，与“完全被 $'X'$ 包裹”的 `'O'`。

2. **虚拟节点**

    我们引入一个“虚拟边界节点” `dummy`，编号为 $m \times n$，专门代表“所有可以逃出边界的 $'O'$”。

3. **合并原则**

    * 对于每个本身为 $'O'$ 的格子 $(i, j)$：

        * 如果它在矩阵**边界**，则直接将其与 `dummy` 合并。
        * 否则，枚举其 $4$ 个方向相邻格 $(nx, ny)$，只要也是 $'O'$，就将 $(i, j)$ 和 $(nx, ny)$ 两点合并。

4. **最终判定**

    遍历所有点：

    * 若该点 $'O'$ **属于 `dummy` 所在集合**，说明它能逃出边界，**不翻转**。
    * 否则，该 $'O'$ 永远不会与边界联通，**直接翻转为 $'X'$**。

#### 核心知识点与技巧

* **虚拟节点技巧**：泛化“能跑出边界”的问题（实用且本质）
* **并查集高级优化**：按秩合并 + 路径压缩，保证近乎常数复杂度
* **原地遍历与翻转**：最后只需遍历矩阵一次即可完成操作

#### 完整代码

```java
public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        int dummy = m * n;
        UnionFind uf = new UnionFind(dummy + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    int pos = i * n + j;
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) uf.union(pos, dummy);
                    else {
                        // 上下左右
                        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                        for (int[] d : dirs) {
                            int ni = i + d[0], nj = j + d[1];
                            if (ni >= 0 && ni < m && nj >= 0 && nj < n && board[ni][nj] == 'O') {
                                int npos = ni * n + nj;
                                uf.union(pos, npos);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    int pos = i * n + j;
                    if (uf.find(pos) != uf.find(dummy)) board[i][j] = 'X';
                }
            }
        }
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int total) {
            parent = new int[total];
            rank = new int[total];
            for (int i = 0; i < total; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) return;
            if (rank[fx] < rank[fy]) parent[fx] = fy;
            else if (rank[fx] > rank[fy]) parent[fy] = fx;
            else {
                parent[fy] = fx;
                rank[fx]++;
            }
        }
    }
}
```

#### 复杂度分析

* **时间复杂度：**
    * 任意 $N$ 次 $find/union$ 操作摊还 $\mathcal{O}(1)$（路径压缩+按秩合并，Ackermann函数极慢增长）
    * 总访问 $m \times n$ 次，时间复杂度 $\mathcal{O}(mn)$
* **空间复杂度：**
    * 额外 $1$ 个并查集 parent/rank 数组， $\mathcal{O}(mn)$

### 完成「力扣」第 959 题：[由斜杠划分区域](https://leetcode.cn/problems/regions-cut-by-slashes)

#### 算法思路（顶点并查集+冗余环计数）

**建模方法**

1. 把棋盘看作**点阵**

    * 一个 $n\times n$ 方格有 $(n+1)\times(n+1)$ 个“顶点”（还是以方格角点视为点，更接近图论思想）。
    * 若将所有顶点之间相邻区域用线段连接，实际上就是在顶点之间不断画斜线/边界，产生若干圈。

2. **并查集思路**核心

    * 把所有顶点均编号成 $[0, (n+1)^2-1]$。

    * 对于每一条“斜线”，就等价于“把对应的两个端点连一根边”。

        * `\` 斜线：连接 $(i, j)$ 与 $(i+1, j+1)$。
        * `/` 斜线：连接 $(i+1, j)$ 与 $(i, j+1)$。

    * 边界点全部与虚拟源点 $0$ 联通，方便约束整个联通性的判断（表示“和无穷远连通”）。

3. 区域数计数方式

    * 并查集，若尝试合并两个点（即这两个顶点本来就在一个连通块里），此时说明内部出现“环”（多余的圈），这些就是新出现的封闭区块，需要 $\text{regions} ++$。
    * 最终，区域数即为“合并过程中形成的冗余环数”+1（围住外部大区域）。

#### 核心知识点与技巧

* **圆方格点技巧**：点阵编号 $(i, j) \mapsto i\times(n+1)+j$，静态映射无误。
* **只连顶点，无需三角拆分**：本解空间与效率均大幅提升，远优于“三角格子模型”。
* **判断环的出现**：合并前判断若根已同，说明形成环/冗余闭合，计数器加 $1$。
* **边界合并简化边界流出**：确保所有外围顶点都与“虚拟根节点”联通，避免外部被重复计数。

#### 完整代码

```java
public class RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind((n + 1) * (n + 1));
        for (int i = 0; i <= n; i++) {
            // 左边列
            uf.union(0, i * (n + 1));
            // 右边列
            uf.union(0, i * (n + 1) + n);
            // 顶行
            uf.union(0, i);
            // 底行
            uf.union(0, n * (n + 1) + i);
        }
        int regions = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '\\') {
                    // (i,j)-(i+1,j+1)
                    int a = i * (n + 1) + j;
                    int b = (i + 1) * (n + 1) + (j + 1);
                    if (uf.find(a) == uf.find(b)) regions++;
                    uf.union(a, b);
                } else if (c == '/') {
                    // (i+1,j)-(i,j+1)
                    int a = (i + 1) * (n + 1) + j;
                    int b = i * (n + 1) + (j + 1);
                    if (uf.find(a) == uf.find(b)) regions++;
                    uf.union(a, b);
                }
            }
        }
        return regions;
    }

    static class UnionFind {
        int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) return;
            if (rank[fx] < rank[fy]) parent[fx] = fy;
            else if (rank[fx] > rank[fy]) parent[fy] = fx;
            else {
                parent[fy] = fx;
                rank[fx]++;
            }
        }
    }
}
```

#### 复杂度分析

* **时间复杂度：**

    * $n^2$ 次操作，每次 `union`/`find` 均接近摊还 $\mathcal{O}(1)$。
    * 总复杂度 $\mathcal{O}(n^2)$。

* **空间复杂度：**
    * 只用 `parent`/`rank` 数组，空间 $\mathcal{O}(n^2)$。

---

[返回](../README.md)