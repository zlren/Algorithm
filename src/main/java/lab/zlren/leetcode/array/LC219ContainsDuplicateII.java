package lab.zlren.leetcode.array;

/**
 * 滑动窗口+查找表
 *
 * @author zlren
 * @date 2017-11-13
 */
public class LC219ContainsDuplicateII {
    public static void main(String[] args) {

        LC219ContainsDuplicateII lc219ContainsDuplicateII = new LC219ContainsDuplicateII();
        int[] nums = {1, 0, 1, 1};
        System.out.println(lc219ContainsDuplicateII.containsNearbyDuplicate(nums, 1));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null || nums.length < 2) {
            return false;
        }

        int l = 0, r = 1;
        while (l <= nums.length - 1) {

            if (l < r && nums[l] == nums[r]) {
                return true;
            }

            if (r < nums.length - 1) {
                if (r - l < k) {
                    r++;
                } else {
                    l++;
                }
            } else {
                l++;
            }
        }

        return false;
    }
}
