package lab.zlren.leetcode.sort;

import java.util.Arrays;

/**
 * @author zlren
 * @date 2018-03-05
 */
public class QuickSortEasy {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 1, 7, 2, 6};
        System.out.println(partition(nums, 0, nums.length - 1));
        System.out.println(Arrays.toString(nums));
    }

    public static int partition(int[] nums, int l, int r) {

        // 取最左边的作为标准
        int v = nums[l];

        while (l < r) {
            while (nums[r] >= v & l < r) {
                r--;
            }
            nums[l] = nums[r];

            while (nums[l] <= v && l < r) {
                l++;
            }
            nums[r] = nums[l];
        }

        nums[r] = v;

        return r;
    }
}
