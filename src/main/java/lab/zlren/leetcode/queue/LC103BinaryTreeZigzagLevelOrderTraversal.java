package lab.zlren.leetcode.queue;

import lab.zlren.leetcode.stack.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * S型层序遍历二叉树
 *
 * @author zlren
 * @date 2017-11-26
 */
public class LC103BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // true表示顺序，false表示逆序
        boolean flag = true;

        while (!queue.isEmpty()) {

            int levelNum = queue.size();

            List<Integer> list = new LinkedList<>();

            for (int i = 1; i <= levelNum; i++) {

                TreeNode poll = queue.poll();

                if (flag) {
                    list.add(poll.val);
                } else {
                    list.add(0, poll.val);
                }

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }

            res.add(list);
            flag = !flag;
        }

        return res;
    }
}
