package lab.zlren.leetcode.linkedlist;

/**
 * @author zlren
 * @date 2017-11-20
 */
public class LC86PartitionList {

    public static void main(String[] args) {

        LC86PartitionList lc86PartitionList = new LC86PartitionList();

        int[] nums = {1, 4, 3, 2, 5, 2};
        ListNode origin = LinkedListUtil.createLinkedList(nums);
        LinkedListUtil.printLinkedList(origin);
        LinkedListUtil.printLinkedList(lc86PartitionList.partition(origin, 3));
    }

    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyLess = new ListNode(0);
        ListNode dummyGreater = new ListNode(0);

        ListNode pLess = dummyLess, pGreater = dummyGreater;

        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                pLess.next = p;
                p = p.next;
                pLess = pLess.next;
                pLess.next = null;
            } else {
                pGreater.next = p;
                p = p.next;
                pGreater = pGreater.next;
                pGreater.next = null;
            }
        }

        pLess = dummyLess;
        while (pLess.next != null) {
            pLess = pLess.next;
        }

        pLess.next = dummyGreater.next;

        return dummyLess.next;
    }
}
