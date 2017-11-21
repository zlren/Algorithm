package lab.zlren.leetcode.linkedlist;

/**
 * 翻转指定区间的节点
 *
 * @author zlren
 * @date 2017-11-16
 */
public class LC92ReverseLinkedListII {

    public static void main(String[] args) {

        LC92ReverseLinkedListII lc92ReverseLinkedListII = new LC92ReverseLinkedListII();

        int[] nums = {1, 2, 3, 4, 5};
        ListNode origin = LinkedListUtil.createLinkedList(nums);
        LinkedListUtil.printLinkedList(origin);
        LinkedListUtil.printLinkedList(lc92ReverseLinkedListII.reverseBetween(origin, 2, 4));
    }


    /**
     * 1 ≤ m ≤ n ≤ length of list.
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || head.next == null) {
            return head;
        }

        if (m == n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preM = dummy;
        for (int i = 1; i <= m - 1; i++) {
            preM = preM.next;
        }


        // 接下来使用头插法进行中间部分的翻转
        ListNode mNode = preM.next;
        // mNode的下一个进行翻转
        ListNode cur = mNode.next;
        ListNode t = cur.next;
        for (int i = 1; i <= n - m; i++) {
            t = cur.next;
            cur.next = preM.next;
            preM.next = cur;
            cur = t;
        }

        // t指向n后面一个节点
        mNode.next = t;

        return dummy.next;
    }
}
