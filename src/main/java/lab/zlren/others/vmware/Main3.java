package lab.zlren.others.vmware;

import java.util.Scanner;

/**
 * @author zlren
 * @date 2018-04-27
 */
public class Main3 {

    private static boolean flag[][];

    private static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] data = new int[n][m];
        flag = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = scanner.nextInt();
            }
        }

        // int result = 0;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         for (int k = 0; k < n; k++) {
        //             Arrays.fill(flag[k], false);
        //         }
        //         result = Math.max(result, helper(data, n, m, i, j, 1));
        //     }
        // }

        System.out.println(helper(data, n, m, 1, 1, 1));
    }

    private static int helper(int[][] data, int n, int m, int i, int j, int cur) {

        for (int k = 0; k < 4; k++) {
            int newx = i + dir[k][0];
            int newy = j + dir[k][1];
            if (isvalid(newx, newy, n, m) && !flag[newx][newy] && data[i][j] > data[newx][newy]) {
                flag[newx][newy] = true;
                cur = Math.max(cur, helper(data, n, m, newx, newy, cur + 1));
                flag[newx][newy] = false;
            }
        }

        return cur;
    }

    private static boolean isvalid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

}
