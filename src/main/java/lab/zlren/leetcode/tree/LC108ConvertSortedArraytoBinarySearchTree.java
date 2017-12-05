package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * 将一个有序数组转为一个平衡的二叉搜索树
 *
 * @author zlren
 * @date 2017-12-05
 */
public class LC108ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        return fun(nums, 0, nums.length - 1);
    }

    /**
     * 非常优秀的递归设计，是我自己想出来的
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private TreeNode fun(int[] nums, int l, int r) {

        assert l <= r;

        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        if (l <= mid - 1) {
            node.left = fun(nums, l, mid - 1);
        }

        if (mid + 1 <= r) {
            node.right = fun(nums, mid + 1, r);
        }

        return node;
    }
}
