package lab.zlren.leetcode.array;

/**
 * @author zlren
 * @date 2017-11-06
 */
public class LC209MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {

        // [l..r]是窗口
        int l = 0, r = -1;
        int sum = 0;
        int ret = Integer.MAX_VALUE;

        while (l <= nums.length - 1) {
            if (r + 1 <= nums.length - 1 && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }

            if (sum >= s) {
                ret = Math.min(ret, r - l + 1);
            }
        }

        if (ret == Integer.MAX_VALUE) {
            return 0;
        }

        return ret;
    }

}
