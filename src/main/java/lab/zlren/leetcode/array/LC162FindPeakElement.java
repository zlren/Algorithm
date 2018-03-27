package lab.zlren.leetcode.array;

import java.util.LinkedList;
import java.util.List;

/**
 * 寻找局部峰值
 *
 * @author zlren
 * @date 2018-03-24
 */
public class LC162FindPeakElement {

    public static void main(String[] args) {
        List<Integer> list = majorityElement(new int[]{1, 2, 2, 3, 2, 1, 1, 3});
        System.out.println(list);
    }

    public List<Integer> findDuplicates(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i]--;
        }

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                int cur = nums[i];
                while (cur != nums[cur]) {
                    int temp = nums[cur];
                    nums[cur] = cur;
                    cur = temp;
                }
            }
        }

        return null;
    }


    public static int findPeakElement(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int left = 0, right = nums.length - 1, mid;
        while (left < right) {

            mid = left + (right - left) / 2;

            // 如果nums[mid]比右侧小，证明右侧一定有一个峰值
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static List<Integer> majorityElement(int[] nums) {
        // 超过n/3的数字，最多有两个

        List<Integer> res = new LinkedList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        int val1 = 0, val2 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {

            if (val1 == num) {
                count1++;
            } else if (val2 == num) {
                count2++;
            } else if (count1 == 0) {
                val1 = num;
                count1++;
            } else if (count2 == 0) {
                val2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == val1) {
                count1++;
            } else if (num == val2) {
                count2++;
            }
        }

        int k = nums.length / 3;

        if (count1 > k) {
            res.add(val1);
        }
        if (count2 > k) {
            res.add(val2);
        }

        return res;
    }
}
