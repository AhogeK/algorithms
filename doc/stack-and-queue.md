<!-- TOC -->
* [栈与队列](#栈与队列)
  * [动态数组](#动态数组)
    * [均摊复杂度分析](#均摊复杂度分析)
    * [避免复杂度震荡](#避免复杂度震荡)
    * [380. O(1) 时间插入、删除和获取随机元素](#380-o--1--时间插入删除和获取随机元素)
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