package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * 判断一棵树是否是BST
 * 注意BST不要只判断自己的左孩子和右孩子跟自己的值的大小关系
 * 要判断左子树的所有值和右子树的所有值
 *
 * @author zlren
 * @date 2017-12-03
 */
public class LC98ValidateBinarySearchTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(1);

        System.out.println(new LC98ValidateBinarySearchTree().isValidBST(root));

    }

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.val <= maxVal(root.left)) {
            return false;
        }

        if (root.right != null && root.val >= minVal(root.right)) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    /**
     * 以node为根节点的树的所有节点的最小值
     *
     * @param node 不该为null
     * @return
     */
    private int minVal(TreeNode node) {

        if (node.left == null && node.right == null) {
            return node.val;
        }

        if (node.left == null) {
            return Math.min(node.val, minVal(node.right));
        }

        if (node.right == null) {
            return Math.min(node.val, minVal(node.left));
        }

        return Math.min(Math.min(node.val, minVal(node.left)), minVal(node.right));
    }

    /**
     * 以node为根节点的树的所有节点的最大值
     *
     * @param node 不该为null
     * @return
     */
    private int maxVal(TreeNode node) {

        if (node.left == null && node.right == null) {
            return node.val;
        }

        if (node.left == null) {
            return Math.max(node.val, maxVal(node.right));
        }

        if (node.right == null) {
            return Math.max(node.val, maxVal(node.left));
        }

        return Math.max(Math.max(node.val, maxVal(node.left)), maxVal(node.right));
    }
}
