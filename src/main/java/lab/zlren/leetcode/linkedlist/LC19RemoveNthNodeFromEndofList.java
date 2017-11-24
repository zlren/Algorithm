package lab.zlren.leetcode.linkedlist;

/**
 * 移除倒数第n个节点
 *
 * @author zlren
 * @date 2017-11-23
 */
public class LC19RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        LinkedListUtil.printLinkedList(removeNthFromEnd(LinkedListUtil.createLinkedList(new int[]{1, 2}), 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = dummy;
        for (int i = 1; i <= n; i++) {
            p = p.next;
        }

        // pre指向被删除的节点的前一个节点，倒数第n-1个节点
        ListNode pre = dummy;
        while (p.next != null) {
            p = p.next;
            pre = pre.next;
        }

        pre.next = pre.next.next;

        return dummy.next;
    }
}
