package lab.zlren.others.tencent;

import java.util.Scanner;

/**
 * @author zlren
 * @date 2018-04-05
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long k = n / (2 * m);
        System.out.println(k * m * m);
    }
}
