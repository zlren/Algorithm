package lab.zlren.leetcode.linkedlist;

/**
 * @author zlren
 * @date 2017-11-23
 */
public class LC61RotateList {

    public static void main(String[] args) {

        LinkedListUtil.printLinkedList(rotateRight(LinkedListUtil.createLinkedList(new int[]{1, 2, 3, 4, 5}), 8));
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 得到长度len，因为k有可能大于len，tail指向尾节点
        int len = 0;
        ListNode tail = dummy;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        k = k % len;
        // q应该指向前段的最后一个节点
        ListNode q = dummy;
        for (int i = 1; i <= len - k; i++) {
            q = q.next;
        }

        tail.next = dummy.next;
        dummy.next = q.next;
        q.next = null;

        return dummy.next;
    }
}
