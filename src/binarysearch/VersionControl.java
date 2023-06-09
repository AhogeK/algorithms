package binarysearch;

import java.util.Random;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-25 10:22:30
 */
public class VersionControl {

    private final int firstBadVersion;

    public VersionControl() {
        Random random = new Random();
        this.firstBadVersion = random.nextInt(101);
    }

    /**
     * 判断版本是否错误
     *
     * @param version 版本号
     * @return 是否错误
     */
    boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

    public int getFirstBadVersion() {
        return firstBadVersion;
    }
}
