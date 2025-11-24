package daily.twentyfive.nov;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-24 17:31:11
 */
public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>(nums.length);
        int remainder = 0;
        for (int bit : nums) {
            remainder = ((remainder << 1) | bit) % 5;
            answer.add(remainder == 0);
        }
        return answer;
    }
}
