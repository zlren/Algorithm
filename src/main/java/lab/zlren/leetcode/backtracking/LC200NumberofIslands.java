package lab.zlren.leetcode.backtracking;

/**
 * @author zlren
 * @date 2018-03-28
 */
public class LC200NumberofIslands {

    private int[][] d = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m, n;
    private boolean[][] visited;

    private boolean inArea(int x, int y) {
        return x >= 0 && x <= m - 1 && y >= 0 && y <= n - 1;
    }

    public int numIslands(char[][] grid) {

        m = grid.length;
        if (m == 0) {
            return 0;
        }

        n = grid[0].length;

        visited = new boolean[grid.length][grid[0].length];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    /**
     * 从grid[x][y]的位置开始，进行floodfill
     *
     * @param grid
     * @param x
     * @param y
     */
    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
    }
}
