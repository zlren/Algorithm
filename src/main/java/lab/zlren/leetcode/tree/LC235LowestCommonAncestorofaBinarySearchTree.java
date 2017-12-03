package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * 二叉搜索树中两个节点的最小公共祖先
 *
 * @author zlren
 * @date 2017-12-03
 */
public class LC235LowestCommonAncestorofaBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode temp = root;

        int pVal = p.val;
        int qVal = q.val;

        int max = Math.max(pVal, qVal);
        int min = Math.min(pVal, qVal);

        while (temp != null) {

            if (temp.val <= max && temp.val >= min) {
                return temp;
            }

            if (temp.val > max) {
                temp = temp.left;
            }

            if (temp.val < min) {
                temp = temp.right;
            }
        }

        return null;
    }

}
