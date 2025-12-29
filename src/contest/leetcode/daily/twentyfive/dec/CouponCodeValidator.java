package contest.leetcode.daily.twentyfive.dec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 3606. 优惠券校验器
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-13 19:07:55
 */
public class CouponCodeValidator {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String>[] buckets = new ArrayList[4];
        for (int i = 0; i < 4; i++) buckets[i] = new ArrayList<>();
        int n = code.length;
        for (int i = 0; i < n; i++) {
            if (!isActive[i]) continue;
            int idx = lineIndex(businessLine[i]);
            if (idx < 0) continue;
            if (!isValidCode(code[i])) continue;
            buckets[idx].add(code[i]);
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Collections.sort(buckets[i]);
            ans.addAll(buckets[i]);
        }
        return ans;
    }

    private int lineIndex(String line) {
        if (line == null) return -1;
        return switch (line) {
            case "electronics" -> 0;
            case "grocery" -> 1;
            case "pharmacy" -> 2;
            case "restaurant" -> 3;
            default -> -1;
        };
    }

    private boolean isValidCode(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '_') continue;
            if (!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }
}
