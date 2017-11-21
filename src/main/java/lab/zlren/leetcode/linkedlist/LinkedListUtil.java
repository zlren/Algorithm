package lab.zlren.leetcode.linkedlist;

/**
 * @author zlren
 * @date 2017-11-20
 */
public class LinkedListUtil {

    public static ListNode createLinkedList(int[] nums) {

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (int i = 0; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }

        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode p = head;

        while (p != null) {
            System.out.print(p.val + " -> ");
            p = p.next;
        }

        System.out.println("NULL");
    }

}
