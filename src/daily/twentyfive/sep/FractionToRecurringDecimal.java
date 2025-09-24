package daily.twentyfive.sep;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 *
 * @author AhogeK
 * @since 2025-09-24 16:35:51
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) sb.append('-');
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        sb.append(num / den);
        long remainder = num % den;
        if (remainder == 0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> remainderMap = new HashMap<>();
        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                sb.insert(remainderMap.get(remainder), "(");
                sb.append(")");
                break;
            }
            remainderMap.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / den);
            remainder %= den;
        }
        return sb.toString();
    }
}
