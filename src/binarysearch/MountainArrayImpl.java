package binarysearch;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-25 10:52:10
 */
public class MountainArrayImpl implements MountainArray {

    private final int[] array;

    public MountainArrayImpl(int[] array) {
        this.array = array;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public int length() {
        return array.length;
    }
}
