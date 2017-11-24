package lab.zlren.leetcode.linkedlist;

/**
 * @author zlren
 * @date 2017-11-23
 */
public class LC237DeleteNodeinaLinkedList {

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        } else if (node.next == null) {
            node = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

}
