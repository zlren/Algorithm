package lab.zlren.others;

import java.util.Arrays;

/**
 * @author zlren
 * @date 2018-03-04
 */
public class AllRange {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        permute(nums, 0);
    }

    /**
     * array[start...len-1]部分进行全排列
     *
     * @param array
     * @param start
     */
    private static void permute(int[] array, int start) {
        if (start == array.length) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = start; i < array.length; ++i) {
                swap(array, start, i);
                permute(array, start + 1);
                swap(array, start, i);
            }
        }
    }

    private static void swap(int[] array, int s, int i) {
        int t = array[s];
        array[s] = array[i];
        array[i] = t;
    }

}
