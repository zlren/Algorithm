package lab.zlren.leetcode.array;

import java.util.Arrays;

/**
 * @author zlren
 * @date 17/10/11
 */
public class LC283MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 13};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 空间复杂度 On
     *
     * @param nums
     */
    private static void moveZeroes(int[] nums) {

        int[] numsNoZero = new int[nums.length];
        int j = 0;

        for (int num : nums) {
            if (num != 0) {
                numsNoZero[j++] = num;
            }
        }

        // for (int i = j; i < nums.length; i++) {
        //     numsNoZero[i] = 0; // 其实可以不用做，java默认就是0
        // }

        System.arraycopy(numsNoZero, 0, nums, 0, nums.length);
    }

    /**
     * 不使用辅助空间，原地操作
     *
     * @param nums
     */
    private static void moveZeroes2(int[] nums) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }

            if (i > k) {
                nums[i] = 0;
            }
        }
    }
}
