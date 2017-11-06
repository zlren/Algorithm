package lab.zlren.leetcode.array;

/**
 * 在数组中寻找第k大的元素
 * 利用快排的分区操作，将基准值放置在了其正确的位置上
 *
 * @author zlren
 * @date 2017-11-06
 */
public class LC215KthLargestElementInAnArray {

    public static void main(String[] args) {
        LC215KthLargestElementInAnArray lc215KthLargestElementInAnArray = new LC215KthLargestElementInAnArray();

        int[] array = {3, 2, 1, 5, 6, 4};
        System.out.println(lc215KthLargestElementInAnArray.findKthLargest(array, 2));
    }

    /**
     * 我们要找的是第n大的数，排完以后是从小到大排列
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        k = nums.length - k;

        int l = 0, r = nums.length - 1;

        int p = partition(l, r, nums);

        while (p != k) {
            if (p < k) {
                l = p + 1;
            } else if (p > k) {
                r = p - 1;
            }
            p = partition(l, r, nums);
        }

        return nums[k];
    }

    int partition(int l, int r, int[] nums) {

        // 取最左边的作为标准
        int v = nums[l];

        // i负责遍历，i指向即将考察的元素
        // 循环不变量
        // [l+1..j] < v
        // [j+1..i) > v  为什么不包括i呢？因为i是即将被考察的元素
        // j初始化为l，和标准值为同一个index，都是最左边
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            // if (nums[i] > v) {
            //     // 什么都不用做
            // } else
            if (nums[i] < v) {
                // 交换的是j+1和当前考察的元素，交换完j++
                swap(nums, j + 1, i);
                j++;
            }
        }

        swap(nums, l, j);

        return j;
    }

    public void swap(int[] nums, int i, int j) {

        assert 0 <= i && i <= nums.length - 1;
        assert 0 <= j && j <= nums.length - 1;

        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
