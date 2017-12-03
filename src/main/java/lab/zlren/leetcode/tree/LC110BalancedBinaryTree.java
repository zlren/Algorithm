package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * 判断一棵树是否是平衡二叉树
 * 什么是平衡二叉树？左右子树的节点的高度差值不超过1
 *
 * @author zlren
 * @date 2017-12-02
 */
public class LC110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int diff = depth(root.left) - depth(root.right);

        if (Math.abs(diff) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 计算树的高度
     *
     * @param node
     * @return
     */
    private int depth(TreeNode node) {

        if (node == null) {
            return 0;
        }

        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}
