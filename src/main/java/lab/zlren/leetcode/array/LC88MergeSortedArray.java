package lab.zlren.leetcode.array;

/**
 * 给定两个有序数组nums1和nums2，将nums2的元素归并到nums1中
 *
 * @author zlren
 * @date 2017-11-06
 */
public class LC88MergeSortedArray {

    /**
     * 从后往前遍历，将二者的最大值拿过来
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m + n - 1;
        int j = m - 1;
        int k = n - 1;

        while (i >= 0) {
            if (j >= 0 && k >= 0) {
                if (nums1[j] > nums2[k]) {
                    nums1[i] = nums1[j];
                    j--;
                } else {
                    nums1[i] = nums2[k];
                    k--;
                }
            } else if (j >= 0) {
                nums1[i] = nums1[j];
                j--;
            } else if (k >= 0) {
                nums1[i] = nums2[k];
                k--;
            }
            i--;
        }
    }
}
