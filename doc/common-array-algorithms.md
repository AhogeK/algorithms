<!-- TOC -->
* [数组里常见的两类算法](#数组里常见的两类算法)
  * [滑动窗口简介](#滑动窗口简介)
    * [算法核心原理](#算法核心原理)
      * [1. 基本定义](#1-基本定义)
      * [2. 时间复杂度优化](#2-时间复杂度优化)
    * [例题：「力扣」第 3 题：无重复字符的最长子串](#例题力扣第-3-题无重复字符的最长子串)
      * [核心思路：滑动窗口 + 哈希表](#核心思路滑动窗口--哈希表)
      * [代码详解](#代码详解)
      * [复杂度分析](#复杂度分析)
<!-- TOC -->

# 数组里常见的两类算法

数组中常见的两类算法它们是「滑动窗口」和「双指针」。其中，「滑动窗口」也可以理解为一种特殊的「双指针」

* 核心思想对比

    | **维度**    | **滑动窗口 (Sliding Window)**                    | **双指针 (Two Pointers)**              |
    |-----------|----------------------------------------------|-------------------------------------|
    | **定义**    | 维护一个**连续区间**（窗口），通过移动左右边界动态调整窗口大小，寻找满足条件的子区间 | 使用两个指针协同遍历数据结构，通过特定移动规则解决对称、匹配或搜索问题 |
    | **关注点**   | 窗口内部的整体属性（如和、频率、唯一性）                         | 两个指针所指元素的**关系**（如相等、对称、和值）          |
    | **连续性要求** | 必须处理**连续子序列**                                | 可以处理非连续元素（如链表去重、有序数组两数之和）           |

* 选择策略
 
    | 判断条件             | 推荐算法    |
    |------------------|---------|
    | 需要处理连续区间（子串/子数组） | 滑动窗口    |
    | 涉及多个元素的关联计算      | 双指针     |
    | 数据已排序或有排序可能性     | 双指针     |
    | 需要同时考虑前后关系       | 双指针（反向） |

* 总结

    | 维度        | 滑动窗口      | 双指针       |
    |-----------|-----------|-----------|
    | **数据连续性** | 必须连续      | 可离散       |
    | **移动方向**  | 同向        | 同向/反向/交错  |
    | **核心操作**  | 窗口扩展与收缩   | 指针协同移动    |
    | **典型优化**  | 哈希表记录字符位置 | 利用有序性跳过重复 |

## 滑动窗口简介

### 算法核心原理

#### 1. 基本定义

* **窗口**：连续子序列的抽象表示

* **窗口边界**：用左右指针（ $left$ , $right$ ）标记窗口范围

* **滑动规则**：

  * **固定窗口**：窗口大小不变，整体滑动
  * **可变窗口**：窗口大小动态变化，根据条件收缩/扩展

#### 2. 时间复杂度优化

* **暴力解法**： $O(n^2)$
* **滑动窗口**： $O(n)$ ，每个元素最多被左右指针各访问一次

### 例题：「力扣」第 3 题：[无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/)

[../src/array/LongestSubstringWithoutRepeatingCharacters.java](../src/array/LongestSubstringWithoutRepeatingCharacters.java)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 哈希表存储字符及其最新索引
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLen = 0;  // 记录最大长度
        int left = 0;    // 窗口左边界

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果字符已存在且在当前窗口内，更新左边界
            if (charIndex.containsKey(currentChar) && charIndex.get(currentChar) >= left) {
                left = charIndex.get(currentChar) + 1;
            }

            // 更新字符的最新索引
            charIndex.put(currentChar, right);
            
            // 计算当前窗口长度并更新最大值
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
```

#### 核心思路：滑动窗口 + 哈希表

1. **滑动窗口**：维护一个窗口 `[left, right]`，窗口内的字符不重复。

2. **哈希表**：记录每个字符最后一次出现的索引。

3. **移动策略**：

   * **右指针**：每次向右扩展窗口，尝试包含新字符。
   * **左指针**：当新字符导致重复时，跳跃到重复字符的下一个位置。

#### 代码详解

1. **初始化**：
   * `charIndex`：哈希表记录字符的最后出现位置。
   * `maxLen`：记录最长子串长度。
   * `left`：窗口左边界初始为0。
2. **遍历字符串**：
   * 右指针 `right` 从0开始向右遍历每个字符。
   * 检查当前字符 `currentChar` 是否在哈希表中且其索引在窗口 `[left, right)` 内：
     * 若存在，将左边界移动到重复字符的下一个位置（`left = index + 1`）。
     * 若不存在或不在窗口内，保持左边界不变。
3. **更新哈希表**：
   * 无论是否移动左边界，都将当前字符的索引更新到哈希表中。
4. **计算窗口长度**：
   * 每次循环计算当前窗口长度 `right - left + 1`，更新最大值。

#### 复杂度分析

* **时间复杂度**： $O(n)$ ，每个字符被访问两次（左右指针各一次）。
* **空间复杂度**： $O(|\Sigma|)$ ， $\Sigma$ 为字符集大小（ASCII字符最多128个）。

## 滑动窗口经典问题

### 例题：「力扣」第 76 题：[最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/)

```java
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        // 初始化阶段
        int[] need = new int[128]; // 记录t中每个字符的需求量
        int[] window = new int[128]; // 记录当前窗口中字符的统计量
        int count = 0; // t中不同字符的种类数

        // 初始化need数组并统计字符种类
        for (char c : t.toCharArray()) {
            if (need[c] == 0) count++; // 首次出现时增加种类计数
            need[c]++; // 更新需求量
        }

        // 滑动窗口主循环
        int left = 0, right = 0; // 窗口的左右指针
        int fit = 0; // 满足需求的字符种类数
        int start = 0, minLen = Integer.MAX_VALUE;
        final int n = s.length();
        while (right < n) {
            char cur = s.charAt(right);

            // 仅处理目标字符 （need[c] > 0）
            if (need[cur] > 0) {
                window[cur]++;
                if (window[cur] == need[cur]) {
                    fit++; //当数量精确匹配时增加fit
                }
            }
            right++; //右指针始终右移

            // 当所有字符满足需求时收缩窗口
            while (fit == count) {
                // 更新最小窗口
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                    if (minLen == t.length()) break; // 提前终止优化
                }

                // 处理左指针移动
                char leftChar = s.charAt(left);
                if (need[leftChar] > 0) {
                    if (window[leftChar] == need[leftChar]) {
                        fit--; // 移出前数量正好满足需求，移出后不满足
                    }
                    window[leftChar]--;
                }
                left++;
            }

            if (minLen == t.length()) break; // 外层提前终止
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
```

该题核心思路使用**滑动窗口** + 数组计数在字符串 $s$ 中寻找包含 $t$ 所有字符的最短子串，通过两个指针 $left$ 和 $right$ 动态维护窗口，时间复杂度为 $O(n)$ 。

#### 1. 算法框架

* **滑动窗口**：维护窗口 `[left, right]`，动态扩展和收缩

* **数组计数**：用两个长度为128的数组（ASCII字符集）：

  * `need`：记录 `t` 中每个字符的需求量
  * `window`：记录当前窗口中字符的统计量

* **验证条件**：`fit` 表示窗口中满足需求的字符种类数

#### 关键逻辑解析

1. **满足条件判断**：

   * `fit == count`表示窗口中每个字符的数量都**至少达到**$t$中的需求
   * 例如：t="AABC"（count=3），当A、B、C在窗口中分别出现至少2、1、1次时满足条件

2. **窗口更新策略**：

   ```text
   未满足条件 → 右扩窗口
   满足条件 → 左缩窗口直到不满足
   ```

3. **复杂度分析**：

   * 每个字符最多被左右指针各访问一次 → $O(n)$

*这个解法通过精妙的双指针配合计数统计，高效地解决了最小覆盖子串问题。理解这个模板后，可以应对许多滑动窗口类题目。*

### 完成「力扣」第 209 题：[长度最小的子数组](https://leetcode.cn/problems/minimum-size-subarray-sum)

```java
public class MinimumSizeSubarraySum {
    
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                int currentLen = right - left + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                }
                sum -= nums[left];
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
```

#### **算法思路：滑动窗口**

1. **核心思想**：\
   利用双指针维护一个滑动窗口，通过动态调整窗口大小来寻找满足条件的最小窗口长度。

2. **操作步骤**：

   * **初始化**左右指针 `left = 0` 和 `right = 0`，窗口和 `sum = 0`，最小长度 `minLen = Integer.MAX_VALUE`。
   * **扩展右边界**：移动 `right` 指针累加元素，直到窗口和 ≥ `target`。
   * **收缩左边界**：当窗口和满足条件时，尝试移动 `left` 指针缩小窗口，同时更新最小长度。
   * **终止条件**：`right` 遍历完数组后停止。

#### **关键细节点**

1. **数组元素均为正整数**：\
   这一特性保证了当 `sum` 增加时窗口只能通过移动左边界来减少，使得算法时间复杂度为 $O(n)$ 。

2. **窗口长度计算**：\
   `right - left + 1` 是因为数组下标从 `0` 开始。例如，当 `left = 0` 且 `right = 0` 时，窗口长度为 `1`。

3. **更新最小长度的时机**：\
   必须在每次窗口满足条件时立即更新，因为后续收缩左边界可能导致窗口不再满足条件。

#### **复杂度分析**

* **时间复杂度**： $O(n)$ \
  每个元素最多被访问两次（被 `right` 和 `left` 各访问一次）。
* **空间复杂度**： $O(1)$ \
  仅使用常数级别的额外空间。
