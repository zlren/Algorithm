package lab.zlren.leetcode.tree;

import lombok.Data;

/**
 * @author zlren
 * @date 17/10/29
 */
@Data
public class Node {

    private int key;
    private int value;
    private Node left;
    private Node right;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
