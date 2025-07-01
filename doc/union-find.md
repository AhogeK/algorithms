<!-- TOC -->
* [并查集](#并查集)
  * [并查集简介](#并查集简介)
    * [并查集的基本思想](#并查集的基本思想)
    * [数据结构实现](#数据结构实现)
    * [基本代码](#基本代码)
    * [应用举例](#应用举例)
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
for (int i = 0; i < n; i++) {
    parent[i] = i;
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

---

[返回](../README.md)