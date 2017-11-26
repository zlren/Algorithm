package lab.zlren.leetcode.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归形式的后续遍历二叉树
 *
 * @author zlren
 * @date 2017-11-26
 */
public class LC145BinaryTreePostorderTraversal {

    private class Command {

        String s;
        TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }

        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));

        while (!stack.isEmpty()) {
            Command pop = stack.pop();

            if ("print".equals(pop.s)) {
                ret.add(pop.node.val);
            } else {
                assert "go".equals(pop.s);

                stack.push(new Command("print", pop.node));

                if (pop.node.right != null) {
                    stack.push(new Command("go", pop.node.right));
                }

                if (pop.node.left != null) {
                    stack.push(new Command("go", pop.node.left));
                }
            }
        }

        return ret;
    }

}
