package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * 二叉树的对称性
 *
 * @author zlren
 * @date 2017-12-02
 */
public class LC101SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    /**
     * 判断一颗二叉树的左右两子节点是否对称
     *
     * @param leftNode  左子节点
     * @param rightNode 右子节点
     * @return true：对称 false：不对称
     */
    public boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (
                (leftNode != null && rightNode == null) ||
                        (leftNode == null && rightNode != null) ||
                        leftNode.val != rightNode.val ||
                        !isMirror(leftNode.left, rightNode.right) ||
                        !isMirror(leftNode.right, rightNode.left)) {
            return false;
        } else {
            return true;
        }
    }

}
