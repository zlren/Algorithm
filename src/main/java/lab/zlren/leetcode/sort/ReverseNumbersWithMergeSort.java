package lab.zlren.leetcode.sort;

/**
 * 利用归并排序过程求解逆序对个数
 *
 * @author zlren
 * @date 17/10/20
 */
public class ReverseNumbersWithMergeSort {

    private static int result = 0;

    private static int solution(int[] nums) {

        mergeSort(nums, 0, nums.length - 1);

        return result;
    }

    private static void mergeSort(int[] nums, int l, int r) {

        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        mergeArray(nums, l, mid, r);
    }

    /**
     * [l..mid] vs [mid+1..r] --> [l..r]
     *
     * @param nums
     * @param l
     * @param mid
     * @param r
     */
    private static void mergeArray(int[] nums, int l, int mid, int r) {

        int[] numsBak = new int[r - l + 1];
        int k = 0;

        int i = l, j = mid + 1;

        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                // 放i的时候要看已经放完的j的个数，放j的时候就不要统计了，会重复
                numsBak[k++] = nums[i++];
                result += (j - mid - 1);
            } else {
                numsBak[k++] = nums[j++];
            }
        }

        // 下面两个while二选一
        while (i <= mid) {
            // 如果到这里说明j已经放完了
            numsBak[k++] = nums[i++];
            result += (r - mid);
        }

        while (j <= r) {
            numsBak[k++] = nums[j++];
        }

        System.arraycopy(numsBak, 0, nums, l, numsBak.length);
    }

    public static void main(String[] args) {

        int[] nums = {7, 5, 6, 4};
        System.out.println(solution(nums));
    }
}
