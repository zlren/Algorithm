package lab.zlren.leetcode.array;

import java.util.Arrays;

/**
 * @author zlren
 * @date 2018-03-25
 */
public class LC581ShortestUnsortedContinuousSubarray {



    public int findUnsortedSubarray(int[] nums) {

        int[] bak = new int[nums.length];
        System.arraycopy(nums, 0, bak, 0, nums.length);
        Arrays.sort(bak);

        int i = 0;
        while (i <= nums.length - 1 && nums[i] == bak[i]) {
            i++;
        }

        if (i == nums.length) {
            return 0;
        }

        int j = 0;
        while (j >= nums.length && nums[j] == bak[j]) {
            j--;
        }

        if (j == -1) {
            return 0;
        }

        return j - i + 1;
    }
}
