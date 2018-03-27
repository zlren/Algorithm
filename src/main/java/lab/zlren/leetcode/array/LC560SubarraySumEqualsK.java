package lab.zlren.leetcode.array;

/**
 * @author zlren
 * @date 2018-03-24
 */
public class LC560SubarraySumEqualsK {

    public static void main(String[] args) {


        System.out.println(new LC560SubarraySumEqualsK().subarraySum(new int[]{1, 1, 2}, 2));
    }

    public int subarraySum(int[] nums, int k) {

        // 求所有和为k的子数组的个数
        int left = 0, right = 0, sum = nums[0];
        int count = 0;
        while (left <= right && right <= nums.length - 1) {
            if (sum == k) {
                count++;
                if (right < nums.length - 1) {
                    right++;
                    sum += nums[right];
                } else {
                    break;
                }
            } else if (sum < k) {
                right++;
                sum += nums[right];
            } else {
                sum -= nums[left];
                left++;
            }
        }
        return count;
    }
}
