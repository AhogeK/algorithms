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
    * [完成 「力扣」第 297 题：二叉树的序列化与反序列化](#完成-力扣第-297-题二叉树的序列化与反序列化)
      * [代码实现](#代码实现-18)
      * [复杂度分析](#复杂度分析-23)
    * [完成 「力扣」第 543 题：二叉树的直径](#完成-力扣第-543-题二叉树的直径)
      * [代码实现](#代码实现-19)
      * [复杂度分析](#复杂度分析-24)
    * [完成 「力扣」第 1443 题：收集树上所有苹果的最少时间](#完成-力扣第-1443-题收集树上所有苹果的最少时间)
      * [代码实现](#代码实现-20)
      * [复杂度分析](#复杂度分析-25)
  * [二叉搜索树与查找表](#二叉搜索树与查找表)
    * [定义](#定义)
    * [用途](#用途)
    * [查找表](#查找表)
      * [二叉搜索树查找表的关键特性](#二叉搜索树查找表的关键特性)
      * [查找示例过程](#查找示例过程)
      * [优缺点](#优缺点)
    * [API](#api)
      * [查找（Search）](#查找search)
      * [插入（Insert）](#插入insert)
      * [删除（Delete）](#删除delete)
      * [地板（Floor）](#地板floor)
      * [天花板（Ceiling）](#天花板ceiling)
      * [排名（Rank）](#排名rank)
      * [选择（Select）](#选择select)
      * [遍历（Traverse）](#遍历traverse)
      * [获取最值（Find Min/Max）](#获取最值find-minmax)
      * [其他辅助API](#其他辅助api)
    * [二叉搜索树的升级版](#二叉搜索树的升级版)
      * [常见的二叉搜索树升级版](#常见的二叉搜索树升级版)
      * [平衡二叉搜索树（Balanced BST）](#平衡二叉搜索树balanced-bst)
      * [AVL树](#avl树)
      * [红黑树（Red-Black Tree）](#红黑树red-black-tree)
      * [Splay树](#splay树)
      * [Treap（树堆）](#treap树堆)
      * [augmented BST（增强型二叉搜索树）](#augmented-bst增强型二叉搜索树)
    * [「力扣」450.删除二叉搜索树中的节点](#力扣450删除二叉搜索树中的节点)
      * [算法思路](#算法思路-16)
      * [代码实现](#代码实现-21)
      * [复杂度分析](#复杂度分析-26)
    * [完成「力扣」第 700 题：二叉搜索树中的搜索](#完成力扣第-700-题二叉搜索树中的搜索)
      * [代码实现](#代码实现-22)
      * [复杂度分析](#复杂度分析-27)
    * [完成「力扣」第 701 题：二叉搜索树中的插入操作](#完成力扣第-701-题二叉搜索树中的插入操作)
      * [算法思路](#算法思路-17)
      * [代码实现](#代码实现-23)
      * [复杂度分析](#复杂度分析-28)
    * [完成「力扣」第 173 题：二叉搜索树迭代器](#完成力扣第-173-题二叉搜索树迭代器)
      * [算法思路](#算法思路-18)
      * [代码实现](#代码实现-24)
      * [复杂度分析](#复杂度分析-29)
    * [完成「力扣」第 449 题：序列化和反序列化二叉搜索树](#完成力扣第-449-题序列化和反序列化二叉搜索树)
      * [算法思路](#算法思路-19)
      * [代码实现](#代码实现-25)
      * [复杂度分析](#复杂度分析-30)
    * [完成「力扣」第 108 题：将有序数组转换为二叉搜索树](#完成力扣第-108-题将有序数组转换为二叉搜索树)
      * [算法思路](#算法思路-20)
      * [代码实现](#代码实现-26)
      * [复杂度分析](#复杂度分析-31)
    * [完成「力扣」第 109 题：有序链表转换二叉搜索树](#完成力扣第-109-题有序链表转换二叉搜索树)
      * [算法思路](#算法思路-21)
      * [代码实现](#代码实现-27)
      * [复杂度分析](#复杂度分析-32)
    * [完成「力扣」第 235 题：二叉搜索树的最近公共祖先](#完成力扣第-235-题二叉搜索树的最近公共祖先)
      * [算法思路](#算法思路-22)
      * [代码实现](#代码实现-28)
      * [复杂度分析](#复杂度分析-33)
    * [完成「力扣」第 538 题：把二叉搜索树转换为累加树](#完成力扣第-538-题把二叉搜索树转换为累加树)
      * [算法思路](#算法思路-23)
      * [代码实现](#代码实现-29)
      * [复杂度分析](#复杂度分析-34)
    * [完成「力扣」第 653 题：两数之和 IV - 输入 BST](#完成力扣第-653-题两数之和-iv---输入-bst)
      * [算法思路](#算法思路-24)
      * [代码实现](#代码实现-30)
      * [复杂度分析](#复杂度分析-35)
    * [AVL 树](#avl-树)
      * [AVL树如何定义“平衡”（“平衡因子”概念）](#avl树如何定义平衡平衡因子概念)
      * [AVL树旋转(Rotation)](#avl树旋转rotation)
      * [完整可运行的 AVL 树 Java 代码](#完整可运行的-avl-树-java-代码)
    * [红黑树](#红黑树)
      * [红黑树完整实现](#红黑树完整实现)
  * [典型问题 1：二叉搜索树中第 K 小的元素](#典型问题-1二叉搜索树中第-k-小的元素)
    * [「力扣」第 230 题：二叉搜索树中第 $K$ 小的元素](#力扣第-230-题二叉搜索树中第-k-小的元素)
      * [解题思路](#解题思路)
      * [代码实现](#代码实现-31)
      * [复杂度分析](#复杂度分析-36)
    * [完成「力扣」第 669 题：修剪二叉搜索树](#完成力扣第-669-题修剪二叉搜索树)
      * [解题思路](#解题思路-1)
      * [代码实现](#代码实现-32)
      * [复杂度分析](#复杂度分析-37)
    * [完成「力扣」第 783 题：二叉搜索树节点最小距离](#完成力扣第-783-题二叉搜索树节点最小距离)
      * [解题思路](#解题思路-2)
      * [代码实现](#代码实现-33)
      * [复杂度分析](#复杂度分析-38)
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
return Math.min(minDepth(root.left),minDepth(root.right))+1;
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
    * 如果 `leftDepth == rightDepth`，说明左子树是完全二叉树且满的，节点数为 $2^{leftDepth} - 1$
      ，加上根节点，再加右子树递归结果，直接计算无需递归左子树。
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
* 空间复杂度：由递归栈决定，最坏情况下树退化深度为 $n$，则为 $\mathcal{O}(n)$；平衡树时深度约为 $\log n$
  ，则为 $\mathcal{O}(\log n)$。

### 完成 「力扣」第 297 题：[二叉树的序列化与反序列化](https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/description/)

#### 代码实现

```java
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, nodes);
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if ("#".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
    }
}
```

#### 复杂度分析

* 时间复杂度：
    * 序列化：访问每个节点一次，递归遍历全树，复杂度为 $\mathcal{O}(n)$。
    * 反序列化：同理遍历每个节点字符串一次，复杂度 $\mathcal{O}(n)$。
* 空间复杂度：
    * 序列化所用额外空间主要为字符串缓存，大小 $\mathcal{O}(n)$。
    * 反序列化用递归栈空间为树高度，平均 $\mathcal{O}(\log n)$，最坏为 $\mathcal{O}(n)$。

### 完成 「力扣」第 543 题：[二叉树的直径](https://leetcode.cn/problems/diameter-of-binary-tree/description/)

#### 代码实现

```java
public class DiameterOfBinaryTree {
    class Solution {
        private int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);
            return maxDiameter;
        }

        private int depth(TreeNode node) {
            if (node == null) return 0;
            int leftDepth = depth(node.left);
            int rightDepth = depth(node.right);
            maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
```

#### 复杂度分析

* 时间复杂度： $\mathcal{O}(n)$ 每个节点访问一次递归。
* 空间复杂度： $\mathcal{O}(h)$ 递归调用栈， $h$ 为树高度，最坏为 $n$。

### 完成 「力扣」第 1443 题：[收集树上所有苹果的最少时间](https://leetcode.cn/problems/minimum-time-to-collect-all-apples-in-a-tree/description/)

#### 代码实现

```java
public class MinimumTimeToCollectAllApplesInATree {
    class Solution {
        List<List<Integer>> graph;
        boolean[] visited;

        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            visited = new boolean[n];
            return dfs(0, hasApple);
        }

        private int dfs(int node, List<Boolean> hasApple) {
            visited[node] = true;
            int cost = 0;
            for (int next : graph.get(node)) {
                if (visited[next]) continue;
                int subCost = dfs(next, hasApple);
                if (subCost > 0 || hasApple.get(next)) cost += subCost + 2;
            }
            return cost;
        }
    }
}
```

#### 复杂度分析

| 项目    | 复杂度                          |
|-------|------------------------------|
| 时间复杂度 | $\mathcal{O}(n)$ 遍历每条边一次     |
| 空间复杂度 | $\mathcal{O}(n)$ 邻接表 + 递归栈空间 |

## 二叉搜索树与查找表

### 定义

二叉搜索树是一种特殊的二叉树，它满足以下定义：对于树中每个节点，其左子树上所有节点的值都严格小于该节点的值，而其右子树上所有节点的值都严格大于该节点的值。此外，左右子树本身也是二叉搜索树。

具体来说，设某节点的值为 $v$，则：

* 左子树中任意节点值 $x$ 满足 $x < v$
* 右子树中任意节点值 $y$ 满足 $y > v$

### 用途

二叉搜索树的主要用途是支持高效的动态数据管理和查询操作，特别适合需要频繁插入、删除和查找的场景。具体用途包括：

* **快速查找**：二叉搜索树可以在平均 $\mathcal{O}(\log n)$ 时间内完成元素查找，比无序数据结构快得多。
* **动态数据维护**：支持动态插入和删除操作，适合需要实时更新的数据结构。
* **排序访问**：中序遍历二叉搜索树能得到一个有序的元素序列，方便排序和区间查询。
* **实现集合和映射**：常用于实现集合（Set）和映射（Map）结构，如平衡二叉搜索树（红黑树、AVL树）被广泛用于标准库的数据容器。
* **数据库索引**：在数据库系统中，二叉搜索树的变种经常用于构建索引，加速数据检索。

### 查找表

二叉搜索树的查找表是一种利用二叉搜索树（Binary Search Tree, BST）结构实现的查找数据结构。它通过二叉树的特性有效支持动态数据的搜索、插入和删除操作。

#### 二叉搜索树查找表的关键特性

* **节点结构**：每个节点包含键（key）、存储的数据（value）、左子节点指针和右子节点指针。
* **有序性**：左子树的所有键值 < 当前节点键值 < 右子树的所有键值。
* **查找操作**：从根节点开始，比较查找的键值与当前节点键值，若相等则找到；若查找键值更小，则进入左子树；若更大，则进入右子树，重复此过程直到找到或到达空节点（查找失败）。
* **时间复杂度**：理想情况下树高为 $\log n$，查找操作的平均时间复杂度为 $\mathcal{O}(\log n)$
  ；但在最坏情况下（如树退化成链表），时间复杂度退化为 $\mathcal{O}(n)$。

#### 查找示例过程

假设需要查找的键为 $k$，从根节点开始：

1. 若当前节点为空，说明查找失败。
2. 若当前节点键值等于 $k$，则返回该节点对应数据。
3. 若 $k <$ 当前节点键值，进入左子树继续查找。
4. 若 $k >$ 当前节点键值，进入右子树继续查找。

#### 优缺点

* **优点**：结构简单，支持动态插入和删除，查找平均效率高。
* **缺点**：对树的平衡性要求较高，若树不平衡性能下降；需要额外维护以保证树的高度平衡（如AVL树、红黑树等）。

### API

二叉搜索树（BST）的各种API主要是对树结构进行操作的函数接口，常见的API包括查找、插入、删除、遍历等。下面详细讲解每种API的功能和实现思路。

#### 查找（Search）

* **功能**：根据给定的键值 $k$，在BST中查找对应的节点（键值和数据）。
* **实现思路**：从根节点开始，比较 $k$ 与当前节点键值：
    * 若相等，返回当前节点。
    * 若 $k <$ 当前节点键值，递归或迭代进入左子树。
    * 若 $k >$ 当前节点键值，进入右子树。
* **时间复杂度**：平均 $\mathcal{O}(\log n)$，最坏 $\mathcal{O}(n)$。

#### 插入（Insert）

* **功能**：将新节点（含键值和数据）插入BST，保持BST性质。
* **实现思路**：
    1. 从根节点开始查找插入位置，遍历路径中比较键值。
    2. 找到第一个空的左或右子节点作为插入点。
* **注意**：若键值已存在，插入操作一般有两种选择：覆盖旧值或忽略插入。
* **时间复杂度**：平均 $\mathcal{O}(\log n)$，最坏 $\mathcal{O}(n)$。

#### 删除（Delete）

* **功能**：删除BST中指定键值的节点，保持BST性质。
* **实现思路**：\
  删除节点有三种情况：
    1. **删除叶子节点**：直接删除。
    2. **删除有一个子节点的节点**：用该子节点替代被删除节点。
    3. **删除有两个子节点的节点**：找到该节点右子树的最小节点（或左子树的最大节点）代替该节点，再删除该最小（最大）节点。
* **时间复杂度**：平均 $\mathcal{O}(\log n)$，最坏 $\mathcal{O}(n)$。

#### 地板（Floor）

* **功能**：查找BST中小于或等于给定键值 $k$ 的最大键值（即不大于 $k$ 的最大节点键）。
* **实现思路**：从根节点开始比较：
    * 若当前节点键值等于 $k$，则当前节点就是 floor。
    * 若当前节点键值大于 $k$，向左子树递归查找 floor。
    * 若当前节点键值小于 $k$，当前节点可能是 floor，继续递归右子树寻找更大但不超过 $k$ 的键值。
* **时间复杂度**：平均 $\mathcal{O}(\log n)$，最坏 $\mathcal{O}(n)$。

#### 天花板（Ceiling）

* **功能**：查找BST中大于或等于给定键值 $k$ 的最小键值（即不小于 $k$ 的最小节点键）。
* **实现思路**：从根节点开始比较：
    * 若当前节点键值等于 $k$，当前节点即为 ceiling。
    * 若当前节点键值小于 $k$，进入右子树查找。
    * 若当前节点键值大于 $k$，当前节点可能是 ceiling，继续左子树查找更小但不小于 $k$ 的键值。
* **时间复杂度**：平均 $\mathcal{O}(\log n)$，最坏 $\mathcal{O}(n)$。

#### 排名（Rank）

* **功能**：返回BST中小于给定键值 $k$ 的节点数，即 $k$ 在有序序列中的排名（从 $0$ 开始计数）。
* **实现思路**：要求节点中维护子树大小信息 `size`，递归计算：
    * 若当前节点键值等于 $k$，`rank` = 左子树节点数。
    * 若 $k <$ 当前节点键值，递归左子树查找 `rank`。
    * 若 $k >$ 当前节点键值，`rank` = 左子树大小 + 1（当前节点） + 右子树对 $k$ 的递归 `rank` 结果。
* **时间复杂度**：平均 $\mathcal{O}(\log n)$，最坏 $\mathcal{O}(n)$。

#### 选择（Select）

* **功能**：返回BST中排名为 $i$ （ $0 \leq i < n$）的键值，即第 $i+1$ 小的元素。
* **实现思路**：依赖节点中维护的子树大小信息 `size`：
    * 计算当前节点左子树大小 $t$。
    * 若 $i = t$，当前节点即为第 $i$ 小元素。
    * 若 $i < t$，递归左子树查找第 $i$ 小元素。
    * 若 $i > t$，递归右子树查找第 $i - t - 1$ 小元素。
* **时间复杂度**：平均 $\mathcal{O}(\log n)$，最坏 $\mathcal{O}(n)$。

#### 遍历（Traverse）

* **功能**：按一定顺序访问BST中所有节点，常用遍历方式包括：
    * **中序遍历（In-order）**：左子树 → 当前节点 → 右子树，结果是键值的升序。
    * **前序遍历（Pre-order）**：当前节点 → 左子树 → 右子树。
    * **后序遍历（Post-order）**：左子树 → 右子树 → 当前节点。
* **应用**：中序遍历用于有序输出；前序和后序遍历常用于树的复制或释放等操作。

#### 获取最值（Find Min/Max）

* **功能**：查找BST中键值最小或最大的节点。
* **实现思路**：
    * 最小值节点位于树的最左下角，向左子树持续遍历直至空。
    * 最大值节点位于最右下角，向右子树持续遍历直至空。
* **时间复杂度**：平均和最坏均可达到 $\mathcal{O}(h)$，其中 $h$ 是树高。

#### 其他辅助API

* **获取树高（Height）**：递归计算左右子树高度的最大值加 $1$。
* **检查是否为空（IsEmpty）**：判断根节点是否为空。
* **清空树（Clear）**：递归释放所有节点内存。

### 二叉搜索树的升级版

二叉搜索树（BST）的升级版主要是为了改进普通BST在最坏情况下退化成链表导致效率降低的问题，提升操作的稳定性和效率。这些升级版数据结构通过增加平衡机制或调整树的结构，使得树高度保持在 $\mathcal{O}(\log n)$
级别，从而保证查找、插入和删除的时间复杂度稳定。

#### 常见的二叉搜索树升级版

#### 平衡二叉搜索树（Balanced BST）

#### AVL树

* **特点**：严格平衡。每个节点的左右子树高度只相差 $1$，通过旋转操作保持平衡。
* **优势**：查找效率高，维护平衡代价相对较大。
* **应用**：适合读多写少的场景。

#### 红黑树（Red-Black Tree）

* **特点**：一种弱平衡二叉搜索树，满足“红黑性质”：
    * 节点颜色为红或黑。
    * 根节点是黑色。
    * 红色节点不能连续出现（红节点的子节点必须是黑色）。
    * 从根到叶子的每条路径上黑色节点数相同。
* **优势**：插入和删除操作旋转次数较少，平衡更新更高效。
* **应用**：广泛用于语言库底层（如 C++ STL 的 map 和 set）。

#### Splay树

* **特点**：自调整树，每次访问节点后，会通过旋转将该节点移动到根部。
* **优势**：对访问局部性极好的情况有出色性能，平均操作均摊为 $\mathcal{O}(\log n)$。
* **应用**：适合频繁访问相同元素的场景。

#### Treap（树堆）

* **特点**：结合二叉搜索树和堆的性质，每个节点除了键值外还有一个随机优先级，保持BST和堆的性质。
* **优势**：随机化保证了树的平衡，结构简单。
* **应用**：概率上保证平衡，常用于竞赛算法。

#### augmented BST（增强型二叉搜索树）

* **特点**：在普通BST节点上增加更多辅助信息，如子树大小、区间覆盖信息等。
* **优势**：支持更多高级操作，比如 `rank`、`select`、区间查询等。
* **应用**：统计信息维护、区间查询、动态序列操作。

### 「力扣」450.[删除二叉搜索树中的节点](https://leetcode.cn/problems/delete-node-in-a-bst/description/)

#### 算法思路

* **递归思想**：\
  利用 BST 的性质确定查找路径，如果 $key < root.val$，递归到左子树；如果 $key > root.val$，递归到右子树；如果相等，执行删除。
* **删除节点处理**：
    * 如果节点没有左子树，则用右子树代替。
    * 如果节点没有右子树，则用左子树代替。
    * 如果节点左右子树均存在，用中序后继（右子树的最左节点）替换当前节点的值，再递归删除该后继节点。
* **寻找中序后继**：\
  右子树中一路向左找到最小节点。
* **递归结构**：\
  删除操作的返回值是新子树根节点，递归函数每一步返回新连接保证树结构正确。

#### 代码实现

```java
public class DeleteNodeInABST {
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else if (key > root.val) {
                root.right = deleteNode(root.right, key);
            } else {
                if (root.left == null) return root.right;
                else if (root.right == null) return root.left;
                else {
                    TreeNode successor = findMin(root.right);
                    root.val = successor.val;
                    root.right = deleteNode(root.right, successor.val);
                }
            }
            return root;
        }

        private TreeNode findMin(TreeNode node) {
            while (node.left != null) node = node.left;
            return node;
        }
    }
}
```

#### 复杂度分析

* 时间复杂度：删除操作符合查找复杂度 $\mathcal{O}(h)$， $h$ 是树的高度。平衡BST时为 $\mathcal{O}(\log n)$
  ，最坏退化链表时为 $\mathcal{O}(n)$。
* 空间复杂度：递归调用栈深度为 $h$，即 $\mathcal{O}(h)$。

### 完成「力扣」第 700 题：[二叉搜索树中的搜索](https://leetcode.cn/problems/search-in-a-binary-search-tree/)

#### 代码实现

```java
public class SearchInABinarySearchTree {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) return null;
            if (root.val == val) return root;
            return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
        }
    }
}
```

#### 复杂度分析

* 时间复杂度：每次根据比较选择左或右子树，搜索深度最多为树高，因此为 $\mathcal{O}(h)$，平衡树为 $\mathcal{O}(\log n)$
  ，最坏退化为链表时 $\mathcal{O}(n)$。
* 空间复杂度：递归栈深度为 $h$，即 $\mathcal{O}(h)$。

### 完成「力扣」第 701 题：[二叉搜索树中的插入操作](https://leetcode.cn/problems/insert-into-a-binary-search-tree/description/)

#### 算法思路

利用BST的有序性，将待插入值与当前节点比较，若更小则递归/迭代进入左子树，否则进入右子树。\
当遍历到空节点时，新建值节点并将其挂到父节点相应指针上完成插入。

#### 代码实现

```java
public class InsertIntoABinarySearchTree {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            if (val < root.val) root.left = insertIntoBST(root.left, val);
            else root.right = insertIntoBST(root.right, val);
            return root;
        }
    }
}
```

#### 复杂度分析

* 时间复杂度：每次比较消耗常数，最多遍历树高层数，故为 $\mathcal{O}(h)$；平均情况下 $h\approx\log n$
  ，最坏情形退化为 $\mathcal{O}(n)$。
* 空间复杂度：递归深度为树高，空间为 $\mathcal{O}(h)$；迭代实现只需常数额外空间，为 $\mathcal{O}(1)$。

### 完成「力扣」第 173 题：[二叉搜索树迭代器](https://leetcode.cn/problems/binary-search-tree-iterator/description/)

#### 算法思路

构造时，将从根节点开始一路向左的所有节点压入栈；

* `hasNext()`：判断栈是否为空；
* `next()`：弹出栈顶节点 cur，
    1. 返回 `cur.val`；
    2. 若 `cur.right` 不为空，则将其右子树从该右节点开始一路左推到底的所有节点再次压栈，保证栈顶始终是下一个最小节点。

#### 代码实现

```java
public class BinarySearchTreeIterator {
    class BSTIterator {
        private Deque<TreeNode> stack = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            pushLeft(root);
        }

        private void pushLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode cur = stack.pop();
            if (cur.right != null) pushLeft(cur.right);
            return cur.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
```

#### 复杂度分析

* 时间复杂度：摊销 $\mathcal{O}(1)$，每个节点仅一次入栈、一次出栈；
* 空间复杂度： $\mathcal{O}(h)$，其中 $h$ 为树高，栈最多存储一条根→叶路径。

### 完成「力扣」第 449 题：[序列化和反序列化二叉搜索树](https://leetcode.cn/problems/serialize-and-deserialize-bst/)

#### 算法思路

1. 序列化（serialize）
    * 对根节点做先序遍历，遇到非空节点就将其值和一个分隔符（如英文逗号）追加到 `StringBuilder`；
    * 遍历完成后去掉末尾多余的分隔符，返回字符串。
2. 反序列化（deserialize）
    * 将序列化字符串按逗号拆分为整型数组 `vals`；
    * 用一个全局索引 `idx` 从头处理 `vals`，递归函数 `build(lower, upper)`：
        * 若 `idx` 越界或当前值不在 `(lower, upper)` 范围内，返回 `null`；
        * 否则以当前值构造节点，`idx++`，再分别构建左子树 (`(lower, val)`) 和右子树 (`(val, upper)`)。

#### 代码实现

```java
public class SerializeAndDeserializeBst {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preOrder(root, sb);
            if (!sb.isEmpty()) sb.setLength(sb.length() - 1);
            return sb.toString();
        }

        private void preOrder(TreeNode node, StringBuilder sb) {
            if (node == null) return;
            sb.append(node.val).append(",");
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }

        private int idx;

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) return null;
            String[] arr = data.split(",");
            int n = arr.length;
            int[] vals = new int[n];
            for (int i = 0; i < n; i++)
                vals[i] = Integer.parseInt(arr[i]);
            idx = 0;
            return build(vals, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode build(int[] vals, int lower, int upper) {
            if (idx == vals.length) return null;
            int v = vals[idx];
            if (v < lower || v > upper) return null;
            idx++;
            TreeNode node = new TreeNode(v);
            node.left = build(vals, lower, v);
            node.right = build(vals, v, upper);
            return node;
        }
    }
}
```

#### 复杂度分析

* 时间复杂度：序列化和反序列化各为 $\mathcal{O}(n)$，其中 $n$ 是节点数，先序遍历和线性扫描各访问一次。
* 空间复杂度：
    * 序列化： $\mathcal{O}(n)$ 用于结果字符串；
    * 反序列化： $\mathcal{O}(n)$ 用于数组和递归栈（最坏 $\mathcal{O}(n)$，平均 $\mathcal{O}(h)$）。

### 完成「力扣」第 108 题：[将有序数组转换为二叉搜索树](https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/)

#### 算法思路

1. 选取当前数组区间的中间元素作为当前子树的根节点。
2. 递归对中间元素左侧子数组构建左子树。
3. 递归对中间元素右侧子数组构建右子树。
4. 递归终止条件为子数组为空时返回 `null`。

这种方式保证了每次选择的根节点是子数组的中间元素，使得树节点左右分布均匀，满足平衡二叉搜索树的要求。

#### 代码实现

```java
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
```

#### 复杂度分析

* 时间复杂度： $\mathcal{O}(n)$，每个元素构建一次节点。
* 空间复杂度： $\mathcal{O}(\log n)$ 递归栈深，平衡树高度为 $\log n$。

### 完成「力扣」第 109 题：[有序链表转换二叉搜索树](https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/description/)

#### 算法思路

1. 先计算链表长度，令 $n$ 为节点数。
2. 按BST的中序遍历构造二叉树：
    * 递归构造左子树长度为 $mid = \frac{n}{2}$ 的节点数量。
    * 当前链表头节点即为根节点，替换为当前节点，链表指针后移。
    * 递归构造右子树剩余长度的节点。

#### 代码实现

```java
public class ConvertSortedListToBinarySearchTree {
    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int length = 0;
        ListNode ptr = head;
        while (ptr != null) {
            length++;
            ptr = ptr.next;
        }
        current = head;
        return build(0, length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode leftChild = build(left, mid - 1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode rightChild = build(mid + 1, right);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}
```

#### 复杂度分析

* 时间复杂度： $\mathcal{O}(n)$ ，每个节点只访问一次。
* 空间复杂度： $\mathcal{O}(\log n)$ ，递归调用栈深度。

### 完成「力扣」第 235 题：[二叉搜索树的最近公共祖先](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/)

#### 算法思路

* 从根节点开始，比较 `p` 和 `q` 的值与当前节点 `root`。
* 如果 `p.val` 和 `q.val` 都小于 `root.val`，说明公共祖先在左子树，递归左子树；
* 如果都大于 `root.val`，说明公共祖先在右子树，递归右子树；
* 否则当前节点正是分叉点（或其中一个节点本身），即为最近公共祖先。

#### 代码实现

```java
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (node != null) {
            int currVal = node.val;
            if (pVal > currVal && qVal > currVal) node = node.right;
            else if (pVal < currVal && qVal < currVal) node = node.left;
            else return node;
        }
        return null;
    }
}
```

#### 复杂度分析

* 时间复杂度： $\mathcal{O}(h)$，其中 $h$ 是树高度，平均 $\log n$。
* 空间复杂度： $\mathcal{O}(1)$，迭代版无递归栈。

### 完成「力扣」第 538 题：[把二叉搜索树转换为累加树](https://leetcode.cn/problems/convert-bst-to-greater-tree/description/)

#### 算法思路

* **BST的性质** 表明中序遍历是递增序列。
* 要得到每个节点的大于等于该值的累加值，可以利用**逆序中序遍历**（右-根-左），从最大值开始累加。
* 具体做法：
    * 维持一个累加器 `sum` 初始为0。
    * 逆序中序遍历节点，每访问一个节点，先遍历右子树（较大值），更新该节点值为 `node.val += sum`，再更新 `sum = node.val`
      ，最后遍历左子树（较小值）。
* 这样保证每个节点被更新时，`sum` 会包含所有大于当前节点值的节点和。

#### 代码实现

```java
public class ConvertBSTToGreaterTree {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.right);
        node.val += sum;
        sum = node.val;
        traverse(node.left);
    }
}
```

#### 复杂度分析

* 时间复杂度： $\mathcal{O}(n)$ ，n为节点数，遍历每个节点一次。
* 空间复杂度： $\mathcal{O}(h)$ ，h为树的高度（递归栈空间），最坏情况退化为链表为 $\mathcal{O}(n)$。

### 完成「力扣」第 653 题：[两数之和 IV - 输入 BST](https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/description/)

#### 算法思路

**中序遍历+双指针法**

* 由于BST的中序遍历产生升序序列，可以先中序遍历把节点值存入数组（有序）。
* 然后用双指针(头尾指针)在数组内寻找两个数和为k。
* 时间复杂度 $O(n)$ ，空间复杂度 $O(n)$。

#### 代码实现

```java
public class TwoSumIVInputIsABST {
    private final Deque<TreeNode> stackLeft = new ArrayDeque<>();
    private final Deque<TreeNode> stackRight = new ArrayDeque<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        pushLeft(root);
        pushRight(root);
        int leftVal = nextLeft();
        int rightVal = nextRight();
        while (leftVal < rightVal) {
            int sum = leftVal + rightVal;
            if (sum == k) return true;
            if (sum < k) {
                if (stackLeft.isEmpty()) break;
                leftVal = nextLeft();
            } else {
                if (stackRight.isEmpty()) break;
                rightVal = nextRight();
            }
        }
        return false;
    }

    private int nextRight() {
        TreeNode node = stackRight.pop();
        int val = node.val;
        pushRight(node.left);
        return val;
    }

    private int nextLeft() {
        TreeNode node = stackLeft.pop();
        int val = node.val;
        pushLeft(node.right);
        return val;
    }

    private void pushRight(TreeNode root) {
        while (root != null) {
            stackRight.push(root);
            root = root.right;
        }
    }

    private void pushLeft(TreeNode root) {
        while (root != null) {
            stackLeft.push(root);
            root = root.left;
        }
    }
}
```

#### 复杂度分析

* 时间复杂度： $\mathcal{O}(n)$，遍历树节点两次（每个节点最多入栈出栈一次）。
* 空间复杂度： $\mathcal{O}(h)$，存储栈空间为树高度。

### AVL 树

> AVL 树，全称 Adelson-Velsky and Landis' Tree，它的核心思想就是通过在插入或删除节点后进行一些调整，
> 来始终保持树的“平衡”，从而避免二叉搜索树（BST）退化成链表的极端情况，保证搜索效率。

#### AVL树如何定义“平衡”（“平衡因子”概念）

这个定义非常关键，它依靠一个叫做**平衡因子 (Balance Factor)** 的概念。

> **平衡因子**的计算公式是：`一个节点的平衡因子 = 右子树的高度 - 左子树的高度`。

而 AVL 树的核心规则就是：

> **树中每一个节点的平衡因子，其绝对值必须小于或等于 1。** 也就是说，平衡因子只允许是 **-1, 0, 或 1**。
> 只要有任何一个节点的平衡因子变成了 -2 或 2，整个树就“失衡”了，需要进行调整。

为了计算平衡因子，我们先要定义“高度”。我们把一个节点到最远叶子节点的**边的数量**作为它的高度。
所以，叶子节点本身的高度是 0，一个空位（null）的高度是 -1。

1. **一个“平衡”的例子**
    ```
         20 (高度=1)
         /  \
    10 (高=0)  30 (高=0)
    ```
    * **节点 10**：左右子树都是空的，平衡因子 = (-1) - (-1) = **0**。
    * **节点 30**：左右子树都是空的，平衡因子 = (-1) - (-1) = **0**。
    * **节点 20**：左子树（节点10）高度为 0，右子树（节点30）高度为 0。平衡因子 = 0 - 0 = **0**。

   所有节点的平衡因子都是 0，所以这是一棵完美的 AVL 树。
2. **一个“失衡”的例子**
    ```
          10 (高度=2)
         /
        20 (高度=1)
       /
      30 (高度=0)
    ```
    * **节点 30**：叶子节点，平衡因子 = **0**。
    * **节点 20**：右子树为空（高度-1），左子树（节点30）高度为 0。平衡因子 = (-1) - 0 = **-1**。
    * **节点 10**：右子树为空（高度-1），左子树（节点20）高度为 1。平衡因子 = (-1) - 1 = **-2**。

   因为节点 10 的平衡因子是 -2，所以这棵树在根节点处失衡了，它不是一棵 AVL 树。

#### AVL树旋转(Rotation)

旋转就像是给树做“正骨”，当某个节点因为新节点的加入而导致“脱臼”（失衡）时，旋转能把它扳回正常位置，恢复平衡。

失衡的情况根据新节点插入的位置，总共分为四种。

**情况一：左-左 (Left-Left, 简称 LL)**

1. 如何造成LL失衡\
   假设我们有一棵空树，依次插入 30, 20, 10。
    * 插入 30: 树是 `{30}`，平衡。
    * 插入 20: 20 小于 30，放在左边。树是 `{30 -> 20}`，平衡。
    * 插入 10: 10 小于 30，再小于 20，继续放左边。
      插入 10 之后，树就变成了这样，并且失衡了：
    ```
          30 (平衡因子 = -2)  <-- 失衡点
         /
        20 (平衡因子 = -1)
       /
      10 (平衡因子 = 0)
    ```
2. 如何通过旋转来修复？\
   为了修复 LL 型失衡，我们需要对失衡的节点 (`30`) 进行一次 **右旋转**。\
   你可以想象用手捏住中间的节点 `20`，然后把它“向右上方提”，让它成为新的根节点。
    * **旋转前：** `30` 是 `20` 的父节点。
    * **旋转后：** `20` 成为新的根，而 `30` “降级”成为 `20` 的右孩子。
      旋转后的结果是：
    ```
          20 (平衡因子 = 0)
         /  \
    10(BF=0) 30(BF=0)
    ```
   看，现在所有节点的平衡因子都变回 0，树又恢复了完美的平衡！

代码实现：

我们先为 AVL 树创建一个基本的 `Node` 节点类，它除了左右子节点外，还需要一个 `height` 属性。

```java
// AVL 树的节点结构
class Node {
    int key;
    int height; // 节点的高度
    Node left;
    Node right;

    Node(int d) {
        key = d;
        height = 1; // 新插入的节点高度默认为 1 (叶子节点)
    }
}
```

现在，我们来编写 `rightRotate` (右旋转) 的方法。这个方法会接收一个失衡的节点作为参数（比如我们例子中的节点 `30`），并返回旋转后这个位置
**新的根节点**。

```java
/**
 * 对节点 y 进行右旋转
 */
private Node rightRotate(Node y) {
    // 步骤 1: 定义新根 x 和需要移动的子树 T2
    Node x = y.left;
    Node T2 = x.right;

    // 步骤 2: 执行旋转
    x.right = y; // y 成为 x 的右孩子
    y.left = T2;  // T2 成为 y 的新左孩子

    // 步骤 3: 更新节点的高度 (顺序很重要，先更新子节点 y, 再更新新根 x)
    y.height = Math.max(height(y.left), height(y.right)) + 1;
    x.height = Math.max(height(x.left), height(x.right)) + 1;

    // 步骤 4: 返回旋转后子树的 new root
    return x;
}

// 一个辅助函数，用来获取节点的高度，处理 null 的情况
private int height(Node N) {
    if (N == null)
        return 0;
    return N.height;
}
```

为了更好理解这个AVLTree结构，下面提供了AVLTree是如何获取平衡因子以及插入的代码

```java
// 获取节点平衡因子的辅助函数
private int getBalance(Node N) {
    if (N == null) return 0;
    // 平衡因子 = 右子树高度 - 左子树高度
    return height(N.right) - height(N.left); 
}

// 插入一个新节点的递归函数
public Node insert(Node node, int key) {
    /* 1. 执行标准的二叉搜索树 (BST) 插入 */
    if (node == null) {
        return (new Node(key));
    }

    if (key < node.key) {
        node.left = insert(node.left, key);
    } else if (key > node.key) {
        node.right = insert(node.right, key);
    } else { // 不允许插入重复的键
        return node;
    }

    /* 2. 更新当前节点的高度 */
    node.height = 1 + Math.max(height(node.left), height(node.right));

    /* 3. 获取当前节点的平衡因子，判断是否失衡 */
    int balance = getBalance(node);

    /* 4. 如果失衡，则进行旋转调整 */

    // LL (左-左) 型失衡
    // balance < -1 表示左子树比右子树高太多
    // key < node.left.key 确认新节点是插在左孩子的左边
    if (balance < -1 && key < node.left.key) {
        return rightRotate(node);
    }

    // RR (右-右) 型失衡 (留待我们接下来讨论)
    // ...

    // LR (左-右) 型失衡 (留待我们接下来讨论)
    // ...

    // RL (右-左) 型失衡 (留待我们接下来讨论)
    // ...

    /* 5. 如果没有失衡，直接返回当前节点 */
    return node;
}
```

**情况二：右-右 (Right-Right, 简称 RR)**

1. 如何造成 RR 失衡？

    我们依次插入 10, 20, 30

    * 插入 10: 树是 `{10}`，平衡。
    * 插入 20: 20 大于 10，放在右边。树是 `{10 -> 20}`，平衡。
    * 插入 30: 30 大于 10，再大于 20，继续放右边。

    插入 30 之后，树就变成了这样，并且失衡了：

    ```
          10 (平衡因子 = +2)  <-- 失衡点
         / \
          -  20 (平衡因子 = +1)
             / \
              -  30 (平衡因子 = 0)
    ```

2. 如何通过旋转来修复？

    为了修复 RR 型失衡，我们需要对失衡的节点 (`10`) 进行一次 **左旋转**。

    这和右旋转是镜像操作。你可以想象用手捏住中间的节点 `20`，然后把它“向左上方提”，让它成为新的根节点。

    * **旋转前：** `10` 是 `20` 的父节点。
    * **旋转后：** `20` 成为新的根，而 `10` “降级”成为 `20` 的左孩子。

    旋转后的结果是：

    ```
          20 (平衡因子 = 0)
         /  \
    10(BF=0) 30(BF=0)
    ```

    树再次恢复了平衡。

相应的，`insert` 方法里会增加对 RR 型的判断：

```java
// 在 insert 方法内...
int balance = getBalance(node);

// ... (之前的 LL 型判断)

// RR (右-右) 型失衡
// balance > 1 表示右子树比左子树高太多
// key > node.right.key 确认新节点是插在右孩子的右边
if (balance > 1 && key > node.right.key) {
    return leftRotate(node);
}
```

而 `leftRotate` 方法也正是 `rightRotate` 的镜像：

```java
private Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;

    // 执行旋转
    y.left = x;
    x.right = T2;

    // 更新高度
    x.height = Math.max(height(x.left), height(x.right)) + 1;
    y.height = Math.max(height(y.left), height(y.right)) + 1;

    // 返回新的根
    return y;
}
```

LL 和 RR 这两种“单旋转”的情况比较直观。但还有两种更复杂的情况：**LR (左-右)** 和 **RL (右-左)**，它们需要两次旋转才能修复。

**情况三：左-右 (Left-Right, 简称 LR)**

1. 如何造成 LR 失衡？

    `30, 20, 25` 插入：

    * 插入 30, 20 后，树是 `30 -> 20`。
    * 插入 25，它比 30 小，比 20 大，所以插在了 20 的右边。

    此时树的形态如下，形成了一个 "之"字形：

    ```text
          30 (平衡因子 = -2)  <-- 失衡点
         /
        20 (平衡因子 = +1)
         \
          25 (平衡因子 = 0)
    ```

    新节点 `25` 是在失衡点 `30` 的**左**子树 (`20`) 的**右**边插入的，所以这叫 **LR 型失衡**。
 
2. 为什么一次旋转不够？

    新节点 `25` 是在失衡点 `30` 的**左**子树 (`20`) 的**右**边插入的，所以这叫 **LR 型失衡**。

    ```text
          20
           \
            30
           /
          25
    ```

    你看，树还是一个奇怪的 "之"字形，并没有恢复平衡。所以，对于 LR 型，一次旋转是不够的。

3. 如何通过“两次旋转”来修复？

    这里的诀窍是：**先把 LR 型变成我们熟悉的 LL 型，然后再用 LL 的方法解决。**

    * **第 1 步：先对子节点 (`20`) 进行一次“左旋转”** \
    这个操作的目的是把 "之"字形拉直。

    ```text
      // 旋转前
          30 (-2)
         /
        20 (+1)
         \
          25
    ```

    对 `20` 进行左旋后，`25` 上位，`20` 成为 `25` 的左孩子。

    ```text
      // 旋转后
          30 (-2)
         /
        25
       /
      20
    ```

    * **第 2 步：对原失衡点 (`30`) 进行一次“右旋转”** \
    经过第一步，你发现了吗？这棵树现在变成了一个我们非常熟悉的 **LL 型**结构！所以，我们现在只需要按 LL 的处理方法，对 `30` 进行一次右旋转即可。

    ```text
      // 最终结果
          25
         /  \
        20  30
    ```

至此，树恢复了完美的平衡。所以，LR 型的修复=先左旋再右旋。

在 `insert` 方法中，我们会这样实现它：

```java
// 在 insert 方法内...
int balance = getBalance(node);

// ... (LL 和 RR 的判断) ...

// LR (左-右) 型失衡
if (balance < -1 && key > node.left.key) {
    node.left = leftRotate(node.left); // 步骤1：对左孩子进行左旋
    return rightRotate(node);          // 步骤2：对当前节点进行右旋
}
```

**情况四：右-左 (Right-Left, 简称 RL)**

1. 如何造成 RL 失衡？
 
    我们可以依次插入 `10, 30, 20`。

    * 插入 10, 30 后，树是 `10 -> 30`。
    * 插入 20，它比 10 大，比 30 小，所以插在了 30 的左边。

    此时树的形态再次形成 "之"字形：

    ```text
          10 (平衡因子 = +2)  <-- 失衡点
           \
            30 (平衡因子 = -1)
           /
          20 (平衡因子 = 0)
    ```

    新节点 `20` 是在失衡点 `10` 的**右**子树 (`30`) 的**左**边插入的，所以这叫 **RL 型失衡**。

2. 修复步骤：先右旋，再左旋

    我们先把这个 RL 型结构变成一个我们熟悉的 RR 型。

   * 第 1 步：先对子节点 (`30`) 进行一次“右旋转”

     这个操作同样是为了把 "之"字形拉直。
   
       ```text
         // 旋转前
             10 (+2)
              \
               30 (-1)
              /
             20
       ```
      
     对 `30` 进行右旋后，`20` 上位，`30` 成为 `20` 的右孩子。

       ```text
         // 旋转后 (变成了 RR 型)
             10 (+2)
              \
               20
                \
                 30
       ```
   * 第 2 步：对原失衡点 (`10`) 进行一次“左旋转”

     现在这棵树是一个标准的 RR 型结构了。我们对 `10` 进行一次左旋转。
    
        ```text
          // 最终结果
              20
             /  \
            10  30
        ```

在 `insert` 方法中，代码实现如下：

```java
// 在 insert 方法内...
int balance = getBalance(node);

// ... (LL, RR, LR 的判断) ...

// RL (右-左) 型失衡
if (balance > 1 && key < node.right.key) {
    node.right = rightRotate(node.right); // 步骤1：对右孩子进行右旋
    return leftRotate(node);              // 步骤2：对当前节点进行左旋
}
```

至此，AVL 树在插入节点时所有可能遇到的四种失衡情况以及对应的旋转策略我们都学习完了！

| 失衡类型         | 形状  | 旋转策略                     |
|--------------|-----|--------------------------|
| **LL** (左-左) | `/` | `右旋转` (一次)               |
| **RR** (右-右) | `\` | `左旋转` (一次)               |
| **LR** (左-右) | `<` | `先左旋 (子)` `再右旋 (父)` (两次) |
| **RL** (右-左) | `>` | `先右旋 (子)` `再左旋 (父)` (两次) |

#### 完整可运行的 AVL 树 Java 代码

```java
/**
 * 一个标准的 AVL 树实现 (包含插入与删除)
 */
public class AVLTree {

    /**
     * 1. 节点类定义
     */
    static class Node {
        int key;      // 节点的键值
        int height;   // 节点的高度
        Node left;    // 左子节点
        Node right;   // 右子节点

        Node(int key) {
            this.key = key;
            this.height = 1; // 新插入的节点默认为叶子节点，高度为1
        }
    }

    private Node root; // 树的根节点

    /**
     * 2. 辅助函数
     */
    // 获取节点的高度
    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // 获取节点的平衡因子 (右子树高度 - 左子树高度)
    private int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.right) - height(node.left);
    }

    /**
     * 3. 旋转操作 (与之前相同)
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    /**
     * 4. 插入操作 (与之前相同)
     */
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node node, int key) {
        if (node == null) return (new Node(key));
        if (key < node.key) node.left = insertRec(node.left, key);
        else if (key > node.key) node.right = insertRec(node.right, key);
        else return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance < -1 && key < node.left.key) return rightRotate(node);
        if (balance > 1 && key > node.right.key) return leftRotate(node);
        if (balance < -1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance > 1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    /**
     * 5. 删除操作
     */
    // 公开的删除接口
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    // 递归实现的删除方法
    private Node deleteRec(Node node, int key) {
        // 步骤 1: 执行标准的二叉搜索树 (BST) 删除
        if (node == null) return node;

        if (key < node.key) {
            node.left = deleteRec(node.left, key);
        } else if (key > node.key) {
            node.right = deleteRec(node.right, key);
        } else {
            // 找到要删除的节点
            // 情况 1 & 2: 节点有一个或零个子节点
            if ((node.left == null) || (node.right == null)) {
                Node temp = (node.left != null) ? node.left : node.right;
                if (temp == null) { // 零个子节点
                    node = null;
                } else { // 一个子节点
                    node = temp; // 用子节点替换当前节点
                }
            } else {
                // 情况 3: 节点有两个子节点
                // 找到右子树中的最小节点 (中序后继)
                Node temp = minValueNode(node.right);
                // 将后继节点的值复制到当前节点
                node.key = temp.key;
                // 从右子树中删除那个后继节点
                node.right = deleteRec(node.right, temp.key);
            }
        }

        // 如果树在删除后变为空 (例如，只有一个节点时)
        if (node == null) return node;

        // 步骤 2: 更新当前节点的高度
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // 步骤 3: 获取平衡因子并检查是否失衡
        int balance = getBalance(node);

        // 步骤 4: 如果失衡，处理四种情况
        // 左-左 (LL) 型
        if (balance < -1 && getBalance(node.left) <= 0) {
            return rightRotate(node);
        }

        // 左-右 (LR) 型
        if (balance < -1 && getBalance(node.left) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // 右-右 (RR) 型
        if (balance > 1 && getBalance(node.right) >= 0) {
            return leftRotate(node);
        }

        // 右-左 (RL) 型
        if (balance > 1 && getBalance(node.right) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // 查找子树中最小值的辅助函数
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
```

可以注意到结构代码中有个删除操作，删除和插入的思路很相似：首先执行一个基本操作，然后检查并修复可能出现的失衡。

具体来说，删除操作包括：

1. **执行标准的二叉搜索树 (BST) 删除**。
2. 从删除点的父节点开始，**一路回溯到根节点，检查路径上每个节点的平衡性，并在必要时进行旋转**。

**标准BST删除的回顾**

```java
// 递归实现的删除方法
private Node deleteRec(Node node, int key) {
    // 基础情况：如果树为空，直接返回
    if (node == null) {
        return node;
    }

    // 1. 寻找要删除的节点
    if (key < node.key) {
        node.left = deleteRec(node.left, key);
    } else if (key > node.key) {
        node.right = deleteRec(node.right, key);
    } 
    // 2. 找到了要删除的节点 (key == node.key)
    else {
        // 情况 1 & 2: 节点有一个或零个子节点
        // 这段代码巧妙地同时处理了这两种情况
        if (node.left == null) {
            return node.right; // 如果左子节点为空，则用右子节点替换
        } else if (node.right == null) {
            return node.left;  // 如果右子节点为空，则用左子节点替换
        }

        // 情况 3: 节点有两个子节点
        // a. 找到右子树中的最小节点 (中序后继)
        Node successor = minValueNode(node.right);
        
        // b. 将后继节点的值复制到当前节点
        node.key = successor.key;
        
        // c. 从右子树中递归地删除那个后继节点
        node.right = deleteRec(node.right, successor.key);
    }

    return node;
}

// 查找子树中最小值的辅助函数 (即中序后继)
private Node minValueNode(Node node) {
    Node current = node;
    // 循环找到最左边的叶子节点
    while (current.left != null) {
        current = current.left;
    }
    return current;
}
```

现在来看 AVL 删除中最关键的一步：**自我修复**。

和插入一样，我们在 `deleteRec` 方法执行完标准的 BST 删除后，会在递归返回的路径上，由下至上地检查每个节点的平衡性。

修复的旋转操作（左旋、右旋）是完全一样的。但关键的区别在于**如何判断失衡的类型**。

* 在**插入**时，我们可以根据新插入 `key` 的位置来判断是 LL 还是 LR。
* 但在**删除**时，一个节点没了，我们没有这个 `key` 作为参考。所以，我们必须用一种新方法：**检查更高那棵子树的根节点的平衡因子**。

我们来看第一种失衡场景： 假设我们删除了一个节点后，回溯到一个节点 `P`，发现它的平衡因子变成了 **-2**。这意味着它的左子树比右子树高了。

现在有两种可能，是 LL 型还是 LR 型？

* **判断方法：** 我们去看 `P` 的左孩子 `L` 的平衡因子。
    * 如果 `L` 的平衡因子是 **-1 或 0**，这说明“重量”在左侧，这是一个 **LL 型**失衡。我们只需对 `P` 进行一次**右旋转**即可修复。
    * 如果 `L` 的平衡因子是 **+1**，这说明“重量”在内侧，形成了一个“之”字形，这是一个 **LR 型**失衡。我们需要先对 `L` **左旋**，再对 `P` **右旋**来修复。

我们把刚才的理论补充到代码里，就构成了完整的 `deleteRec` 方法：

```java
private Node deleteRec(Node node, int key) {
    // ... (标准的 BST 删除部分，同上)
    
    // 如果树在删除后变为空
    if (node == null) return node;

    // 步骤 2: 更新当前节点的高度
    node.height = Math.max(height(node.left), height(node.right)) + 1;

    // 步骤 3: 获取平衡因子并检查是否失衡
    int balance = getBalance(node);

    // 步骤 4: 如果失衡，处理四种情况
    
    // --- 左子树过高 (balance < -1) ---
    // LL 型
    if (balance < -1 && getBalance(node.left) <= 0) {
        return rightRotate(node);
    }
    // LR 型
    if (balance < -1 && getBalance(node.left) > 0) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    // --- 右子树过高 (balance > 1) ---
    // RR 型
    if (balance > 1 && getBalance(node.right) >= 0) {
        return leftRotate(node);
    }
    // RL 型
    if (balance > 1 && getBalance(node.right) < 0) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    return node;
}
```

### 红黑树

它和 AVL 树一样，都是为了解决二叉搜索树退化的问题，但它实现“平衡”的思路非常不同。

* **AVL 树**像个严格的体操运动员，追求完美的平衡（高度差绝对值不超过1），因此查找速度极快，但为了维持这种严格的平衡，插入和删除时可能需要进行多次旋转。
* **红黑树**则更灵活，它允许一定程度的“不平衡”，通过一套巧妙的“染色”规则来确保树不会变得太“偏”，这让它在插入和删除时需要调整的次数更少，综合性能更优。因此，在很多语言的库函数中（比如 Java 的 `TreeMap` 和 `TreeSet`，C++ STL 的 `map` 和 `set`），都用的是红黑树。

红黑树不计算高度或平衡因子，而是通过给每个节点分配“红色”或“黑色”，并遵循以下五条规则来维持近似的平衡：

1. 每个节点不是红色就是黑色。
2. 根节点永远是**黑色**。
3. 所有叶子节点（NIL 节点，可以看作是 `null`）都是**黑色**的。
4. **红色**节点的子节点必须是**黑色**的。（这也就意味着，**不能有两个连续的红色节点**）。
5. 从任一节点到其所有后代叶子节点的路径上，包含的**黑色**节点数量必须相同（这个数量被称为“黑高”）。

其中，真正保证树“不会太偏”的核心，是第 4 条和第 5 条规则的巧妙结合。

**规则 4：红色节点的子节点必须是黑色的。**

这很好理解：它禁止了父子节点都是红色的情况。这就直接避免了形成长长的红色链条，从而初步限制了树的高度。

**规则 5：从任一节点到其所有后代叶子节点的路径上，包含的黑色节点数量必须相同。** 

我们把这个相同的黑色节点数称为节点的“黑高” (black-height)。这条规则强制树在“黑色深度”上是完全平衡的。

那么，这两条规则如何一起保证平衡呢？

* 想象一下，从一个节点出发，到叶子节点**最短的路径**，就是一条纯黑节点的路径（假设黑高为 N）。

* 那么**最长的路径**会是怎样的呢？根据规则 4，它最多就是“一黑一红”交替出现。而根据规则 5，这条最长路径上的黑色节点数量也必须是 N。

* 所以，最长路径的长度最多是 `N` (黑) + `N` (红) = `2N`。

结论就是：**红黑树中最长的路径，永远不会超过最短路径的两倍。** 这就是它“不会太偏”的数学保证！

这个第 4 和第 5 条规则的配合是红黑树平衡的核心。理解了这个之后，我们再回头看一个看似简单的规则——**规则 2：根节点永远是黑色。**

主要原因有两个：

1. **避免“红-红冲突”的特殊情况**：红黑树在插入新节点时，通常会先将新节点设为**红色**。想象一下，如果树是空的，我们插入第一个节点。如果允许它是红色的，那么它就成了一个红色的根。紧接着我们再插入一个子节点（也设为红色），就立刻违反了“红色节点的子节点必须是黑色”的规则4。通过强制规定根节点必须是黑色，就从根本上杜絕了这种最顶层的“红-红冲突”，简化了插入算法。
2. **保证“黑高”的一致性**：规则5要求所有路径的“黑高”一致。如果根节点是红色的，那它就不计入黑高，树的黑高就由它的子节点决定。而如果根节点是黑色的，那么从根节点算起的黑高就是明确且一致的。这让整棵树的属性更加统一。

所以，你可以把“根节点是黑色”这条规则看作是为了让整个红黑树的体系自洽、算法简单而设立的一个方便、可靠的基准。

我们来详细看看红黑树的插入操作。

红黑树的插入比 AVL 树要多一个“重新着色”的步骤，但旋转的逻辑会更少一些。整个过程的核心，就是为了维护我们刚才讨论的那五条规则不被破坏。

首先，一个新节点要插入时，它总是以**红色**的身份被添加进去的。

但这会造成**红-红冲突**（Red-Red Conflict）。这是插入操作中最核心、最需要解决的问题。因为新节点是红色的，如果它的父节点也是红色的，就立刻违反了规则4：“红色节点的子节点必须是黑色的”。

为了解决这个冲突，我们需要观察一个关键的角色：新节点的**叔叔** (uncle) 节点。叔叔节点就是**父节点的兄弟节点**。

根据这个叔叔节点的颜色，我们有两种主要的修复策略：

1. 如果叔叔节点是**红色**的。
2. 如果叔叔节点是**黑色**的 (或者不存在，即为NIL节点)。

我们先来看第一种情况。假设我们有下图这样的一个红-红冲突，并且叔叔节点 `Y` 也是红色的。

```text
      G (黑)
     / \
    P (红) Y (红)  <-- 叔叔是红色
   /
  X (红)          <-- 新插入的节点
```

这里 `G` 是祖父 (Grandparent)，`P` 是父 (Parent)，`X` 是新节点。

在这种情况下，最简单的修复方法不是旋转，而是**重新着色 (Recoloring)**。

**1. 触发条件：**

* 新插入的节点 `X` 是**红色**的。
* 它的父节点 `P` 也是**红色**的 (产生了“红-红冲突”)。
* 它的叔叔节点 `Y` **也是红色**的。

**2. 修复操作（一次性完成）：**

* **步骤 a:** 将父节点 `P` 和叔叔节点 `Y` 的颜色由**红**变为**黑**。
* **步骤 b:** 将祖父节点 `G` 的颜色由**黑**变为**红**。

**3. 操作结果：**

* **直接效果：** `P` 节点变成了黑色，因此 `P` 和 `X` 之间的“红-红冲突”立刻被解决了。
* **连锁反应：** 祖父节点 `G` 被染成了红色。现在，`G` 就成了新的“潜在问题节点”。我们需要把 `G` 当作一个新插入的节点，向上回溯，检查它和它的父节点（曾祖父节点）是否也构成了“红-红冲突”。等于说，我们把问题成功地向上推了一层。

```java
// 假设 x 是新插入的红色节点，parent 是它的父节点...
// 叔叔节点可以通过祖父节点的另一个孩子找到

// --- 情况一：叔叔节点是红色 ---
if (uncle != null && uncle.color == RED) {
    // 步骤 a: 将父节点和叔叔节点变为黑色
    parent.color = BLACK;
    uncle.color = BLACK;

    // 步骤 b: 将祖父节点变为红色
    grandparent.color = RED;

    // 步骤 c: 将祖父节点作为新的问题节点，继续向上检查
    // 在一个循环或递归的结构中，下一次的检查点就变成了祖父节点
    x = grandparent; 
} else {
    // --- 情况二：叔叔节点是黑色 (我们接下来会讨论) ---
}
```

我们来看叔叔节点是**黑色**的这种情况。这是需要**旋转**来解决的，稍微复杂一些。

当叔叔是黑色时，我们需要根据新节点 `X`、父节点 `P` 和祖父节点 `G` 的相对位置，把它分为两种情况：

1. **“直线” (Line):** `G`, `P`, `X` 形成一条直线 (比如左-左, LL 或 右-右, RR)。
2. **“三角形” (Triangle):** `G`, `P`, `X` 形成一个 "之" 字形 (比如左-右, LR 或 右-左, RL)。

我们先看比较直接的“直线”型。

**子情况 A: “直线”型 (以 LL 为例)**

**1. 状态:** 祖父 `G`、父亲 `P`、新节点 `X` 形成一条直线。

```text
      G (黑)
     /
    P (红)
   /
  X (红)  <-- P 和 X 存在红-红冲突
```

**2. 修复操作 (两步)：**

* **步骤 a (旋转):** 对**祖父节点 `G`** 进行一次**右旋转**。
* **步骤 b (变色):** 将旋转后新的根节点 `P` 变为**黑色**，被换下来的 `G` 变为**红色**。

**3. 结果:**

```text
      P (黑)
     / \
    X (红) G (红)
```

这样一来，红-红冲突被彻底解决，并且由于路径上黑节点数量不变（之前是 `G`，现在是 `P`），黑高属性也得到了维持。

**子情况 B: “三角形”型 (以 LR 为例)**

现在我们来看“三角形”。它的修复思路是：**通过一次旋转，先把它变成我们刚刚解决的“直线”型**。

**1. 状态:** `G`, `P`, `X` 形成一个 "之" 字形。

```text
      G (黑)
     /
    P (红)
     \
      X (红)
```

**修复操作:**

* **步骤 a (变为直线):** 对**父节点 `P`** 进行一次**左旋转**。这会把“三角形”拉直，变成上面的 LL“直线”型。
* **步骤 b (按直线型修复):** 既然已经变成了直线型，我们就按刚才学的方法处理即可（对 `G` 右旋，然后 `G` 和 `X` 变色）。

```java
// ... (在 fixInsert 循环或递归方法中)

} else { // --- 情况二：叔叔节点是黑色或不存在 ---

    // 首先判断父节点 P 是 G 的左孩子还是右孩子
    if (parent == grandparent.left) {
        
        // 子情况 B: “三角形” (LR 型)
        // 如果新节点 X 是父节点 P 的右孩子，形成 "之" 字形
        if (x == parent.right) {
            // 步骤 a: 对父节点 P 进行左旋，将其转为“直线”型
            leftRotate(parent);
            // 旋转后，原来的父节点 P 就变成了 x 的子节点
            // 为了后续操作的统一，我们需要更新 parent 的指向
            parent = x;
        }

        // 子情况 A: “直线” (LL 型)
        // 经过上面可能的转换，此时一定是直线型了
        // 步骤 b: 对祖父节点 G 右旋，并交换颜色
        parent.color = BLACK;
        grandparent.color = RED;
        rightRotate(grandparent);

    } else { // 对称情况：父节点 P 是 G 的右孩子
        
        // 子情况 B: “三角形” (RL 型)
        if (x == parent.left) {
            rightRotate(parent);
            parent = x;
        }

        // 子情况 A: “直线” (RR 型)
        parent.color = BLACK;
        grandparent.color = RED;
        leftRotate(grandparent);
    }
    
    // 只要进入了“叔叔是黑色”的逻辑，
    // 通过一次或两次旋转和变色，冲突一定会被解决，
    // 所以我们可以直接结束修复过程。
    break; 
}
```

**现在来学习红黑树的删除操作**

删除通常被认为比插入更复杂，因为它需要考虑的情况更多。但核心思想是一样的：

1. 先执行标准的 BST 删除。
2. 然后通过一系列的“修复”操作（重新着色和旋转）来恢复红黑树的五条规则。

删除操作的核心问题在于：如果我们删除了一个**黑色**节点，那么经过这个节点的所有路径上的“黑高”就会减一，破坏了规则5。

* 为了解决这个问题，我们引入一个概念叫做“**双重黑**” (Double Black)。你可以想象，被删除的黑色节点的空位，由一个带有“双重黑”属性的节点来占据，我们的任务就是想办法消除这个“双重黑”。
* (如果我们删除的是一个红色节点，则不会有任何影响，因为不改变黑高。)

和插入时我们关心“叔叔”节点一样，在删除时，解决“双重黑”问题的关键角色是它的**兄弟** (Sibling) 节点。

修复“双重黑”的策略，主要取决于这个兄弟节点的颜色。

1. 兄弟节点是**红色**的。
2. 兄弟节点是**黑色**的 (这是更常见，也更复杂的情况)。

**情况一：兄弟节点是红色**

这是最简单的一种情况，它的作用是**通过一次旋转和变色，将问题转化为我们接下来要处理的“兄弟是黑色”的情况**。

**1. 状态:** 

“双重黑”节点 `X` 的兄弟 `S` 是红色的。（那么根据规则4，它的父节点 `P` 和侄子节点 `C`, `D` 必然是黑色的）。

```
      P (黑)
     / \
    X (双重黑) S (红)
             / \
            C (黑) D (黑)
```

**2. 修复操作:**

* **步骤 a (变色):** 将父节点 `P` 变为**红色**，兄弟 `S` 变为**黑色**。
* **步骤 b (旋转):** 对父节点 `P` 进行一次**左旋转**。

**3. 结果:** 

旋转后，原来的兄弟 `S` 成了新的父节点。`X` 的新兄弟变成了 `C` (黑色)。

```
      S (黑)
     / \
    P (红) D (黑)
   / \
  X(双重黑) C (黑) <-- 新的兄弟
```

你看，我们并没有解决“双重黑”的问题，但我们成功地把情况转化为了接下来要处理的“兄弟是黑色”的情况。

**情况二：兄弟节点是黑色**

这是核心，它根据两个侄子（兄弟的孩子）的颜色，又分为三种子情况。

**子情况 2a: 兄弟的两个孩子都是黑色**

**1. 状态:** 兄弟 `S` 是黑色的，它的两个孩子 `C`, `D` 也都是黑色的。

**2. 修复操作 (只变色):**

* **步骤 a:** 将兄弟 `S` 的颜色变为**红色**。
* **步骤 b:** “双重黑”问题解决了一半，我们将父节点 `P` 视为新的“问题节点”，对其**重新进行平衡检查** (如果 `P` 原来是红色，现在变黑即可；如果原来是黑色，那它就成了新的“双重黑”节点，需要继续向上回溯)。

**这个操作的本质是：** 把 `X` 路径上缺少的黑色，从兄弟 `S` 的路径上“借”过来一个（通过把S变红），然后把问题向上推给父节点 `P`。

**子情况 2c: 兄弟的“内部”孩子是红色，“外部”孩子是黑色 (“三角形”)**

**1. 状态:** 兄弟 `S` 是黑色，靠近 `X` 的那个孩子 `C` 是红色的。

**2. 修复操作 (先变“直线”):**

* **步骤 a (变色):** 将兄弟 `S` 变为**红色**，侄子 `C` 变为**黑色**。
* **步骤 b (旋转):** 对兄弟 `S` 进行一次**右旋转**。

**这个操作的本质是：** 通过一次小范围的旋转和变色，将“三角形”转化为我们最后要讲的“直线”情况。

**子情况 2b: 兄弟的“外部”孩子是红色 (“直线”)*8

这是**最终解决问题**的情况。

**1. 状态:** 兄弟 `S` 是黑色，远离 `X` 的那个孩子 `D` 是红色的。

**2. 修复操作 (最终修复):**

* **步骤 a (变色):** 将兄弟 `S` 的颜色变得和父节点 `P` 一样，然后将 `P` 变为**黑色**，红色侄子 `D` 也变为**黑色**。
* **步骤 b (旋转):** 对父节点 `P` 进行一次**左旋转**。

**这个操作的本质是：** 通过一次大范围的旋转，从兄弟路径借调了一个黑节点过来，并且彻底解决了“双重黑”问题，整个修复过程**到此结束**。

```java
// --- 删除操作 ---

/**
 * 公开的删除接口，通过键值查找并删除节点
 */
public void delete(int key) {
    Node z = findNode(root, key);
    if (z == NIL) {
        // 节点不存在，直接返回
        return;
    }
    deleteNode(z);
}

// 查找具有给定键的节点
private Node findNode(Node node, int key) {
    while (node != NIL && key != node.key) {
        if (key < node.key) {
            node = node.left;
        } else {
            node = node.right;
        }
    }
    return node;
}


/**
 * transplant 方法用 v 替换 u
 */
private void transplant(Node u, Node v) {
    if (u.parent == NIL) {
        root = v;
    } else if (u == u.parent.left) {
        u.parent.left = v;
    } else {
        u.parent.right = v;
    }
    v.parent = u.parent;
}

/**
 * 查找子树中的最小节点
 */
private Node minimum(Node node) {
    while (node.left != NIL) {
        node = node.left;
    }
    return node;
}

/**
 * 核心的删除节点逻辑
 */
private void deleteNode(Node z) {
    Node y = z;
    Node x;
    boolean yOriginalColor = y.color;

    if (z.left == NIL) {
        x = z.right;
        transplant(z, z.right);
    } else if (z.right == NIL) {
        x = z.left;
        transplant(z, z.left);
    } else {
        y = minimum(z.right);
        yOriginalColor = y.color;
        x = y.right;
        if (y.parent == z) {
            x.parent = y;
        } else {
            transplant(y, y.right);
            y.right = z.right;
            y.right.parent = y;
        }
        transplant(z, y);
        y.left = z.left;
        y.left.parent = y;
        y.color = z.color;
    }

    // 如果被删除的节点是黑色的，才需要进行修复
    if (yOriginalColor == BLACK) {
        fixDelete(x);
    }
}

/**
 * 删除后的修复方法，处理“双重黑”问题
 */
private void fixDelete(Node x) {
    while (x != root && x.color == BLACK) {
        // x 是其父节点的左孩子
        if (x == x.parent.left) {
            Node sibling = x.parent.right;

            // 情况一：兄弟是红色
            if (sibling.color == RED) {
                sibling.color = BLACK;
                x.parent.color = RED;
                leftRotate(x.parent);
                sibling = x.parent.right;
            }

            // 情况二：兄弟是黑色
            if (sibling.left.color == BLACK && sibling.right.color == BLACK) {
                // 2a: 兄弟的两个孩子都是黑色
                sibling.color = RED;
                x = x.parent; // 问题上移
            } else {
                // 2c: “三角形”
                if (sibling.right.color == BLACK) {
                    sibling.left.color = BLACK;
                    sibling.color = RED;
                    rightRotate(sibling);
                    sibling = x.parent.right;
                }
                // 2b: “直线”
                sibling.color = x.parent.color;
                x.parent.color = BLACK;
                sibling.right.color = BLACK;
                leftRotate(x.parent);
                x = root; // 修复完成
            }
        } else { // x 是其父节点的右孩子的对称情况
            Node sibling = x.parent.left;

            // 情况一：兄弟是红色
            if (sibling.color == RED) {
                sibling.color = BLACK;
                x.parent.color = RED;
                rightRotate(x.parent);
                sibling = x.parent.left;
            }

            // 情况二：兄弟是黑色
            if (sibling.right.color == BLACK && sibling.left.color == BLACK) {
                // 2a: 兄弟的两个孩子都是黑色
                sibling.color = RED;
                x = x.parent;
            } else {
                // 2c: “三角形”
                if (sibling.left.color == BLACK) {
                    sibling.right.color = BLACK;
                    sibling.color = RED;
                    leftRotate(sibling);
                    sibling = x.parent.left;
                }
                // 2b: “直线”
                sibling.color = x.parent.color;
                x.parent.color = BLACK;
                sibling.left.color = BLACK;
                rightRotate(x.parent);
                x = root;
            }
        }
    }
    x.color = BLACK; // 确保根节点或被修复节点最终是黑色
}
```

#### 红黑树完整实现

```java
/**
 * 一个完整的红-黑树实现
 */
public class RedBlackTree {

    // 颜色枚举
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * 内部节点类
     */
    private class Node {
        int key;
        boolean color;
        Node parent, left, right;

        Node(int key) {
            this.key = key;
            this.color = RED; // 新节点默认为红色
        }
    }

    private Node root;
    private final Node NIL; // 哨兵节点，代表所有的叶子节点

    public RedBlackTree() {
        NIL = new Node(0);
        NIL.color = BLACK;
        root = NIL;
    }

    // --- 旋转操作 ---
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NIL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == NIL) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != NIL) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == NIL) {
            root = x;
        } else if (y == y.parent.right) {
            y.parent.right = x;
        } else {
            y.parent.left = x;
        }
        x.right = y;
        y.parent = x;
    }

    // --- 插入操作 ---
    public void insert(int key) {
        Node z = new Node(key);
        Node y = NIL;
        Node x = root;

        // 1. 执行标准 BST 插入
        while (x != NIL) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == NIL) {
            root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = NIL;
        z.right = NIL;

        // 2. 修复红黑树性质
        fixInsert(z);
    }

    private void fixInsert(Node z) {
        while (z.parent.color == RED) {
            Node parent = z.parent;
            Node grandparent = parent.parent;

            if (parent == grandparent.left) {
                Node uncle = grandparent.right;
                // 情况一：叔叔是红色
                if (uncle.color == RED) {
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandparent.color = RED;
                    z = grandparent; // 问题上移
                } else {
                    // 情况二：叔叔是黑色
                    // 子情况 B: "三角形" -> 转为 "直线"
                    if (z == parent.right) {
                        z = parent;
                        leftRotate(z);
                        parent = z.parent; // 更新指针
                    }
                    // 子情况 A: "直线"
                    parent.color = BLACK;
                    grandparent.color = RED;
                    rightRotate(grandparent);
                }
            } else { // 对称情况
                Node uncle = grandparent.left;
                // 情况一：叔叔是红色
                if (uncle.color == RED) {
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandparent.color = RED;
                    z = grandparent;
                } else {
                    // 情况二：叔叔是黑色
                    // 子情况 B: "三角形"
                    if (z == parent.left) {
                        z = parent;
                        rightRotate(z);
                        parent = z.parent;
                    }
                    // 子情况 A: "直线"
                    parent.color = BLACK;
                    grandparent.color = RED;
                    leftRotate(grandparent);
                }
            }
        }
        root.color = BLACK; // 规则2：根节点永远是黑色
    }

    // --- 删除操作 ---
    // (删除操作代码较长，且逻辑复杂，此处省略以保持清晰)
    // (完整的删除会包含 bstDelete, transplant, fixDelete 等辅助方法)
    // (其逻辑与我们之前讨论的理论完全一致)


    // --- 打印树 (中序遍历) ---
    public void inOrder() {
        inOrderRec(this.root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != NIL) {
            inOrderRec(node.left);
            System.out.print(node.key + "(" + (node.color == RED ? "R" : "B") + ") ");
            inOrderRec(node.right);
        }
    }
}
```

## 典型问题 1：二叉搜索树中第 K 小的元素

### 「力扣」第 230 题：[二叉搜索树中第 $K$ 小的元素](https://leetcode.cn/problems/kth-smallest-element-in-a-bst/)

#### 解题思路

1. 对 BST 进行递归中序遍历，并在遍历过程中计数。
2. 每访问一个节点，计数器加一。
3. 当计数器等于 k 时，记录该节点值并停止遍历。
4. 返回该值。


#### 代码实现

```java
public class KthSmallestElementInABST {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }
}
```

#### 复杂度分析

* 时间复杂度：平均和最坏均为 $\mathcal{O}(H + k)$，其中 H 是树的高度。中序遍历访问 k 个元素后返回，最坏时遍历 $k + H$ 个节点。
* 空间复杂度：递归调用栈深度为树高度 $\mathcal{O}(H)$，最坏为 $\mathcal{O}(n)$（退化成线性链表）；平均情况下 $\mathcal{O}(\log n)$。

### 完成「力扣」第 669 题：[修剪二叉搜索树](https://leetcode.cn/problems/trim-a-binary-search-tree/description/)

#### 解题思路

采用**递归**方式，步骤为：

1. 若当前节点为空，返回 `null`。
2. 若当前节点值小于 `low`，说明当前节点和左子树都小于 `low`，整棵左子树舍弃，递归调用右子树修剪结果返回。
3. 若当前节点值大于 `high`，说明当前节点和右子树都大于 `high`，整个右子树舍弃，递归调用左子树修剪结果返回。
4. 当前节点值在区间内，则递归调用左右子树修剪，分别更新 `root.left` 和 `root.right`，返回当前节点。

#### 代码实现

```java
public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val < low) return trimBST(root.right, low, high);
        else if (root.val > high) return trimBST(root.left, low, high);
        else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}
```

#### 复杂度分析

* 时间复杂度: $\mathcal{O}(n)$，每个节点最多访问一次，递归遍历整棵树。
* 空间复杂度: $\mathcal{O}(H)$，为递归栈空间，H 为树的高度，平均为 $\mathcal{O}(\log n)$，最坏退化为链表 $\mathcal{O}(n)$。

### 完成「力扣」第 783 题：[二叉搜索树节点最小距离](https://leetcode.cn/problems/minimum-distance-between-bst-nodes/description/)

#### 解题思路

* 利用 **中序遍历** 得到一个递增序列（无需完整保存数组，只需记录上一个节点即可节省空间）。
* 在遍历过程中：
    * 维护上一个节点值变量 `prev`。
    * 每访问一个节点时，计算当前节点与 `prev` 的差值并更新全局最小差 `ans`。
* 遍历结束后得到最小差值。


#### 代码实现

```java
public class MinimumDistanceBetweenBSTNodes {
    private int ans = Integer.MAX_VALUE;
    private Integer prev = null;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        if (prev != null) ans = Math.min(ans, node.val - prev);
        prev = node.val;
        inorder(node.right);
    }
}
```

#### 复杂度分析

* **时间复杂度**： 遍历整棵树一次， $\mathcal{O}(n)$
* **空间复杂度**： 主要为递归栈深度 $\mathcal{O}(H)$， 平均 $\mathcal{O}(\log n)$，最坏为 $\mathcal{O}(n)$。

---

**[返回](../README.md)**