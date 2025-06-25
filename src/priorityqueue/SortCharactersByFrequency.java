package priorityqueue;

import java.util.Arrays;

/**
 * 451. 根据字符出现频率排序
 *
 * @author AhogeK
 * @since 2025-06-25 20:35:35
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[][] freqPair = new int[128][2];
        for (int i = 0; i < 128; i++)
            freqPair[i][0] = i;
        for (char c : s.toCharArray())
            freqPair[c][1]++;
        Arrays.sort(freqPair, (a, b) -> b[1] - a[1]);
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < 128 && freqPair[i][1] > 0; i++) {
            char c = (char) freqPair[i][0];
            int freq = freqPair[i][1];
            sb.append(String.valueOf(c).repeat(Math.max(0, freq)));
        }
        return sb.toString();
    }
}
