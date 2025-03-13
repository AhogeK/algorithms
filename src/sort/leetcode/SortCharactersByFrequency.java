package sort.leetcode;

import java.util.*;

/**
 * @author AhogeK
 * @since 2025-03-13 16:06:07
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        // 使用128长度的数组统计ASCII字符频率
        int[] freq = new int[128];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            freq[c]++;
        }

        // 创建字符-频率对列表（避免Map.Entry开销）
        List<int[]> charFreqList = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                charFreqList.add(new int[]{i, freq[i]});
            }
        }

        // 按频率降序排序（Collections.sort比优先队列更快）
        Collections.sort(charFreqList, (a, b) -> b[1] - a[1]);

        // 直接操作字符数组（比StringBuilder更快）
        char[] result = new char[arr.length];
        int idx = 0;
        for (int[] pair : charFreqList) {
            char c = (char) pair[0];
            int count = pair[1];
            Arrays.fill(result, idx, idx + count, c);
            idx += count;
        }
        return new String(result);
    }
}
