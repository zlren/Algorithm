package lab.zlren.leetcode.queue;

import lab.zlren.leetcode.stack.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从右侧观察一棵二叉树，返回看到的节点值
 *
 * @author zlren
 * @date 2017-11-26
 */
public class LC199BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            for (int i = 1; i <= levelNum; i++) {
                TreeNode poll = queue.poll();

                if (i == levelNum) {
                    res.add(poll.val);
                }

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }

        return res;
    }

}
