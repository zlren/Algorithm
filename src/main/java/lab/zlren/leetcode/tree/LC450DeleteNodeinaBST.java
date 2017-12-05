package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * 二分搜索树中删除一个节点
 *
 * @author zlren
 * @date 2017-12-05
 */
public class LC450DeleteNodeinaBST {

    public static void main(String[] args) {

    }

    /**
     * 二分搜索树中删除一个节点
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        // 如果被删除的节点没有孩子，是叶子节点，直接删掉
        // 如果被删除的节点有一个孩子，让孩子替代自己
        // 如果被删除的节点D有两个孩子，那么替代自己的是右孩子的最小节点N，N的左孩子是被删除节点D的左孩子，
        // 右孩子是被删除节点D的右孩子（这里可能会由于在右子树上执行过删除最小节点的操作而发生改变）

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // 当前节点是要被删除的节点

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // 左右孩子都有，将自己的值设置为右子树的最小节点的值
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;

            // 递归的删除右子树中值为root.val的节点
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
