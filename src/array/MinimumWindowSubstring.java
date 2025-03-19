package array;

/**
 * @author AhogeK
 * @since 2025-03-18 17:35:44
 */
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
