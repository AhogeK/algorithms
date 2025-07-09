package daily.twentyfive.july;

/**
 * 3439. 重新安排会议得到最多空余时间 I
 *
 * @author AhogeK
 * @since 2025-07-09 19:58:06
 */
public class RescheduleMeetingsForMaximumFreeTimeI {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int res = 0;
        int t = 0;
        for (int i = 0; i < n; i++) {
            t += endTime[i] - startTime[i];
            int left = i <= k - 1 ? 0 : endTime[i - k];
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            res = Math.max(res, right - left - t);
            if (i >= k - 1) {
                t -= endTime[i - k + 1] - startTime[i - k + 1];
            }
        }
        return res;
    }
}
