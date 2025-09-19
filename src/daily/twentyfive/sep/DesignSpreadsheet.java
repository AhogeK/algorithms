package daily.twentyfive.sep;

/**
 * 3484. 设计电子表格
 *
 * @author AhogeK
 * @since 2025-09-19 10:49:48
 */
public class DesignSpreadsheet {
    class Spreadsheet {
        private int rows;
        private int[][] sheet;

        public Spreadsheet(int rows) {
            this.rows = rows;
            this.sheet = new int[rows][26];
        }

        public void setCell(String cell, int value) {
            int[] pos = parseCell(cell);
            sheet[pos[0]][pos[1]] = value;
        }

        public void resetCell(String cell) {
            int[] pos = parseCell(cell);
            sheet[pos[0]][pos[1]] = 0;
        }

        public int getValue(String formula) {
            int plusIndex = -1;
            for (int i = 1; i < formula.length(); i++) {
                if (formula.charAt(i) == '+') {
                    plusIndex = i;
                    break;
                }
            }
            int val1 = parseOperand(formula, 1, plusIndex);
            int val2 = parseOperand(formula, plusIndex + 1, formula.length());
            return val1 + val2;
        }

        private int parseOperand(String s, int start, int end) {
            char first = s.charAt(start);
            if (first >= 'A' && first <= 'Z') {
                int col = first - 'A';
                int row = 0;
                for (int i = start + 1; i < end; i++) {
                    row = row * 10 + (s.charAt(i) - '0');
                }
                return sheet[row - 1][col];
            } else {
                int res = 0;
                for (int i = start; i < end; i++) {
                    res = res * 10 + (s.charAt(i) - '0');
                }
                return res;
            }
        }

        private int[] parseCell(String cell) {
            int col = cell.charAt(0) - 'A';
            int row = 0;
            for (int i = 1; i < cell.length(); i++) row = row * 10 + (cell.charAt(i) - '0');
            return new int[]{row - 1, col};
        }
    }
}
