package lab.zlren.nowcoder.toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zlren
 * @date 2018-03-24
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line1 = scanner.nextLine();
        String[] split = line1.split(" ");
        int n = Integer.valueOf(split[0]);
        int k = Integer.valueOf(split[1]);

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(findKPair(nums, k));
    }

    private static int findKPair(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i; j < nums.length; j++) {
                int target = nums[j] - nums[i];
                if (target == k) {
                    count++;
                    break;
                } else if (target > k) {
                    break;
                }
            }
        }
        return count;
    }

}
