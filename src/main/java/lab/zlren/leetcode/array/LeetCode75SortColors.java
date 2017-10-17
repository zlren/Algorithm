package lab.zlren.leetcode.array;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are
 * adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 *
 * @author zlren
 * @date 17/10/15
 */
public class LeetCode75SortColors {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 0, 0, 2, 1};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 计数排序
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {

        int[] count = new int[3];

        for (int num : nums) {
            assert num >= 0 && num <= 2;
            count[num] += 1;
        }

        for (int i = 0; i < count[0]; i++) {
            nums[i] = 0;
        }

        for (int i = count[0]; i < count[0] + count[1]; i++) {
            nums[i] = 1;
        }

        for (int i = count[0] + count[1]; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    /**
     * 只循环一遍数组，模拟一次三路快排
     *
     * @param nums
     */
    private static void sortColors2(int[] nums) {

        int left = 0, right = nums.length - 1, i = 0;

        while (i <= right) { // 注意这里的条件，i不能超过right
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
                // 注意这里没有i++，因为有可能换过来的是1，需要下一次将其换到左边
            } else {
                i++;
            }
        }
    }

    /**
     * 交换数组的两个值
     *
     * @param data
     * @param a
     * @param b
     */
    private static void swap(int[] data, int a, int b) {
        int t = data[a];
        data[a] = data[b];
        data[b] = t;
    }
}
