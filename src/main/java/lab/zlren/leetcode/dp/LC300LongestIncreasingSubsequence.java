package lab.zlren.leetcode.dp;

import java.util.Arrays;

/**
 * 最长上升子序列
 *
 * @author zlren
 * @date 2018-03-28
 */
public class LC300LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(new LC300LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

public int lengthOfLIS(int[] nums) {

    // dp[i]表示以i结尾的最长上升子序列的长度
    // 状态转移方程：dp[i] = max(1 + dp[j]) if nums[i] > nums[j] (对于所有的j需要满足j<i）

    if (nums == null || nums.length == 0) {
        return 0;
    }

    if (nums.length == 1) {
        return 1;
    }

    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);

    dp[0] = 1;

    int max = 0;

    for (int i = 1; i < nums.length; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        max = Math.max(max, dp[i]);
    }

    return max;
}

}
