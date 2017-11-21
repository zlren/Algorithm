package lab.zlren.leetcode.linkedlist;

/**
 * @author zlren
 * @date 2017-11-21
 */
public class LC21MergeTwoSortedLists {

    public static void main(String[] args) {

        LinkedListUtil.printLinkedList(mergeTwoLists(LinkedListUtil.createLinkedList(new int[]{1, 3, 4}), LinkedListUtil
                .createLinkedList(new int[]{1, 2, 2, 4, 5})));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode p1 = l1, p2 = l2;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }

        if (p1 != null) {
            cur.next = p1;
        }

        if (p2 != null) {
            cur.next = p2;
        }

        return dummy.next;
    }
}
