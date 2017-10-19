package lab.zlren.leetcode.sort;

import lab.zlren.leetcode.helper.ArrayHelper;

/**
 * @author zlren
 * @date 17/10/18
 */
public class MergeSort {

    /**
     * 归并排序
     * 参数只有待排序数组，默认给整个数组排序
     * 但是里面要递归的方法不是这样的，所以新加一个递归方法，加上了左右索引
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 对 [l..r] 之间的数值进行归并排序
     * 要做的事情就是：排左边，排右边，合起来
     *
     * @param nums
     * @param l
     * @param r
     */
    public static void mergeSort(int[] nums, int l, int r) {

        // if (l >= r) {
        //     return;
        // }

        if (r - l <= 15) {
            // 使用插入排序
            InsertionSort.insertionSort2WithIndex(nums, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        // 排好
        // 前后两个有序子序列如果直接连起来就是有序的就省的排序了
        // 这种情况需要排序
        if (nums[mid] > nums[mid + 1]) {
            merge(nums, l, mid, r);
        }
    }

    /**
     * 左右两部分有序以后，将其归并成一个部分
     * 排序算法就是不断地从两个序列的头部取出较小的值
     *
     * @param nums
     * @param l
     * @param mid
     * @param r
     */
    public static void merge(int[] nums, int l, int mid, int r) {

        // [l..mid] 有序
        // [mid+1..r] 有序
        int[] numsNum = new int[r - l + 1];

        // i和j负责遍历两个有序的子序列
        int i = l, j = mid + 1;
        // k负责新的序列
        int k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                numsNum[k++] = nums[i++];
            } else {
                numsNum[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            numsNum[k++] = nums[i++];
        }

        while (j <= r) {
            numsNum[k++] = nums[j++];
        }

        System.arraycopy(numsNum, 0, nums, l, r - l + 1);
    }


    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            int[] nums = ArrayHelper.generateNearlyOrderedArray(1000);
            sort(nums);
            if (!ArrayHelper.isSorted(nums)) {
                System.out.println("有问题");
            }
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }

}
