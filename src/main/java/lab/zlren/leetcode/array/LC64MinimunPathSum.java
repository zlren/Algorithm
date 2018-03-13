package lab.zlren.leetcode.array;

/**
 * @author zlren
 * @date 2018-03-13
 */
public class LC64MinimunPathSum {

    public int minPathSum(int[][] grid) {

        int rows = grid.length, cols = grid[0].length;

        for (int i = rows - 2; i >= 0; i--) {
            grid[i][cols - 1] += grid[i + 1][cols - 1];
        }

        for (int j = cols - 2; j >= 0; j--) {
            grid[rows - 1][j] += grid[rows - 1][j + 1];
        }

        for (int j = cols - 2; j >= 0; j--) {
            for (int i = rows - 2; i >= 0; i--) {
                grid[i][j] += Math.min(grid[i][j + 1], grid[i + 1][j]);
            }
        }

        return grid[0][0];
    }

}
