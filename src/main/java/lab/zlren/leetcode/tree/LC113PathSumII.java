package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zlren
 * @date 2017-12-03
 */
public class LC113PathSumII {

    public static void main(String[] args) {

        // TreeNode root = new TreeNode(2);
        // root.left = new TreeNode(5);
        // root.right = new TreeNode(4);
        //
        // root.right.left = new TreeNode(1);
        // root.right.right = new TreeNode(2);
        //
        // new LC113PathSumII().pathSum(root, 7);

        System.out.println(Integer.valueOf(String.valueOf(-1)));

    }

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        fuc(root, "", sum);

        return result;
    }

    private void fuc(TreeNode node, String path, int sum) {
        if (node != null) {
            if (node.left == null && node.right == null && node.val == sum) {

                List<Integer> list = new LinkedList<>();

                for (String s : path.split("a")) {
                    if (s.length() > 0) {
                        list.add(Integer.valueOf(s));
                    }
                }
                list.add(node.val);

                result.add(list);
            } else {
                fuc(node.left, path + "a" + node.val, sum - node.val);
                fuc(node.right, path + "a" + node.val, sum - node.val);
            }
        }
    }

}
