package lab.zlren.nowcoder.offer;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * 判断一棵二叉树是不是平衡二叉树
 *
 * @author zlren
 * @date 2018-01-01
 */
public class IsBalanced {


    private boolean isBalanced = true;

    public boolean isbalancedSolution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }

    /**
     * 本质是在求树的深度，这个过程中捎带检查了是否是平衡的
     *
     * @param root
     * @return
     */
    private int getDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return Math.max(left, right) + 1;
    }

}
