package lab.zlren.leetcode.sort;

import lab.zlren.leetcode.helper.ArrayHelper;

import java.util.Random;

/**
 * @author zlren
 * @date 17/10/20
 */
public class QuickSort3Ways {

    public static void sort(int[] nums) {
        quickSort3(nums, 0, nums.length - 1);
    }


    /**
     * 三路快排
     *
     * @param nums
     * @param l
     * @param r
     */
    public static void quickSort3(int[] nums, int l, int r) {

        if (r - l <= 15) {
            InsertionSort.insertionSort2WithIndex(nums, l, r);
            return;
        }

        // 这里由于partition部分的操作要返回2个值，就不抽象为函数了，直接在这里排
        Random random = new Random();
        int vIndex = random.nextInt(r - l + 1) + l;
        ArrayHelper.swap(nums, l, vIndex);

        int v = nums[l];

        // [l+1..lt] < v，lt的初值一般是使得这个区间的值为空的那个临界值
        int lt = l;

        // [gt..r] > v
        int gt = r + 1;

        // [lt+1..i) == v
        int i = l + 1;

        while (i < gt) {
            if (nums[i] < v) {
                ArrayHelper.swap(nums, i, lt + 1);
                lt++;
                i++;
            } else if (nums[i] == v) {
                i++;
            } else if (nums[i] > v) {
                ArrayHelper.swap(nums, i, gt - 1);
                gt--;
                // 这时候i不要用，因为这时候i所指向的元素还没有被处理，是刚被换过来的
            }
        }

        // 标准值放在等于v的那部分元素的第一个位置
        ArrayHelper.swap(nums, l, lt);


        quickSort3(nums, l, lt - 1);
        quickSort3(nums, gt, r);
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
