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
  * [滑动窗口经典问题](#滑动窗口经典问题)
    * [例题：「力扣」第 76 题：最小覆盖子串](#例题力扣第-76-题最小覆盖子串)
      * [1. 算法框架](#1-算法框架)
      * [关键逻辑解析](#关键逻辑解析)
    * [完成「力扣」第 209 题：长度最小的子数组](#完成力扣第-209-题长度最小的子数组)
      * [**算法思路：滑动窗口**](#算法思路滑动窗口)
      * [**关键细节点**](#关键细节点)
      * [**复杂度分析**](#复杂度分析-1)
    * [完成「力扣」第 438 题：找到字符串中所有字母异位词](#完成力扣第-438-题找到字符串中所有字母异位词)
      * [**算法思路：固定窗口滑动**](#算法思路固定窗口滑动)
      * [**关键细节点**](#关键细节点-1)
      * [**复杂度分析**](#复杂度分析-2)
    * [完成「力扣」第 567 题：字符串的排列](#完成力扣第-567-题字符串的排列)
      * [算法思路](#算法思路)
        * [滑动窗口 + 哈希表计数](#滑动窗口--哈希表计数)
        * [关键变量](#关键变量)
      * [细节点剖析](#细节点剖析)
      * [复杂度分析](#复杂度分析-3)
    * [完成「力扣」第 424 题：替换后的最长重复字符](#完成力扣第-424-题替换后的最长重复字符)
      * [**算法思路：滑动窗口**](#算法思路滑动窗口-1)
      * [**关键细节点**](#关键细节点-2)
      * [**复杂度分析**](#复杂度分析-4)
  * [双指针简介](#双指针简介)
    * [双指针的基本类型](#双指针的基本类型)
      * [1. 对撞指针（相向双指针）](#1-对撞指针相向双指针)
      * [2. 快慢指针](#2-快慢指针)
      * [3. 滑动窗口](#3-滑动窗口)
    * [双指针的优势](#双指针的优势)
    * [应用场景](#应用场景)
    * [例题：「力扣」第 15 题：三数之和](#例题力扣第-15-题三数之和)
      * [问题分析](#问题分析)
      * [算法设计](#算法设计)
      * [代码详解与关键点](#代码详解与关键点)
        * [1. 排序的重要性](#1-排序的重要性)
        * [2. 提前终止条件](#2-提前终止条件)
        * [3. 去重处理](#3-去重处理)
        * [4. 双指针移动策略](#4-双指针移动策略)
      * [复杂度分析](#复杂度分析-5)
        * [时间复杂度: $O(n^2)$](#时间复杂度-on2)
        * [空间复杂度: $O(1)$](#空间复杂度-o1)
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

[../src/array/MinimumSizeSubarraySum.java](../src/array/MinimumSizeSubarraySum.java)

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

### 完成「力扣」第 438 题：[找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/)

[../src/array/FindAllAnagramsInAString.java](../src/array/FindAllAnagramsInAString.java)

```java
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] currentCount = new int[26];
        int valid = 0; // 记录满足频率要求的字符种类数
        int uniqueChars = 0; // p中不同字符的数量

        // 统计p的字符频率
        for (char c : p.toCharArray()) {
            if (pCount[c - 'a'] == 0) uniqueChars++;
            pCount[c - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            currentCount[c - 'a']++;

            // 当新增字符的频率与p中该字符的频率一致时，valid增加
            if (currentCount[c - 'a'] == pCount[c - 'a']) {
                valid++;
            }

            // 窗口大小超过p长度时，左指针右移
            if (right - left + 1 > p.length()) {
                char leftChar = s.charAt(left);
                if (currentCount[leftChar - 'a'] == pCount[leftChar - 'a']) {
                    valid--;
                }
                currentCount[leftChar - 'a']--;
                left++;
            }

            // 当窗口大小等于p长度且valid匹配时，记录索引
            if (right - left + 1 == p.length() && valid == uniqueChars) {
                result.add(left);
            }
        }

        return result;
    }
}
```

#### **算法思路：固定窗口滑动**

1. **核心思想**：\
   维护一个长度固定为 `p.length()` 的滑动窗口，统计窗口内字符频率是否与 `p` 的字符频率一致。

2. **操作步骤**：

   * 统计 `p` 的字符频率，存入数组 `pCount`。
   * 初始化窗口的左右指针 `left=0` 和 `right=0`，统计窗口内字符频率的数组 `currentCount`。
   * 维护计数器 `valid` 表示当前窗口内满足 `p` 字符频率的字符种类数。
   * 当窗口大小等于 `p` 的长度时，若 `valid` 等于 `p` 的字符种类数，则记录起始索引。

#### **关键细节点**

1. **固定窗口大小**：\
   窗口大小必须严格等于 `p` 的长度，因此当 `right - left + 1 > p.length()` 时必须收缩左边界。

2. **字符频率的精确匹配**：\
   仅当某个字符在窗口内的频率 **等于** `p` 中该字符的频率时，才会计入 `valid`。例如，若 `p` 中 `a` 出现2次，窗口内 `a` 出现2次才会触发 `valid++`。

3. **计数器的维护**：

   * 右指针扩展时，若字符频率从 `pCount[c]-1` 增加到 `pCount[c]`，则 `valid++`。
   * 左指针收缩时，若字符频率从 `pCount[c]` 减少到 `pCount[c]-1`，则 `valid--`。

#### **复杂度分析**

* **时间复杂度**： $O(n)$
  * `n` 为 `s` 的长度，每个字符最多被左右指针各访问一次。
* **空间复杂度**： $O(1)$
  * 固定长度的数组 `pCount` 和 `currentCount`（长度26）。

### 完成「力扣」第 567 题：[字符串的排列](https://leetcode.cn/leetbook/read/learning-algorithms-with-leetcode)

[../src/array/PermutationInString.java](../src/array/PermutationInString.java)

```java
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] hash = new int[26];
        // 统计s1字符频率
        for (char c : s1.toCharArray()) {
            hash[c - 'a']++;
        }

        // 初始化剩余需要匹配的字符数
        int requiredChars = len1;

        // 处理初始窗口（s2的前len1个字符）
        for (int i = 0; i < len1; i++) {
            int idx = s2.charAt(i) - 'a';
            // 若该字符是s1需要的，减少需匹配数
            if (hash[idx]-- > 0) {
                requiredChars--;
            }
        }
        if (requiredChars == 0) return true;

        // 滑动窗口：每次移动一位
        for (int right = len1; right < len2; right++) {
            int leftChar = s2.charAt(right - len1) - 'a'; // 是要移出的，所以长度还是2
            int rightChar = s2.charAt(right) - 'a';

            // 处理左边界字符移出
            if (hash[leftChar]++ >= 0) { // 若该字符原属于s1，需恢复匹配需求
                requiredChars++;
            }

            if (hash[rightChar]-- > 0) { // 若该字符是s1需要的，减少需匹配数
                requiredChars--;
            }

            if (requiredChars == 0) return true;
        }
        return false;
    }
}
```

#### 算法思路

##### 滑动窗口 + 哈希表计数

1. **边界处理**：若`s1`长度 > `s2`长度，直接返回`false`。
2. **哈希表初始化**：统计`s1`的字符频率。
3. **初始窗口处理**：检查`s2`的前`len(s1)`个字符是否匹配。
4. **滑动窗口**：每次移动窗口右边界，动态维护字符频率计数和匹配状态。

##### 关键变量

* `hash[26]`：记录每个字符的剩余需要匹配的次数（负数表示冗余）。
* `requiredChars`：剩余需要匹配的字符总数（初始为`s1`的长度）。

#### 细节点剖析

1. **窗口长度固定**：始终为`len(s1)`，通过`right`从`len(s1)`开始，每次移动一位。

2. **哈希表动态更新**：

   * **移出左边界字符**：若该字符原本属于`s1`（`hash[leftChar] >= 0`），则移出后需增加`requiredChars`。
   * **新增右边界字符**：若该字符在`s1`中有剩余需求（`hash[rightChar] > 0`），则减少`requiredChars`。

3. **提前终止条件**：一旦`requiredChars == 0`，立即返回`true`。

#### 复杂度分析

1. **时间复杂度**： $O(n)$ ，其中$n$是`s2`的长度。每个字符最多进入和离开窗口各一次。
2. **空间复杂度**： $O(1)$ ，固定长度的哈希表（26个字符）。

### 完成「力扣」第 424 题：[替换后的最长重复字符](https://leetcode.cn/problems/longest-repeating-character-replacement/)

[../src/array/LongestRepeatingCharacterReplacement.java](../src/array/LongestRepeatingCharacterReplacement.java)

```java
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxCount = 0, result = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'A']++;
            maxCount = Math.max(maxCount, count[c - 'A']); // 更新当前窗口的最大出现次数

            // 若窗口不满足条件，收缩左边界
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--; // 移除左边界字符
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
```

#### **算法思路：滑动窗口**

1. **核心思想**：\
   维护一个滑动窗口，统计窗口内字符出现的最大次数 `maxCount`。若窗口大小满足 `窗口大小 - maxCount ≤ k`，则可以通过替换 `k` 次字符使窗口内字符全部相同。

2. **操作步骤**：

   * **初始化**：字符计数数组 `count`，左指针 `left = 0`，最大出现次数 `maxCount = 0`，结果 `result = 0`。
   * **扩展窗口**：右指针 `right` 遍历字符串，更新当前字符的计数和 `maxCount`。
   * **收缩窗口**：若窗口大小 `right - left + 1 - maxCount > k`，则移动左指针并减少对应字符的计数。
   * **更新结果**：每次扩展后，记录窗口大小的最大值。

#### **关键细节点**

1. **字符计数数组**：\
   使用长度为 `26` 的数组统计每个字符的出现次数（仅限大写字母）。

2. **`maxCount` 的动态维护**：

   * 右指针移动时，更新当前字符的计数，并比较是否超过 `maxCount`。
   * **无需在左指针移动时更新 `maxCount`**：即使 `maxCount` 被高估，窗口收缩后仍能正确判断有效性。

3. **窗口有效性条件**：\
   窗口大小 `right - left + 1` 必须满足 `窗口大小 ≤ maxCount + k`，否则需收缩左边界。

#### **复杂度分析**

| 指标        | 值      | 说明                 |
|-----------|--------|--------------------|
| **时间复杂度** | $O(n)$ | 每个字符被左右指针各访问一次     |
| **空间复杂度** | $O(1)$ | 固定长度的字符计数数组（26个元素） |

## 双指针简介

> 双指针（Two Pointers）是一种常用的算法技巧，主要用于处理数组、链表等线性数据结构的问题。这种技术通过使用两个指针（通常是索引或引用）同时在数据结构中移动，以达到优化时间复杂度或解决特定问题的目的

### 双指针的基本类型

#### 1. 对撞指针（相向双指针）

* 一个指针从开始位置出发，另一个指针从结束位置出发
* 两个指针向中间移动，直到它们相遇

```
function fn(arr):
    left = 0
    right = arr.length - 1
    while left < right:
        // 根据问题处理逻辑
        // 根据条件决定移动左指针、右指针或两者
```

#### 2. 快慢指针

* 两个指针维护一个窗口，通常都是向前移动
* 用于寻找满足特定条件的子数组或子串

#### 3. 滑动窗口

* 两个指针维护一个窗口，通常都是向前移动
* 用于寻找满足特定条件的子数组或子串

### 双指针的优势

1. **时间复杂度优化**：通常可以将暴力解法的 $O(n^2)$ 优化到 $O(n)$
2. **空间效率高**：一般只需要常数级别 $O(1)$ 的额外空间
3. **特别适合处理排序数组**：可以利用有序性质更高效地解决问题

### 应用场景

1. 查找满足特定条件的数对
2. 判断回文结构
3. 删除数组中的重复元素
4. 链表中环的检测
5. 最长无重复字符的子串
6. 接雨水问题
7. 颜色分类（荷兰国旗问题）

双指针技术的核心优势在于能够在一次遍历中完成工作，将时间复杂度控制在 $O(n)$ ，因为两个指针总共最多只会移动 $n$ 次。

### 例题：「力扣」第 15 题：[三数之和](https://leetcode.cn/problems/3sum)

[../src/array/ThreeSum.java](../src/array/ThreeSum.java)

```java
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 处理边界情况
        if (nums == null || nums.length < 3) return result;

        // 先对数组进行排序
        Arrays.sort(nums);

        int n = nums.length;

        // 遍历数组，固定第一个数
        for (int i = 0; i < n - 2; i++) {
            // 如果当前数字大于0，因为数组已排序，后面的数字都比它大，三数之和必然大于0，所以结束循环
            if (nums[i] > 0) {
                break;
            }

            // 去重：跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 使用双指针在剩余数组中寻找两个数
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    // 和小于0，需要增大，左指针右移
                    left++;
                } else if (sum > 0) {
                    // 和大于0，需要减少，右指针左移
                    right--;
                } else {
                    // 找到一组
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 去重，跳过重复的左右指针指向的元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 指针同时移动，继续寻找其他解
                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}
```

#### 问题分析

这个问题本质上是要我们找到数组中所有三个数之和为 0 的不重复组合。最直观的做法是使用三重循环来枚举所有可能的三元组，但这样的时间复杂度是 $O(n^3)$，效率非常低。

#### 算法设计

我们可以使用排序加双指针的策略来优化：

1. 先将数组排序，这样可以方便地跳过重复元素
2. 固定一个数 `nums[i]`，然后在 `nums[i]` 后面的区间内使用双指针寻找两个数，使三数之和为 0

具体步骤：

1. 对数组进行排序
2. 遍历数组，固定第一个数 `nums[i]`
3. 使用左右双指针 `left = i + 1`, `right = nums.length - 1` 查找两个数使三数之和为 0
4. 处理重复情况以避免重复结果

#### 代码详解与关键点

##### 1. 排序的重要性

排序（`Arrays.sort(nums)`）是解决此问题的关键步骤：

* 使得相同的元素相邻，便于去重
* 使得我们可以应用双指针技巧
* 有序数组使我们可以根据三数之和的大小决定移动哪个指针

##### 2. 提前终止条件

当 `nums[i] > 0` 时，由于数组已排序，后面的元素都大于等于 `nums[i]`，三数之和必然大于 0，因此可以直接结束外层循环。

##### 3. 去重处理

代码中有两处去重操作：

* 对第一个数（`nums[i]`）的去重：`if (i > 0 && nums[i] == nums[i - 1]) continue;`
* 找到一组解后，对第二个和第三个数的去重：使用 while 循环跳过重复值

##### 4. 双指针移动策略

* 当三数之和 < 0 时，说明当前和太小，需要增大，因此移动左指针
* 当三数之和 > 0 时，说明当前和太大，需要减小，因此移动右指针
* 当三数之和 = 0 时，记录结果，并移动双指针继续寻找

#### 复杂度分析

##### 时间复杂度: $O(n^2)$

* 排序需要 $O(n \log n)$ 的时间
* 双层循环需要 $O(n^2)$ 的时间
* 总体时间复杂度为 $O(n^2)$

##### 空间复杂度: $O(1)$

* 除了存储结果的空间外，我们只使用了常数级别的额外空间
* 如果考虑返回结果所需的空间，则为 $O(n)$
