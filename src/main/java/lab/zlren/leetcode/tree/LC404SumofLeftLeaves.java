package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * 所有左叶子节点的累加和
 * 左叶子，既是叶子，还是父亲的左孩子
 *
 * @author zlren
 * @date 2017-12-02
 */
public class LC404SumofLeftLeaves {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        preOrder(root);
        return sum;
    }

    public void preOrder(TreeNode node) {
        if (node != null) {

            if (node.left != null && node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            }

            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
