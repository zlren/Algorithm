package lab.zlren.leetcode.sort;

import lab.zlren.leetcode.helper.ArrayHelper;

import java.util.Random;

/**
 * @author zlren
 * @date 17/10/19
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }


    /**
     * 快排的递归函数
     * 需要做三件事
     * 1 将第一个数字找到它所在的索引，即分区
     * 2 快排左边的
     * 3 快排右边的
     *
     * @param nums
     * @param l
     * @param r
     */
    private static void quickSort(int[] nums, int l, int r) {

        // if (l >= r) {
        //     return;
        // }

        if (r - l <= 15) {
            InsertionSort.insertionSort2WithIndex(nums, l, r);
            return;
        }

        // 分区
        int p = partition(nums, l, r);

        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }

    /**
     * 分区操作
     *
     * @param nums
     * @param l
     * @param r
     * @return nums[l..p-1] < nums[p] && nums[p] < nums[p+1..r]
     */
    private static int partition(int[] nums, int l, int r) {

        // vIndex是随机选择的基准值的下标，将它和最左侧的交换，然后再继续..
        int vIndex = new Random().nextInt(r - l + 1) + l;
        ArrayHelper.swap(nums, l, vIndex);

        // 取最左边的作为标准
        int v = nums[l];

        // i负责遍历，i指向即将考察的元素
        // 循环不变量
        // [l+1..j] < v
        // [j+1..i) > v  为什么不包括i呢？因为i是即将被考察的元素
        // j初始化为l，和标准值为同一个index，都是最左边
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            // if (nums[i] > v) {
            //     // 什么都不用做
            // } else
            if (nums[i] < v) {
                // 交换的是j+1和当前考察的元素，交换完j++
                ArrayHelper.swap(nums, j + 1, i);
                j++;
            }
        }

        ArrayHelper.swap(nums, l, j);

        return j;
    }


    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            int[] nums = ArrayHelper.generateRandomArray(1000, 10);
            sort(nums);
            if (!ArrayHelper.isSorted(nums)) {
                System.out.println("有问题");
            }
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }
}
