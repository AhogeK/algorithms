package contest.leetcode.daily.twentyfive.dec;

import java.util.List;

/**
 * 3433. 统计用户被提及情况
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-12 01:54:45
 */
public class CountMentionsPerUser {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] ans = new int[numberOfUsers];
        int[] onlineTime = new int[numberOfUsers];
        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if (timeA != timeB) return timeA - timeB;
            String typeA = a.getFirst();
            String typeB = b.getFirst();
            if (typeA.equals("OFFLINE")) return -1;
            if (typeB.equals("OFFLINE")) return 1;
            return 0;
        });
        for (List<String> event : events) {
            String type = event.get(0);
            int curTime = Integer.parseInt(event.get(1));
            String content = event.get(2);
            if (type.equals("OFFLINE")) {
                int userId = Integer.parseInt(content);
                onlineTime[userId] = curTime + 60;
            } else {
                if (content.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) ans[i]++;
                } else if (content.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++)
                        if (curTime >= onlineTime[i]) ans[i]++;
                } else {
                    String[] ids = content.split(" ");
                    for (String idStr : ids) {
                        int id = Integer.parseInt(idStr.substring(2));
                        ans[id]++;
                    }
                }
            }
        }
        return ans;
    }
}
