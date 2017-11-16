package lab.zlren.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口 + 查找表
 * blog
 *
 * @author zlren
 * @date 2017-11-13
 */
public class LC219ContainsDuplicateII {

    public static void main(String[] args) {

        LC219ContainsDuplicateII lc219ContainsDuplicateII = new LC219ContainsDuplicateII();
        int[] nums = {1, 2, 1};
        System.out.println(lc219ContainsDuplicateII.containsNearbyDuplicate2(nums, 0));
    }

    /**
     * 这里我只使用了滑动窗口，但是没有使用查找表，现在有点疑惑，虽然也 AC 了但是感觉不太对。。
     * <p>
     * 使用查找表的话可以维护一个窗口大小固定为k的窗口，记录下来这个窗口中存在的值，这里用set比较好，然后分析窗口右边的一个元素，
     * 如果在窗口中存在就找到，没有就窗口向右移动一位，维护窗口对应的set即可
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null || nums.length < 2 || k < 1) {
            return false;
        }

        int l = 0, r = 1;
        // 注意在左右指针移动的时候存在重合的情况，但是这种情况并不满足题意
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

    /**
     * 滑动窗口 + 查找表
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {

        if (nums == null || nums.length < 2 || k < 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();

        // 最右边与最左边的距离最多是k
        if (nums.length <= k + 1) {
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                } else {
                    set.add(nums[i]);
                }
            }
            return false;
        }

        set.clear();

        // 维护窗口的大小为k，右边index减去左边index的值为k-1，然后分析窗口右边紧挨着的那个元素
        for (int i = 0; i <= k - 1; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        int l = 0;
        for (int i = k; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.remove(nums[l]);
            l++;

            set.add(nums[i]);
        }

        return false;
    }


    public boolean containsNearbyDuplicate3(int[] nums, int k) {

        if (nums == null || nums.length < 2 || k < 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

}
