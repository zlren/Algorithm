package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zlren
 * @date 2017-12-03
 */
public class LC129SumRoottoLeafNumbers {

    List<Integer> pathList = new LinkedList<>();

    public int sumNumbers(TreeNode root) {

        fun(root, 0);

        int sum = 0;
        Iterator it = pathList.iterator();
        while (it.hasNext()) {
            sum += (int) it.next();
        }

        return sum;
    }

    private void fun(TreeNode node, Integer num) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                pathList.add(num * 10 + node.val);
            } else {
                fun(node.left, num * 10 + node.val);
                fun(node.right, num * 10 + node.val);
            }
        }
    }
}
