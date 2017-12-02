package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * 计算一棵完全二叉树的节点个数
 *
 * @author zlren
 * @date 2017-12-02
 */
public class LC222CountCompleteTreeNodes {

    public static void main(String[] args) {

        System.out.println(1 << 3);
    }

    public int countNodes(TreeNode root) {

        // 一个完全二叉树，会有一棵满二叉树子树，这部分可以整体计算

        if (root == null) {
            return 0;
        }

        TreeNode left = root, right = root;
        int height = 0;

        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }

        if (left == null) {
            // 1<<n的值就是2^n
            return (1 << height) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
