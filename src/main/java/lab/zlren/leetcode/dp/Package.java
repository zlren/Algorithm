package lab.zlren.leetcode.dp;

/**
 * 01背包问题
 *
 * @author zlren
 * @date 2018-03-28
 */
public class Package {

    public static void main(String[] args) {
        System.out.println(new Package().knapsack(new int[]{1, 2, 3}, new int[]{6, 10, 12}, 5));
    }

    /**
     * 记忆化搜索
     */
    private int[][] memo;

    private int knapsack(int[] w, int[] v, int c) {

        memo = new int[w.length][c + 1];

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < c + 1; j++) {
                memo[i][j] = -1;
            }
        }

        return helper(w, v, w.length - 1, c);
    }

    private int helper(int[] w, int[] v, int index, int c) {

        if (index < 0 || c <= 0) {
            return 0;
        }

        if (memo[index][c] != -1) {
            return memo[index][c];
        }

        // 选择第index个
        int a = -1;
        if (c >= w[index]) {
            a = v[index] + helper(w, v, index - 1, c - w[index]);
        }

        // 不选择第index个
        int b = helper(w, v, index - 1, c);

        int res = Math.max(a, b);

        memo[index][c] = res;

        return res;
    }
}
