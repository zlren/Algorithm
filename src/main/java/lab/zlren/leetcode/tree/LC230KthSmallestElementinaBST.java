package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * 返回二叉搜索树中第k小的元素
 *
 * @author zlren
 * @date 2017-12-05
 */
public class LC230KthSmallestElementinaBST {

    int c = 0;
    boolean goon = true;
    int result = 0;

    /**
     * 二叉树的中序遍历结果是有序的
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        midOrder(root, k);
        return result;
    }

    private void midOrder(TreeNode node, int k) {

        // 设置goon是为了及时的失败，减少无用功
        if (node != null && goon) {
            midOrder(node.left, k);
            c++;
            if (c == k) {
                result = node.val;
                goon = false;
            }
            midOrder(node.right, k);
        }
    }
}
