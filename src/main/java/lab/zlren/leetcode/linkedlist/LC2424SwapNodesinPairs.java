package lab.zlren.leetcode.linkedlist;

/**
 * @author zlren
 * @date 2017-11-21
 */
public class LC2424SwapNodesinPairs {

    public static void main(String[] args) {
        // LinkedListUtil.printLinkedList(swapPairs(LinkedListUtil.createLinkedList(new int[]{1, 2})));
        LinkedListUtil.printLinkedList(reverseKGroup(LinkedListUtil.createLinkedList(new int[]{1, 2, 3, 4, 5}), 3));
    }

    public static ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, cur = head;

        while (cur != null && cur.next != null) {

            // 当前分析的这两个的后面一个
            ListNode temp = cur.next.next;

            pre.next = cur.next;
            pre.next.next = cur;
            cur.next = temp;

            pre = pre.next.next;
            cur = temp;
        }

        return dummy.next;
    }

    /**
     * LC No.25
     * 每k个为一组，反转每一组的节点，最后如果剩下节点但是个数不够一组就不要动
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        if (k < 2) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, cur = head;
        boolean f;

        while (true) {

            // temp是当前组的后一组的第一个节点，便于接上
            ListNode temp = cur;
            f = false;
            for (int i = 1; i <= k; i++) {
                if (temp != null) {
                    temp = temp.next;
                } else {
                    f = true;
                    break;
                }
            }

            if (f) {
                break;
            }

            // 这一组的第一个节点，操作完成后它会在最后
            ListNode first = cur;
            // 从这一组的第2个节点开始执行头插法，操作k-1个节点
            cur = cur.next;

            for (int i = 1; i <= k - 1; i++) {
                ListNode t = cur.next;

                cur.next = pre.next;
                pre.next = cur;

                cur = t;
            }

            // 接上
            first.next = temp;
            pre = first;
            cur = pre.next;
        }

        return dummy.next;
    }
}
