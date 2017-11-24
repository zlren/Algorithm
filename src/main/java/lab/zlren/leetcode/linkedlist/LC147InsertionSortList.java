package lab.zlren.leetcode.linkedlist;

/**
 * @author zlren
 * @date 2017-11-23
 */
public class LC147InsertionSortList {

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2, 2, 1};
        LinkedListUtil.printLinkedList(insertionSortList(LinkedListUtil.createLinkedList(nums)));
    }

    /**
     * 链表的插入排序
     *
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // cur指向待操作链表，dummy指向排好的新链表

        // cur指向即将操作的节点
        ListNode cur = head.next;

        // head的第一个节点直接放到dummy的后面
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        dummy.next.next = null;

        while (cur != null) {
            ListNode temp = cur.next;

            cur.next = null;

            ListNode p = dummy, q = dummy.next;
            while (!(cur.val >= p.val && cur.val <= q.val)) {
                p = q;
                q = q.next;

                // 最后了。。
                if (q == null) {
                    break;
                }
            }

            // cur放在p和q之间
            cur.next = q;
            p.next = cur;

            cur = temp;
        }

        return dummy.next;
    }
}
