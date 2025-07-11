package daily.twentyfive.july;

import java.util.Map;
import java.util.TreeMap;

/**
 * 3169. 无需开会的工作日
 *
 * @author AhogeK
 * @since 2025-07-11 14:47:47
 */
public class CountDaysWithoutMeetings {
    public int countDays(int days, int[][] meetings) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int res = days;
        for (int[] m : meetings) {
            int l = m[0];
            int r = m[1];
            Map.Entry<Integer, Integer> entry = map.floorEntry(r);
            int newL = l;
            int newR = r;
            while (entry != null && entry.getValue() >= l - 1) {
                newL = Math.min(newL, entry.getKey());
                newR = Math.max(newR, entry.getValue());
                res += entry.getValue() - entry.getKey() + 1;
                map.remove(entry.getKey());
                entry = map.lowerEntry(entry.getKey());
            }
            map.put(newL, newR);
            res -= newR - newL + 1;
        }
        return res;
    }
}
