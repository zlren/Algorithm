package lab.zlren.nowcoder.offer;

import lab.zlren.leetcode.linkedlist.ListNode;

/**
 * @author zlren
 * @date 2018-01-16
 */
public class EntryNodeOfLoop {


    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l3;

        ListNode node = new EntryNodeOfLoop().EntryNodeOfLoop(l1);
        System.out.println(node.val);

    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }

        ListNode slow = pHead.next, fast = pHead.next.next;
        while (slow != fast) {

            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return null;
            }
        }

        ListNode a = slow, b = pHead;
        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;
    }
}
