package lab.zlren.leetcode.dp;

/**
 * @author zlren
 * @date 2018-03-28
 */
public class LC63UniquePathsII {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        };
        System.out.println(new LC63UniquePathsII().uniquePathsWithObstacles(nums));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // m行，n列
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        boolean stock = false;
        for (int i = 0; i < m; i++) {
            if (!stock && obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
                stock = true;
            }
        }

        stock = false;
        for (int i = 0; i < n; i++) {
            if (!stock && obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
                stock = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }

        return dp[m - 1][n - 1];
    }
}
