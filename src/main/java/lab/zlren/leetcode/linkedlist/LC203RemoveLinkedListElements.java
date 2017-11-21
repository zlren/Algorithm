package lab.zlren.leetcode.linkedlist;

/**
 * @author zlren
 * @date 2017-11-21
 */
public class LC203RemoveLinkedListElements {

    public static void main(String[] args) {
        int[] nums = {1, 0, 1};
        LinkedListUtil.printLinkedList(removeElements(LinkedListUtil.createLinkedList(nums), 1));
    }

    public static ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }

}
