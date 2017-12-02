package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * 反转一棵二叉树
 *
 * @author zlren
 * @date 2017-12-02
 */
public class LC226InvertBinaryTree {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {

        if (root != null) {

            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;

            invertTree(root.left);
            invertTree(root.right);
        }

        return root;
    }
}
