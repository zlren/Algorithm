package lab.zlren.nowcoder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int count = 0;
        for (int y = k + 1; y <= n; y++) {
            for (int z = k; z <= y - 1; z++) {
                count += ((n - z) / y + 1);
            }
        }
        System.out.println(count);
    }
}
