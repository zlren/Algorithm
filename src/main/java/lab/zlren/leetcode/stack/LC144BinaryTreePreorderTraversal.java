package lab.zlren.leetcode.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归的形式前序遍历二叉树
 *
 * @author zlren
 * @date 2017-11-25
 */
public class LC144BinaryTreePreorderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        LC144BinaryTreePreorderTraversal lc144BinaryTreePreorderTraversal = new LC144BinaryTreePreorderTraversal();

        for (Integer integer : lc144BinaryTreePreorderTraversal.preorderTraversal(root)) {
            System.out.print(integer + " ");
        }

    }


    /**
     * 指令
     */
    private class Command {

        String s;
        TreeNode node;

        Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    private List<Integer> preorderTraversal(TreeNode root) {

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
                if (pop.node.right != null) {
                    stack.push(new Command("go", pop.node.right));
                }
                if (pop.node.left != null) {
                    stack.push(new Command("go", pop.node.left));
                }
                stack.push(new Command("print", pop.node));
            }
        }

        return ret;
    }

}
