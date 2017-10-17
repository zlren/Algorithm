package lab.zlren.leetcode.helper;

import java.util.Random;

/**
 * @author zlren
 * @date 17/10/17
 */
public class ArrayHelper {

    public static void main(String[] args) {
        int[] array = generateRandomArray(4, 2, 5);
        printArray(array);
    }

    /**
     * SortTestHelper不允许产生任何实例
     */
    private ArrayHelper() {
    }

    /**
     * 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
     *
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;

        int[] arr = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }

        return arr;
    }

    /**
     * 仅指定右边界，左边界默认为0
     *
     * @param n
     * @param rangeR
     * @return
     */
    public static int[] generateRandomArray(int n, int rangeR) {
        return generateRandomArray(n, 0, rangeR);
    }

    /**
     * 打印arr数组的所有内容
     *
     * @param arr
     */
    public static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }

        System.out.println();
    }

    /**
     * 交换数组下标为 i 和 j 的数值
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {

        assert 0 <= i && i <= nums.length - 1;
        assert 0 <= j && j <= nums.length - 1;

        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
