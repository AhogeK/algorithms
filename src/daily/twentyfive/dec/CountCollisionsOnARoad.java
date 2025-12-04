package daily.twentyfive.dec;

/**
 * 2211. 统计道路上的碰撞次数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-04 10:15:41
 */
public class CountCollisionsOnARoad {
    public int countCollisions(String directions) {
        char[] d = directions.toCharArray();
        int n = d.length;
        int left = 0;
        int right = n - 1;
        while (left < n && d[left] == 'L') left++;
        while (right >= 0 && d[right] == 'R') right--;
        int count = 0;
        for (int i = left; i <= right; i++)
            if (d[i] != 'S') count++;
        return count;
    }
}
