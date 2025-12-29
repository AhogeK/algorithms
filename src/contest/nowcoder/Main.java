package contest.nowcoder;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 模版
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-29 14:11:12
 */
public class Main {
    // 声明静态输入输出对象，供全局调用
    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        // -------------------------------------------------------------
        // 模式切换区
        // true  = 题目第一行是 T (如: 3 \n case1 \n case2...) -> CF/牛客常见
        // false = 题目没提 T，或者说 "Process to EOF"      -> LeetCode/老题
        boolean multipleTestCases = true;
        // -------------------------------------------------------------

        int T = 1;
        if (multipleTestCases) {
            // 尝试读取 T，若文件为空或格式错误，默认为 0 跳过
            try {
                String tStr = sc.next();
                if (tStr != null) T = Integer.parseInt(tStr);
            } catch (Exception e) {
                T = 0;
            }
        }

        while (T-- > 0) {
            try {
                solve();
            } catch (Exception e) {
                // 遇到 EOF 异常直接退出，防止死循环
                break;
            }
        }

        // 【致命重要】必须在程序结束前 flush，否则控制台可能一片空白
        out.flush();
    }

    /**
     * 核心逻辑区域 - 每一组数据都会调用一次此方法
     */
    static void solve() {
        // 1. 读入
        int n = sc.nextInt();
        long k = sc.nextLong();

        // 2. 算法逻辑
        // 示例：输出 n + k
        long ans = n + k;

        // 3. 输出 (不要用 System.out.println)
        out.println(ans);
    }

    // -----------------------------------------------------------------
    // 下面是 Fast I/O 引擎，比赛时折叠起来即可，无需修改
    // -----------------------------------------------------------------
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        // 核心：获取下一个 token (字符串)
        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    // 如果读到 null，说明文件结束 (EOF)
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            String s = next();
            // 如果需要处理 EOF 导致无法读取数字的情况，可在此判空
            return Integer.parseInt(s);
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}