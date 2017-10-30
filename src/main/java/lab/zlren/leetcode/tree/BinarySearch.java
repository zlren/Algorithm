package lab.zlren.leetcode.tree;

/**
 * @author zlren
 * @date 17/10/29
 */
public class BinarySearch {

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return 如果找到target，返回它在nums的索引，否则返回-1
     */
    public static int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        int mid;
        while (left <= right) {

            //
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
