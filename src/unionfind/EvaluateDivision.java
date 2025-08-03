package unionfind;

import java.util.HashMap;
import java.util.List;

/**
 * 399. 除法求值
 *
 * @author AhogeK
 * @since 2025-08-03 22:26:12
 */
public class EvaluateDivision {

    private HashMap<String, String> parent = new HashMap<>();
    private HashMap<String, Double> weight = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++)
            union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);
            if (!parent.containsKey(c) || !parent.containsKey(d))
                result[i] = -1.0;
            else {
                String rootC = find(c);
                String rootD = find(d);
                if (!rootC.equals(rootD))
                    result[i] = -1.0;
                else
                    result[i] = weight.get(c) / weight.get(d);
            }
        }
        return result;
    }

    private void union(String x, String y, double value) {
        String rootX = find(x);
        String rootY = find(y);
        if (!rootX.equals(rootY)) {
            parent.put(rootX, rootY);
            weight.put(rootX, weight.get(y) * value / weight.get(x));
        }
    }

    private String find(String x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            weight.put(x, 1.0);
            return x;
        }
        if (x.equals(parent.get(x))) return x;
        String root = find(parent.get(x));
        weight.put(x, weight.get(x) * weight.get(parent.get(x)));
        parent.put(x, root);
        return root;
    }
}
