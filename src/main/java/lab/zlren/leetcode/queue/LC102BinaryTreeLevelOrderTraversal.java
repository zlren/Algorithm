package lab.zlren.leetcode.queue;

import lab.zlren.leetcode.stack.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历二叉树
 *
 * @author zlren
 * @date 2017-11-26
 */
public class LC102BinaryTreeLevelOrderTraversal {

    private class MyTreeNode {
        int level;
        TreeNode node;

        public MyTreeNode(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    /**
     * 层序遍历的过程，还得记录下具体节点是哪一层的
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(new MyTreeNode(0, root));

        while (!queue.isEmpty()) {
            MyTreeNode myTreeNode = queue.poll();
            int level = myTreeNode.level;

            if (res.size() <= level) {
                res.add(new ArrayList<Integer>());
            }
            res.get(level).add(myTreeNode.node.val);

            if (myTreeNode.node.left != null) {
                queue.offer(new MyTreeNode(level + 1, myTreeNode.node.left));
            }

            if (myTreeNode.node.right != null) {
                queue.offer(new MyTreeNode(level + 1, myTreeNode.node.right));
            }
        }

        return res;
    }
}
