package lab.zlren.leetcode.queue;

import lab.zlren.leetcode.stack.TreeNode;

import java.util.*;

/**
 * @author zlren
 * @date 2017-11-26
 */
public class LC107BinaryTreeLevelOrderTraversalII {

    private class MyTreeNode {
        int level;
        TreeNode node;

        public MyTreeNode(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

        List<List<Integer>> res2 = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            res2.add(res.get(i));
        }

        return res2;
    }
}
