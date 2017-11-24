package lab.zlren.leetcode.linkedlist;

/**
 * @author zlren
 * @date 2017-11-23
 */
public class LC234PalindromeLinkedList {

    public static void main(String[] args) {

    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;




        return false;
    }
}
