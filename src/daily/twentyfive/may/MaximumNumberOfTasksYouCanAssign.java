package daily.twentyfive.may;

import java.util.Arrays;

/**
 * 2071. 你可以安排的最多任务数目
 *
 * @author AhogeK
 * @since 2025-05-01 17:35:37
 */
public class MaximumNumberOfTasksYouCanAssign {
    int[] que = new int[50000];

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int m = tasks.length;
        int n = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int l = 0;
        int r = Math.min(m, n);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(tasks, workers, pills, strength, mid, n - mid))
                l = mid + 1;
            else
                r = mid - 1;
        }
        return r;
    }

    private boolean check(int[] tasks, int[] workers, int pills, int strength, int mid, int start) {
        int write = 0;
        int read = 0;
        int taskIndex = 0;
        int workerIndex = 0;

        while (workerIndex < mid) {
            int curStrength = workers[start + workerIndex];
            boolean matched = false;

            if (read == write) {
                if (curStrength >= tasks[taskIndex]) {
                    taskIndex++;
                    matched = true;
                }
            } else {
                if (curStrength >= que[read]) {
                    read++;
                    matched = true;
                }
            }

            if (matched) {
                workerIndex++;
                continue;
            }

            if (pills == 0)
                return false;

            pills--;
            curStrength += strength;

            while (taskIndex < mid && curStrength >= tasks[taskIndex]) {
                que[write++] = tasks[taskIndex++];
            }

            if (read == write) {
                return false;
            }
            write--;
            workerIndex++;
        }

        return read == write;
    }
}
