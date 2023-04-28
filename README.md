# Algorithms

> 个人算法学习练习记录<br>
> [零起步学算法](https://leetcode.cn/leetbook/detail/learning-algorithms-with-leetcode/)

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

[GuessNumber](src/binarysearch/GuessNumber.java)

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
直接取的化就是 `mid = (2 + 3) / 2 = 2`, 但是此时 `nums[mid] > target`，触发 `right = mid - 1 = 1`，
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

[SearchInsert](src/binarysearch/SearchInsert.java)

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