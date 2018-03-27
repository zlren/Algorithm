package lab.zlren.nowcoder.toutiao;

import java.util.Scanner;

public class Main2 {

    private static int minStep = 10000;

    private static void helper(int n, int s, int m, int step) {
        if (s == n) {
            minStep = Math.min(step, minStep);
            return;
        }
        if (s + m > n) {
            return;
        }

        helper(n, s * 2, s, step + 1);
        helper(n, s + m, m, step + 1);
    }

    private static void work(int n) {
        helper(n, 1, 1, 0);
        System.out.println(minStep);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        work(n);
    }
}