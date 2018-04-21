package lab.zlren.others.tencent;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zlren
 * @date 2018-04-05
 */
public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();

        int a = scanner.nextInt();
        int x = scanner.nextInt();
        int b = scanner.nextInt();
        int y = scanner.nextInt();

        List<Integer> aa = new LinkedList<>();
        List<Integer> bb = new LinkedList<>();

        for (int i = 0; i <= Math.min(k / a, x); i++) {
            int t = k - a * i;
            if (t / b <= y && t % b == 0) {
                aa.add(i);
                bb.add(t / b);
            }
        }

        int count = 0;
        for (Integer ai : aa) {
            for (Integer bi : bb) {
                count += (((long) C(ai, x) * (long) C(bi, y)) % 1000000007);
            }
        }

        System.out.println(count);
    }


    private static int C(int up, int below) {

        int helf = below / 2;
        if (up > helf) {
            up = below - up;
        }
        int denominator = A(up, up);
        int numerator = A(up, below);
        return numerator / denominator;
    }

    private static int A(int up, int bellow) {
        int result = 1;
        for (int i = up; i > 0; i--) {
            result *= bellow;
            bellow--;
        }
        return result;
    }
}
