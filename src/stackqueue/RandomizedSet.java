package stackqueue;

import java.util.*;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 *
 * @author AhogeK
 * @since 2025-05-15 10:37:08
 */
class RandomizedSet {
    private final List<Integer> nums;
    private final Map<Integer, Integer> valToIdx;
    private final Random rand;

    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIdx = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valToIdx.containsKey(val)) return false;
        valToIdx.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIdx.containsKey(val)) return false;
        int idx = valToIdx.get(val);
        int lastVal = nums.getLast();
        if (idx != nums.size() - 1) {
            nums.set(idx, lastVal);
            valToIdx.put(lastVal, idx);
        }
        nums.removeLast();
        valToIdx.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIdx = rand.nextInt(nums.size());
        return nums.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */