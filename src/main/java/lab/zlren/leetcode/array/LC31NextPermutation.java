package lab.zlren.leetcode.array;

/**
 * 全排列中下一次比自己大的值
 *
 * @author zlren
 * @date 2018-02-27
 */
public class LC31NextPermutation {

    private void swapList(int[] nums, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            swap(nums, k, (j - (k - i)));
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void nextPermutation(int[] nums) {
        // 从后往前找到第一个值A，这个值比它前面的值大，如果这样的值不存在的话就说明每个值都比前面的值小，这是最大的排列，也就不存在下一个比它大的值，记录下A前面的这个值的位置
        // 从后往前找到第一个值B，这个B比A大
        // 交换A和B
        // 逆序B后面的子序列
        if (nums == null || nums.length < 2) {
            return;
        }

        int len = nums.length;

        int a = -1;
        for (int i = len - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                a = i - 1; // !!
                break;
            }
        }

        // 已经是最大值了
        if (a == -1) {
            swapList(nums, 0, len - 1);
        } else {
            int b = -1;
            for (int i = len - 1; i >= 0; i--) {
                if (nums[i] > nums[a]) {
                    b = i;
                    break;
                }
            }
            swap(nums, a, b);

            // 逆序位置a之后的序列
            swapList(nums, a + 1, len - 1);
        }
    }
}
