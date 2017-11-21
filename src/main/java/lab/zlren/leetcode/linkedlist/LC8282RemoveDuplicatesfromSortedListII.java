package lab.zlren.leetcode.linkedlist;

/**
 * @author zlren
 * @date 2017-11-21
 */
public class LC8282RemoveDuplicatesfromSortedListII {

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);

        int[] nums = {1, 2, 3, 3, 4, 4, 5};
        int[] nums2 = {1, 1, 1, 2, 3};
        LinkedListUtil.printLinkedList(deleteDuplicates(LinkedListUtil.createLinkedList(nums2)));
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, cur = head;

        int goal = Integer.MAX_VALUE - 8;

        while (cur != null) {
            if (cur.val == goal) {
                cur = cur.next;
                pre.next = cur;
            } else if (cur.next != null && cur.next.val == cur.val) {
                goal = cur.val;
                // 一下删两个
                cur = cur.next.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
