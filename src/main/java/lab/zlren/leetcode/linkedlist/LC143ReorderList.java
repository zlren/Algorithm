package lab.zlren.leetcode.linkedlist;

/**
 * @author zlren
 * @date 2017-11-23
 */
public class LC143ReorderList {

    public static void main(String[] args) {
        ListNode origin = LinkedListUtil.createLinkedList(new int[]{1, 2, 3, 4});
        reorderList(origin);
        LinkedListUtil.printLinkedList(origin);
    }

    public static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // 找到中间节点，后半部分翻转（头插法），然后一个一个的取出来就好了。。

        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        // pre是前段的最后一个节点，slow是后段的头结点
        ListNode dummySlow = new ListNode(0);

        ListNode p = slow, t;
        while (p != null) {
            t = p.next;
            p.next = dummySlow.next;
            dummySlow.next = p;
            p = t;
        }

        ListNode dummy = new ListNode(0), cur = dummy;

        ListNode l1 = head, l2 = dummySlow.next;
        int i = 1;
        while (l1 != null && l2 != null) {

            ListNode x;

            if (i % 2 == 1) {
                x = l1;
                l1 = l1.next;
            } else {
                x = l2;
                l2 = l2.next;
            }

            i++;
            x.next = null;

            cur.next = x;
            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        }

        if (l2 == null) {
            cur.next = l1;
        }
    }
}
