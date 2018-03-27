package lab.zlren.nowcoder.toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huang on 2018/3/24.
 */
public class Main5 {

    private int[] arr;
    private int n;
    private int k;
    private int h;
    private int[][] f;
    private int maxH = 0;

    private void dfs(int curH, int pos, int step) {
        maxH = Math.max(curH, maxH);
        if (step == k) {
            return;
        }
        if (pos >= 0 && curH <= f[pos][step]) {
            return;
        }
        if (pos >= 0) {
            f[pos][step] = curH;
        }
        for (int i = pos + 1; i < n; i++) {
            if (curH >= arr[i]) {
                continue;
            }
            if (curH + h >= arr[i]) {
                dfs(arr[i] * 2 - curH, i, step + 1);
            } else {
                return;
            }
        }
    }

    private void work() {
        Arrays.sort(arr);
        f = new int[n][k];
        dfs(0, -1, 0);
        System.out.println(maxH);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main5 s = new Main5();
        s.n = scanner.nextInt();
        s.k = scanner.nextInt();
        s.h = scanner.nextInt();
        s.arr = new int[s.n];
        for (int i = 0; i < s.n; i++) {
            s.arr[i] = scanner.nextInt();
        }
        s.work();
    }
}