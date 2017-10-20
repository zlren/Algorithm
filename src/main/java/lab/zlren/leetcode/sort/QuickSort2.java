package lab.zlren.leetcode.sort;

import lab.zlren.leetcode.helper.ArrayHelper;

import java.util.Random;

/**
 * 优化待排数组重复值较多的情况
 * 将和基准值相同的值分散在左右两侧
 *
 * @author zlren
 * @date 17/10/20
 */
public class QuickSort2 {

    public static void sort(int[] nums) {
        quickSort2(nums, 0, nums.length - 1);
    }

    public static void quickSort2(int[] nums, int l, int r) {

        if (r - l <= 15) {
            InsertionSort.insertionSort2WithIndex(nums, l, r);
            return;
        }

        int p = partition2(nums, l, r);
        quickSort2(nums, l, p - 1);
        quickSort2(nums, p + 1, r);
    }


    /**
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public static int partition2(int[] nums, int l, int r) {
        Random random = new Random();
        int vIndex = random.nextInt(r - l + 1) + l;
        ArrayHelper.swap(nums, l, vIndex);

        int v = nums[l];

        // [l+1..i) <= v && (j..r] >= v
        // i和j这样的初始值使得上面两部分开始都是空的
        int i = l + 1, j = r;
        while (true) {

            while (i <= r && nums[i] < v) {
                i++;
            }

            while (j >= l + 1 && nums[j] > v) {
                j--;
            }

            if (i > j) {
                break;
            }

            ArrayHelper.swap(nums, i, j);
            i++;
            j--;
        }

        // 循环结束以后j的位置排在了i的前面，j是最后一个小于等于v的位置
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
