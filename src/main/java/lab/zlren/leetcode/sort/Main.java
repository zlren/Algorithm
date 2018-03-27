package lab.zlren.leetcode.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zlren
 * @date 2018-03-23
 */
public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int k = Integer.valueOf(in.nextLine());

        int[] x = new int[4];
        int[] y = new int[4];

        for (int i = 0; i < k; i++) {

            String l1 = in.nextLine();
            String l2 = in.nextLine();

            String[] split = l1.split(" ");
            for (int j = 0; j < split.length; j++) {
                x[j] = Integer.valueOf(split[j]);
            }

            split = l2.split(" ");
            for (int j = 0; j < split.length; j++) {
                y[j] = Integer.valueOf(split[j]);
            }

            System.out.println(helper(x, y));
        }

    }

    private static String helper(int[] x, int[] y) {

        int[] len = new int[6];
        int k = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = i + 1; j <= 3; j++) {
                len[k++] = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
            }
        }

        Arrays.sort(len);

        if (len[0] == len[1] && len[1] == len[2] && len[2] == len[3] && len[3] < len[4] && len[4] == len[5]) {
            return "Yes";
        }

        return "No";
    }
}
