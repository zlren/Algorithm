package lab.zlren.leetcode.sort;

import lab.zlren.leetcode.helper.ArrayHelper;

import java.util.Random;

/**
 * 利用快排思想的分区操作，找到数组中第n大的值
 *
 * @author zlren
 * @date 17/10/20
 */
public class NthMaxWithQuickSort {

    /**
     * 从数组中找到第n大的元素
     *
     * @param nums
     * @param n
     * @return
     */
    public static int solution(int[] nums, int n) {

        int l = 0, r = nums.length - 1;
        int p = partition(nums, l, r);
        while (p != n - 1) {
            if (p < n - 1) {
                l = p + 1;
            } else {
                r = p - 1;
            }
            p = partition(nums, l, r);
        }

        return nums[n - 1];
    }

    public static int partition(int[] nums, int l, int r) {

        if (l >= r) {
            return l;
        }

        Random random = new Random();
        int vIndex = random.nextInt(r - l + 1) + l;
        ArrayHelper.swap(nums, l, vIndex);

        int v = nums[l];
        // [l+1..j]<v [j+1..i)>v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < v) {
                ArrayHelper.swap(nums, i, j + 1);
                j++;
            }
        }

        ArrayHelper.swap(nums, l, j);
        return j;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}, 2));
    }
}
