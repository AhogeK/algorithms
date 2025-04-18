<!-- TOC -->
* [链表](#链表)
  * [基本类型](#基本类型)
  * [常用技巧](#常用技巧)
  * [经典问题](#经典问题)
  * [链表操作的时间复杂度](#链表操作的时间复杂度)
  * [链表的优缺点](#链表的优缺点)
  * [解决链表中的指针指向问题](#解决链表中的指针指向问题)
    * [指针指向问题的本质](#指针指向问题的本质)
    * [例题：「力扣」第 206 题：反转链表](#例题力扣第-206-题反转链表)
      * [算法思路](#算法思路)
      * [复杂度剖析](#复杂度剖析)
    * [完成「力扣」第 92 题：反转链表 II](#完成力扣第-92-题反转链表-ii)
      * [算法思路](#算法思路-1)
      * [细节点分析](#细节点分析)
      * [复杂度分析](#复杂度分析)
    * [完成「力扣」第 203 题：移除链表元素](#完成力扣第-203-题移除链表元素)
      * [算法思路](#算法思路-2)
      * [复杂度分析](#复杂度分析-1)
    * [完成「力扣」第 24 题：两两交换链表中的节点](#完成力扣第-24-题两两交换链表中的节点)
      * [算法思路](#算法思路-3)
      * [复杂度分析](#复杂度分析-2)
    * [完成「力扣」第 25 题：K 个一组翻转链表](#完成力扣第-25-题k-个一组翻转链表)
      * [算法思路](#算法思路-4)
      * [复杂度分析](#复杂度分析-3)
    * [完成「力扣」第 143 题：重排链表](#完成力扣第-143-题重排链表)
      * [算法思路](#算法思路-5)
      * [复杂度分析](#复杂度分析-4)
    * [完成「力扣」第 328 题：奇偶链表](#完成力扣第-328-题奇偶链表)
      * [算法思路](#算法思路-6)
      * [复杂度剖析](#复杂度剖析-1)
    * [完成「力扣」第 61 题：旋转链表](#完成力扣第-61-题旋转链表)
      * [算法思路](#算法思路-7)
      * [复杂度剖析](#复杂度剖析-2)
    * [完成「力扣」第 234 题：回文链表](#完成力扣第-234-题回文链表)
      * [算法思路](#算法思路-8)
      * [算法技巧](#算法技巧)
      * [复杂度剖析](#复杂度剖析-3)
    * [完成「力扣」第 147 题：对链表进行插入排序](#完成力扣第-147-题对链表进行插入排序)
      * [算法思路](#算法思路-9)
      * [知识点](#知识点)
      * [复杂度分析](#复杂度分析-5)
        * [时间复杂度](#时间复杂度)
        * [空间复杂度](#空间复杂度)
  * [虚拟头节点](#虚拟头节点)
    * [例题：「力扣」第 19 题：删除链表的倒数第 N 个节点](#例题力扣第-19-题删除链表的倒数第-n-个节点)
      * [算法思路](#算法思路-10)
      * [算法技巧](#算法技巧-1)
      * [复杂度分析](#复杂度分析-6)
    * [完成「力扣」第 2 题：两数相加](#完成力扣第-2-题两数相加)
      * [算法思路](#算法思路-11)
      * [算法技巧](#算法技巧-2)
      * [复杂度分析](#复杂度分析-7)
    * [完成「力扣」第 445 题：两数相加 II](#完成力扣第-445-题两数相加-ii)
      * [算法思路](#算法思路-12)
      * [复杂度分析](#复杂度分析-8)
    * [完成「力扣」第 21 题：合并两个有序链表](#完成力扣第-21-题合并两个有序链表)
      * [算法思路](#算法思路-13)
      * [复杂度分析](#复杂度分析-9)
    * [完成「力扣」第 23 题：合并 K 个排序链表](#完成力扣第-23-题合并-k-个排序链表)
      * [算法思路](#算法思路-14)
      * [复杂度分析](#复杂度分析-10)
    * [完成「力扣」第 82 题：删除排序链表中的重复元素 II](#完成力扣第-82-题删除排序链表中的重复元素-ii)
      * [算法思路](#算法思路-15)
      * [复杂度分析](#复杂度分析-11)
    * [完成「力扣」第 83 题：删除排序链表中的重复元素](#完成力扣第-83-题删除排序链表中的重复元素)
      * [算法思路](#算法思路-16)
      * [复杂度分析](#复杂度分析-12)
    * [完成「力扣」第 86 题：分隔链表](#完成力扣第-86-题分隔链表)
      * [算法思路](#算法思路-17)
      * [复杂度分析](#复杂度分析-13)
  * [快慢指针](#快慢指针)
    * [基本思想](#基本思想)
    * [主要应用](#主要应用)
      * [1. 检测链表中是否有环](#1-检测链表中是否有环)
      * [2. 查找链表的中间节点](#2-查找链表的中间节点)
    * [伪代码示例](#伪代码示例)
      * [检测环](#检测环)
      * [找中点](#找中点)
    * [完成「力扣」第 876 题：链表的中间结点](#完成力扣第-876-题链表的中间结点)
      * [算法思路](#算法思路-18)
      * [复杂度分析](#复杂度分析-14)
  * [典型问题： 环形链表](#典型问题-环形链表)
    * [1. 如何判断链表是否有环？](#1-如何判断链表是否有环)
      * [伪代码](#伪代码)
    * [2. 如何找到环的入口（起始点）？](#2-如何找到环的入口起始点)
      * [关键原理](#关键原理)
        * [1. 变量设定](#1-变量设定)
        * [2. 推理（关键公式）](#2-推理关键公式)
    * [例 1：「力扣」第 142 题：环形链表 II](#例-1力扣第-142-题环形链表-ii)
      * [算法思路](#算法思路-19)
      * [复杂度分析](#复杂度分析-15)
    * [例 2：「力扣」第 141 题：环形链表 II](#例-2力扣第-141-题环形链表-ii)
      * [算法思路](#算法思路-20)
      * [复杂度分析](#复杂度分析-16)
  * [典型问题：相交链表](#典型问题相交链表)
    * [问题定义与性质](#问题定义与性质)
    * [常见考法](#常见考法)
    * [典型解法及技巧](#典型解法及技巧)
      * [解法一：哈希表法（适用于所有链表问题）](#解法一哈希表法适用于所有链表问题)
      * [解法二：双指针法（最优解，推荐）](#解法二双指针法最优解推荐)
<!-- TOC -->

# 链表

链表是一种线性数据结构，由一系列连接的节点组成，每个节点包含数据和指向下一个节点的引用（指针）。
与数组不同，链表元素在内存中不需要连续存储， 而是通过指针相连。

## 基本类型

* **单向链表（Singly Linked List）**：每个节点只有一个指向下一个节点的指针
* **双向链表（Doubly Linked List）**：每个节点有两个指针，分别指向前一个和后一个节点
* **循环链表（Circular Linked List）**：最后一个节点指向第一个节点而不是null

## 常用技巧

1. 使用哨兵节点（Dummy Node）
2. 快慢指针技巧

## 经典问题

1. 反转链表
2. 合并两个有序链表
3. 删除链表的倒数第N个节点
4. 判断回文链表
5. 找出环的入口点

## 链表操作的时间复杂度

* 访问元素： $O(n)$
* 在头部插入/删除： $O(1)$
* 在中间/尾部插入/删除： $O(n)$ （需要先找到位置）
* 查找元素： $O(n)$

## 链表的优缺点

优点：

* 动态大小
* 插入和删除操作简单高效
* 不需要连续的内存空间

缺点：

* 不支持随机访问
* 需要额外的内存存储指针
* 缓存不友好，元素不连续存储

链表是许多高级数据结构的基础，掌握它对理解更复杂的算法和数据结构非常重要。

## 解决链表中的指针指向问题

在链表数据结构中，"指针指向问题"是指针操作中的核心难点，它涉及如何正确管理节点间的引用关系。

### 指针指向问题的本质

链表中的指针指向问题主要涉及以下几个方面：

1. **节点间连接关系的管理**：确保链表节点正确连接，不出现断链或环路（除非是有意设计的循环链表）
2. **指针操作的顺序**：在增删节点时，指针操作顺序错误可能导致节点丢失或链表结构被破坏
3. **边界条件处理**：如何处理头节点、尾节点的特殊情况以及空链表

### 例题：「力扣」第 206 题：[反转链表](https://leetcode.cn/problems/reverse-linked-list/)

[../src/linked/ReverseLinkedList.java](../src/linked/ReverseLinkedList.java)

```java

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // 处理边界情况
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null; // 以反转部分的头节点
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}
```

#### 算法思路

使用**迭代法**反转列表，迭代法的核心思想是：**边遍历边反转**。我们维护三个关键指针：

1. `prev`：指向已反转部分的头节点
2. `current`：指向当前处理的节点
3. `nextTemp`：临时保存下一个要处理的节点

#### 复杂度剖析

1. **时间复杂度**： $O(n)$ ，其中 n 为链表长度
    * 我们需要遍历链表一次，对每个节点进行常数次操作
2. **空间复杂度**： $O(1)$
    * 只使用了几个指针变量，不管链表多长，额外空间使用都是常量级的

反转链表是链表操作中的基础问题，也是许多复杂链表问题的子问题。
掌握这种简单的迭代反转方法对于解决其他链表问题非常有帮助。
关键是要理解指针操作的顺序，并通过保存临时引用防止链表断裂。

### 完成「力扣」第 92 题：[反转链表 II](https://leetcode.cn/problems/reverse-linked-list-ii/)

[../src/linked/ReverseLinkedListII.java](../src/linked/ReverseLinkedListII.java)

```java
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 处理特殊情况
        if (head == null || left == right) {
            return head;
        }

        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 找到反转部分的前一个节点
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        // 当前节点初始化为left位置
        ListNode curr = pre.next;
        ListNode next;

        // 执行（right - left）次反转操作
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }
}
```

#### 算法思路

我们将使用"**头插法**"来反转指定区间的链表。头插法的核心思想是：将需要反转部分的节点一个个地插入到反转区间的头部，从而实现反转效果。

具体步骤如下：

1. 处理特殊情况：如果链表为空或只需反转一个节点（`left == right`），直接返回原链表
2. 创建虚拟头节点，简化操作（特别是当`left=1`时的边界情况）
3. 定位到反转区间的前一个节点（`pre`）
4. 将`curr`指针设置为反转区间的第一个节点（`left`位置）
5. 执行`right-left`次头插操作，每次：
    * 取出`curr`的下一个节点
    * 将这个节点插入到反转部分的头部
    * 更新链接关系
6. 返回反转后的链表

#### 细节点分析

1. **虚拟头节点**：
    * 使用虚拟头节点`dummy`可以统一处理`left=1`的特殊情况
    * 如果不使用虚拟头节点，当`left=1`时需要特殊处理头节点的变化
2. **指针不变性**：
    * 整个过程中，`curr`指针始终指向原始链表中`left`位置的节点（示例中的节点2）
    * 反转完成后，`curr`成为反转部分的尾节点
    * `pre`始终指向反转部分的前一个节点（示例中的节点1）
3. **指针操作顺序**：
    * 操作顺序至关重要，必须按照代码中的顺序执行
    * 任何顺序的改变都可能导致链表断裂或循环引用
4. **头插法原理**：
    * 每次循环都将`curr.next`节点移到反转部分的头部
    * 通过`right-left`次操作，完成区间内所有节点的反转

#### 复杂度分析

* **时间复杂度**： $O(n)$ ，其中 $n$ 是链表的长度
    * 定位到`left`位置需要 $O(left)$ 时间
    * 反转区间内的节点需要 $O(right-left)$ 时间
    * 总体时间复杂度为 $O(right)$ ，最坏情况下为 $O(n)$
* **空间复杂度**： $O(1)$
    * 只使用了几个指针变量，不随输入规模变化
    * 没有使用额外的数据结构

### 完成「力扣」第 203 题：[移除链表元素](https://leetcode.cn/problems/remove-linked-list-elements)

[../src/linked/RemoveLinkedListElements.java](../src/linked/RemoveLinkedListElements.java)

```java
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 当前遍历节点指针
        ListNode curr = dummy;

        // 遍历链表
        while (curr.next != null) {
            // 如果下一个节点的值等于要删除的值
            if (curr.next.val == val) {
                // 删除下一个节点
                curr.next = curr.next.next;
            } else {
                // 否则移动到下一个节点
                curr = curr.next;
            }
        }

        // 返回新的头节点
        return dummy.next;
    }
}
```

#### 算法思路

解决这类链表删除问题有一个非常经典的技巧：**使用虚拟头节点（dummy node）**。

基本思路如下：

1. 创建一个虚拟头节点，将其 next 指向原链表的头节点
2. 遍历链表，检查每个节点的下一个节点
3. 如果下一个节点的值等于 `val`，则删除该节点（通过修改指针）
4. 如果不等于 `val`，则移动当前指针到下一个节点
5. 最后返回虚拟头节点的 next 作为新的头节点

#### 复杂度分析

* **时间复杂度**： $O(n)$ ，其中 $n$ 是链表的长度
    * 我们需要遍历整个链表一次，对每个节点进行常数次操作

* **空间复杂度**： $O(1)$
    * 只使用了几个额外的指针变量，不随输入规模变化
    * 不需要额外的数据结构存储中间结果

### 完成「力扣」第 24 题：[两两交换链表中的节点](https://leetcode.cn/problems/swap-nodes-in-pairs)

[../src/linked/SwapNodesInPairs.java](../src/linked/SwapNodesInPairs.java)

```java
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev指针，指向待交换两个节点的前一个节点
        ListNode prev = dummy;

        // 当链表表还有至少两个节点可以交换时
        while (head != null && head.next != null) {
            // 定位待交换的两个节点
            ListNode first = head;
            ListNode second = head.next;

            // 进行交换
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // 更换指针，为下一次交换作准备
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
}
```

#### 算法思路

本题的最优解法是**迭代法**，通过维护指针关系来实现节点交换。具体思路如下：

1. 创建一个虚拟头节点（dummy node），简化对原始头节点的处理
2. 使用三个关键指针：
    * `prev`: 指向待交换的两个节点的前一个节点
    * `first`: 指向待交换的第一个节点
    * `second`: 指向待交换的第二个节点
3. 对于每一对需要交换的节点，调整它们的指针关系
4. 更新指针位置，继续处理后面的节点对

#### 复杂度分析

* **时间复杂度**： $O(n)$，其中 $n$ 是链表的长度
    * 我们需要遍历整个链表，对每一对节点进行常数次操作
    * 每个节点最多被访问和操作一次
* **空间复杂度**： $O(1)$
    * 只使用了几个指针变量，额外空间使用不随输入规模变化
    * 没有使用递归，不需要占用调用栈空间

### 完成「力扣」第 25 题：[K 个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group)

[../src/linked/ReverseNodesInKGroup.java](../src/linked/ReverseNodesInKGroup.java)

```java
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 初始化指针
        ListNode prev = dummy;

        while (true) {
            // 检查是否有 k 个节点
            ListNode kth = getKth(prev, k);
            if (kth == null) break;

            // 当前组的第一个节点和下一组的起始节点
            ListNode first = prev.next;
            ListNode nextStart = kth.next;

            // 断开当前组与后续节点的连接
            kth.next = null;

            // 反转当前组，并连接到前一个节点
            prev.next = reverseList(first);

            // 连接当前组的尾节点（翻转后的 first）到下一组的起始节点
            first.next = nextStart;

            prev = first;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode node, int k) {
        for (int i = 0; i < k; i++) {
            node = node.next;
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
```

#### 算法思路

解决这个问题的最优方法是使用**迭代法**，主要步骤如下：

1. 创建虚拟头节点（dummy node）简化边界情况处理
2. 循环处理每一组 `k` 个节点：
    * 检查当前位置是否有足够的 `k` 个节点
    * 如果不足 `k` 个节点，保持原有顺序并结束
    * 如果有 `k` 个节点，进行翻转操作
    * 重新连接翻转后的组到主链表
    * 继续处理下一组节点

#### 复杂度分析

* **时间复杂度**: $O(n)$ ，其中 $n$ 是链表的长度
    * 每个节点最多被访问两次：一次是在 `getKth` 函数中检查是否有 `k` 个节点，一次是在反转过程中
    * 对每个节点的操作都是常数时间的

* **空间复杂度**: $O(1)$
    * 只使用了几个指针变量，不随输入规模增长
    * 不使用额外的数据结构
    * 满足题目进阶要求的 $O(1)$ 额外内存空间

### 完成「力扣」第 143 题：[重排链表](https://leetcode.cn/problems/reorder-list)

[../src/linked/ReorderList.java](../src/linked/ReorderList.java)

```java
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 使用快慢指针找到链表的中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转链表的后半部分
        ListNode secondHalf = slow.next;
        slow.next = null;
        secondHalf = reverseList(secondHalf);

        // 合并两个链表
        mergeLists(head, secondHalf);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private void mergeLists(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
    }
}
```

#### 算法思路

我们可以将这个问题分解为三个步骤：

1. **找到链表的中点**：使用快慢指针法
2. **反转后半部分链表**：从中点之后的节点开始反转
3. **合并两个链表**：将前半部分与反转后的后半部分交替合并

#### 复杂度分析

* **时间复杂度**： $O(n)$
    * 查找中点： $O(n)$
    * 反转链表： $O(n/2)$ ≈ $O(n)$
    * 合并链表： $O(n/2)$ ≈ $O(n)$
    * 总体： $O(n)$
* **空间复杂度**： $O(1)$
    * 只使用了常数个额外指针变量
    * 没有使用额外的数据结构存储节点

### 完成「力扣」第 328 题：[奇偶链表](https://leetcode.cn/problems/odd-even-linked-list/)

[../src/linked/OddEvenLinkedList.java](../src/linked/OddEvenLinkedList.java)

```java
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 初始化奇数节点指针和偶数节点指针
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // 遍历链表，将奇数节点和偶数节点分别连接起来
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
```

#### 算法思路

1. **分离奇偶节点**：使用两个指针 `odd` 和 `even` 分别指向奇数位置和偶数位置的节点。
2. **连接奇偶链表**：遍历链表，将奇数节点和偶数节点分别连接起来。
3. **合并链表**：最后将奇数链表的末尾连接到偶数链表的头部。

#### 复杂度剖析

* **时间复杂度**： $O(n)$ ，我们只遍历了一次链表。
* **空间复杂度**： $O(1)$ ，只使用了常数级别的额外空间。

### 完成「力扣」第 61 题：[旋转链表](https://leetcode.cn/problems/rotate-list)

```java
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 计算链表长度
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // 计算实际旋转次数
        k %= n;
        if (k == 0) return head;

        // 找到新的头结点的前一个节点
        ListNode newTail = head;
        for (int i = 0; i < n - k - 1; i++) newTail = newTail.next;

        // 调整指针
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }
}
```

#### 算法思路

1. **计算链表长度**：首先遍历链表，计算其长度 `n`。
2. **处理 `k` 的有效性**：如果 `k ≥ n`，则实际旋转次数为 `k % n`（因为旋转 `n` 次后链表恢复原状）。
3. **找到新头节点**：旋转后的新头节点是原链表的第 `n - k` 个节点。
4. **调整指针**：
    * 将原链表的尾节点指向原头节点（形成环）。
    * 将新头节点的前一个节点的 `next` 置为 `null`（断开环）。

#### 复杂度剖析

* **时间复杂度**： $O(n)$ ，其中 `n` 是链表长度。需要遍历链表两次（计算长度和找到新头节点）。
* **空间复杂度**： $O(1)$ ，仅使用常数额外空间。

### 完成「力扣」第 234 题：[回文链表](https://leetcode.cn/problems/palindrome-linked-list)

[../src/linked/PalindromeLinkedList.java](../src/linked/PalindromeLinkedList.java)

```java
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 找到链表中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半部分链表
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;

        // 比较前后两部分
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
```

#### 算法思路

时间复杂度最优的解法是 $O(n)$ 时间复杂度和 $O(1)$ 空间复杂度的解法，步骤如下：

1. **找到链表的中点**：使用快慢指针法，快指针每次走两步，慢指针每次走一步，当快指针到达末尾时，慢指针正好在中点。
2. **反转后半部分链表**：从中点开始反转后半部分链表。
3. **比较前后两部分**：将前半部分和反转后的后半部分逐一比较节点值。
4. **恢复链表（可选）**：如果需要保持原链表结构，可以再次反转后半部分恢复原状。

#### 算法技巧

* **快慢指针法**：用于高效找到链表的中点
* **链表反转**：原地反转链表是链表操作的基本功
* **双指针比较**：前后指针同时遍历比较

#### 复杂度剖析

* **时间复杂度**： $O(n)$
    * 找中点： $O(n/2)$
    * 反转后半部分： $O(n/2)$
    * 比较前后部分： $O(n/2)$
* **空间复杂度**： $O(1)$ ，只使用了固定数量的指针变量。

### 完成「力扣」第 147 题：[对链表进行插入排序](https://leetcode.cn/problems/insertion-sort-list/)

```java
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode lastSorted = head; // 已排序部分的最后一个节点
        ListNode curr = head.next; // 当前待排序节点

        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                // 当前节点大于已排序部分最后一个节点，直接扩展
                lastSorted = lastSorted.next;
            } else {
                // 需要插入，从头开始寻找插入位置
                ListNode prev = dummy;
                while (prev.next.val <= curr.val) prev = prev.next;
                // 执行插入操作（此时prev.val <= curr.val但prev.next.val > curr.val）
                lastSorted.next = curr.next; // lastSorted去连接当前的下一个待排元素(临时将curr从链表中摘除)
                curr.next = prev.next; // curr被摘除，curr.next从原先的null变为大于curr的值也就是上面说的prev.next
                prev.next = curr; // prev.val <= curr.val的，所以最后重新连上即可
            }
            // 移动到下一个待排序节点
            curr = lastSorted.next;
        }

        return dummy.next;
    }
}
```

#### 算法思路

该算法实现了链表的插入排序，通过维护已排序部分的尾指针`lastSorted`来优化性能。核心思想是将链表分为已排序和未排序两部分，
逐步将未排序部分的节点插入到已排序部分的正确位置。

#### 知识点

1. **哑节点(dummy node)应用**：
    * 统一处理在头部插入的特殊情况
    * 代码示例：`ListNode dummy = new ListNode(0, head)`
2. **双指针协同**：
    * `lastSorted`跟踪已排序部分的边界
    * `prev`在需要插入时用于查找位置
3. **链表操作四步法**：
   ```
   lastSorted.next = curr.next; // 1.摘除当前节点
   curr.next = prev.next;       // 2.连接后续节点
   prev.next = curr;            // 3.插入到正确位置
   ```

#### 复杂度分析

##### 时间复杂度

* **最佳情况**（已排序链表）： $O(n)$
    * 每次比较都满足`lastSorted.val <= curr.val`
    * 只需一次遍历，无需内部循环
* **最坏情况**（完全逆序）： $O(n^2)$
    * 每次都需要遍历整个已排序部分
    * 比较次数为 $1 + 2 + ... + (n-1) = n(n-1)/2$
* **平均情况**： $O(n^2)$

##### 空间复杂度

* $O(1)$
    * 只使用了固定数量的指针变量
    * 排序是原地进行的

## 虚拟头节点

> 在链表算法中，虚拟头节点（Dummy Node）是一种常用的编程技巧，主要用于简化边界条件的处理。

1. **基本概念**
    * **定义**：一个不存储实际数据的辅助节点，其`next`指针指向真正的链表头节点。
    * **数学表示**：若原链表为 $L = [a_1, a_2, ..., a_n]$ ，则带虚拟头节点的链表为
      $L' = [dummy \rightarrow a_1 \rightarrow a_2 \rightarrow ... \rightarrow a_n]$ 。
2. **核心作用**
    * **统一操作逻辑**：所有节点（包括原头节点）都变成"中间节点"，避免对头节点的特殊处理。
    * **典型应用场景**：
        * 链表插入/删除（尤其是头节点可能被修改时）
        * 链表反转
        * 合并两个有序链表

### 例题：「力扣」第 19 题：[删除链表的倒数第 N 个节点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/)

[../src/linked/RemoveNthNodeFromEndOfList.java](../src/linked/RemoveNthNodeFromEndOfList.java)

```java
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;

        // 快指针先走n+1步（此时与慢指针的间隔就是n+1，因为要删除的目标在倒数第 n+1 个节点）
        for (int i = 0; i < n + 1; i++) fast = fast.next;

        // 同步前进
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除操作
        slow.next = slow.next.next;

        return dummy.next;
    }
}
```

#### 算法思路

使用**双指针技巧**中的快慢指针法：

1. **快指针**先走n步
2. **快慢指针**同时前进，直到快指针到达末尾
3. 此时慢指针指向的就是倒数第n个节点的前驱节点
4. 执行删除操作

#### 算法技巧

* **哑节点(dummy node)**：简化头节点删除的特殊处理
* **快慢指针**：高效定位倒数第n个节点
* **链表删除操作**：标准的前驱节点处理方式

#### 复杂度分析

* **时间复杂度**： $O(L)$ ，其中L是链表长度，只需一次遍历
* **空间复杂度**： $O(1)$ ，只使用了固定数量的指针变量

### 完成「力扣」第 2 题：[两数相加](https://leetcode.cn/problems/add-two-numbers/)

[../src/linked/AddTwoNumbers.java](../src/linked/AddTwoNumbers.java)

```java
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
```

#### 算法思路

我们可以模拟手工加法的过程：

1. 从两个链表的头部开始相加（即从数字的个位开始）
2. 维护一个进位值 `carry`
3. 每次计算当前位的和：`sum = l1.val + l2.val + carry`
4. 当前位的值为 `sum % 10`，新的进位为 `sum / 10`
5. 移动到下一个节点继续计算
6. 如果链表长度不等，较短的链表视为0
7. 最后如果还有进位，需要额外创建一个节点

#### 算法技巧

* **链表遍历**：同时遍历两个链表
* **虚拟头节点**：简化链表操作，避免处理头节点特殊情况
* **进位处理**：正确处理进位是本题关键

#### 复杂度分析

* **时间复杂度**： $O(\max(m, n))$ ，其中 $m$ 和 $n$ 分别是两个链表的长度。我们需要遍历两个链表的全部节点。
* **空间复杂度**： $O(\max(m, n))$ ，结果链表的长度最多为 $\max(m, n) + 1$（因为有进位）。

### 完成「力扣」第 445 题：[两数相加 II](https://leetcode.cn/problems/add-two-numbers-ii)

[../src/linked/AddTwoNumbersII.java](../src/linked/AddTwoNumbersII.java)

```java
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 反转两个链表
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        // 执行相加操作
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // 反转结果
        return reverseList(dummy.next);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
```

#### 算法思路

由于数字是正序存储的，我们可以采用以下方法：

1. **反转链表**：先将两个链表反转，变成逆序存储
2. **相加操作**：使用与前一题相同的方法进行相加
3. **再次反转**：将结果链表反转回来，恢复正序存储

#### 复杂度分析

* **时间复杂度**： $O(\max(m, n))$ ，其中 $m$ 和 $n$ 分别是两个链表的长度
* **空间复杂度**： $O(1)$（不考虑结果链表占用的空间）

### 完成「力扣」第 21 题：[合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/)

[../src/linked/MergeTwoSortedLists.java](../src/linked/MergeTwoSortedLists.java)

```java
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // 同时遍历两个链表
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 连接剩余的链表
        current.next = list1 != null ? list1 : list2;

        return dummy.next;
    }
}
```

#### 算法思路

我们可以使用**迭代法**来合并两个有序链表：

1. 创建一个虚拟头节点(dummy)作为新链表的起点
2. 使用一个指针(current)来跟踪新链表的当前位置
3. 比较两个链表当前节点的值，将较小的节点连接到新链表
4. 移动被选中链表的指针到下一个节点
5. 重复上述过程直到其中一个链表遍历完毕
6. 将剩余的非空链表直接连接到新链表的末尾

#### 复杂度分析

* **时间复杂度**： $O(n + m)$ ，其中 $n$ 和 $m$ 分别是两个链表的长度。我们需要遍历两个链表的所有节点。
* **空间复杂度**： $O(1)$ ，我们只需要常数空间存储几个指针，没有使用额外的数据结构。

### 完成「力扣」第 23 题：[合并 K 个排序链表](https://leetcode.cn/problems/merge-k-sorted-lists)

[../src/linked/MergeKSortedLists.java](../src/linked/MergeKSortedLists.java)

```java
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeLists(lists, 0, lists.length - 1);
    }

    // 分治合并
    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        // 只有一个链表的情况
        if (left == right) return lists[left];

        // 将链表数组分成两部分
        int mid = left + (right - left) / 2;
        ListNode leftList = mergeLists(lists, left, mid);
        ListNode rightList = mergeLists(lists, mid + 1, right);

        // 合并两个有序链表
        return mergeTwoLists(leftList, rightList);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        current.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
```

#### 算法思路

采用分治法，将大问题分解为小问题，逐个击破：

1. **分解阶段**：将K个链表分成两部分，递归处理每一部分
2. **解决阶段**：当分解到只剩一个链表时直接返回（基准情况）
3. **合并阶段**：将两个已排序的链表合并为一个有序链表

#### 复杂度分析

* **时间复杂度**： $O(N \log K)$
    * 分治树的高度为 $\log K$
    * 每层需要合并所有 $N$ 个节点
* **空间复杂度**： $O(\log K)$
    * 递归调用栈的深度
    * 比堆方法的 $O(K)$ 更优

### 完成「力扣」第 82 题：[删除排序链表中的重复元素 II](https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii)

[../src/linked/RemoveDuplicatesFromSortedListII.java](../src/linked/RemoveDuplicatesFromSortedListII.java)

```java
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            // 跳过所有重复节点
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            // 如果 pre.next == cur，说明 cur 没有重复 (即没有执行上面的循环)
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                // 删除所有重复节点
                pre.next = cur.next;
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}
```

#### 算法思路

1. **虚拟头节点**：创建一个虚拟头节点(dummy)简化边界条件处理
2. **前驱指针(pre)**：指向当前确定不重复的最后一个节点
3. **当前指针(cur)**：用于遍历链表
4. **重复检测**：当发现重复节点时，跳过所有重复节点

#### 复杂度分析

* **时间复杂度**： $O(n)$ ，只需遍历链表一次
* **空间复杂度**： $O(1)$ ，只使用了常数个额外指针

### 完成「力扣」第 83 题：[删除排序链表中的重复元素](https://leetcode.cn/problems/remove-duplicates-from-sorted-list/)

[../src/linked/RemoveDuplicatesFromSortedList.java](../src/linked/RemoveDuplicatesFromSortedList.java)

```java
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        
        return head;
    }
}
```

#### 算法思路

可以使用**单指针**方法高效解决这个问题：

1. **当前指针(cur)**：用于遍历链表
2. **重复检测**：比较当前节点与下一个节点的值
3. **删除操作**：当发现重复时，跳过重复节点

#### 复杂度分析

* **时间复杂度**： $O(n)$ ，只需遍历链表一次
* **空间复杂度**： $O(1)$ ，只使用了常数个额外指针

### 完成「力扣」第 86 题：[分隔链表](https://leetcode.cn/problems/partition-list/)

[../src/linked/PartitionList.java](../src/linked/PartitionList.java)

```java
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // 创建两个虚拟头节点
        ListNode smallerDummy = new ListNode(0);
        ListNode largerDummy = new ListNode(0);

        // 两个链表的当前节点指针
        ListNode smaller = smallerDummy;
        ListNode larger = largerDummy;

        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                larger.next = head;
                larger = larger.next;
            }
            head = head.next;
        }

        // 连接两个链表
        larger.next = null;
        smaller.next = largerDummy.next;
        
        return smallerDummy.next;
    }
}
```

#### 算法思路

使用**双链表**方法可以高效解决这个问题：

1. 创建两个虚拟头节点：一个用于存储小于 `x` 的节点（小链表），一个用于存储大于等于 `x` 的节点（大链表）
2. 遍历原始链表，将每个节点分配到对应的链表中
3. 最后将小链表的尾部连接到大链表的头部

#### 复杂度分析

* **时间复杂度**： $O(n)$ ，只需遍历链表一次
* **空间复杂度**： $O(1)$ ，只使用了常数个额外指针

## 快慢指针

> 链表的“快慢指针”是一种经典且非常实用的链表遍历技巧，常用于解决如链表中环检测、寻找中间节点等问题。

### 基本思想

* 设置两个指针：
    * **慢指针**（slow）：每次移动一步
    * **快指针**（fast）：每次移动两步
* 两指针同时从头结点出发，通过不同的速度遍历链表。

### 主要应用

#### 1. 检测链表中是否有环

* 快指针和慢指针一起遍历链表：
    * 如果链表没有环，快指针会最先到达末尾（null）；
    * 如果链表有环，快慢指针最终会在链表某个节点相遇（相等）。

#### 2. 查找链表的中间节点

* 快指针每次走两步，慢指针每次走一步。
* 当快指针到达末尾时，慢指针正好在中间节点的位置。

### 伪代码示例

#### 检测环

```
slow = head
fast = head
while fast 和 fast.next 非空:
    slow = slow.next
    fast = fast.next.next
    如果 slow == fast:
        有环
```

#### 找中点

```
slow = head
fast = head
while fast 和 fast.next 非空:
    slow = slow.next
    fast = fast.next.next
# slow 停下时就是中点
```

### 完成「力扣」第 876 题：[链表的中间结点](https://leetcode.cn/problems/middle-of-the-linked-list)

[../src/linked/MiddleOfTheLinkedList.java](../src/linked/MiddleOfTheLinkedList.java)

```java
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```

#### 算法思路

**快慢指针法（双指针）**

* 用两个指针`slow`和`fast`，都从`head`出发。
* `slow`每次移动1步，`fast`每次移动2步。
* 当`fast`到达尾部（`fast==null`或`fast.next==null`），`slow`必定停在链表中点（若为偶数个结点则停在第二个中点）。
* 为什么？每轮`fast`比`slow`多走一步，遍历结束`slow`刚好到1/2或1/2后一位（即第二个中点）。

#### 复杂度分析

* **时间复杂度**： $O(n)$ ，n为链表节点数。只遍历一次。
* **空间复杂度**： $O(1)$ 只用了两个额外指针。

## 典型问题： 环形链表

> 环形链表（有环链表）是链表中的一种特殊情况。所谓“环形”，就是链表中某个结点的next指针指向了它前面的某个结点（也可能指向自己），这样链表就形成了一个闭环。

### 1. 如何判断链表是否有环？

这里最经典的就是使用**快慢指针法**：

* 设置两个指针，slow每次走1步，fast每次走2步。
* 如果链表无环，fast会最先走到null，循环退出。
* 如果有环，fast一定会追上slow（相遇），类似“追逐游戏”。

#### 伪代码

```
slow = head
fast = head
while fast != null and fast.next != null:
    slow = slow.next
    fast = fast.next.next
    if slow == fast:
        return true
return false
```

复杂度都是

* 时间： $O(n)$
* 空间： $O(1)$

### 2. 如何找到环的入口（起始点）？

* 先用上面的方法让两指针相遇。
* 相遇后，让其中一个指针回到头，另一个留在原地。
* 两指针每次都走1步，两者在下次相遇处就是**环的入口**。

#### 关键原理

##### 1. 变量设定

假设：

* 链表起点到环入口的长度为 $a$ ，
* 环入口到相遇点的长度为 $b$ ，
* 环的长度为 $r$ 。

慢指针走的总步数： $s_{slow} = a + b$ 快指针走的总步数： $s_{fast} = a + b + n \times r \quad (n \geq 1)$\
且 $s_{fast} = 2 \times s_{slow}$

##### 2. 推理（关键公式）

$$\begin{aligned} s\_{fast} &= 2 \times s\_{slow} \\\ a + b + n \times r &= 2 (a + b) \\\ a + b + n \times r &= 2a + 2b \\\ n \times r &= a + b \\\ a &= n \times r - b \end{aligned}$$

**这意味着：**\
从链表头节点到环入口距离 $a$，等于“相遇点往后走 $n$ 圈减去 $b$”的长度，即从相遇点出发经过 $b$ 到入口多走了 $n-1$ 圈。

**形象理解：**\
当一个指针从头走，另一个从相遇点走，他们速度相等（都走一步），那么两者必然在入口相遇！

### 例 1：「力扣」第 142 题：[环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii)

[../src/linked/LinkedListCycleII.java](../src/linked/LinkedListCycleII.java)

```java
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 说明有环
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                // 找到环入口
                return slow;
            }
        }

        return null;
    }
}
```

#### 算法思路

采用**快慢指针法（Floyd 判圈算法）**：

1. **判环阶段：**
    * 用两个指针，`fast` 每次走两步，`slow` 每次走一步，如果这两个指针能相遇，则链表有环，否则无环。
2. **确定环入口：**
    * 首先，让 `slow`、`fast` 在环中第一次相遇。
    * 然后，将 `slow` 指回头结点，`fast` 保持在相遇点，二者都每次走一步。
    * 它们第二次相遇的节点，就是环的入口节点。

#### 复杂度分析

* **时间复杂度：** $O(n)$ 遍历两遍；
* **空间复杂度：** $O(1)$ ，未用任何辅助空间。

### 例 2：「力扣」第 141 题：[环形链表 II](https://leetcode.cn/problems/linked-list-cycle)

[../src/linked/LinkedListCycle.java](../src/linked/LinkedListCycle.java)

```java
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
```

#### 算法思路

本题最好、最快的算法为“双指针法”——分别用快、慢两个指针遍历链表：

1. **指针初始化**：都指向头节点；
2. 快指针每次前进两步 `fast = fast.next.next`，慢指针每次前进一步 `slow = slow.next`；
3. 如果存在环，两者最终一定会在环中相遇（进入环后，快指针总体“套圈追上”慢指针）；
4. 如果不存在环，快指针会先到达链表末尾，即出现 `fast == null || fast.next == null`。

#### 复杂度分析

* **时间复杂度**：$O(n)$
    * 每个节点最多被快、慢指针遍历一次，所以线性复杂度；
* **空间复杂度**：$O(1)$
    * 没有用额外的数据结构（哈希表等）。

## 典型问题：相交链表

> 给定两条单链表，判断它们是否在某个节点处相交。如果相交，找出第一个相交节点。

### 问题定义与性质

* **什么叫“相交”**：\
  两个链表在某一个节点 $c$ 处开始，之后的所有节点都完全重合（即是同一个地址对象），而不是值相等。
* **链表可能有不同长度**。前半段独立，后半段重叠。
* **相交节点唯一**。不可能有“分叉再合并”；即相交后无法再分开。

### 常见考法

* **判断是否相交**：返回 Boolean。
* **返回第一个相交节点**：即第一个公共节点的地址。

### 典型解法及技巧

#### 解法一：哈希表法（适用于所有链表问题）

* 用哈希表存第一条链表的所有节点；
* 遍历第二条链表，看是否出现重复节点。
* **时间复杂度**： $O(m+n)$
* **空间复杂度**： $O(m)$

#### 解法二：双指针法（最优解，推荐）

**思路**：

* 让两个指针分别从两链表的头部出发；
* 走到尽头后切换到另一条链表继续走；
* 最终相遇于第一个相交节点（或同时为 null）。

**关键原理**：保证两个指针走过的路径长度都为 $m+n$ ，避免了长短问题。

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode pA = headA, pB = headB;
    while (pA != pB) {
        pA = (pA != null) ? pA.next : headB;
        pB = (pB != null) ? pB.next : headA;
    }
    return pA;   // 若无交点，最终为null，有交点为第一个公共节点
}
```

* **时间复杂度**： $O(m+n)$
* **空间复杂度**： $O(1)$

---

[返回](../README.md)