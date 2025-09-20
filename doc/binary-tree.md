<!-- TOC -->
* [二叉树](#二叉树)
  * [树的简介](#树的简介)
    * [完全二叉树与满二叉树](#完全二叉树与满二叉树)
    * [二叉树的遍历](#二叉树的遍历)
      * [三种基本遍历](#三种基本遍历)
      * [遍历示意](#遍历示意)
      * [层序遍历（广度优先遍历）](#层序遍历广度优先遍历)
    * [深度优先遍历](#深度优先遍历)
      * [深度优先遍历的直观感受](#深度优先遍历的直观感受)
      * [深度优先遍历需要借助「栈」实现](#深度优先遍历需要借助栈实现)
    * [广度优先遍历](#广度优先遍历)
      * [广度优先遍历的直观感受](#广度优先遍历的直观感受)
      * [广度优先遍历需要借助「队列」实现](#广度优先遍历需要借助队列实现)
    * [「力扣」第 102 题： 二叉树的层序遍历](#力扣第-102-题-二叉树的层序遍历)
      * [算法思路](#算法思路)
      * [核心知识点与技巧](#核心知识点与技巧)
      * [代码实现](#代码实现)
      * [复杂度分析](#复杂度分析)
    * [「深度优先遍历」与「广度优先遍历」的比较](#深度优先遍历与广度优先遍历的比较)
      * [访问顺序](#访问顺序)
      * [数据结构](#数据结构)
      * [特点对比](#特点对比)
      * [总结](#总结)
    * [完成「力扣」第 107 题：二叉树的层次遍历 II](#完成力扣第-107-题二叉树的层次遍历-ii)
      * [算法思路](#算法思路-1)
      * [核心知识与技巧](#核心知识与技巧)
      * [代码实现](#代码实现-1)
      * [复杂度分析](#复杂度分析-1)
    * [完成《剑指 Offer》第 32 - I 题：从上到下打印二叉树](#完成剑指-offer第-32---i-题从上到下打印二叉树)
      * [算法思路](#算法思路-2)
      * [知识点与技巧](#知识点与技巧)
      * [代码实现](#代码实现-2)
      * [复杂度分析](#复杂度分析-2)
    * [完成《剑指 Offer》第 32 - III 题：从上到下打印二叉树 III](#完成剑指-offer第-32---iii-题从上到下打印二叉树-iii)
      * [算法思路](#算法思路-3)
      * [知识点与技巧](#知识点与技巧-1)
      * [代码实现](#代码实现-3)
      * [复杂度分析](#复杂度分析-3)
    * [「力扣」第 103 题：二叉树的锯齿形层次遍历](#力扣第-103-题二叉树的锯齿形层次遍历)
      * [算法思路](#算法思路-4)
      * [代码实现](#代码实现-4)
      * [复杂度分析](#复杂度分析-4)
  * [二叉树的遍历](#二叉树的遍历-1)
    * [二叉树的前序遍历](#二叉树的前序遍历)
      * [代码示例（递归版）](#代码示例递归版)
      * [复杂度分析](#复杂度分析-5)
      * [前序遍历使用栈的模拟](#前序遍历使用栈的模拟)
      * [例 1：「力扣」第 144 题：二叉树的前序遍历](#例-1力扣第-144-题二叉树的前序遍历)
    * [二叉树的中序遍历](#二叉树的中序遍历)
      * [递归实现](#递归实现)
      * [迭代实现（基于栈）](#迭代实现基于栈)
      * [Morris 遍历](#morris-遍历)
      * [例 2：「力扣」第 94 题：二叉树的中序遍历](#例-2力扣第-94-题二叉树的中序遍历)
    * [二叉树的后续遍历](#二叉树的后续遍历)
      * [遍历规则](#遍历规则)
      * [递归实现](#递归实现-1)
      * [迭代实现](#迭代实现)
      * [例 3：「力扣」第 145 题：二叉树的后序遍历](#例-3力扣第-145-题二叉树的后序遍历)
    * [完成「力扣」第 100 题：相同的树](#完成力扣第-100-题相同的树)
      * [算法思路](#算法思路-5)
      * [核心知识与技巧](#核心知识与技巧-1)
      * [代码实现](#代码实现-5)
      * [复杂度分析](#复杂度分析-6)
    * [完成「力扣」第 101 题：对称二叉树](#完成力扣第-101-题对称二叉树)
      * [算法思路](#算法思路-6)
      * [代码实现](#代码实现-6)
      * [复杂度分析](#复杂度分析-7)
    * [完成「力扣」第 199 题：二叉树的右视图](#完成力扣第-199-题二叉树的右视图)
      * [算法思路](#算法思路-7)
      * [核心知识点技巧](#核心知识点技巧)
      * [代码实现](#代码实现-7)
      * [复杂度分析](#复杂度分析-8)
    * [完成「力扣」第 226 题：翻转二叉树](#完成力扣第-226-题翻转二叉树)
      * [算法思路](#算法思路-8)
      * [核心知识点技巧](#核心知识点技巧-1)
      * [代码实现](#代码实现-8)
      * [复杂度分析](#复杂度分析-9)
    * [完成「力扣」第 110 题：平衡二叉树](#完成力扣第-110-题平衡二叉树)
      * [算法思路](#算法思路-9)
      * [代码实现](#代码实现-9)
      * [复杂度分析](#复杂度分析-10)
    * [完成「力扣」第 104 题：二叉树的最大深度](#完成力扣第-104-题二叉树的最大深度)
      * [算法思路](#算法思路-10)
      * [复杂度分析](#复杂度分析-11)
  * [复杂度分析](#复杂度分析-12)
    * [完成「力扣」第 111 题：二叉树的最小深度](#完成力扣第-111-题二叉树的最小深度)
      * [算法思路](#算法思路-11)
      * [正确解法：后序递归 DFS](#正确解法后序递归-dfs)
      * [代码实现](#代码实现-10)
      * [复杂度分析](#复杂度分析-13)
    * [完成「力扣」第 112 题：路径总和](#完成力扣第-112-题路径总和)
      * [算法思路](#算法思路-12)
      * [代码实现](#代码实现-11)
      * [复杂度分析](#复杂度分析-14)
    * [完成「力扣」第 129 题：求根到叶子节点数字之和](#完成力扣第-129-题求根到叶子节点数字之和)
      * [算法思路](#算法思路-13)
      * [代码实现](#代码实现-12)
      * [复杂度分析](#复杂度分析-15)
    * [完成「力扣」第 222 题：完全二叉树的节点个数](#完成力扣第-222-题完全二叉树的节点个数)
      * [算法思路](#算法思路-14)
      * [复杂度分析](#复杂度分析-16)
    * [完成「力扣」第 124 题：二叉树中的最大路径和](#完成力扣第-124-题二叉树中的最大路径和)
      * [算法思路](#算法思路-15)
      * [代码实现](#代码实现-13)
      * [复杂度分析](#复杂度分析-17)
  * [典型问题 1：从前、中序遍历序列构造二叉树](#典型问题-1从前中序遍历序列构造二叉树)
    * [「力扣」第 105 题：从前序与中序遍历序列构造二叉树](#力扣第-105-题从前序与中序遍历序列构造二叉树)
      * [复杂度分析](#复杂度分析-18)
    * [完成「力扣」第 589 题：N 叉树的前序遍历](#完成力扣第-589-题n-叉树的前序遍历)
      * [代码实现](#代码实现-14)
      * [复杂度分析](#复杂度分析-19)
    * [完成「力扣」第 590 题：N 叉树的后序遍历](#完成力扣第-590-题n-叉树的后序遍历)
      * [代码实现](#代码实现-15)
      * [复杂度分析](#复杂度分析-20)
    * [完成「力扣」第 429 题：N 叉树的层序遍历](#完成力扣第-429-题n-叉树的层序遍历)
      * [代码实现](#代码实现-16)
      * [复杂度分析](#复杂度分析-21)
  * [典型问题 2：二叉树的最近公共祖先](#典型问题-2二叉树的最近公共祖先)
    * [「力扣」第 236 题：二叉树的最近公共祖先](#力扣第-236-题二叉树的最近公共祖先)
      * [代码实现](#代码实现-17)
      * [复杂度分析](#复杂度分析-22)
<!-- TOC -->

# 二叉树

## 树的简介

> 二叉树是一种重要的树形数据结构，其中每个节点最多有两个子节点，通常称为左子节点和右子节点。它广泛用于表达层次关系、实现搜索算法（如二叉搜索树）、表达表达式结构等。

**简要介绍**：

* **定义**：二叉树是一个由节点组成的树结构，每个节点最多有两个子节点。
* **节点组成**：每个节点包含三个部分：存储的数据，指向左子节点的指针，指向右子节点的指针。
* **种类**：
    * 满二叉树：每个节点要么是叶子节点，要么有两个子节点。
    * 完全二叉树：除最后一层，其他层节点都满，且最后一层从左到右连续排列。
    * 二叉搜索树（BST）：左子树所有节点值小于根节点，右子树所有节点值大于根节点。
* **应用**：
    * 实现高效查找、插入、删除操作。
    * 表达算术表达式。
    * 优先队列的实现（堆）。

### 完全二叉树与满二叉树

完全二叉树与满二叉树都是二叉树的特殊类型，它们的区别如下：

* **满二叉树**：每个节点要么是叶子节点（没有子节点），要么恰好有两个子节点。换句话说，所有层的节点都被完全填满，没有缺少子节点的情况，节点总数达到最大。
* **完全二叉树**：除了最后一层外，所有层的节点都是满的，且最后一层节点都靠左排列，没有空缺的“间隙”。最后一层的叶子节点不一定填满，但必须集中在左侧。

总结：

* 满二叉树要求所有节点都是“0或2个子节点”，树结构非常规整。
* 完全二叉树允许最后一层不满，但节点分布连续。

完全二叉树常用于堆结构，满二叉树则在理论和递归等场景中更常见。

### 二叉树的遍历

二叉树的遍历是指按照一定顺序访问二叉树中所有节点的过程，主要有三种经典遍历方式：前序遍历、中序遍历和后序遍历。

#### 三种基本遍历

* **前序遍历（Preorder）**：先访问根节点，再遍历左子树，最后遍历右子树。访问顺序是“根-左-右”。
* **中序遍历（Inorder）**：先遍历左子树，再访问根节点，最后遍历右子树。访问顺序是“左-根-右”。
* **后序遍历（Postorder）**：先遍历左子树，再遍历右子树，最后访问根节点。访问顺序是“左-右-根”。

#### 遍历示意

给定一棵二叉树：

```
    A
   / \
  B   C
 / \
D   E
```

* 前序遍历结果：A → B → D → E → C
* 中序遍历结果：D → B → E → A → C
* 后序遍历结果：D → E → B → C → A

#### 层序遍历（广度优先遍历）

除了上述三种深度优先遍历，还有一种层序遍历，是按层自上而下、从左到右访问节点。

* 层序遍历结果：A → B → C → D → E

这几种遍历方式是二叉树操作中最基本且最常用的方法。

### 深度优先遍历

#### 深度优先遍历的直观感受

深度优先遍历（Depth-First Search，DFS）直观上就是沿着树的某一条路径不断往深“钻”，直到无法继续为止，然后回溯到上一个分叉点再探索另一条路径。

具体感受可以类比为：

* **像迷宫探险**：走进一条路走到底，走不通了再返回选择另一条路，直到所有路都走过。
* **递归展开**：每访问一个节点，就先把这个节点当作“当前焦点”，深入它的子节点，直到叶子节点，再一个个返回完成未探索的分支。
* **强调“深”**：优先深入搜索，使你先发现树的某一条“深”路径，而不是同层的其他节点。

这种策略适合解决需要“全路径”或者“寻找满足条件路径”的问题，能节省空间（递归调用栈按深度增长），但在不加限制时可能探索很多无用分支。

#### 深度优先遍历需要借助「栈」实现

深度优先遍历（DFS）本质上是沿着树的一条路径不断深入，然后回溯，因此它的实现需要借助**栈结构**来保存访问路径上的节点信息。

**为什么需要栈？**

* 遍历时需要记住“待返回”的节点，即“下一步要回去继续探索的分叉点”。
* 栈的**后进先出**性质恰好匹配DFS的回溯逻辑：当前节点处理完成后，返回到最近的分叉点继续探索未访问的子节点。

**实现方式**

* **递归实现**：系统调用栈隐式地保存了节点，利用函数调用的栈结构完成回溯，不需要显式栈。

* **非递归实现**：通过手动维护一个显式栈，模拟递归调用过程，每次从栈顶取出节点，访问并将其子节点依次压入栈中。

**递归与栈的关系示意**

```
递归代码调用          <--->        手动栈操作
   访问当前节点                    入栈当前节点
   深入左子树                      入栈左子节点
   回溯返回                       弹出栈顶节点
   深入右子树                      入栈右子节点
```

**关键总结**

* 栈是DFS的核心存储结构，用于追踪路径上的节点。
* 递归用系统栈，手写非递归则用显式栈。
* 利用栈保证DFS能够“深入探索后再回溯”，避免丢失待访问的节点。

### 广度优先遍历

#### 广度优先遍历的直观感受

广度优先遍历（Breadth-First Search，BFS）直观感受可以理解为“按层一次访问一层节点”，从树的根节点开始，先访问所有距离根最近的节点，再逐层向下扩展。

具体感觉类似于：

* **像波浪扩散**：从起点发出波纹，先把周围一圈的节点全部访问，再向外一圈一圈地扩散，确保离根越近的节点越早被访问。
* **层层推进**：先处理当前层所有节点，再全部进入下一层，像“排队逐层过关”一样。
* **强调“广”**：不像深度优先那样钻到底，BFS保证先访问完一个层级的所有节点，适合寻找最短路径、最小层数等问题。

这种方式通过队列实现，利用先进先出原则保证节点按层访问顺序。广度优先遍历（BFS）直观感受就是“像波纹一样一层一层向外扩散”，先访问根节点，然后访问所有与根节点距离为 $1$
的节点，再访问距离为 $2$的节点，依此类推。

具体来说：

* 从根节点开始，先访问该层所有节点，像排队一样一层层处理。
* 访问当前层节点时，将它们的子节点按顺序加入队列，保证先入队的先访问。
* 它体现了**层序推进**的思想，先广后深。

这种遍历特别适合用于寻找最短路径或最近的目标节点，因为它保证了最早访问到的节点距离根节点最短。

#### 广度优先遍历需要借助「队列」实现

广度优先遍历（BFS）需要借助**队列**来实现，因为队列能保证节点按照访问顺序“先进先出”，这正好符合BFS逐层访问的特点。

**为什么需要队列？**

* BFS 要按层访问节点，先访问当前层的所有节点，再访问下一层。
* 队列的先进先出性质保证了被访问的节点先加入队列，先访问，后加入的节点后访问，从而实现层序遍历。

**实现流程**

1. 将根节点入队，表示从根开始访问。
2. 循环执行以下步骤直到队列为空：
    * 从队头取出一个节点，访问它。
    * 将该节点的所有未访问子节点依次入队。
3. 遍历结束时，所有节点都被按层访问一次。

**直观类比**

* 队列像一个“排队等候”的队伍，先入队的节点先被处理，保证一层层逐渐访问。
* 访问当前节点时，把它的子节点“加入排队”，等待下一轮访问。

**关键总结**

* 队列是BFS的核心数据结构，保证节点访问顺序按层次展开。
* 通过队列的先进先出，BFS实现了“先广后深”的访问策略。
* 没有队列，难以维持正确的层序访问顺序。

### 「力扣」第 102 题： [二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal)

#### 算法思路

* 使用队列（FIFO）数据结构辅助实现层序遍历。
* 利用队列实现逐层访问，每层节点数量被固定，遍历完成后进入下一层。

具体步骤：

1. 初始化结果列表 `res` 和队列 `queue`，将根节点入队。
2. 当 `queue` 非空时，执行如下：
    * 记录当前层节点数 `levelSize = queue.size()`
    * 初始化当前层列表 `levelList`
    * 按 `levelSize` 次循环弹出节点：
        * 访问节点值加入 `levelList`
        * 若左右子节点不空，加入队列
    * 当前层遍历完，加入 `res` 中
3. 返回 `res`

#### 核心知识点与技巧

* 利用先进先出性质的队列保存当前层节点和下一层节点。
* 通过记录每层节点数量，实现层与层之间的分界。
* 空树需特殊判断直接返回空列表。

#### 代码实现

```java
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(levelList);
        }
        return res;
    }
}
```

#### 复杂度分析

* **时间复杂度**：遍历所有节点一次，故为 $\mathcal{O}(n)$，其中 $n$为节点数。
* **空间复杂度**：队列最多存储一层节点，最坏情况下为 $\mathcal{O}(w)$，其中 $w$为最大宽度。结果列表占 $\mathcal{O}(n)$。

### 「深度优先遍历」与「广度优先遍历」的比较

> 深度优先遍历（DFS）和广度优先遍历（BFS）是遍历树或图的两种基本策略，二者在访问顺序、数据结构和应用场景上有明显区别。

#### 访问顺序

| 特点     | 深度优先遍历（DFS）      | 广度优先遍历（BFS）         |
|--------|------------------|---------------------|
| 访问顺序   | 优先深入一个分支，直到不能再深入 | 按层级逐层访问，先访问近根节点再远节点 |
| 节点访问方式 | 沿路径“深入钻研”        | 像波纹一样“逐层扩散”         |

#### 数据结构

| 特点      | 具体实现结构            |
|---------|-------------------|
| 递归版DFS  | 利用系统调用栈           |
| 非递归版DFS | 使用显式 **栈（Stack）** |
| BFS     | 使用 **队列（Queue）**  |

#### 特点对比

* **空间复杂度**：
    * DFS 栈空间与路径深度相关，平均为 $\mathcal{O}(h)$， $h$为树高。
    * BFS 队列空间与最大宽度相关，最坏情况下为 $\mathcal{O}(w)$， $w$为树最大宽度。
* **适用场景**：
    * DFS 适合求解路径、连通组件、拓扑排序等，适合深层次搜索。
    * BFS 适合求最短路径、最小层数问题，层序访问。
* **搜索顺序差异**：
    * DFS先到达叶子后回溯，访问顺序深度优先。
    * BFS层层访问，先访问距离根节点近的节点。

#### 总结

| 维度     | 深度优先遍历（DFS）          | 广度优先遍历（BFS）          |
|--------|----------------------|----------------------|
| 访问顺序   | 深入到尽头后回溯             | 按层访问，先广后深            |
| 核心数据结构 | 栈（递归调用栈或显式栈）         | 队列                   |
| 应用偏好   | 深层路径、连通性、拓扑排序        | 最短路径、层序遍历            |
| 空间需求   | $\mathcal{O}(h)$（树高） | $\mathcal{O}(w)$（树宽） |

理解两者特点有助于针对具体问题选择合适遍历策略，兼顾时间与空间效率。

### 完成「力扣」第 107 题：[二叉树的层次遍历 II](https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/description/)

#### 算法思路

本题在本质上等于普通层序遍历(广度优先搜索BFS)，**完成后将结果列表逆序即可**。

具体步骤：

1. 使用队列实现层序遍历，逐层访问节点并收集结果。
2. 每层节点访问顺序为从左到右。
3. 将每层节点值临时存储在列表中，遍历结束获得从上到下的层序。
4. **对结果列表整体反转**，得到自底向上的层序遍历结果。

#### 核心知识与技巧

* 利用队列完成层序遍历。
* 每层访问节点数量固定，保证层次边界划分。
* 对结果的最终列表进行反转，是本题主要技巧之一。
* 性能优化：直接使用 `LinkedList` 的 `addFirst()` 方法逐层头插结果，避免显式反转操作，提高效率。

#### 代码实现

```java
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.addFirst(levelList);
        }
        return res;
    }
}
```

#### 复杂度分析

* **时间复杂度**：遍历所有节点一次，整体为 $\mathcal{O}(n)$，其中 $n$ 为节点数。
* **空间复杂度**：队列和结果列表最大占用 $\mathcal{O}(w)$， $w$为最大层宽。

### 完成《剑指 Offer》第 32 - I 题：[从上到下打印二叉树](https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/description/)

#### 算法思路

* 使用**广度优先搜索**（BFS）实现层序遍历。
* 借助队列维护每层节点顺序。
* 遍历过程中按访问顺序，把节点值存到结果列表中。
* 最后将列表转成数组返回。

#### 知识点与技巧

* 利用队列保证节点访问的**从左到右**顺序。
* 每次先弹出队头节点，访问后将左右子节点依次入队。
* 及时判空避免空指针异常。
* 利用数组直接输出，节省空间和时间开销。

#### 代码实现

```java
public class CongShangDaoXiaDaYinErChaShuLcof {
    public int[] decorateRecord(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            resList.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++)
            res[i] = resList.get(i);
        return res;
    }
}
```

#### 复杂度分析

* 时间复杂度：每个节点访问一次，约为 $\mathcal{O}(n)$， $n$是节点数。
* 空间复杂度：队列与结果存储开销均为 $\mathcal{O}(n)$。

### 完成《剑指 Offer》第 32 - III 题：[从上到下打印二叉树 III](https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/description/)

#### 算法思路

使用标准的层序遍历BFS，按层访问节点。对于每层：

* 提前判断当前层是奇数层还是偶数层（可通过层数计数 `level` 模拟）。
* 访问节点时，将节点值按正常顺序存入数组。
* 若当前层是需要反转的层，则在将该层结果加入总表前，调用反转操作（或使用双端队列插入顺序控制兼容）。

可选优化：

* 利用 `LinkedList`，根据层数决定是**尾插**还是**头插**当前层值，从而省去反转时间。

#### 知识点与技巧

* 队列维持层序访问顺序。
* 双端结构或后期反转实现单层逆序存储。
* 使用整数 `level` 计数，判断奇偶以控制层次方向。
* 节点入队顺序不变，控制层结果输出顺序。

#### 代码实现

```java
public class CongShangDaoXiaDaYinErChaShuIII {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) levelList.addLast(node.val);
                else levelList.addFirst(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(levelList);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
```

#### 复杂度分析

* 时间复杂度：所有节点访问一次，插入集合操作均为 $\mathcal{O}(1)$（双端链表头尾插入），整体为 $\mathcal{O}(n)$。
* 空间复杂度：队列与结果存储占 $\mathcal{O}(n)$。

### 「力扣」第 103 题：[二叉树的锯齿形层次遍历]()

#### 算法思路

* 采用广度优先搜索（BFS）实现层序遍历。
* 使用队列保证节点按层顺序访问。
* 用一个布尔变量 `leftToRight` 标记当前层遍历方向。
* 访问当前层节点时：
    * 若 `leftToRight == true`，按正常顺序将节点值加入列表尾部。
    * 若 `leftToRight == false`，将节点值插入列表头部，反转顺序。
* 每层结束翻转 `leftToRight`，使遍历方向交替。

#### 代码实现

```java
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) levelList.addLast(node.val);
                else levelList.addFirst(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(levelList);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
```

#### 复杂度分析

* **时间复杂度**：所有节点访问一次，队列操作和链表插入均为 $\mathcal{O}(1)$，总体为 $\mathcal{O}(n)$。
* **空间复杂度**：队列、结果列表均需存储节点，最大开销为 $\mathcal{O}(n)$。

## 二叉树的遍历

### 二叉树的前序遍历

二叉树的前序遍历是一种深度优先遍历方法，其遍历顺序是：先访问根节点，再遍历左子树，最后遍历右子树。

具体步骤如下：

1. 访问当前节点（根节点）。
2. 递归地前序遍历左子树。
3. 递归地前序遍历右子树。

用递归形式表达为：

$$\text{preorder}(node) = \begin{cases} \text{访问} \ node, \\\ \text{preorder}(node.left), \\\ \text{preorder}(node.right) \end{cases}$$

![](img/1600918132-VIgfpr-11-02-01-preorder-traversal-use-stack.gif)

#### 代码示例（递归版）

```java
public void preorder(TreeNode node) {
    if (node == null) {
        return;
    }
    System.out.println(node.val);  // 访问根节点
    preorder(node.left);           // 遍历左子树
    preorder(node.right);          // 遍历右子树
}
```

#### 复杂度分析

* 时间复杂度为 $\mathcal{O}(n)$，其中 $n$ 是二叉树节点数，每个节点访问一次。
* 空间复杂度取决于递归深度，最坏情况为 $\mathcal{O}(n)$（退化成链表），平均为 $\mathcal{O}(\log n)$（平衡树）。

#### 前序遍历使用栈的模拟

前序遍历使用栈模拟的关键在于：因为前序遍历顺序是根-左-右，而栈是后进先出（LIFO），为了保证左子节点先被访问，必须先将右子节点压入栈，再压入左子节点。这样出栈时，左子节点先访问，匹配前序遍历顺序。

**模拟步骤**

1. 创建一个栈，将根节点压入栈。
2. 当栈不为空时，弹出栈顶节点，并访问它。
3. 如果该节点有右子节点，先将右子节点压入栈。
4. 如果该节点有左子节点，再将左子节点压入栈。
5. 重复步骤 2-4，直到栈空。

```java
public void preorderIterative(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        System.out.println(node.val); // 访问节点
        if (node.right != null) stack.push(node.right); // 先压右子节点
        if (node.left != null) stack.push(node.left);   // 再压左子节点
    }
}
```

**关键点总结**

* 栈保证访问顺序，先入后出。
* 先压右子节点，再压左子节点，确保左子节点先弹出访问。
* 时间复杂度为 $\mathcal{O}(n)$，空间复杂度最坏 $\mathcal{O}(n)$。

#### 例 1：「力扣」第 144 题：[二叉树的前序遍历](https://leetcode.cn/problems/binary-tree-preorder-traversal/description/)

**代码实现**

```java
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }
}
```

**复杂度分析**

* 时间复杂度为 $\mathcal{O}(n)$，其中 $n$ 是节点总数，每个节点入栈和出栈各一次。
* 空间复杂度为 $\mathcal{O}(n)$，最坏情况下（如链状二叉树）栈中最多保存所有节点。

### 二叉树的中序遍历

二叉树中序遍历按“左子树 → 根节点 → 右子树”的顺序访问所有节点，常见实现有递归、基于栈的迭代和 Morris
遍历，三者的时间复杂度均为 $\mathcal{O}(n)$，空间复杂度分别为 $\mathcal{O}(h)$（递归/迭代）和 $\mathcal{O}(1)$（Morris）。

![](img/1600841382-mXqJlI-11-02-01.gif)

#### 递归实现

递归方法直接反映中序遍历定义：

* 终止条件：当前节点为空时返回
* 递归遍历左子树
* 访问当前节点
* 递归遍历右子树

```java
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}
```

时间复杂度： $\mathcal{O}(n)$；\
空间复杂度：递归调用栈深度最坏为树高， $\mathcal{O}(h)$。

#### 迭代实现（基于栈）

利用显式栈模拟递归调用栈：

1. 从根节点开始，将所有左子节点入栈
2. 栈顶节点出栈并访问
3. 将该节点的右子树作为新的当前节点，重复上述过程

```java
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
```

时间复杂度： $\mathcal{O}(n)$；\
空间复杂度：显式栈最坏存储路径节点， $\mathcal{O}(h)$。

#### Morris 遍历

Morris 遍历通过在树中临时建立线程链接，避免栈或递归：

* 若节点无左子树，访问并转向右子树
* 若有左子树，找到左子树的最右节点（前驱）
    * 若前驱节点右指针为空，令其指向当前节点，转向左子树
    * 否则恢复前驱右指针为空，访问当前节点，转向右子树

```java
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}
```

* 当不存在左子树时，直接访问节点并右移。
* 当存在左子树时，第一次遇到前驱时建线索并下移左子树；第二次遇到前驱时说明左子树已遍历完，需拆线索并访问当前节点。

**复杂度分析**

时间复杂度为 $\mathcal{O}(n)$，因为每个节点最多被访问和修改指针两次；\
空间复杂度为 $\mathcal{O}(1)$，仅在树内部临时改动指针，无额外数据结构。

**树结构恢复**

在第二次遇到前驱节点时，代码中有 `pred.right = null` 的操作保证了线索被拆除，最终 Morris 遍历结束后，树的结构与初始保持一致。

#### 例 2：「力扣」第 94 题：二叉树的中序遍历

**代码实现**

```java
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) pre = pre.right;
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}
```

**复杂度分析**

时间复杂度： $\mathcal{O}(n)$，每个节点最多被遍历两次。\
空间复杂度： $\mathcal{O}(1)$（忽略输出空间，仅指针改写，无额外栈或递归）。

### 二叉树的后续遍历

二叉树的后序遍历是一种深度优先遍历方式，先递归遍历左子树，然后遍历右子树，最后访问根节点，常用于计算表达式树或删除树节点等场景。

#### 遍历规则

后序遍历的顺序为：左 → 右 → 根。例如，对于一个简单的二叉树根节点为 $1$，左子节点为 $2$，右子节点为 $3$
，遍历结果将是 $2, 3, 1$。

![](img/1600918252-WWNUFi-11-02-03-postorder-traversal-use-stack.gif)

#### 递归实现

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.val);
    }
}
```

**时间复杂度**

二叉树后序遍历递归实现的时间复杂度为 $\mathcal{O}(n)$，其中 $n$是节点数。\
每个节点被访问一次，总操作线性于树规模，是最优的。

**空间复杂度**

空间复杂度平均为 $\mathcal{O}(h)$，其中 $h$是树高。\
最坏情况下（如偏斜树）为 $\mathcal{O}(n)$，主要由递归栈引起。

#### 迭代实现

```java
public class PostorderTraversalImproved {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        Collections.reverse(result);
        return result;
    }
}
```

**时间复杂度**

迭代实现的时间复杂度为 $\mathcal{O}(n)$，每个节点入栈出栈一次，反转操作线性。

**空间复杂度**

空间复杂度平均为 $\mathcal{O}(h)$（树高 $h$），最坏为 $\mathcal{O}(n)$（栈深度主导）。

**后序遍历是非常重要的解决二叉树问题的思想**：后序遍历允许先处理子树信息，再汇总到根节点，适合计算依赖子树结果的问题，如树高或平衡检查。

核心原因

后序遍历的顺序（左-右-根）确保在访问根时，子树已完全处理完毕，便于自底向上构建解决方案：

* 子树信息向上聚合：例如，计算树高时，先递归求左右子树高度，再取最大值加1。
* 避免多次遍历：单次后序可高效解决复杂问题，而前序或中序可能需额外存储或多次扫描。

典型应用示例

* **计算树高**：伪代码中，先求子树高，再计算根高。

$$\begin{aligned} &\textbf{Function} \text{ Height}(node) \\\ &\qquad \textbf{if } node = \text{null} \textbf{ then return } 0 \\\ &\qquad \text{leftH} \gets \text{Height}(node.left) \\\ &\qquad \text{rightH} \gets \text{Height}(node.right) \\\ &\qquad \textbf{return } \max(\text{leftH}, \text{rightH}) + 1 \end{aligned}$$

* **检查平衡树**：后序计算高度差，判断是否平衡。
* **树序列化**：后序序列易于重建树（如反序列化）。

这种思想在动态规划式树问题中尤为高效，时间通常为 $\mathcal{O}(n)$，避免冗余计算。\
与其他遍历比较，前序适合自顶向下（如复制树），但后序更擅长远景聚合。

#### 例 3：「力扣」第 145 题：[二叉树的后序遍历](https://leetcode.cn/problems/binary-tree-postorder-traversal/description/)

**代码实现**

```java
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.val);
    }
}
```

**复杂度分析**

时间复杂度：
算法通过递归访问每个节点一次（包括左子树、右子树和根的添加操作），总操作次数与节点数线性相关，最坏情况下遍历所有 $n$
个节点，故为 $\mathcal{O}(n)$。

空间复杂度： 结果列表`result`存储所有 $n$个节点值，占用 $\mathcal{O}(n)$空间；此外，递归栈深度最坏为 $\mathcal{O}(n)$
（树退化为链），平均为 $\mathcal{O}(\log n)$（平衡树），总体空间为 $\mathcal{O}(n)$。

### 完成「力扣」第 100 题：[相同的树](https://leetcode.cn/problems/same-tree/description/)

#### 算法思路

**递归（DFS）解法**

这是最自然的思路，直接自顶向下比较：

1. 基本情况：
    * 如果 `p` 和 `q` 都为空，说明对应位置都没有节点，返回 `true`。
    * 如果只有一个为空，另一个不为空，说明结构不同，返回 `false`。
    * 如果二者值不同，直接返回 `false`。
2. 否则，递归检查左右子树：
    * 左子树相同：`isSameTree(p.left, q.left)`
    * 右子树相同：`isSameTree(p.right, q.right)`
    * 两者同时满足时返回 `true`。

#### 核心知识与技巧

* **树的递归匹配**：树的问题通常递归是最强解，条件写清楚即可。
* **基线条件**：递归必须写好三个出口：同时为空、一方为空、值不等。
* **逻辑顺序**：先检查最容易判断真假情况，再进入递归，否则浪费计算。
* **竞赛中的优化方向**：递归本身**最清晰且足够快**，只要节点数 ≤ 100，不需要迭代 BFS/DFS 优化。

#### 代码实现

```java
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```

#### 复杂度分析

* **时间复杂度**：每个节点只访问一次，且对比操作常数级，整体复杂度为 $\mathcal{O}(\min(n, m))$ 其中 $n, m$ 分别为两棵树的节点数。
* **空间复杂度**：递归栈深度取决于树的高度 $h$。
    * 最好情况（平衡树）： $\mathcal{O}(\log n)$
    * 最坏情况（全链式树）： $\mathcal{O}(n)$

### 完成「力扣」第 101 题：[对称二叉树](https://leetcode.cn/problems/symmetric-tree/description/)

#### 算法思路

**递归法（核心解法）**

递归法是最直观且速度最快的思维方式。要判断树是否对称，就是递归判断根节点的左子树 `L` 与右子树 `R` 是否满足镜像。

定义函数 `isMirror(TreeNode p, TreeNode q)`，语义是“判断两棵子树是否镜像”：

1. **基线条件**：
    * 若 `p == null && q == null` → 返回 `true`
    * 若 `p == null || q == null` → 返回 `false`
    * 若 `p.val != q.val` → 返回 `false`
2. **递归调用**：\
   检查 `p.left` 对应 `q.right`，以及 `p.right` 对应 `q.left`，都要成立。

   $$\text{isMirror}(p, q) = \text{isMirror}(p.left, q.right) \land \text{isMirror}(p.right, q.left)$$

这样写相当简洁直接，且时空复杂度最优（不需要额外数据结构）。

#### 代码实现

```java
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}
```

#### 复杂度分析

* 时间复杂度：\
  每个节点最多访问一次 → $\mathcal{O}(n)$

* 空间复杂度：\
  最坏情况树退化为链表 → 递归深度 $\mathcal{O}(n)$，否则为平均树高 $\mathcal{O}(\log n)$

### 完成「力扣」第 199 题：[二叉树的右视图](https://leetcode.cn/problems/binary-tree-right-side-view/description/)

#### 算法思路

**核心思路：层次遍历（BFS）**

1. 使用队列进行**层次遍历**。
2. 每一层遍历时，将该层所有节点依次出队，同时把左右孩子入队。
3. 在处理完该层时，最后一个出队的节点就是该层的最右侧节点，记录下来。
4. 遍历结束后，结果数组即为从上到下的右视图。

#### 核心知识点技巧

* **队列 BFS**：典型的层序遍历操作。
* **层控制技巧**：通过队列长度（即当前层节点数）来划分层，确保能够在每层末尾找到那个最右节点。
* **和 DFS 对比**：完全可以用 DFS（优先右子树）求解，但在竞赛中 BFS 写法更快且不易出错。

#### 代码实现

```java
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1) res.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return res;
    }
}
```

#### 复杂度分析

* **时间复杂度**：\
  每个节点进队出队各一次，整体为 $\mathcal{O}(n)$，其中 $n$ 为节点总数。

* **空间复杂度**：\
  队列最大可能存放一层节点，最差为完全二叉树的最后一层，大小约为 $\mathcal{O}(n)$。

### 完成「力扣」第 226 题：[翻转二叉树](https://leetcode.cn/problems/invert-binary-tree/description/)

#### 算法思路

**核心思想**

树类题目常用策略：

1. **递归自顶向下**：对当前结点交换左右子树，然后递归处理其左右子结点。
2. **递归自底向上**：先递归子结点，再交换。
3. **迭代方法（BFS 或 DFS）**：用队列或栈来层序/深度遍历，每访问一个节点时进行子树交换。

这里为了执行速度和代码简洁性，选择 **递归自顶向下** 的方式，时间复杂度最优，同时空间开销来自递归栈即可。

#### 核心知识点技巧

* **二叉树递归的三个步骤**
    * 确定终止条件
    * 写清本层处理逻辑（例如交换左右节点）
    * 递归调用子问题
* **二叉树对称性**\
  本题的翻转约等于对树进行一次“镜像”操作。
* **递归与迭代复杂度等价**\
  DFS 栈递归方式与手工迭代 DFS/队列 BFS 在复杂度上一致，但写法不同。

#### 代码实现

```java
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
```

#### 复杂度分析

* **时间复杂度**：\
  每个节点恰好访问一次，故为\
  $\mathcal{O}(n)$

* **空间复杂度**：\
  最坏情况（完全不平衡的链式树）递归深度为 $n$\
  最优情况（完全平衡二叉树）递归深度为 $\log n$\
  故空间复杂度为\
  $\mathcal{O}(h)$\
  其中 $h$ 为树高。

### 完成「力扣」第 110 题：[平衡二叉树](https://leetcode.cn/problems/balanced-binary-tree/description/)

#### 算法思路

**后续递归一次遍历**

1. 使用 DFS 后序遍历：先算子树高度，再判断平衡性
2. 在计算节点高度的同时，如果发现子树不平衡，立即返回特殊值（如 -1）剪枝终止
3. 返回值约定：
    * 若当前子树平衡，返回真实高度
    * 若不平衡，直接返回 -1 上浮
      这样保证每个节点最多被访问一次，总体只需一次 DFS。

#### 代码实现

```java
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        if (left == -1) return -1;
        int right = height(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
```

#### 复杂度分析

* **时间复杂度**：\
  每个节点访问一次，时间为\
  $\mathcal{O}(n)$

* **空间复杂度**：\
  递归栈深度为树高 $h$，最坏情况下链式树 $\mathcal{O}(n)$，最优完全平衡树 $\mathcal{O}(\log n)$。

### 完成「力扣」第 104 题：[二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/)

#### 算法思路

**思路核心**

根节点的最大深度 = **左右子树最大深度的较大值 + 1**。\
因此典型递归公式为：

$$\text{maxDepth(root)} = \max(\text{maxDepth(root.left)}, \text{maxDepth(root.right)}) + 1$$

可用后序遍历(DFS)进行递归计算,速度最快。

```java
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
```

#### 复杂度分析

## 复杂度分析

* **时间复杂度**：每个节点访问一次 $\mathcal{O}(n)$
* **空间复杂度**：
    * DFS 递归栈深度 $\mathcal{O}(h)$ （h 为树高，最坏 $\mathcal{O}(n)$）
    * BFS 队列存储一层的节点，最坏 $\mathcal{O}(n)$

### 完成「力扣」第 111 题：[二叉树的最小深度](https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/)

#### 算法思路

**常见错误**

很多人会写成：

```java
return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
```

这样的错误在于：如果一边为空，这一边深度为 0，会导致结果错误。

#### 正确解法：后序递归 DFS

1. 若根节点为空，返回 0；

2. 若其中一个子树为空，必须返回非空子树的深度 + 1；

3. 若左右子树都非空，返回最小值 + 1。

公式：

$$\text{minDepth(root)} = \begin{cases} 0, & \text{root == null} \\\ 1, & \text{root 为叶子} \\\ \min(\text{minDepth(root.left)}, \ \text{minDepth(root.right)}) + 1, & \text{左右非空} \\\ \max(\text{minDepth(root.left)}, \ \text{minDepth(root.right)}) + 1, & \text{一边为空} \end{cases}$$

#### 代码实现

```java
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
```

#### 复杂度分析

* **时间复杂度**：每个节点访问一次 → $\mathcal{O}(n)$
* **空间复杂度**：递归栈深度依赖树高 $h$，最坏链式树 → $\mathcal{O}(n)$，平衡树 → $\mathcal{O}(\log n)$

### 完成「力扣」第 112 题：[路径总和](https://leetcode.cn/problems/path-sum/description/)

#### 算法思路

**深度优先搜索 (DFS)**

* 从根节点开始，不断向左右子树递归。
* 每访问一个节点，把 `targetSum` 减去该节点的值。
* 当走到叶子节点时，若此时剩余的 `targetSum` 恰好等于叶子节点的值，则路径成立。
* 一旦找到一条合法路径，直接返回 `true`。

**算法核心逻辑**

* 如果当前节点为空，直接返回 `false`。
* 如果当前节点是叶子节点，检查是否满足 `剩余目标和 == 当前节点值`。
* 否则，将 `targetSum - 当前节点值`，然后继续递归左右子树。

#### 代码实现

```java
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        int remain = targetSum - root.val;
        return hasPathSum(root.left, remain) || hasPathSum(root.right, remain);
    }
}
```

#### 复杂度分析

* **时间复杂度**： $\mathcal{O}(n)$\
  每个节点访问一次，最多遍历整棵树。
* **空间复杂度**： $\mathcal{O}(h)$\
  递归栈深度与树高相关。最坏情况（链状树） $h = n$，平均情况下 $h=\log n$。

### 完成「力扣」第 129 题：[求根到叶子节点数字之和](https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/)

#### 算法思路

采用深度优先搜索（DFS）通过递归实现遍历：

1. **递归参数设计**：每次递归带上当前路径数字 `curSum`，初始为 0。
2. **路径数字更新**：遍历到当前节点时，计算 `curSum = curSum * 10 + node.val`，因为每往下一层，数字向左移一位再加新节点。
3. **叶节点判断**：到达叶节点时，累加当前路径数字到结果。
4. **递归返回**：递归遍历左右子节点，最后返回全部路径的和。

此方法无需额外数据结构，空间使用由递归栈决定。

#### 代码实现

```java
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int curSum) {
        if (node == null) return 0;
        curSum = curSum * 10 + node.val;
        if (node.left == null && node.right == null) return curSum;
        return dfs(node.left, curSum) + dfs(node.right, curSum);
    }
}
```

#### 复杂度分析

* **时间复杂度**：遍历所有节点，故为 $\mathcal{O}(n)$，其中 $n$ 是节点数。
* **空间复杂度**：递归栈深度最大为树深度 $d$，所以为 $\mathcal{O}(d)$，最坏情况下为 $\mathcal{O}(n)$（极端退化为链表）。

### 完成「力扣」第 222 题：[完全二叉树的节点个数](https://leetcode.cn/problems/count-complete-tree-nodes/description/)

#### 算法思路

直接遍历树统计节点是 $\mathcal{O}(n)$ 复杂度，对于节点数可达 $5 \times 10^4$ 的规模效率尚可，但不符合进阶要求。

利用完全二叉树性质进行优化：

1. **高度计算**：
    * 计算树的左子树的最大深度 `leftDepth`（一直往左走直到空节点算深度）。
    * 计算树的右子树的最大深度 `rightDepth`。
2. **比较深度**：
    * 如果 `leftDepth == rightDepth`，说明左子树是完全二叉树且满的，节点数为 $2^{leftDepth} - 1$，加上根节点，再加右子树递归结果，直接计算无需递归左子树。
    * 如果 `leftDepth != rightDepth`，说明右子树是完全二叉树且满的，节点数为 $2^{rightDepth} - 1$，加上根节点，再加左子树递归结果。
     
该思路每次递归高度计算最多 $\log n$ 层，总复杂度约为 $\mathcal{O}((\log n)^2)$。

```java
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) return (1 << leftDepth) + countNodes(root.right);
        else return (1 << rightDepth) + countNodes(root.left);
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }
}
```

#### 复杂度分析

* **时间复杂度**：\
  每层递归调用时，`getDepth` 需要最坏 $\mathcal{O}(\log n)$（计算深度的路径长度）。\
  递归层数最多为 $\mathcal{O}(\log n)$。\
  故总体复杂度为 $\mathcal{O}((\log n)^2)$。

* **空间复杂度**：\
  递归栈空间取决于树高，约为 $\mathcal{O}(\log n)$。

### 完成「力扣」第 124 题：[二叉树中的最大路径和](https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/)

#### 算法思路

采用**后序遍历 + 递归动态规划**思想：

1. **定义递归函数**返回某节点为终点路径的最大贡献值，贡献值定义为：
    * 节点值加上左右子树中最大贡献路径（若为负数则不接）。
2. **全局变量**跟踪迄今遇到的最大路径和。
3. 递归过程中计算当前节点路径和包括三种情况：
    * 仅当前节点
    * 当前节点 + 左子树最大贡献
    * 当前节点 + 右子树最大贡献
    * 当前节点 + 左子树最大贡献 + 右子树最大贡献（形成以当前节点为“拐点”的路径）\
      全局最大值更新为四者最大值之一。
4. 递归返回值应为当前节点值加上左、右子树贡献中较大的一个，代表路径持续向上贡献最大值（只可选择一个分支）。

#### 代码实现

```java
public class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftGain = Math.max(dfs(node.left), 0);
        int rightGain = Math.max(dfs(node.right), 0);
        int currentMaxPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentMaxPath);
        return node.val + Math.max(leftGain, rightGain);
    }
}
```

#### 复杂度分析

* **时间复杂度**：\
  每个节点访问且递归计算一次，整体为 $\mathcal{O}(n)$，其中 $n$ 是节点数。

* **空间复杂度**：\
  递归深度取决于树高度，最坏情况下为 $\mathcal{O}(n)$，平均为 $\mathcal{O}(\log n)$。

## 典型问题 1：从前、中序遍历序列构造二叉树

### 「力扣」第 105 题：[从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/)

```java
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int[] preorder;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int n = preorder.length;
        inorderIndexMap = HashMap.newHashMap(n);
        for (int i = 0; i < n; i++)
            inorderIndexMap.put(inorder[i], i);
        return buildSubtree(0, n - 1, 0, n - 1);
    }

    private TreeNode buildSubtree(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = inorderIndexMap.get(rootVal);
        int leftTreeSize = inRootIndex - inStart;
        root.left = buildSubtree(preStart + 1, preStart + leftTreeSize, inStart, inRootIndex - 1);
        root.right = buildSubtree(preStart + leftTreeSize + 1, preEnd, inRootIndex + 1, inEnd);
        return root;
    }
}
```

#### 复杂度分析

* **时间复杂度**：
    * 建索引Map耗费 $\mathcal{O}(n)$。
    * 每个节点递归处理一次，查索引为常数。
    * 整体为 $\mathcal{O}(n)$。
* **空间复杂度**：
    * 递归栈深度最坏 $\mathcal{O}(n)$（退化链）。
    * HashMap空间 $\mathcal{O}(n)$。

### 完成「力扣」第 589 题：[N 叉树的前序遍历](https://leetcode.cn/problems/n-ary-tree-preorder-traversal/description/)

#### 代码实现

```java
public class NAryTreePreOrderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        if (node.children != null)
            for (Node child : node.children)
                dfs(child, res);
    }
}
```

#### 复杂度分析

* **时间复杂度**：\
  遍历所有节点一次，访问时间为 $\mathcal{O}(n)$。
* **空间复杂度**：\
  递归栈最大大小为树最大深度，最坏情况下为 $\mathcal{O}(n)$。结果存储空间为 $\mathcal{O}(n)$。

### 完成「力扣」第 590 题：[N 叉树的后序遍历](https://leetcode.cn/problems/n-ary-tree-postorder-traversal/description/)

#### 代码实现

```java
public class NAryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res);
        return res;
    }

    private void dfs(Node node, List<Integer> res) {
        if (node == null) return;
        if (node.children != null)
            for (Node child : node.children)
                dfs(child, res);
        res.add(node.val);
    }
}
```

#### 复杂度分析

* **时间复杂度**：\
  遍历所有节点一次，访问时间为 $\mathcal{O}(n)$。
* **空间复杂度**：\
  递归栈最大大小为树最大深度，最坏情况下为 $\mathcal{O}(n)$。结果存储空间为 $\mathcal{O}(n)$。

### 完成「力扣」第 429 题：[N 叉树的层序遍历](https://leetcode.cn/problems/n-ary-tree-level-order-traversal/description/)

#### 代码实现

```java
public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> layer = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                layer.add(curr.val);
                if (curr.children != null)
                    for (Node child : curr.children)
                        queue.offer(child);
            }
            res.add(layer);
        }
        return res;
    }
}
```

#### 复杂度分析

* **时间复杂度**：\
  访问每个节点一次，整体为 $\mathcal{O}(n)$，其中 $n$ 是节点总数。

* **空间复杂度**：\
  队列最多存储一层节点，最坏为最大宽度 $\mathcal{O}(n)$，结果存储同样 $\mathcal{O}(n)$。

## 典型问题 2：二叉树的最近公共祖先

### 「力扣」第 236 题：[二叉树的最近公共祖先](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/)

#### 代码实现

```java
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
```

#### 复杂度分析

* 时间复杂度： $\mathcal{O}(n)$，每个节点至多访问一次。
* 空间复杂度：由递归栈决定，最坏情况下树退化深度为 $n$，则为 $\mathcal{O}(n)$；平衡树时深度约为 $\log n$，则为 $\mathcal{O}(\log n)$。

---

**[返回](../README.md)**