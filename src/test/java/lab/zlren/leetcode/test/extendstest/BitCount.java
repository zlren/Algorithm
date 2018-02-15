package lab.zlren.leetcode.test.extendstest;

import java.util.Arrays;

/**
 * @author zlren
 * @date 2018-02-03
 */
public class BitCount {

    public static void main(String[] args) {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        int[] heaters = {282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923};
        Arrays.sort(heaters);

        int target[] = {143542612};

        for (int targe : target) {
            System.out.println(new BitCount().helper(heaters, targe));

            int min = Integer.MAX_VALUE, k = 0;
            for (int i = 0; i < heaters.length; i++) {
                int heater = heaters[i];
                if (Math.abs(heater - targe) < min) {
                    min = Math.abs(heater - targe);
                    k = i;
                }
            }
            System.out.println(min);
        }

    }

    public int findRadius(int[] houses, int[] heaters) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) { // 每个加热器
            max = Math.max(max, helper(heaters, houses[i]));
        }
        return max;
    }

    // 二分法，为每个房子找到最近的加热器，计算这个距离
    // 所有的这些个距离，取最大值
    public int helper(int[] heaters, int target) {
        int left = 0, right = heaters.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (heaters[mid] == target) {
                break;
            } else if (heaters[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int a = Integer.MAX_VALUE;
        if (mid - 1 >= 0) {
            a = Math.abs(target - heaters[mid - 1]);
        }
        int b = Math.abs(target - heaters[mid]);
        int c = Integer.MAX_VALUE;
        if (mid + 1 <= heaters.length - 1) {
            c = Math.abs(target - heaters[mid + 1]);
        }

        return Math.min(a, Math.min(b, c));
    }
}
