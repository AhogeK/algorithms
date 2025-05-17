<!-- TOC -->
* [栈与队列](#栈与队列)
  * [动态数组](#动态数组)
    * [均摊复杂度分析](#均摊复杂度分析)
    * [避免复杂度震荡](#避免复杂度震荡)
    * [380. O(1) 时间插入、删除和获取随机元素](#380-o--1--时间插入删除和获取随机元素)
  * [栈：后进先出的数据结构](#栈后进先出的数据结构)
    * [基本操作](#基本操作)
    * [常见的实现方式](#常见的实现方式)
    * [应用场景举例](#应用场景举例)
    * [典型复杂度](#典型复杂度)
    * [为什么限制了『后进先出』？](#为什么限制了后进先出)
    * [抽象数据类型](#抽象数据类型)
      * [主要特点](#主要特点)
      * [常见举例](#常见举例)
    * [栈的抽象数据类型](#栈的抽象数据类型)
    * [关于Java栈推荐用`ArrayDeque`实现栈，而不用`Stack`](#关于java栈推荐用arraydeque实现栈而不用stack)
      * [历史上的 `Stack` 类设计问题](#历史上的-stack-类设计问题)
      * [优选 `ArrayDeque` 的理由](#优选-arraydeque-的理由)
  * [典型问题 1: 简化路径](#典型问题-1-简化路径)
    * [例：「力扣」 第 71 题： 简化路径](#例力扣-第-71-题-简化路径)
      * [算法思路](#算法思路)
      * [算法知识点与技巧](#算法知识点与技巧)
      * [代码实现](#代码实现)
      * [复杂度分析](#复杂度分析)
    * [完成「力扣」第 20 题：有效的括号](#完成力扣第-20-题有效的括号)
      * [算法思路](#算法思路-1)
      * [代码实现](#代码实现-1)
      * [复杂度分析](#复杂度分析-1)
    * [完成「力扣」第 150 题：逆波兰表达式求值](#完成力扣第-150-题逆波兰表达式求值)
      * [算法思路](#算法思路-2)
      * [算法技巧知识点](#算法技巧知识点)
      * [复杂度分析](#复杂度分析-2)
<!-- TOC -->

# 栈与队列

> 『栈』与『队列』是最常见的两个数据结构，他们在基础算法领域里发挥着举足轻重的作用，应用十分广泛。

## 动态数组

动态数组是一种能够根据需要动态调整容量的数据结构，常见于编程语言标准库
(如 C++ 的 `std::vector`、Java 的 `ArrayList`、Python 的 `list` 等）中。
它解决了静态数组（长度固定，无法变更）在是集应用中灵活性不足问题。

动态数组核心特点包括：

1. **自动扩容**\
   当元素数量达到当前容量上限时，动态数组会自动分配更大的存储空间（通常新容量为原来的 $\alpha$ 倍， $\alpha$ 常为 $2$
   ），并将已有元素复制到新空间中。

2. **下标访问**\
   与普通数组一样，动态数组通过下标可以在 $\mathcal{O}(1)$ 时间内随机访问任意元素。

3. **插入与删除**

    * 末尾插入新元素的摊还时间复杂度为 $\mathcal{O}(1)$（由于偶尔会有扩容导致 $\mathcal{O}(n)$，
      但全部操作平均下来是常数级别）。
    * 中间插入或删除元素的时间复杂度为 $\mathcal{O}(n)$，因为需要移动元素。

4. **空间利用**\
   动态数组在删除元素到达某一阈值时也可能自动收缩，以降低空间浪费。

5. **实现原理**\
   动态数组通常利用普通数组实现，并维护当前元素数与容量两个变量，涉及“扩容”、“拷贝”、“缩容”等操作。

常见操作时间复杂度表：

| 操作      | 时间复杂度               |
|---------|---------------------|
| 末尾添加    | 摊还 $\mathcal{O}(1)$ |
| 下标访问    | $\mathcal{O}(1)$    |
| 中间插入/删除 | $\mathcal{O}(n)$    |
| 查找元素    | $\mathcal{O}(n)$    |

### 均摊复杂度分析

**动态数组**，插入新元素大部分时间都很快（ $\mathcal{O}(1)$ ），但当数组满了需要扩容时，
会出现单次 $\mathcal{O}(N)$ 的拷贝。这个最坏复杂度让单次操作看起来很昂贵，实际却不是每次都发生。

均摊分析，就是把这种高代价操作，“均摊”到之后的每一个元素插入上，得出一个更合理的“每次平均成本”。

* **均摊复杂度分析**，本质上考察的是**一批操作的平均耗时**；
* 拓宽了对于高峰开销操作的理解，更贴近实际应用感受；
* 很多现代数据结构（如动态数组、哈希表、并查集等）背后的性能亮点，都离不开均摊复杂度的思想。

*注：更多细节可查阅《算法导论》第 17 章 『摊还分析』*

### 避免复杂度震荡

所谓“避免复杂度震荡”，是指在动态数组这类数据结构中，通过合理设置扩容和缩容的阈值，防止数组容量频繁增减、
造成连续多次高代价操作，从而导致大量操作的总复杂度升高。

**复杂度震荡**，又叫“复杂度抖动”，通常出现在这样一种极端场景：

* 比如数组刚满时就扩容，插一个扩一次，删一个就缩一次；
* 如果插入与删除操作频繁交替、每次操作都导致扩容或缩容，
  就会出现连续 $\mathcal{O}(n)$ 级别拷贝，**整体复杂度便会大幅度上升**。

解决的**核心思想**就是避免扩容条件和缩容条件完全重合，加设“缓冲区”。

具体做法如下：

* **扩容**：只有数组满时，才把容量扩大到原来的 $2$ 倍；
* **缩容**：仅当实际元素个数 $\leq$ 当前容量的 $\frac{1}{4}$ 时，才把容量缩小到原来的一半。

如下表：

| 触发条件                                | 动作              |
|-------------------------------------|-----------------|
| 元素个数 $=$ 容量                         | 容量 $\times$ $2$ |
| 元素个数 $\leq$ 容量 $\times \frac{1}{4}$ | 容量 $\div$ $2$   |

* 这样做的优点：
    1. 插入、删除在容量边界附近来回波动时，只有跨越 $\frac{1}{4}$ 和 $\frac{1}{2}$
       这两个阈值才发生收缩和扩充，大多数情况都不会触发高代价的搬运；
    2. 有效防止了最坏情况下频繁的整体拷贝。

### [380. O(1) 时间插入、删除和获取随机元素](https://leetcode.cn/problems/insert-delete-getrandom-o1)

* *[../src/stackqueue/RandomizedSet.java](../src/stackqueue/RandomizedSet.java)*

```java
/**
 * 380. O(1) 时间插入、删除和获取随机元素
 *
 * @author AhogeK
 * @since 2025-05-15 10:37:08
 */
class RandomizedSet {
    private final List<Integer> nums;
    private final Map<Integer, Integer> valToIdx;
    private final Random rand;

    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIdx = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valToIdx.containsKey(val)) return false;
        valToIdx.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIdx.containsKey(val)) return false;
        int idx = valToIdx.get(val);
        int lastVal = nums.getLast();
        if (idx != nums.size() - 1) {
            nums.set(idx, lastVal);
            valToIdx.put(lastVal, idx);
        }
        nums.removeLast();
        valToIdx.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIdx = rand.nextInt(nums.size());
        return nums.get(randomIdx);
    }
}
```

*最后，可以阅读下`java.util.ArrayList`的源代码*

## 栈：后进先出的数据结构

> **栈（Stack）** 是一种**线性表**，但只能在一端进行插入和删除操作。遵循 **后进先出（LIFO，Last In First Out）**
> 原则：最后压入栈的数据最先被弹出。

### 基本操作

主要有两个核心操作：

* **入栈（Push）**：将元素加入栈顶
* **出栈（Pop）**：将栈顶元素移除，并返回该元素

此外还常见如下辅助操作：

* **获取栈顶元素（Top/Peek）**：只读取，不删除
* **判空（IsEmpty）**
* **获取栈的大小（Size/Length）**

### 常见的实现方式

* **顺序栈**：用数组实现，操作高效（如 C/C++/Java 的数组实现）。
* **链式栈**：用链表实现，动态扩展，不浪费空间。

### 应用场景举例

* **表达式求值与括号匹配**
* **函数递归调用实现（程序调用栈）**
* **浏览器前进后退、撤销功能**
* **深度优先遍历（DFS）等算法**
* **进制的转换**

### 典型复杂度

$$\begin{aligned} &\text{入栈：} O(1) \\\ &\text{出栈：} O(1) \\\ &\text{读取栈顶：} O(1)
\\\ \end{aligned}$$

### 为什么限制了『后进先出』？

* 这种约束**简化了数据管理和实现**，使栈能够高效地在 $\mathcal{O}(1) $时间复杂度下完成元素的插入与删除（都只操作栈顶）。
* 对于许多应用场景（如函数调用、递归处理、括号配对等），需要严格按照后进先出的顺序还原、撤销或回溯，**LIFO**才能正确保证逻辑一致性和安全性。
* 只有后进先出，才能在“存取顺序不可随意指定”的情形下提供**最简单、最直接的状态还原能力**。

### 抽象数据类型

> **抽象数据类型（ADT）** 指的是对一类数据及其操作行为的一种逻辑描述和抽象封装。它**只关心“做什么”，不关心“怎么做”**，
> 也就是关注“接口而非实现”。

#### 主要特点

* **操作定义清晰**：只定义能对数据进行哪些操作（如插入、删除、查找等），不给出具体实现代码。
* **实现可变**：同一个ADT可以用不同的数据结构具体实现（比如队列可以用数组或链表实现）。
* **屏蔽细节**：使用者不需要知道底层实现，只需通过定义好的操作来使用数据对象。

#### 常见举例

* **栈（Stack）ADT**：只规定有“入栈”、“出栈”、“取栈顶”等操作，但不限实现方式。
* **队列（Queue）ADT**
* **集合（Set）ADT**
* **字典（Map/Dictionary）ADT**

*抽象数据类型便于设计和维护大型系统，**提供模块化、可替换、可扩展的数据结构接口**。
增强了 **数据结构与算法的通用性和可复用性**。*

### 栈的抽象数据类型

| 返回值       | 方法名                | 方法描述                             |
|-----------|--------------------|----------------------------------|
| 构造函数无返回值  | `Stack<Integer>()` | 创建栈，栈内元素为空                       |
| `boolean` | `isEmpty()`        | 返回栈是否为空                          |
| `Integer` | `size()`           | 返回栈中元素的数量                        |
| `void`    | `push(int x)`      | 添加元素 `x`                         |
| `Integer` | `pop()`            | 删除栈顶元素（前提：栈非空）                   |
| `Integer` | `peek()`           | 查看栈顶元素而不取出（前提：栈非空） peek 有「偷瞄」的意思 |

### 关于Java栈推荐用`ArrayDeque`实现栈，而不用`Stack`

#### 历史上的 `Stack` 类设计问题

* $\texttt{Stack}$ 继承自 $\texttt{Vector}$，本身是**同步的（线程安全）**，
  但由于继承而不是组合，暴露了许多并非栈本应具备的方法（如
  $\texttt{insertElementAt}$、 $\texttt{removeElementAt}$ 等），**破坏了“仅允许栈顶插删”的封装性**。
* 设计得不够精简，造成了**接口污染**，违背了栈的抽象数据类型原则。

#### 优选 `ArrayDeque` 的理由

* $\texttt{ArrayDeque}$ 实现了 $\texttt{Deque}$ 接口，**可以高效地作为栈（或队列）使用**。
* 支持 $O(1)$ 复杂度的 $\texttt{push}$、 $\texttt{pop}$、 $\texttt{peek}$ 操作，
  且**性能比 `Stack` 更好、不带额外同步开销**。
* 不暴露非栈操作，更符合“后进先出（LIFO）”的纯粹语义。
* 语法简洁、功能齐全，是现代 Java 算法和数据结构代码的推荐选择。

  示例用法：

  ```java
  Deque<Integer> stack = new ArrayDeque<>();
  stack.push(1);
  stack.push(2);
  int top = stack.pop(); // 弹出2
  ```

## 典型问题 1: 简化路径

### 例：「力扣」 第 71 题： [简化路径](https://leetcode.cn/problems/simplify-path)

#### 算法思路

**核心思路是用栈模拟路径的层级变化**：

1. 按 `/` 拆分路径每一部分（分段）。
2. 顺序遍历：
    * 忽略 `.`（表示本目录）。
    * 对于 `..`，如果栈不为空则弹出栈顶（回到上一级）。
    * 对于其他目录名（包括 `...`），推入栈。
3. 遍历结束，将栈内元素用 `/` 连接，保证以 `/` 开头，不以 `/` 结尾（除了根目录 `/`）。

#### 算法知识点与技巧

* **栈的应用**：栈后进先出适合处理“返回上一级”的场景。
* **边界与特殊符号处理**：本题需要细致判断 `"."`、`".."` 及普通目录名的区别，注意 `"..."` 之类不能混淆。
* **字符串遍历与切分**：本题高效做法不是直接 `split("/")`, 而是用双指针逐段分析（更省空间、处理细节更灵活）。
* **构造输出**：拼接标准路径时避免多余 `/` 和空路径。

#### 代码实现

* *[../src/stackqueue/SimplifyPath.java](../src/stackqueue/SimplifyPath.java)*

```java
public class SimplifyPath {

    public String simplifyPath(String path) {
        int len = path.length();
        Deque<String> stack = new ArrayDeque<>();
        int idx = 0;
        while (idx < len) {
            while (idx < len && path.charAt(idx) == '/')
                idx++;
            if (idx == len) break;
            int end = idx;
            while (end < len && path.charAt(end) != '/')
                end++;
            String segment = path.substring(idx, end);
            if (segment.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (!segment.equals(".")) {
                stack.offerLast(segment);
            }
            idx = end;
        }
        if (stack.isEmpty()) return "/";
        StringBuilder res = new StringBuilder();
        for (String dir : stack) {
            res.append("/").append(dir);
        }
        return res.toString();
    }
}
```

**代码关键点**:

* `Deque<String>` 实现栈，用于存放每一级目录。
* 双指针 `idx, end` 遍历路径字符串，避免直接 split 后的空字符串问题（更严谨且效率高）。
* `.equals("..")` 判断上一级，栈非空才弹出（已经是根目录就忽略）。
* 常规目录名用 `offerLast` 入栈，`"."` 和空字符串（多余斜杠产生的）被忽略。
* 构造输出时，`StringBuilder` 拼接，每级前加 `/`，避免多余 `/`。

#### 复杂度分析

* **时间复杂度**： $O(n)$， $n$ 为路径字符串长度，每个字符至多被访问两次（遍历和依次处理）。
* **空间复杂度**： $O(n)$，最坏情况下每一层路径都要入栈。

### 完成「力扣」第 20 题：[有效的括号](https://leetcode.cn/problems/valid-parentheses)

#### 算法思路

**核心思路：**\
**用栈存左括号，遇到右括号时判断栈顶是否与其配对，配对成功则出栈，否则无效**

#### 代码实现

* *[../src/stackqueue/ValidParentheses.java](../src/stackqueue/ValidParentheses.java)*

```java
public class SimplifyPath {
    public String simplifyPath(String path) {
        int len = path.length();
        Deque<String> stack = new ArrayDeque<>();
        int idx = 0;
        while (idx < len) {
            while (idx < len && path.charAt(idx) == '/')
                idx++;
            if (idx == len) break;
            int end = idx;
            while (end < len && path.charAt(end) != '/')
                end++;
            String segment = path.substring(idx, end);
            if (segment.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (!segment.equals(".")) {
                stack.offerLast(segment);
            }
            idx = end;
        }
        if (stack.isEmpty()) return "/";
        StringBuilder res = new StringBuilder();
        for (String dir : stack) {
            res.append("/").append(dir);
        }
        return res.toString();
    }
}
```

#### 复杂度分析

* **时间复杂度**： $O(n)$（每字符最多只进/出栈一次）
* **空间复杂度**： $O(n)$（全部为左括号时栈空间最大化）

### 完成「力扣」第 150 题：[逆波兰表达式求值](https://leetcode.cn/leetbook/read/learning-algorithms-with-leetcode)

#### 算法思路

**核心步骤：**
1. 遍历 `tokens`
    * 若遇到整数，入栈
    * 若遇到运算符，从栈弹出 **栈顶两个数**，按“左操作数 `op` 右操作数”顺序计算，结果压回栈顶
2. 遍历完成，栈顶即为最终答案
**注意顺序：**
* 一次运算时，先`pop`出来的是“右操作数”，第二次`pop`得到“左操作数”。

#### 算法技巧知识点

* 用`int`数组模拟栈，避免`Java`集合类带来函数开销，提高运行速度。
* 利用运算符字符串的等值判断（`equals()`），也可用`switch-case`替代链式判断，提升效率。
* 字符串转整数推荐 `Integer.parseInt`，对特殊用例直接转型。

```java
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1;
        for (String token : tokens) {
            char c = token.charAt(0);
            if (token.length() == 1 && (c == '+' || c == '-' || c == '*' || c == '/')) {
                int b = stack[top--];
                int a = stack[top--];
                int res = switch (c) {
                    case '+' -> a + b;
                    case '-' -> a - b;
                    case '*' -> a * b;
                    case '/' -> a / b;
                    default -> 0;
                };
                stack[++top] = res;
            } else {
                stack[++top] = Integer.parseInt(token);
            }
        }
        return stack[top];
    }
}
```

#### 复杂度分析

* **时间复杂度：** $O(n)$，每个 `token` 仅入栈/出栈/算一次。
* **空间复杂度：** $O(n)$，辅助栈空间。
