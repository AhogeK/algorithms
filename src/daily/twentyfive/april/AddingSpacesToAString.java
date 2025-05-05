package daily.twentyfive.april;

/**
 * <a href="https://leetcode.cn/problems/adding-spaces-to-a-string">2109. 向字符串添加空格<a>
 *
 * @author AhogeK
 * @since 2025-03-30 19:19:47
 */
public class AddingSpacesToAString {

    public String addSpaces(String s, int[] spaces) {
        int resultLength = s.length() + spaces.length;
        char[] result = new char[resultLength];
        int resultIndex = 0;
        int spaceIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            // 检查当前位置是否需要添加空格
            if (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                result[resultIndex++] = ' ';
                spaceIndex++;
            }
            // 添加当前字符
            result[resultIndex++] = s.charAt(i);
        }

        return new String(result);
    }

    public static void main(String[] args) {
        AddingSpacesToAString solution = new AddingSpacesToAString();
        System.out.println(solution.addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
    }
}
