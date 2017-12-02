package lab.zlren.leetcode.queue;

import lab.zlren.leetcode.linkedlist.LinkedListUtil;
import lab.zlren.leetcode.linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 * @author zlren
 * @date 2017-12-02
 */
public class LC23MergekSortedLists {

    public static void main(String[] args) {

        int[] nums1 = {1, 1, 2, 3};
        int[] nums2 = {1, 3, 4, 5};
        int[] nums3 = {2, 3, 4, 5};

        ListNode l1 = LinkedListUtil.createLinkedList(nums1);
        ListNode l2 = LinkedListUtil.createLinkedList(nums2);
        ListNode l3 = LinkedListUtil.createLinkedList(nums3);

        ListNode[] lists = {l1, l2, l3};

        ListNode listNode = new LC23MergekSortedLists().mergeKLists(lists);

        LinkedListUtil.printLinkedList(listNode);
    }

    private class Tuple2 implements Comparable<Tuple2> {
        private ListNode node;
        private int index;

        public Tuple2(ListNode node, int index) {
            this.node = node;
            this.index = index;
        }

        @Override
        public int compareTo(Tuple2 o) {
            return this.node.val - o.node.val;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        int len = lists.length;

        if (len == 1) {
            return lists[0];
        }

        PriorityQueue<Tuple2> priorityQueue = new PriorityQueue<>(lists.length);

        ListNode[] cur = new ListNode[lists.length];
        for (int i = 0; i < len; i++) {
            cur[i] = lists[i];
        }

        for (int i = 0; i < len; i++) {
            if (cur[i] != null) {
                priorityQueue.offer(new Tuple2(cur[i], i));
                cur[i] = cur[i].next;
            }
        }

        ListNode dummy = new ListNode(0), dummyCur = dummy;

        while (!priorityQueue.isEmpty()) {
            Tuple2 poll = priorityQueue.poll();

            if (cur[poll.index] != null) {
                priorityQueue.offer(new Tuple2(cur[poll.index], poll.index));
                cur[poll.index] = cur[poll.index].next;
            }

            dummyCur.next = poll.node;
            dummyCur = dummyCur.next;
            dummyCur.next = null;
        }

        return dummy.next;
    }

}
