package daily.twentyfive.july;

import java.util.*;

/**
 * 1233. 删除子文件夹
 *
 * @author AhogeK
 * @since 2025-07-19 18:42:26
 */
public class RemoveSubFoldersFromTheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, folder);
        List<String> ans = new ArrayList<>();
        for (String s : folder) {
            String substring = s.substring(0, s.lastIndexOf('/'));
            if (substring.isEmpty()) ans.add(s);
            else {
                while (!substring.isEmpty() && !set.contains(substring))
                    substring = substring.substring(0, substring.lastIndexOf('/'));
                if (substring.isEmpty()) ans.add(s);
            }
        }
        return ans;
    }
}
