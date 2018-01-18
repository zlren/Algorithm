package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

/**
 * @author zlren
 * @date 2018-01-18
 */
public class BTSDeleteNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        int k = 2;
        for (int i = 1; i <= k; i++) {
            TreeNode node = root;
            while (node.left != null) {
                node = node.left;
            }
            if (i == k) {
                System.out.println("第k个节点是：" + node.val);
            }
            root = delete(root, node.val);
        }

        System.out.println(1);

    }

    /**
     * 返回删除节点后的根节点
     * 如果不返回的话，假设删除了根节点就不好办了
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode delete(TreeNode root, int val) {

        TreeNode parent = null, node = root;

        // 首先找到与val相等的即要被删除的节点
        while (node != null) {
            if (node.val == val) {
                break;
            } else {
                parent = node;
                if (node.val < val) {
                    node = parent.right;
                } else { // node.val > val
                    node = parent.left;
                }
            }
        }

        // 没有找到与val相等的节点
        if (node == null) {
            return root;
        }

        // node是要被删除的节点
        if (node.left == null) {
            // node的左子树为空，把右子树替代自己，挂到parent上

            // parent为null表示node是root，后面都要这样判断
            if (parent == null) {
                return node.right;
            } else {
                // 判断node是parent的左孩子还是右孩子
                if (parent.left == node) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
            }
        } else if (node.right == null) {
            if (parent == null) {
                return node.left;
            } else {
                if (parent.left == node) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
            }
        } else {

            // 这里不用判断parent是不是null，因为即使node就是root，但是我们不删除，仅仅是替换值

            // node的左右子树都不是null
            // node的右子树的最小节点来替代自己
            TreeNode temp = node.right, tempParent = node;
            while (temp.left != null) {
                tempParent = temp;
                temp = temp.left;
            }

            // 找完以后还要判断一下tempParent和node的关系
            if (tempParent == node) {
                // 说明temp直接就是node的右孩子，且没有进入while循环
                node.right = temp.right;
            } else {
                // temp肯定是tempParent的左孩子，且temp没有左孩子，temp可能有右孩子
                tempParent.left = temp.right;
            }

            node.val = temp.val;
        }

        return root;
    }
}
