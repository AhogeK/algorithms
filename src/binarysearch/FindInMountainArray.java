package binarysearch;

/**
 * 「力扣」1095. 山脉数组中查找目标值
 * <a href="https://leetcode-cn.com/problems/find-in-mountain-array/">题目网址</a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-25 10:46:16
 */
public class FindInMountainArray {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peakIndex = findPeakIndex(mountainArr, 0, n - 1);

        int index = binarySearch(mountainArr, 0, peakIndex, target);
        if (index != -1) {
            return index;
        }
        return reverseBinarySearch(mountainArr, peakIndex + 1, n - 1, target);
    }

    /**
     * 查找山峰索引
     *
     * @param mountainArr 山脉数组
     * @param left        左边界
     * @param right       右边界
     * @return 山峰索引
     */
    private int findPeakIndex(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 二分查找
     *
     * @param mountainArr 山脉数组
     * @param left        左边界
     * @param right       右边界
     * @param target      目标值
     * @return 目标值索引
     */
    private int binarySearch(MountainArray mountainArr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 反向二分查找
     *
     * @param mountainArr 山脉数组
     * @param left        左边界
     * @param right       右边界
     * @param target      目标值
     * @return 目标值索引
     */
    private int reverseBinarySearch(MountainArray mountainArr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
