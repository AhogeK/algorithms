package binarysearch;

import java.util.Random;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-19 12:30:28
 */
public class GuessGame {

    private final Integer guessNumber;

    public GuessGame() {
        // 随机生成一个整数
        Random random = new Random();
        guessNumber = random.nextInt(100) + 1;  // 生成0-100的随机整数
    }

    /**
     * 猜数字
     *
     * @param num 猜测的数字
     * @return 0: 猜对了; -1: 猜大了; 1: 猜小了
     */
    int guess(int num) {
        if (num == guessNumber) {
            return 0;
        } else if (num < guessNumber) {
            return 1;
        } else {
            return -1;
        }
    }
}
