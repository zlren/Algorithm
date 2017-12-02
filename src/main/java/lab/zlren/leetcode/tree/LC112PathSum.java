package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * 是否存在这样的一条路径，从跟到叶子节点，累加节点值为sum
 *
 * @author zlren
 * @date 2017-12-02
 */
public class LC112PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {

        // 经过当前节点，问题转化为是否在自己的左子树或者右子树存在这样的路径，它的值为 sum - root.val

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
