package lab.zlren.leetcode.linkedlist;

/**
 * 奇数索引排在偶数索引的前面
 *
 * @author zlren
 * @date 2017-11-21
 */
public class LC328OddEvenLinkedList {

    public static void main(String[] args) {
        LC328OddEvenLinkedList lc328OddEvenLinkedList = new LC328OddEvenLinkedList();

        int[] nums = {1, 2, 3, 4, 5};
        ListNode origin = LinkedListUtil.createLinkedList(nums);
        LinkedListUtil.printLinkedList(origin);

        LinkedListUtil.printLinkedList(lc328OddEvenLinkedList.oddEvenList(origin));
    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode oddDummy = new ListNode(0);
        ListNode oddP = oddDummy;
        ListNode evenDummy = new ListNode(0);
        ListNode evenP = evenDummy;

        ListNode cur = head;
        ListNode temp;
        int i = 1;
        while (cur != null) {
            temp = cur.next;
            if (i % 2 == 0) {
                // even
                evenP.next = cur;
                evenP = evenP.next;
                evenP.next = null;
            } else {
                // odd
                oddP.next = cur;
                oddP = oddP.next;
                oddP.next = null;
            }
            cur = temp;
            i++;
        }

        oddP.next = evenDummy.next;

        return oddDummy.next;
    }

}
