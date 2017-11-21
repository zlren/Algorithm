package lab.zlren.leetcode.linkedlist;

import java.util.Stack;

/**
 * @author zlren
 * @date 2017-11-21
 */
public class LC445AddTwoNumbersII {


    public static void main(String[] args) {
        // Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        // Output: 7 -> 8 -> 0 -> 7

        // [3,9,9,9,9,9,9,9,9,9]
        // [7]
        // [4,0,0,0,0,0,0,0,0,6]

        // 5
        // 5
        // 1,0

        int[] nums1 = {5}, nums2 = {5};
        ListNode origin1 = LinkedListUtil.createLinkedList(nums1);
        ListNode origin2 = LinkedListUtil.createLinkedList(nums2);

        LinkedListUtil.printLinkedList(origin1);
        LinkedListUtil.printLinkedList(origin2);

        LinkedListUtil.printLinkedList(addTwoNumbers(origin1, origin2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int sum, flag = 0;

        while (!s1.empty() || !s2.empty()) {

            sum = 0;

            if (!s1.empty()) {
                sum += s1.pop();
            }

            if (!s2.empty()) {
                sum += s2.pop();
            }

            sum += flag;

            ListNode temp = p.next;
            p.next = new ListNode(sum % 10);
            p.next.next = temp;

            flag = sum / 10;
        }

        if (flag > 0) {
            ListNode temp = p.next;
            p.next = new ListNode(flag);
            p.next.next = temp;
        }

        return dummy.next;
    }
}
