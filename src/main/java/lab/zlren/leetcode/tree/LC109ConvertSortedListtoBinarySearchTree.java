package lab.zlren.leetcode.tree;

import lab.zlren.leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 把一棵有序链表转成平衡二叉搜索树
 * 首先转成数组，可以直接索引，再去转成BST
 *
 * @author zlren
 * @date 2018-04-15
 */
public class LC109ConvertSortedListtoBinarySearchTree {

    public static void main(String[] args) {
        System.out.println(fun());
    }

    private static int fun() {
        int ret = 0;
        try {
            throw new Exception();
        } catch (Exception e) {
            ret = 1;
            return ret;
        } finally {
            ret = 2;
        }
    }

    class Solution {
        public TreeNode sortedListToBST(ListNode head) {

            ListNode runner = head;
            List<Integer> list = new ArrayList<>();
            while (runner != null) {
                list.add(runner.val);
                runner = runner.next;
            }

            return helper(list, 0, list.size() - 1);
        }

        private TreeNode helper(List<Integer> list, int start, int end) {

            if (start > end) {
                return null;
            }

            int mid = start + (end - start) / 2;
            TreeNode node = new TreeNode(list.get(mid));
            node.left = helper(list, start, mid - 1);
            node.right = helper(list, mid + 1, end);

            return node;
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
