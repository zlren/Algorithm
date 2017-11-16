package lab.zlren.leetcode.array;

import java.util.TreeSet;

/**
 * 这道题是非常好的一道题，维护一个窗口，分析窗口右边紧挨着的元素（研究对象）
 * 跟研究对象比较范围的题，可以使用treeSet的floor和ceil方法
 * floor(i)，set中比i小的元素中最大的那个
 * ceil(i)，set中比i大的元素中最小的那个
 * 查找floor和ceil的复杂度是lgn
 * blog
 *
 * @author zlren
 * @date 2017-11-15
 */
public class LC220ContainsDuplicateIII {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
    }

    /**
     * Math.abs(j - i) <= k
     * Math.abs(nums[j] - nums[i]) <= k
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums.length < 2 || k == 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            Long floor = set.floor((long) nums[i]);
            Long ceiling = set.ceiling((long) nums[i]);

            boolean exist = (floor != null && nums[i] - floor <= t) || (ceiling != null && ceiling - nums[i] <= t);

            if (exist) {
                return true;
            }

            set.add((long) nums[i++]);

            if (i > k) {
                set.remove((long) nums[i - k - 1]);
            }
        }
        return false;
    }
}
