package stackqueue;

/**
 * 151. 反转字符串中的单词
 *
 * @author AhogeK
 * @since 2025-05-27 02:00:52
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        char[] temp = s.toCharArray();
        int n = temp.length;
        int slow = 0, i = 0;
        while (i < n) {
            while (i < n && temp[i] == ' ')
                i++;
            if (i >= n)
                break;
            if (slow > 0)
                temp[slow++] = ' ';
            while (i < n && temp[i] != ' ')
                temp[slow++] = temp[i++];
        }
        reverse(temp, 0, slow - 1);
        int start = 0;
        int spaceIndex;
        while (start < slow) {
             spaceIndex = start;
            while (spaceIndex < slow && temp[spaceIndex] != ' ')
                spaceIndex++;
            reverse(temp, start, spaceIndex - 1);
            start = spaceIndex + 1;
        }
        return new String(temp, 0, slow);
    }

    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char tmp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = tmp;
        }
    }
}
