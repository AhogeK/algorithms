# Algorithms

> 个人算法学习练习记录<br>
> [零起步学算法](https://leetcode.cn/leetbook/detail/learning-algorithms-with-leetcode/)

## 关于时间复杂度与空间复杂度

*评估算法性能的两个指标*

* 执行时间 ➡️ 时间复杂度
  * 算法执行所需要的时间与输入数据之间的关系。它不指算法具体执行的时间，因为这会受硬件环境、操作系统等多种因素的影响，而是指随着输入数据量的
    增加，算法执行时间的增长趋势。常见的时间复杂度有常数阶 `O(1)`、对数阶 `O(logn)`、线性阶 `O(n)`、线性对数阶 `O(nlogn)`、
    平方阶 `O(n^2)`、立方阶 `O(n^3)`等。
* 内存消耗 ➡️ 空间复杂度 
  * 算法执行过程所需要的存储空间与输入数据之间的关系。包括了算法在运行过程中临时占用的存储空间大小，这个指标帮助我们了解算法对内存的使用效率。
    常见的空间复杂度有常数阶 `O(1)`、线性阶 `O(n)`、平方阶 `O(n^2)`等。

**优化时间复杂度比优化空间复杂度重要得多**

*关于大O表示法（Big O notation）*

* [Big O notation](https://en.wikipedia.org/wiki/Big_O_notation)

*常见的时间复杂度计算规则*

* 加法系数看作0
* 只保留最高阶项, 且去掉系数
* 对数或含有对数乘法因子的项，对数底数都看作2

**绝大多数关注最坏情况**

「时间复杂度」数学定义 O(g(n)) = { f(n) | 存在正常数 c 和 n0，使得对于所有的 n >= n0，有 0 <= f(n) <= c * g(n) }

$$
\lim\limits_{{n \to \infty}} \frac{f(n)}{g(n)} <= C
$$

*[均摊复杂度分析（Amortized Analysis）](https://en.wikipedia.org/wiki/Amortized_analysis)*

是一种用来评估算法在一系列操作中平均每次操作的时间复杂度的方法。这种分析方法特别适用于那些单次操作最坏情况下非常耗时，
但在多次操作中平均表现较好的情况。

*主定理*

主定理（Master Theorem）是解决递归关系式的一种方法，特别是那些出现在分治算法分析中的递归式。它提供了一种快速找到递归算法时间复杂度的方式。

$$T(n) = aT\left(\frac{n}{b}\right) + f(n)$$

* ($a \geq 1$) 表示每次递归调用的子问题数。
* ($b > 1$) 表示输入规模缩小的比例。
* ( $f(n)$ ) 是每层递归中除了递归调用外的工作量。

主定理将 $f(n)$ 与 $n^{\log_b a}$ 的比较作为判断递归时间复杂度的依据，分为三种情况：

1. **情况一：** 如果 $f(n) = O(n^c)$ 其中 $c < \log_b a$，那么 $T(n) = \Theta(n^{\log_b a})$。这意味着递归工作的主要部分由底层递归调用决定。
2. **情况二：** 如果 $f(n) = \Theta(n^c \log^k n)$ 其中 $c = \log_b a$ 且 $k \geq 0$，那么 $T(n) = \Theta(n^c \log^{k+1}
   n)$。这种情况下，递归工作由所有层次上的工作共同决定，且每层的贡献相等。
3. **情况三：** 如果 $f(n) = \Omega(n^c)$ 其中 $c > \log_b a$，且对于某个常数 $\epsilon > 0$ 和足够大的 $n$，满足 $af(n/b)
   \leq (1-\epsilon)f(n)$，那么 $T(n) = \Theta(f(n))$。这表明递归工作的主要部分由非递归工作 $f(n)$ 决定。

*应用示例*

**归并排序：** 归并排序的递归式可以表示为: $T(n) = 2T\left(\frac{n}{2}\right) + n$ 这里， $a = 2$ ， $b = 2$ ， $f(n) =
n$ 。因此， $\log_b a = \log_2 2 = 1$ 。 由于 $f(n) = n = n^{\log_2 2}$ ，符合主定理的第二种情况（ $c = \log_b a$ 且 $k =
0$ ），所以： $T(n) = \Theta(n \log n)$

**二分查找:** 二分查找的递归式为： $T(n) = T\left(\frac{n}{2}\right) + 1$ 这里， $a = 1$ ， $b = 2$ ， $f(n) = 1$ 。因此，
$\log_b a =
\log_2 1 = 0$ 。 由于 $f(n) = 1 = n^0$ ，符合主定理的第一种情况（ $c < \log_b a$ ），所以： $T(n) = \Theta(\log n)$

主定理是分析分治算法中递归时间复杂度的强大工具，它简化了递归式的求解过程，使得算法设计者可以快速评估算法的效率。

#### 主定理（Master Theorem）

主定理为递推关系提供了一个解决方案

$$
T(n) = aT\left(\frac{n}{b}\right) + f(n)
$$

其中：
  * $n$ 是输入的大小
  * $a$ 是每次递归中生成的子问题数，且 $a \geq 1$
  * $b$ 是每次递归中子问题大小的缩减因子(每次递归调用时子问题规模缩小的比例)，且 $b > 1$
  * $f(n)$ 是除了递归调用外的其他工作的成本，包括分割问题和合并子问题的解的成本

𝑎代表每个节点的子节点数，而三个初始节点的运行时间是𝑇(𝑛/𝑏)的运行时间

这棵树的深度为 $\log_b n$，且深度 $i$ 包含 $a^i$ 个节点。因此，有 $a^{\log_b n} = n^{\log_b a}$ 个叶节点，因此运行时间是
$\Theta(n^{\log_b a})$。

![Master Theorem](https://ds055uzetaobb.cloudfront.net/brioche/uploads/it0XGmnWcb-mastertheorem.png?width=1200)

直观地说，主定理表明，如果在递归中加入一个渐近正函数 $f$，使得递归变为

$T(n) = aT\left(\frac{n}{b}\right) + f(n)$

则可以应用主定理来分析这种形式的递归关系。

可以通过比较 $f$ 和 $n^{\log_b a}$ 来确定 $T$ 的渐近形式。

主定理将递归关系分为三种情况：

1. **情况一：** 如果 $f(n) = O(n^{\log_b a - \epsilon})
   $（对于某个正数 $\epsilon$ ），这意味着分割和合并的工作相比于解决子问题的工作来说是渐进小的，那么 $T(n) = \Theta(
   n^{\log_b
   a})$ 。
2. **情况二：** 如果 $f(n) = \Theta(n^{\log_b a})$ ，这意味着分割和合并的工作与解决子问题的工作同样重要，那么 $T(n) =
   \Theta(
   n^{\log_b a} \log n)$ 。
3. **情况三：** 如果 $f(n) = \Omega(n^{\log_b a + \epsilon})$（对于某个正数 $\epsilon$），并且满足正则条件 $af\left(
   \frac{n}{b}\right) \leq kf(n)$ 对于某个常数 $k < 1$ 和所有足够大的 $n$ ，这意味着分割和合并的工作相比于解决子问题的工作来说是渐进大的，那么
   $T(n) = \Theta(f(n))$ 。

---

- [二分查找](doc/binary-search.md)
- [基础排序算法](doc/sort.md)