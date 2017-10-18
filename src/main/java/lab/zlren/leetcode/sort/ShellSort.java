package lab.zlren.leetcode.sort;

import lab.zlren.leetcode.helper.ArrayHelper;

/**
 * @author zlren
 * @date 17/10/18
 */
public class ShellSort {


    /**
     * 希尔排序
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {

        int i;
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            // 这里为什么从gap开始？因为前[0..gap-1]的前gap个元素，分别是gap个子序列的首字符，而每个子序列的首字符在插入排序中是不用考虑的
            // 所以每当gap变换一次，需要排序的下表实际上就是gap..length-1
            for (int j = gap; j < nums.length; j++) {
                // 这里为了避免过多的交换操作进行了优化
                int tmp = nums[j];
                for (i = j; i >= gap && tmp < nums[i - gap]; i -= gap) {
                    nums[i] = nums[i - gap];
                }
                nums[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int[] nums = ArrayHelper.generateRandomArray(100, 100);
            sort(nums);
            if (!ArrayHelper.isSorted(nums)) {
                System.out.println("有问题");
            }
        }
    }

}
