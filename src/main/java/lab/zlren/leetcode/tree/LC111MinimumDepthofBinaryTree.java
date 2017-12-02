package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * 二叉树的最小深度
 * 根到所有的叶子节点的深度中最小的那个
 *
 * @author zlren
 * @date 2017-12-02
 */
public class LC111MinimumDepthofBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);

        System.out.println(new LC111MinimumDepthofBinaryTree().minDepth(root));

    }

    public int minDepth(TreeNode root) {

        // 空返回0
        if (root == null) {
            return 0;
        }

        // 叶子返回1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // 只有一个孩子，我的高度就是那个孩子的+1
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // 两个孩子都有，少的那个+1
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
