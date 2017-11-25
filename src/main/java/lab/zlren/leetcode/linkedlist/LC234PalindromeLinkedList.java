package lab.zlren.leetcode.linkedlist;

/**
 * @author zlren
 * @date 2017-11-23
 */
public class LC234PalindromeLinkedList {

    public static void main(String[] args) {
        System.out.println(isPalindrome(LinkedListUtil.createLinkedList(new int[]{1, 2, 1, 2})));
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


        ListNode dummy = new ListNode(0);
        ListNode cur, temp;
        if (fast == null) {
            // 偶数节点，翻转slow
            cur = slow;
        } else {
            // 奇数节点，翻转slow.next
            cur = slow.next;
        }

        while (cur != null) {
            temp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = temp;
        }

        ListNode l1 = head, l2 = dummy.next;
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return true;
    }
}
