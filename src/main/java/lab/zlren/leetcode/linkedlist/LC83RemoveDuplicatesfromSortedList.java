package lab.zlren.leetcode.linkedlist;

/**
 * @author zlren
 * @date 2017-11-20
 */
public class LC83RemoveDuplicatesfromSortedList {

    public static void main(String[] args) {
        LC83RemoveDuplicatesfromSortedList lc83RemoveDuplicatesfromSortedList = new LC83RemoveDuplicatesfromSortedList();

        int[] nums = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 7, 7};
        ListNode origin = LinkedListUtil.createLinkedList(nums);
        LinkedListUtil.printLinkedList(origin);
        LinkedListUtil.printLinkedList(lc83RemoveDuplicatesfromSortedList.deleteDuplicates(origin));

    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;

        // 如果当前节点的下一个节点和自己相同，那就移除下一个节点
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
