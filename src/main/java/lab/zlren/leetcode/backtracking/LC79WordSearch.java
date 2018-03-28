package lab.zlren.leetcode.backtracking;

/**
 * 二维平面寻找单词，一个字符只能使用一次
 *
 * @author zlren
 * @date 2018-03-28
 */
public class LC79WordSearch {

    public static void main(String[] args) {

    }

    private int[][] d = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 在board[startX][startY]开始，寻找word[index..]
     *
     * @param board
     * @param word
     * @param index
     * @param startX
     * @param startY
     * @return
     */
    private boolean searchWord(char[][] board, String word, int index, int startX, int startY) {
        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }
        if (board[startX][startY] == word.charAt(index)) {
            visited[startX][startY] = true;
            // 四个方向
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                if (inArea(board, newX, newY) && !visited[newX][newY]) {
                    if (searchWord(board, word, index + 1, newX, newY)) {
                        return true;
                    }
                }
            }
            visited[startX][startY] = false;
        }

        return false;
    }

    private boolean inArea(char[][] board, int x, int y) {
        return x >= 0 && x <= board.length - 1 && y >= 0 && y <= board[0].length - 1;
    }
}
