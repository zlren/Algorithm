package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.stack.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zlren
 * @date 2018-02-15
 */
public class LC538ConvertBSTtoGreaterTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        new LC538ConvertBSTtoGreaterTree().convertBST(root);
    }

    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode convertBST(TreeNode root) {

        inOrder(root);

        int sum = 0;
        for (int i = list.size() - 1; i >= 1; i--) {
            sum += list.get(i);
            map.put(list.get(i - 1), sum);
        }

        preOrder(root);

        return root;
    }


    private void preOrder(TreeNode node) {
        if (node != null) {
            node.val += map.get(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            list.add(node.val);
            inOrder(node.right);
        }
    }
}
