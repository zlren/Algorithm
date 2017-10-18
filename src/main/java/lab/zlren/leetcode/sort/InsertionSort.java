package lab.zlren.leetcode.sort;

import lab.zlren.leetcode.helper.ArrayHelper;


/**
 * 插入排序
 *
 * @author zlren
 * @date 17/10/18
 */
public class InsertionSort {

    /**
     * 插入排序
     * 虽然插入排序有可能提前结束一轮排序，但是在排序的过程中具有多次的交换操作，这是比较耗时的
     *
     * @param nums
     */
    public static void insertionSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    ArrayHelper.swap(nums, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 插入排序改进，减少交换操作
     *
     * @param nums
     */
    public static void insertionSort2(int[] nums) {

        int bak;
        for (int i = 1; i < nums.length; i++) {
            bak = nums[i];

            for (int j = i - 1; j >= 0; j--) {
                if (bak < nums[j]) {
                    nums[j + 1] = nums[j];
                } else {
                    nums[j] = bak;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = ArrayHelper.generateNearlyOrderedArray(100000);
        int[] nums2 = new int[nums.length];
        System.arraycopy(nums, 0, nums2, 0, nums.length);

        long startTime = System.currentTimeMillis();
        SelectionSort.sort(nums);
        System.out.println(System.currentTimeMillis() - startTime);

        long startTime2 = System.currentTimeMillis();
        insertionSort2(nums2);
        System.out.println(System.currentTimeMillis() - startTime2);
    }
}
