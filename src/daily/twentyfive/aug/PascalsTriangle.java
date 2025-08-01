package daily.twentyfive.aug;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * @author AhogeK
 * @since 2025-08-01 16:17:52
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++)
                if (j == 0 || j == i) row.add(1);
                else row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            triangle.add(row);
        }
        return triangle;
    }
}
