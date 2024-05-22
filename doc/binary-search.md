<!-- TOC -->
* [二分查找](#二分查找)
  * [二分查找基本思想：减而治之](#二分查找基本思想减而治之)
    * [二分查找应用范围](#二分查找应用范围)
  * [二分查找算法的两种思路](#二分查找算法的两种思路)
    * [关于二分查找取中间代码](#关于二分查找取中间代码)
  * [二分查找的基本问题](#二分查找的基本问题)
    * [应用「排除法」写对二分查找问题](#应用排除法写对二分查找问题)
      * [取中间数可能需要上取整的原因](#取中间数可能需要上取整的原因)
      * [思路2「在循环体中排除目标元素一定不存在的区间」要点](#思路2在循环体中排除目标元素一定不存在的区间要点)
    * [二分查找的典型问题（一）：二分下标](#二分查找的典型问题一二分下标)
    * [二分查找的典型问题（二）：二分答案](#二分查找的典型问题二二分答案)
    * [二分查找的典型问题（三）：判别条件复杂的二分查找](#二分查找的典型问题三判别条件复杂的二分查找)
<!-- TOC -->

# 二分查找

## 二分查找基本思想：减而治之

### 二分查找应用范围

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
  * [BinarySearch](src/binarysearch/BinarySearch.java)
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
  * 每一次再在区间里搜索目标元素，这个区间存在两个上下边界，每次取中间值判断是否是目标值，如果中间值小了，说明目标值在中间值的右边，
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

---

**使用主定理分析为什么是 $O(logn)$**

在主定理的应用中，我们首先要确定递归式。对于这个二分查找算法，递归式可以表示为：

$T(n) = T\left(\frac{n}{2}\right) + c$

这里 $T(n)$ 是解决大小为 $n$ 的问题所需的时间， $c$ 是一个常数，代表除了递归调用外的操作（比如计算中间点和比较操作）。

在这个递归式中， $a = 1$ ， $b = 2$ ，并且 $f(n) = c$ （一个常数）。根据主定理，我们需要比较 $f(n)$ 和 $n^{\log_b a}$ ：

* $a = 1$
* $b = 2$
* 因此， $\log_b a = \log_2 1 = 0$
* 所以， $n^{\log_b a} = n^0 = 1$

现在，我们比较 $f(n) = c$ 和 $n^{\log_b a} = 1$ 。在这种情况下， $f(n)$ 是一个常数，而 $n^{\log_b a}$ 也是一个常数。根据主定理的第二种情况：

* 如果 $f(n) = \Theta(n^{\log_b a})$ ，那么 $T(n) = \Theta(n^{\log_b a} \log n)$ 。

在我们的例子中， $f(n) = c = \Theta(1)$ ，且 $n^{\log_b a} = 1$ ，所以 $f(n) = \Theta(n^{\log_b a})$ 。因此，根据主定理的第二种情况：

$T(n) = \Theta(\log n)$

这是因为 $n^{\log_b a} = 1$ ，所以 $T(n) = \Theta(1 \cdot \log n) = \Theta(\log n)$ 。

---

「力扣」374. 猜数字大小

[GuessNumber](../src/binarysearch/GuessNumber.java)

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

### 应用「排除法」写对二分查找问题

> 思路2：在循环体中排除目标元素一定不存在的区间

* 理解根据分支逻辑调整取中间数
* 循环可以继续的条件是 `while(left < right)` 表示退出循环的时候`[left, right]`只有一个元素
* 结果后处理

```java
public class Solution {
    /**
     * 704 二分查找思路2
     *
     * @param nums   有序数组
     * @param target 目标值
     * @return 目标值在数组中的索引
     */
    public int search3(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == right && nums[left] == target ? left : -1;
    }
}
```

上述代码反向同理，当`nums[mid] > target`时，`right = mid - 1`。但需要注意，取中间值需要向上取整，
`int mid = left + (right - left + 1) / 2;`，否则会导致死循环。

#### 取中间数可能需要上取整的原因

因为当我使用 `nums[mid] > target` 条件时会需要使用到 `right = mid - 1` 的操作，而这样的操作当元素个数为偶数的时候，
如果直接取中间的位置（默认的向下取整），则可能导致查找区间无法被缩小，从而进入死循环。例如当 `left = 2` `right = 3`时，
直接取的话就是 `mid = (2 + 3) / 2 = 2`, 但是此时 `nums[mid] > target`，触发 `right = mid - 1 = 1`，
从而 `left = 2` `right = 1` 无法继续缩小区间

在思路2中的条件是 `while (left < right)`，因为我们不在循环体内判断是否找到了目标元素，因为当退出循环时，
`[left, right]`区间内一定只有一个元素，我们已经排除了所有错误的答案，当只有一个的时候那它只需跟结果比较是否是目标元素即可

#### 思路2「在循环体中排除目标元素一定不存在的区间」要点

* 循环条件 `while(left < right)`
* 循环体内不直接返回，而是缩小查找区间
* 根据中间的数上下取整方式决定缩小区间的逻辑「当看到条件体里出现 `left = mid` 的时候说明时向上取整」
* 退出循环后需要判断最后的元素是否是目标元素

### 二分查找的典型问题（一）：二分下标

* [力扣 35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/)

[SearchInsert](../src/binarysearch/SearchInsert.java)

```java
public class Solution {

    /**
     * 35 搜索插入位置
     *
     * @param nums   有序数组
     * @param target 目标值
     * @return 目标值在数组中的索引
     */
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == right && nums[left] == target ? left : left + 1;
    }
}
```

* [力扣 34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/)

[SearchRange](src/binarysearch/SearchRange.java)

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int leftIndex = binarySearch(nums, target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return result;
        }
        result[0] = leftIndex;
        result[1] = binarySearch(nums, target, false) - 1;
        return result;
    }

    /**
     * 二分查找
     *
     * @param nums   有序数组
     * @param target 目标值
     * @param isFirst 是否查找第一个位置
     * @return 目标值在数组中的索引
     */
    private int binarySearch(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target || (isFirst && nums[mid] == target)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
```

* [153. 寻找旋转排序数组中的最小值](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/)

[FindMin](src/binarysearch/FindMin.java)

```java
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
```

* [154. 寻找旋转排序数组中的最小值 II](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/description/)

[FindMinII](src/binarysearch/FindMinII.java)

```java
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 二分查找的终止条件是 left == right
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果中间值大于最右边的值，说明最小值在右边
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) { // 如果中间值小于最右边的值，说明最小值在左边
                right = mid;
            } else { // 如果中间值等于最右边的值，说明最小值在左边或者右边，此时无法确定，只能将右边界减一
                right--;
            }
        }
        return nums[left];
    }
}
```

* [33. 搜索旋转排序数组](https://leetcode.cn/problems/search-in-rotated-sorted-array/description/)

[SearchRotatedSortedArray](src/binarysearch/SearchRotatedSortedArray.java)

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 二分查找的终止条件是 left == right
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果中间值大于最右边的值，说明最小值在右边
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) { // 如果中间值小于最右边的值，说明最小值在左边
                right = mid;
            } else { // 如果中间值等于最右边的值，说明最小值在左边或者右边，此时无法确定，只能将右边界减一
                right--;
            }
        }
        // 此时 left == right，所以最小值为 nums[left] 或者 nums[right]
        int min = left;
        // 重置 left 和 right
        left = 0;
        right = nums.length - 1;
        // 判断 target 是在最小值的左边还是右边
        if (target >= nums[min] && target <= nums[right]) {
            left = min;
        } else {
            right = min;
        }
        // 标准的二分查找模板
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 如果中间值等于 target，直接返回
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) { // 如果中间值小于 target，说明 target 在右边
                left = mid + 1;
            } else { // 如果中间值大于 target，说明 target 在左边
                right = mid - 1;
            }
        }
        // 如果没有找到，返回 -1
        return -1;
    }
}
```

* [81. 搜索旋转排序数组 II](https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/description/)

[SearchRotatedSortedArrayII](src/binarysearch/SearchRotatedSortedArrayII.java)

```java
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) { // 检查是否找到 target
                return true;
            }

            if (nums[mid] > nums[right]) {
                if (target >= nums[left] && target < nums[mid]) { // 检查 target 是否在有序的左半部分
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) { // 检查 target 是否在有序的右半部分
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // 如果中间值等于最右边的值，无法确定最小值所在的位置，右边界减一
                if (nums[right] == target) { // 检查是否找到 target
                    return true;
                }
                right--;
            }
        }

        return nums[left] == target;
    }
}
```

* [278. 第一个错误的版本](https://leetcode.cn/problems/first-bad-version/description/)

[FirstBadVersion](src/binarysearch/FirstBadVersion.java)

```java
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        // 二分查找的终止条件是 left == right
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果中间值大于最右边的值，说明最小值在右边
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 此时 left == right，所以最小值为 nums[left] 或者 nums[right]
        return left;
    }
}
```

* [852. 山脉数组的峰顶索引](https://leetcode.cn/problems/peak-index-in-a-mountain-array/description/)

[PeakIndexInMountainArray](src/binarysearch/PeakIndexInMountainArray.java)

```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        // 因为题目保证了一定存在山峰，所以 right 可以取 arr.length - 2
        int right = arr.length - 2;
        // 二分查找的终止条件是 left == right
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果中间值大于中间值右边的值，说明山峰在左边
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 此时 left == right，所以最小值为 nums[left] 或者 nums[right]
        return left;
    }
}
```

* [1095. 山脉数组中查找目标值](https://leetcode.cn/problems/find-in-mountain-array/description/)

[FindInMountainArray](src/binarysearch/FindInMountainArray.java)

```java
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peakIndex = findPeakIndex(mountainArr, 0, n - 1);

        int index = binarySearch(mountainArr, 0, peakIndex, target);
        if (index != -1) {
            return index;
        }
        return reverseBinarySearch(mountainArr, peakIndex + 1, n - 1, target);
    }

    /**
     * 查找山峰索引
     *
     * @param mountainArr 山脉数组
     * @param left        左边界
     * @param right       右边界
     * @return 山峰索引
     */
    private int findPeakIndex(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 二分查找
     *
     * @param mountainArr 山脉数组
     * @param left        左边界
     * @param right       右边界
     * @param target      目标值
     * @return 目标值索引
     */
    private int binarySearch(MountainArray mountainArr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 反向二分查找
     *
     * @param mountainArr 山脉数组
     * @param left        左边界
     * @param right       右边界
     * @param target      目标值
     * @return 目标值索引
     */
    private int reverseBinarySearch(MountainArray mountainArr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
```

* [4. 寻找两个正序数组的中位数](https://leetcode.cn/problems/median-of-two-sorted-arrays/description/)

[FindMedianSortedArrays](src/binarysearch/FindMedianSortedArrays.java)

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
         * 保证 nums1 是较短的数组
         * 在较短的数组中进行二分查找，可以减少时间复杂度
         */
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int imin = 0;
        int imax = m;
        // halfLen 是两个数组合并后左半部分的长度 （向上取整）
        int halfLen = (m + n + 1) / 2;

        // 二分查找在 nums1 中的分割点
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;

            /*
             * 如果 nums1 的分割点 i 过小，则需要增大 i
             * i 需要在 nums1 的有效范围内
             * 当第二个数组的左半部分最大的值大于第一个数组的右半部分的最小值时，说明 i 作为分割点还能更大
             */
            if (i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            }
            /*
             * 判断分割点i是否过大，目的是为了左半部分所有元素都可以小于等于右半的所有元素
             * i > 0 是为了确保 i - 1 不会越界
             * 当第一个数组的左半部分最大的值大于第二个数组的右半部分的最小值时，说明 i 作为分割点还能更小
             */
            else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            }
            // 找到了正确的分割点
            else {
                int maxOfLeft;
                // 计算左半部分的最大值
                if (i == 0) {
                    maxOfLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i - 1];
                } else {
                    maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                // 如果两个数组的总长度是奇数，返回左半部分的最大值作为中位数
                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }

                int minOfRight;
                // 计算右半部分的最小值
                if (i == m) {
                    minOfRight = nums2[j];
                } else if (j == n) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }

                // 如果两个数组的总长度是偶数，返回左半部分的最大值和右半部分的最小值的平均值作为中位数
                return (maxOfLeft + minOfRight) / 2.0;
            }
        }

        return 0.0;
    }
}
```

### 二分查找的典型问题（二）：二分答案

> 二分答案的思路是：先确定答案的范围，然后在这个范围内进行二分查找，找到满足条件的答案。

* [「力扣」第 69 题：x的平方根](https://leetcode.cn/problems/sqrtx/)

[MySqrt](src/binarysearch/MySqrt.java)

```java
package binarysearch;

/**
 * 「力扣」第 69 题：x 的平方根
 * <a href="https://leetcode-cn.com/problems/sqrtx/">题目地址</a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-28 23:25:54
 */
public class MySqrt {

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 防止乘法溢出
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
```

* [「力扣」第 287 题：寻找重复数](https://leetcode-cn.com/problems/find-the-duplicate-number/)

[FindDuplicate](src/binarysearch/FindDuplicate.java)

```java
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
```

* [「力扣」第 1300 题：转变数组后最接近目标值的数组和](https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/)

[FindBestValue](src/binarysearch/FindBestValue.java)

```java
public class FindBestValue {

    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 0;
        // 取最大值作为右边界
        for (int num : arr) {
            right = Math.max(right, num);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = calculateSum(arr, mid);
            if (sum < target) {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间是 [left, mid]
                right = mid;
            }
        }
        int sum1 = calculateSum(arr, left - 1);
        int sum2 = calculateSum(arr, left);
        if (Math.abs(target - sum1) <= Math.abs(target - sum2)) {
            return left - 1;
        }
        return left;
    }

    public int calculateSum(int[] arr, int threshold) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, threshold);
        }
        return sum;
    }
}
```

### 二分查找的典型问题（三）：判别条件复杂的二分查找

> 当问题的判别条件相对复杂时，二分查找可以通过一些技巧进行调整和应用。
> 在解决这些问题时，关键是定义好二分查找的判别条件，以及在满足条件时如何缩小搜索范围。

* [「力扣」875. 爱吃香蕉的珂珂](https://leetcode.cn/problems/koko-eating-bananas/description/)

[KokoEatingBananas.java](src/binarysearch/KokoEatingBananas.java)

```java
/**
 * 875. 爱吃香蕉的珂珂
 * <a href="https://leetcode-cn.com/problems/koko-eating-bananas/">题目链接</a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-05-16 15:23:48
 */
public class KokoEatingBananas {

    /**
     * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
     * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉
     * 少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
     * 珂珂喜欢慢慢吃，但仍然希望在回家前吃掉所有的香蕉。
     * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
     *
     * @param piles 香蕉堆
     * @param h     可以吃掉所有香蕉的时间
     * @return 吃掉所有香蕉的最小速度
     */
    public int minEatingSpeed(int[] piles, int h) {
        // 确定范围的上界，即吃掉所有香蕉的最大速度
        int max = 1;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        // 二分查找来查找最小速度
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                // 下一轮搜索区间是 [left, mid]
                right = mid;
            } else {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 判断是否能在 h 小时内以 speed 的速度吃完香蕉
     *
     * @param piles 香蕉堆
     * @param h     可以吃掉所有香蕉的时间
     * @param speed 吃香蕉的速度
     * @return 是否能在 h 小时内以 speed 的速度吃完香蕉
     */
    private boolean canFinish(int[] piles, int h, int speed) {
        int time = 0;
        for (int pile : piles) {
            // 因为会有不是整除的情况，因此不使用 pile / speed 而是 (pile - 1) / speed + 1
            time += (pile - 1) / speed + 1;
        }
        return time <= h;
    }
}
```

* [「力扣」410. 分割数组的最大值](https://leetcode.cn/problems/split-array-largest-sum/)

[SplitArrayLargestSum.java](src/binarysearch/SplitArrayLargestSum.java)

```java
package binarysearch;

/**
 * <a href="https://leetcode.cn/problems/split-array-largest-sum">「力扣」410. 分割数组的最大值</a>
 * <p>
 * 题目描述：给定一个非负整数数组 nums 和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-18 20:47:04
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;

        // 遍历数组找一个最大值，和所有元素的和
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        // 数组中元素最大值作为左边界，因为会被切分，所有m个子数组各自的最大值最小为max
        int left = max;
        int right = sum;
        while (left < right) {
            // 二分查找找一个可能的合的最大值
            int mid = left + (right - left) / 2;
            // 将数组以这个mid为切割点来切割，切多了那就意味着mid小了
            int splits = split(nums, mid);
            if (splits > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int split(int[] nums, int maxIntervalSum) {
        int splits = 1;
        int curIntervalSum = 0;
        for (int num : nums) {
            // 区间大于了区间最大值，分割数+1
            if (curIntervalSum + num > maxIntervalSum) {
                curIntervalSum = 0;
                splits++;
            }
            curIntervalSum += num;
        }
        return splits;
    }
}
```

* [「力扣」 1011. 在 D 天内送达包裹的能力](https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/)

[CapacityToShipPackagesWithinDDays.java](src/binarysearch/CapacityToShipPackagesWithinDDays.java)

```java
package binarysearch;

/**
 * <a href="https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/">
 * 「力扣」1011. 在 D 天内送达包裹的能力
 * </a>
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我买都会按给出重量（weights）的顺序往传送带上装载包裹。
 * 我们装载的重量不会超过船的最大运载重量。返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-24 17:47:53
 */
public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        // 确定二分查找左右边界
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        // 二分查找
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }

            if (need <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
```

* [「力扣」1482. 制作 m 束花所需的最少天数](https://leetcode.cn/problems/minimum-number-of-days-to-make-m-bouquets/)

[MinimumNumberOfDaysToMakeMBouquets.java](src/binarysearch/MinimumNumberOfDaysToMakeMBouquets.java)

```java
package binarysearch;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-days-to-make-m-bouquets/">
 *     「力扣」1482. 制作 m 束花所需的最少天数
 * </a>
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * 现在你需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束花 中。
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-24 18:41:06
 */
public class MinimumNumberOfDaysToMakeMBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        int left = Integer.MAX_VALUE, right = 0;

        // 确定二分查找左右边界
        for (int bloom : bloomDay) {
            left = Math.min(left, bloom);
            right = Math.max(right, bloom);
        }

        while (left < right) {
            int mid = (left + right) / 2;

            // 确认当前天数下能否制作出 m 束花
            if (canMake(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return canMake(bloomDay, m, k, left) ? left : -1;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0;
        int flowers = 0;

        // 计算在 'days' 天内可以制作的花束数量
        for (int bloom : bloomDay) {
            if (bloom <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}
```

* [「力扣」LCP 12. 小张刷题计划](https://leetcode.cn/problems/xiao-zhang-shua-ti-ji-hua)

[XiaozhangCodingPracticePlan.java](src/binarysearch/XiaozhangCodingPracticePlan.java)

```java
package binarysearch;

/**
 * <a href="https://leetcode.cn/problems/xiao-zhang-shua-ti-ji-hua/">
 *     LCP 12. 小张刷题计划
 * </a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-24 19:11:54
 */
public class XiaozhangCodingPracticePlan {

    public int minTime(int[] time, int m) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 判断 mid 的每天耗时能否在 m 天完成所有的times列表道题
            if (check(time, m, mid)) {
                // 可以的话缩小mid的区间
                right = mid - 1;
            } else {
                // 反正扩大 mid 的每天耗时
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] time, int m, int mid) {
        int maxTime = 0;
        int total = 0;
        int days = 1;
        boolean helper = true;
        for (int i = 0; i < time.length; i++) {
            maxTime = Math.max(maxTime, time[i]);
            total += time[i];
            if (total > mid) {
                if (helper) {
                    total -= maxTime;
                    helper = false;
                } else {
                    days++;
                    helper = true;
                    maxTime = 0;
                    total = 0;
                    i--;
                }
            }
        }
        return m >= days;
    }
}
```

---

**相关阅读**

* [Binary search algorithm](https://en.wikipedia.org/wiki/Binary_search_algorithm)
* [Binary Search – Data Structure and Algorithm Tutorials](https://www.geeksforgeeks.org/binary-search/?ref=lbp)