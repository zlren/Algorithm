package lab.zlren.leetcode.test.mergetest;

import java.util.Arrays;

/**
 * @author zlren
 * @date 2017-12-29
 */
public class MergeTest {

    private static int count = 0;

    public static void main(String[] args) {

        int[] nums = {1, 3, 2, 6, 4, 7, 5};
        new MergeTest().mergeHelper(0, nums.length - 1, nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(count);
    }

    // public int InversePairs(int[] array) {
    //
    // }

    private void mergeHelper(int left, int right, int[] array) {
        
    }
}
