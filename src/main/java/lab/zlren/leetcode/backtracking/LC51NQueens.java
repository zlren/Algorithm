package lab.zlren.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题
 *
 * @author zlren
 * @date 2018-03-28
 */
public class LC51NQueens {

    public static void main(String[] args) {
        new LC51NQueens().solveNQueens(4).forEach(System.out::println);
    }

    List<List<String>> res = new ArrayList<>();

    /**
     * 第i列是否摆放了皇后
     */
    boolean[] col;

    /**
     * 两个对角线判断冲突
     */
    boolean[] dia1, dia2;

    public List<List<String>> solveNQueens(int n) {

        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        putQueeu(n, 0, new ArrayList<>());

        return res;
    }

    /**
     * 尝试在一个n皇后问题中，摆放第index行的皇后位置
     *
     * @param n
     * @param index
     * @param row   row[i] == k 表示第i行的皇后摆在第k个位置
     */
    private void putQueeu(int n, int index, List<Integer> row) {

        if (index == n) {
            // 转成题目要求的形式
            res.add(transform(n, row));
            return;
        }

        // 每行放一个，冲突的时候考虑列和对角线
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {

                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueeu(n, index + 1, row);

                row.remove(row.size() - 1);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
            }
        }
    }

    private List<String> transform(int n, List<Integer> row) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (row.get(i) == j) {
                    s.append("Q");
                } else {
                    s.append(".");
                }
            }
            res.add(s.toString());
        }
        return res;
    }
}

