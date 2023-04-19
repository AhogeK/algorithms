package binarysearch;

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
