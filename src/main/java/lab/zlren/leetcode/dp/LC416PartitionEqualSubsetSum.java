package lab.zlren.leetcode.dp;

import java.util.Arrays;

/**
 * @author zlren
 * @date 2018-03-28
 */
public class LC416PartitionEqualSubsetSum {

    public static void main(String[] args) {
        System.out.println(new LC416PartitionEqualSubsetSum().canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100}));
    }


    private int[][] memo;

    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return false;
        }

        if (nums.length == 2) {
            return nums[0] == nums[1];
        }

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 0) {
            memo = new int[nums.length][sum / 2 + 1];
            for (int i = 0; i < memo.length; i++) {
                for (int j = 0; j < memo[0].length; j++) {
                    memo[i][j] = -1;
                }
            }
            return helper(nums, nums.length - 1, sum / 2);
        }

        return false;
    }

    private boolean helper(int[] nums, int index, int c) {

        if (c < 0) {
            return false;
        }

        if (index == -1) {
            return c == 0;
        }

        if (memo[index][c] != -1) {
            return memo[index][c] == 1;
        }

        boolean a = helper(nums, index - 1, c);

        boolean b = false;
        if (c >= nums[index]) {
            b = helper(nums, index - 1, c - nums[index]);
        }

        boolean res = a || b;
        memo[index][c] = res ? 1 : 0;

        return res;
    }
}
