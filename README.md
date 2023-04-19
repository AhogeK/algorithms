# Algorithms

> 个人算法学习练习记录

## 二分查找

### 二分查找基本思想：减而治之

#### 二分查找应用范围

- 在有序数组中进行查找一个数（二分下标）
    - 【数组】【有序】是关键，数组具有随机访问，在内存中连续存放，可以通过数组的下标快速访问到这个元素。如果是链表则需要遍历，就不适用二分查找
- 在整数范围内查找一个整数（二分答案）
    - 当我要找一个整数且知道范围，就可以使用二分查找来缩小查找范围。其中可以发现，二分查找不一定要求目标元素所在区间有序数组，可以放宽这个
      “有序”的概念，例如旋转数组、山脉数组都可以归纳为二分中的“有序”数组

## 二分查找算法的两种思路

* 在循环中查找元素
* 在循环体中排除目标元素一定不存在的区间

### 关于二分查找取中间代码

取中间数的代码`int mid = (left + right) / 2`，严格意义上是有bug的，这是因为在left和right很大的时候，*left + right*有可能会溢出，
所以我们可以使用`int mid = left + (right - left) / 2`来代替

`/2` 写法表示向下取整。并不代表一定要拿左边的数，也可以拿右边的数,如下：

`int mid = left + (right - left + 1) / 2;`

平常二分查找的题解，还会看到 `int mid = (left + right) >> 1;` 这种写法，这是因为整数右移一位相当于除以2，目的是这样写会“快”一点。
但实际对于高级编程语言而言，这种写法并没有优化，因为编译器会自动优化这种写法，没必要特意这么写，而且位运算像C++还需要考虑优先级问题。

在 Java 和 JS 里还有一种写法

`int mid = (left + right) >>> 1;`

`>>>`表示无符号位移，可以在发生溢出时高位补0来保证正确的结果，Python在整型溢出时会自动转换为长整型等细枝末节的地方。但这不是学习算法
关注的重点。至少通过上面的写法知道自己关注到了会有整型溢出这样的问题存在即可。

## 二分查找的基本问题

[【力扣】704. 二分查找](https://leetcode.cn/problems/binary-search/)

* 思路1

    ```java
    public class BinarySearch {

        /**
         * 二分查找 思路1 循环中找到元素直接返回
         *
         * @param nums   有序数组
         * @param target 目标值
         * @return 目标值在数组中的索引
         */
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
    ```
    * 思路1在循环体中找到元素直接返回
    * 每一次再以恶区间里搜索目标元素，这个区间存在两个上下边界，每次取中间值判断是否是目标值，如果中间值小了，说明目标值在中间值的右边，
      如果中间值大了，说明目标值在中间值的左边，这样就可以缩小查找范围，直到找到目标值或者区间为空
    * 上面代码的循环判断使用了 `left <= right` 目的是为了循环中的每一次都去判断中间值是否为目标值
    * 如果退出循环就表明该数组中不包含目标元素，因此返回-1
    * 复杂度分析
        * 时间复杂度：O(logN)
            * [为什么说二分查找的时间复杂度是 O(logN)？](https://github.com/JasonGaoH/KnowledgeSummary/blob/master/Docs/Algorithm/%E4%B8%BA%E4%BB%80%E4%B9%88%E8%AF%B4%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE%E7%9A%84%E6%97%B6%E9%97%B4%E5%A4%8D%E6%9D%82%E5%BA%A6%E6%98%AFO(log%20n).md)
        * 空间复杂度：O(1)

使用「递归」完成二分查找

```java
public class BinarySearch {

    /**
     * 二分查找 递归
     *
     * @param nums 用于查找的有序数组
     * @param target 目标值
     * @param left 左下标
     * @param right 右下标
     * @return 目标值在数组中的索引
     */
    private int binarySearchRecursive(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearchRecursive(nums, target, mid + 1, right);
        } else {
            return binarySearchRecursive(nums, target, left, mid - 1);
        }
    }
}
```

「力扣」374. 猜数字大小

```java
/**
 * 力扣 374
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-19 12:34:17
 */
public class GuessNumber extends GuessGame {

    /**
     * 猜数字
     *
     * @param n 猜测的数字
     * @return 正确的数字
     */
    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
```