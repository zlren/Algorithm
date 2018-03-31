package lab.zlren.leetcode.tree;


/**
 * 二叉树的最近公共祖先
 * LCA问题
 *
 * @author zlren
 * @date 2018-03-30
 */
public class LC236LCAofaBinaryTree {

    public Node lowestCommonAncestor(Node root, Node p, Node q) {

        // 注意找到的条件是root == p，而不是root.val == p.val
        // 找到一个就返回自己，为null表示一个都没找到
        if (root == null || root == p || root == q) {
            return root;
        }

        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }
}
