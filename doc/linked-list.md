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

* 访问元素：$O(n)$
* 在头部插入/删除：$O(1)$
* 在中间/尾部插入/删除：$O(n)$（需要先找到位置）
* 查找元素：$O(n)$

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

---

[返回](../README.md)