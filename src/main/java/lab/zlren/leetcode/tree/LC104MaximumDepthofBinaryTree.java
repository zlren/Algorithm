package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * 计算一棵二叉树的最大深度
 *
 * @author zlren
 * @date 2017-12-02
 */
public class LC104MaximumDepthofBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);

        System.out.println(new LC104MaximumDepthofBinaryTree().maxDepth(root));

    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
