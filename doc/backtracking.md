<!-- TOC -->
* [回溯算法](#回溯算法)
  * [什么是回溯算法](#什么是回溯算法)
    * [回溯算法的基本思想](#回溯算法的基本思想)
    * [回溯算法的三要素](#回溯算法的三要素)
    * [剪枝优化](#剪枝优化)
    * [时间复杂度分析](#时间复杂度分析)
    * [回溯算法与深度优先遍历密不可分](#回溯算法与深度优先遍历密不可分)
      * [一、共同的核心思想：搜索树（决策树）](#一共同的核心思想搜索树决策树)
      * [二、流程对比：两者是一体两面](#二流程对比两者是一体两面)
      * [三、形式化表示](#三形式化表示)
      * [一般 DFS 模型](#一般-dfs-模型)
      * [回溯算法模型](#回溯算法模型)
      * [四、形象类比](#四形象类比)
    * [回溯算法的适用范围](#回溯算法的适用范围)
      * [一、总体适用条件](#一总体适用条件)
      * [二、典型适用问题分类](#二典型适用问题分类)
        * [1. 组合类问题](#1-组合类问题)
        * [2. 排列类问题](#2-排列类问题)
        * [3. 约束满足问题（Constraint Satisfaction Problem, CSP）](#3-约束满足问题constraint-satisfaction-problem-csp)
      * [4. 路径与搜索问题](#4-路径与搜索问题)
      * [三、时间和空间考虑](#三时间和空间考虑)
    * [通过全排列问题理解回溯算法是树形问题上的深度优先遍历](#通过全排列问题理解回溯算法是树形问题上的深度优先遍历)
      * [例：「力扣」第 46 题：全排列](#例力扣第-46-题全排列)
        * [核心思路 （回溯 DFS 构造序列）](#核心思路-回溯-dfs-构造序列)
        * [代码](#代码)
        * [复杂度分析](#复杂度分析)
      * [「力扣」第 113 题：路径总和 II](#力扣第-113-题路径总和-ii)
        * [算法思路](#算法思路)
        * [代码实现](#代码实现)
        * [复杂度分析](#复杂度分析-1)
  * [什么是剪枝](#什么是剪枝)
    * [例 1：「力扣」：第 47 题：全排列 II](#例-1力扣第-47-题全排列-ii)
      * [算法思路：交换回溯 + 局部去重 (Swap-based Backtracking)](#算法思路交换回溯--局部去重-swap-based-backtracking)
        * [1. 原地交换 (In-place Swap)](#1-原地交换-in-place-swap)
        * [2. 局部去重 (Local Deduplication)](#2-局部去重-local-deduplication)
      * [核心知识点与技巧](#核心知识点与技巧)
      * [代码实现](#代码实现-1)
      * [复杂度分析](#复杂度分析-2)
<!-- TOC -->

# 回溯算法

## 什么是回溯算法

> 回溯算法（Backtracking）是一种系统地**搜索和试探**问题解空间的算法思想，它常被形容为“**带撤销的深度优先搜索（DFS）**”。\
> 可以理解为在解决复杂问题（尤其是组合问题）时——不断“尝试（前进）”，发现走不通就“撤回（回溯）”，然后继续尝试别的可能性。

### 回溯算法的基本思想

假设我们要求解的问题可以抽象为一个决策树，每一层表示一种决策（例如选择哪个元素放入结果中）。\
回溯算法的基本过程可以形式化为：

$$\begin{aligned} &\textbf{Function } \textit{backtrack}(state): \\\ &\quad \textbf{if } \textit{state} \text{ 满足结束条件:} \\\ &\quad\quad \text{记录一个可行解} \\\ &\quad \textbf{else:} \\\ &\quad\quad \text{for 每一个可能的选择 } \textit{choice}: \\\ &\quad\quad\quad \text{做出选择} \\\ &\quad\quad\quad \textit{backtrack}(state + choice) \\\ &\quad\quad\quad \text{撤销选择（回溯）} \end{aligned}$$

可以看出，它是一种“枚举 + 剪枝”的搜索策略。

### 回溯算法的三要素

1. **状态定义**\
   当前的路径（或已选元素），即递归函数的参数。
2. **选择列表**\
   当前这一步可以做出的所有可能选择，例如下一步要尝试的数字。
3. **结束条件**\
   符合目标或达到递归边界时，保存结果或停止递归。

### 剪枝优化

由于回溯法可能遍历所有组合，时间复杂度往往是指数级的。\
为了提高效率，可以在搜索时添加约束条件（剪枝），剪掉不可能成功的路径。\
例如在八皇后问题中，如果当前行放的皇后与前面冲突，就不需要继续往下放。

### 时间复杂度分析

通常为指数级，即

$$\mathcal{O}(b^{d})$$

其中 $b$ 是每一步选择的分支数， $d$ 是递归深度。\
通过剪枝可以显著减少实际搜索量。

### 回溯算法与深度优先遍历密不可分

> **回溯其实就是一种带状态撤销的深度优先遍历（DFS）**。要理解它们的关系，可以从思维模型、执行流程和数据结构三个角度来分析。

#### 一、共同的核心思想：搜索树（决策树）

无论是回溯算法还是 DFS，本质上都是对“状态空间树”的搜索。

假设要构建一个解答过程，每个节点表示当前做出的决策状态，每条边表示一次选择，那么整个问题就能抽象为一棵“决策树”：

* **DFS**：沿着树的一个分支一路向下遍历，直到到底，再返回上一层继续。

* **回溯**：也是沿着树的一个分支向下探索，当发现当前路径无解或完成目标时，撤销上一步操作，从上层再尝试其他路径。

也就是说，回溯是带有“撤销决策”和“状态恢复”的 DFS。

#### 二、流程对比：两者是一体两面

| 比较点  | 深度优先遍历（DFS） | 回溯算法（Backtracking） |
|------|-------------|--------------------|
| 遍历对象 | 图或树中的节点     | 决策空间（解的可能性）        |
| 控制方式 | 递归（或栈）驱动下探  | 递归 + 撤销（撤回选择）      |
| 意图   | 访问所有节点      | 搜索满足条件的解           |
| 特征   | 一路深入到底再返回   | 深入探索路径并可撤回修改       |
| 是否剪枝 | 通常不剪枝       | 常剪枝以减少无效搜索         |

可以说：\
DFS 是遍历行为，回溯是决策行为；\
回溯在 DFS 的基础上增加了“状态重置”和“约束条件剪枝”。

#### 三、形式化表示

用伪代码表达两者的关系：

#### 一般 DFS 模型

$$\begin{aligned} &\textbf{DFS}(node): \\\ &\quad \text{访问 node} \\\ &\quad \textbf{for each } child \text{ of node:} \\\ &\quad\quad \textbf{DFS}(child) \end{aligned}$$

#### 回溯算法模型

$$\begin{aligned} &\textbf{Backtrack}(state): \\\ &\quad \textbf{if } \text{state 满足结果条件:} \\\ &\quad\quad \text{保存解并返回} \\\ &\quad \textbf{for each } choice \text{ in 当前可选项:} \\\ &\quad\quad \text{做出选择} \\\ &\quad\quad \textbf{Backtrack}(state + choice) \\\ &\quad\quad \text{撤销选择} \end{aligned}$$

可以看出：

1. 调用结构是一样的（都是递归深度优先形式）。
2. 区别在于回溯多了“做出选择”和“撤销选择”这两步。

#### 四、形象类比

想象一个迷宫：

* **DFS** 就像一个人一直朝一个方向走到底，再回来换方向。
* **回溯算法** 更聪明：每走一步都会检查“是否还能走得通”；如果走不通，就退回上一步，且能确保环境恢复到刚进入那一步时的状态。

这种“走 → 检查 → 如果错了就退回原地”的过程，就是“回溯”的精髓。

### 回溯算法的适用范围

> 回溯算法最擅长的是**解决“搜索所有可能解”或“在约束条件下找到部分解”**的问题。它的本质是穷举，但比暴力枚举更聪明：会通过“剪枝”跳过不可能的分支。因此，回溯算法常用于那些**解空间较大，但结构有规律、可剪枝**的问题。

#### 一、总体适用条件

当一个问题具备以下特征时，适合用回溯算法求解：

1. **解的构成过程是逐步决策的**\
   解可以通过序列化地“选一个元素 → 检查 → 继续选”形成。例如组成一个排列、组合或路径。
2. **每一步都有明确的选择列表**\
   每一层都能列出接下来可选的状态（如可放的数字、可走的路径）。
3. **可以在中途判断是否继续或回退**\
   能通过约束条件提前发现“这条路走不通”，剪掉无效分支。
4. **目标可能不唯一**\
   需要搜索多个解（例如全排列）或满足条件的某个解（例如数独）。

#### 二、典型适用问题分类

可以将回溯问题大致分成四类：

##### 1. 组合类问题

从一组元素中选出若干个元素，顺序不重要。\
例如：

* 子集生成：所有子集
* 组合求和：选若干数使和等于目标
* 括号生成：生成合法括号排列\
  对应结构：

$$\text{每层决策是否选择当前元素}$$

##### 2. 排列类问题

从一组元素中选出所有不同排列，顺序重要。\
例如：

* 全排列：1,2,3 的所有排列
* 字符串的所有排列\
  对应结构：

$$\text{每层决策选哪个未使用的元素}$$

##### 3. 约束满足问题（Constraint Satisfaction Problem, CSP）

要求满足某种约束条件的组合问题。\
例如：

* N 皇后问题
* 数独求解
* 图着色问题\
  这一类通常伴随大量剪枝，通过提前判断无效状态减少搜索。

#### 4. 路径与搜索问题

目标是寻找一条路径或所有路径，通常问题可抽象为图或网格。\
例如：

* 迷宫寻路
* 单词搜索
* Hamilton 回路（遍历所有节点一次）\
  这些问题依托深度优先遍历探索路径，同时需要回溯撤销走过的节点。

#### 三、时间和空间考虑

回溯法通常具有指数级复杂度：

$$\mathcal{O}(b^{d})$$

其中：

* $b$：每一步的分支数量；
* $d$：递归深度（选择层数）。

这种复杂度很高，因此它适合于：

* 输入规模较小；
* 可以剪枝的大空间问题；
* 搜索解有限、但逻辑复杂的问题。

### 通过全排列问题理解回溯算法是树形问题上的深度优先遍历

#### 例：「力扣」第 46 题：[全排列](https://leetcode.cn/problems/permutations/description/)

##### 核心思路 （回溯 DFS 构造序列）

用 DFS 按位置从前往后构造一个长度为 $n$ 的排列：

* 当前构造的排列记为 `path`（一个动态数组）
* 对于每个位置，枚举还没使用过的元素放进去
* 当 `path` 长度为 $n$ 时，得到一个完整排列，加入答案

回溯的核心框架可以抽象成：

$$\begin{aligned} &\text{dfs(当前层)}: \\\ &\quad \text{如果 path 长度 = n，记录答案并返回} \\\ &\quad \text{否则：枚举每一个还没用过的 nums[i]} \\\ &\qquad \text{选择：把 nums[i] 放入 path} \\\ &\qquad \text{递归：进入下一层} \\\ &\qquad \text{撤销选择：把 nums[i] 从 path 移除} \end{aligned}$$

要知道某个元素是否已被使用，需要一个 `used[]` 数组：

* `used[i] == true`：`nums[i]` 已经在当前 `path` 中
* `used[i] == false`：可以使用 `nums[i]`

**状态设计与转移**

1. **状态变量**
    * `List<List<Integer>> res`：存所有排列
    * `List<Integer> path`：当前构造中的排列（路径）
    * `boolean[] used`：长度为 `n`，记录每个位置是否已经使用
    * `int depth`（可选）：当前递归到第几层（即 `path` 长度），也可以直接用 `path.size()` 判断
2. **转移逻辑（DFS）**\
   对于当前递归层：
    1. 若 `path.size() == n`：
        * 说明已经选满了 `n` 个数，得到一个合法排列
        * 需要把 `path` 的一份 **拷贝** 加入结果 `res`\
          因为 `path` 后续还要继续被修改
    2. 否则，遍历所有下标 `i = 0..n-1`：
        * 如果 `used[i] == true`，跳过
        * 若为 `false`：
            * 选择：`path.add(nums[i])`，`used[i] = true`
            * 递归：`dfs` 到下一层
            * 撤销选择（回溯）：`path.remove(path.size() - 1)`，`used[i] = false`

**回溯的知识点与技巧**

1. **“选-递归-撤销”三步固定形式**

    这是几乎所有回溯题的核心模板：

    $$\text{选} \Rightarrow \text{递归} \Rightarrow \text{撤销}$$

    对应代码顺序严格是：

    ```
    path.add(x);
    used[...] = true;

    dfs(...);

    path.remove(path.size() - 1);
    used[...] = false;
    ```

    **撤销要对称**，不能少一步。

2. **为什么结果里要 `new ArrayList<>(path)`？**

    `path` 是一个全局共享的可变对象，在递归过程中不断改动。\
    如果直接把 `path` 放进结果：

    ```
    res.add(path);  // 错误写法
    ```

    后续对 `path` 的修改会影响已经存入的“结果”，最终所有结果引用的都是同一个 `path` 对象，会变成一样的。

    所以必须拷贝一份当前内容：

    ```
    res.add(new ArrayList<>(path));
    ```

    竞赛中如果忘记这一步，会导致输出所有排列都相同，是非常常见的坑。

3. **不需要排序、不需要去重**

    * 题意保证 `nums` 内元素互不相同，不存在重复值
    * 所以不需要任何“去重剪枝”的技巧（比如常见的 `i > 0 && nums[i] == nums[i - 1]`）
    * 只要简单用 `used[]` 就够用了

4. **深度和 `path.size()` 谁更好用？**

    两种写法：

    * 传 `depth` 参数：\
      递归时 `depth + 1`，终止条件 `depth == n`
    * 用 `path.size()` 作为当前已选个数，终止条件：

      $$\text{path.size()} == n$$

    这里推荐用 `path.size()`，参数更少，代码更简洁。

##### 代码

```java
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>(n);
        boolean[] used = new boolean[n];

        dfs(nums, n, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int n, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, n, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }
}
```

##### 复杂度分析

设数组长度为 $n$：

* 全排列个数为：

  $$n! $$

* 每个排列构造过程中，要做 $n$ 次 `add` 和 $n$ 次 `remove`，常数操作

* 整体时间复杂度：

  $$\mathcal{O}(n \times n!) $$

空间复杂度：

* 递归深度最多为 $n$，递归栈占用：

  $$\mathcal{O}(n)$$

* `path` 长度最多 $n$，`used` 长度 $n$，也是：

  $$\mathcal{O}(n)$$

* 输出本身需要存储 $n!$ 个长度为 $n$ 的排列，是不可避免的：

  $$\Theta(n \times n!)$$

通常复杂度分析中会说明：**额外辅助空间**为 $\mathcal{O}(n)$，而结果集空间为问题本身的下界。

#### 「力扣」第 113 题：[路径总和 II](https://leetcode.cn/problems/path-sum-ii/description/)

##### 算法思路

这是一个经典的 DFS + 回溯 问题。我们需要遍历整棵树，在遍历的过程中维护当前的路径和。

**核心逻辑推导**

我们可以将问题分解为三个步骤：**选择 (Choose)** $\to$ **递归 (Recurse)** $\to$ **撤销 (Unchoose/Backtrack)**。

$$\begin{aligned} &\textbf{Algorithm } \text{DFS}(node, \text{remain}) \\\ &\quad \mathbf{1.} \ \textbf{if } node \text{ is null} \textbf{ then return} \\\ &\quad \mathbf{2.} \ \text{path.add}(node.val) \quad \textcolor{blue}{\text{// 1. 做选择}} \\\ &\quad \mathbf{3.} \ \textbf{if } \text{isLeaf}(node) \textbf{ and } \text{remain} == node.val \textbf{ then} \\\ &\qquad \text{result.add}(\text{copy of path}) \quad \textcolor{green}{\text{// 找到一条有效路径}} \\\ &\quad \mathbf{4.} \ \textbf{else} \\\ &\qquad \text{DFS}(node.left, \text{remain} - node.val) \quad \textcolor{orange}{\text{// 2. 递归左右}} \\\ &\qquad \text{DFS}(node.right, \text{remain} - node.val) \\\ &\quad \mathbf{5.} \ \text{path.removeLast()} \quad \textcolor{red}{\text{// 3. 撤销选择 (回溯)}} \end{aligned}$$

**状态流转图**

$$\boxed{ \begin{aligned} &\text{进入节点} \xrightarrow{\text{path.add}} \text{更新状态} \\\ &\quad \downarrow \\\ &\text{递归子节点 (尝试解)} \\\ &\quad \downarrow \\\ &\text{离开节点} \xrightarrow{\text{path.remove}} \text{恢复状态} \end{aligned} }$$

**算法知识点与技巧**

1. **回溯法 (Backtracking)**：通过维护一个全局的（或传递引用的）`path` 列表，在进入递归前添加元素，在递归返回后删除元素。这样可以避免在每个递归层级都创建新的列表，大大节省空间和时间。
2. **引用拷贝 (Deep Copy)**：当找到满足条件的路径时，不能直接把 `path` 引用加入结果集（因为 `path` 会随回溯改变）。必须创建一份**副本**：`new ArrayList<>(path)`。
3. **前序遍历 (Preorder Traversal)**：本质上是遵循“根 -> 左 -> 右”的顺序进行深度优先搜索。

##### 代码实现

```java
public class PathSumII {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null) return;
        path.add(node.val);
        target -= node.val;
        if (node.left == null && node.right == null && target == 0) res.add(new ArrayList<>(path));
        else {
            dfs(node.left, target);
            dfs(node.right, target);
        }
        path.removeLast();
    }
}
```

##### 复杂度分析

设树中节点总数为 $N$，树的高度为 $H$（最好情况 $\log N$，最坏情况 $N$）。

1. **时间复杂度**： $\mathcal{O}(N^2)$ （最坏情况下）
    * 我们必须遍历每个节点一次，这部分是 $\mathcal{O}(N)$。
    * 在最坏情况下（例如完整二叉树，每个叶子节点的路径都符合条件），我们需要对路径进行拷贝。路径平均长度为 $H$。
    * 如果符合条件的路径很多，总拷贝代价可能达到 $\mathcal{O}(N \times H)$。在链状结构下 $H=N$，故最坏为 $\mathcal{O}(N^2)$。
    * *一般情况*：通常远优于最坏情况，接近 $\mathcal{O}(N)$。
2. **空间复杂度**： $\mathcal{O}(H)$
    * 递归栈的深度取决于树的高度 $H$。
    * `path` 列表存储当前路径节点，最大长度为 $H$。
    * （不计算输出结果 `res` 占用的空间）。

$$\begin{array}{c|c|c} \text{维度} & \text{复杂度} & \text{说明} \\\ \hline \text{时间 (Time)} & \mathcal{O}(N \times H) & \text{遍历节点 + 路径拷贝代价} \\\ \text{空间 (Space)} & \mathcal{O}(H) & \text{递归栈 + 路径存储} \end{array}$$

## 什么是剪枝

> 在回溯算法（Backtracking）中，剪枝（Pruning） 是一种至关重要的优化技巧。
> 简单来说，如果把回溯算法看作是在一棵巨大的“决策树”上进行地毯式搜索，那么剪枝就是当发现当前的树枝（路径）不可能通向正确的解，或者绝对不会比已有的解更好时，直接将这根树枝砍断，不再继续往下搜索。
> 这样做可以极大地减小搜索空间，避免无效计算，从而将算法的执行效率从“不可接受”提升到“可以接受”。

1. **为什么要剪枝？**
 
    想象你在走迷宫。

    * **普通回溯（暴力搜索）**：你遇到岔路口就随便选一条走，直到撞到南墙才回头。即使前面明明已经是死胡同了，你也要走到最底端确认一下。
    * **带剪枝的回溯**：你站在路口往里看了一眼，发现地上全是荆棘（不满足条件）或者前面塌方了（不可能有解），你直接就不进去了，转头去试别的路。

    在计算机科学中，回溯问题的解空间通常呈指数级增长，比如 $\mathcal{O}(2^n)$ 或 $\mathcal{O}(n!)$。如果不进行剪枝，当 $n$ 稍微变大一点，计算量就会变成天文数字。

2. **剪枝的核心逻辑**

    回溯算法本质上是**深度优先搜索（DFS）**。剪枝就是在这个递归过程中加入一个判断语句（`if`），如果满足特定条件，直接 `return` 或 `continue`，不再进行下一层递归。

    用伪代码表示，剪枝的位置通常非常靠前：

    $$\begin{aligned} &\textbf{Function } \text{backtrack}(path, choices) \\\ &\qquad \textbf{if } \text{satisfies end condition} \textbf{ then } \\\ &\qquad \qquad \text{add } path \text{ to result} \\\ &\qquad \qquad \textbf{return} \\\ &\qquad \\\ &\qquad \textbf{for } choice \in choices \textbf{ do} \\\ &\qquad \qquad \text{make a move} \\\ &\qquad \qquad \textcolor{red}{\textbf{if } \text{isValid}(path) \textbf{ is false } \textbf{ then continue} \quad // \text{ ✂️ 剪枝点}} \\\ &\qquad \qquad \text{backtrack}(path, \text{remaining choices}) \\\ &\qquad \qquad \text{undo the move (backtrack)} \end{aligned}$$

3. **常见的剪枝类型**

    剪枝通常可以分为两大类：

    * **可行性剪枝 (Feasibility Pruning)**

        **逻辑**：当前路径已经违反了问题的约束条件，继续走下去一定是非法解。

        * **案例**：**N皇后问题 (N-Queens)**。\
          当你在棋盘的第 $i$ 行放置了一个皇后，准备去第 $i+1$ 行放下一个时，如果发现第 $i+1$ 行的某个位置已经被上面的皇后攻击到了（同列或同对角线），那么这个位置就**绝对不能放**。你不需要先把皇后放下去，再去判断这盘棋会不会输，而是直接跳过这个位置。

    * **最优性剪枝 (Optimality Pruning)**

        **逻辑**：主要用于求“最大值”、“最小值”或“最短路径”的问题。如果当前路径的成本已经超过了目前已知的最优解，那么继续走下去也没有意义了。

        * **案例**：**旅行商问题 (TSP)** 或 **最小路径和**。\
          假设你需要找一条从起点到终点的最短路径。你目前已经找到了一条长度为 $L_{min} = 50$ 的路径。\
          现在你正在尝试一条新路线，刚走了一半，累计距离已经达到 $current_dist = 51$。\
          此时 $current_dist > L_{min}$，无论剩下的路程是多少（只要是非负的），这条新路线的总长度一定超过 $51$，不可能比 $50$ 更优。因此，直接放弃这条路，回溯。

剪枝就是算法中的**止损**。

* 它不改变算法的正确性，只改变算法的效率。
* 好的剪枝可以将 $100$ 秒的运行时间缩短到 $0.1$ 秒。
* 剪枝的难点在于**设计剪枝条件**：条件太松，剪不掉多少废枝；条件太严，可能会把正确答案也误剪掉。
 
### 例 1：「力扣」：第 47 题：[全排列 II](https://leetcode.cn/problems/permutations-ii/description/)

#### 算法思路：交换回溯 + 局部去重 (Swap-based Backtracking)

为了超越常规的 `visited` 数组解法，我们采用**基于交换（Swap）的原地回溯**策略。

##### 1. 原地交换 (In-place Swap)

我们不再维护一个额外的 `path` 列表，而是直接在原数组 `nums` 上进行操作。

* 将数组分为 **\[已确定的前缀]** 和 **\[待选的后缀]**。
* 通过 `swap` 操作，将后缀中的任意一个数交换到当前位置 `index`，从而确定当前位置的数字。
* 递归完成后，再 `swap` 回来（回溯），恢复数组状态。

##### 2. 局部去重 (Local Deduplication)

由于交换操作会打乱数组顺序，传统的“排序 + 比较相邻元素”的去重策略失效。我们需要一个新的去重机制：

* **核心思想**：在递归的**每一层（Level）**，也就是决定 `index` 位置放哪个数时，我们需要记录**在这个位置上已经尝试过哪些数值**。
* **实现**：如果在这个位置上，之前已经放过数字 `X` 并递归过了，那么后面如果再遇到一个 `X`，就直接跳过，因为它生成的子树必然是重复的。

#### 核心知识点与技巧

1. **回溯的本质**：回溯不一定要用 `add`/`remove`，**交换（Swap）** 也是一种回溯状态变化。
2. **空间换时间**：利用题目数据范围极小（`-10` 到 `10`），使用栈上的 `boolean` 数组代替 `HashSet` 进行查重，将哈希开销降为零。
3. **Cache Friendly**：该算法极度依赖数组的连续内存访问，且无额外对象创建，对 CPU 缓存极其友好。

#### 代码实现

```java
public class PermutationsII {
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> path = new ArrayList<>(nums.length);
            for (int num : nums) path.add(num);
            res.add(path);
            return;
        }

        boolean[] usedInCurrentLevel = new boolean[21];

        for (int i = index; i < nums.length; i++) {
            if (usedInCurrentLevel[nums[i] + 10]) continue;

            usedInCurrentLevel[nums[i] + 10] = true;
            swap(nums, index, i);
            dfs(nums, index + 1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

#### 复杂度分析

* **时间复杂度**： $\mathcal{O}(n \times n!)$
    * 最坏情况下（无重复元素），解的个数为 $n!$。
    * 每个解在叶子节点需要 $\mathcal{O}(n)$ 的时间复制到结果集。
    * **优势**：相比常规解法，循环次数随着深度递减（ $\sum (n-k)$ vs $\sum n$），且剪枝判断（数组索引访问）比常规解法的判断更快。
* **空间复杂度**： $\mathcal{O}(n)$
    * 递归栈深度为 $n$。
    * 每一层递归分配一个微小的 `boolean[21]`，总空间开销仍然是线性的 $\mathcal{O}(n)$。

***

[返回](../README.md)