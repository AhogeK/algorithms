package linked;

import java.util.*;

/**
 * 355. 设计推特
 *
 * @author AhogeK
 * @since 2025-04-22 12:27:06
 */
public class Twitter {
    // 用户关注关系，最大501用户，静态预分配
    Set<Integer>[] followees = new HashSet[501];
    // 每个用户的最新推文（postLasts下标，-1为无推文）
    int[] userLasts = new int[501];
    // 全部推文链：每条推文[id, 上一条同用户推文下标]
    List<int[]> postLasts = new ArrayList<>();

    public Twitter() {
        Arrays.fill(userLasts, -1);
        // followees 在 follow 时延迟分配，节省空间
    }

    public void postTweet(int userId, int tweetId) {
        // 头插法建立单向链表
        postLasts.add(new int[]{tweetId, userLasts[userId]});
        userLasts[userId] = postLasts.size() - 1;
    }

    public List<Integer> getNewsFeed(int userId) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        add(userId, pq); // 包含自己
        if (followees[userId] != null)
            for (int id : followees[userId])
                add(id, pq);
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty() && ans.size() < 10) {
            int idx = pq.poll();
            int[] post = postLasts.get(idx);
            ans.add(post[0]);
            if (post[1] >= 0)
                // 加入该作者的下一个旧推文
                pq.add(post[1]);
        }
        return ans;
    }

    private void add(int userId, Queue<Integer> pq) {
        if (userLasts[userId] >= 0) pq.add(userLasts[userId]);
    }

    public void follow(int followerId, int followeeId) {
        // 不能关注自己
        if (followerId == followeeId) return;
        if (followees[followeeId] == null) followees[followeeId] = new HashSet<>();
        followees[followeeId].add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followees[followerId] != null) {
            followees[followerId].remove(followeeId);
        }
    }
}
