package lab.zlren.leetcode.dp;

/**
 * @author zlren
 * @date 2018-03-28
 */
public class PackageDp {

    public static void main(String[] args) {
        System.out.println(new PackageDp().knapsack(new int[]{1, 2, 3}, new int[]{6, 10, 12}, 5));
    }

    private int knapsack(int[] w, int[] v, int c) {
        assert w.length == v.length;

        int n = w.length;

        int[][] dp = new int[n][c + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c + 1; j++) {
                dp[i][j] = -1;
            }
        }

        for (int j = 0; j < c + 1; j++) {
            dp[0][j] = (j >= w[0] ? v[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < c + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }

        return dp[n - 1][c];
    }
}
