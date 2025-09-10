package daily.twentyfive.sep;

import java.util.Arrays;

/**
 * 2785. 将字符串中的元音字母排序
 *
 * @author AhogeK
 * @since 2025-09-11 05:09:20
 */
public class SortVowelsInAString {
    public String sortVowels(String s) {
        boolean[] isVowel = new boolean[128];
        for (char c : new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'})
            isVowel[c] = true;
        char[] arr = s.toCharArray();
        int count = 0;
        for (char ch : arr)
            if (isVowel[ch])
                count++;
        char[] vowels = new char[count];
        int idx = 0;
        for (char ch : arr)
            if (isVowel[ch]) vowels[idx++] = ch;
        Arrays.sort(vowels);
        idx = 0;
        for (int i = 0; i < arr.length; i++)
            if (isVowel[arr[i]]) arr[i] = vowels[idx++];
        return new String(arr);
    }
}
