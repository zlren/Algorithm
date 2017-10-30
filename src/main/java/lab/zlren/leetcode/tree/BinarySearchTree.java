package lab.zlren.leetcode.tree;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树 BST
 *
 * @author zlren
 * @date 17/10/29
 */
@Data
public class BinarySearchTree {

    private Node root;
    private int count;

    public BinarySearchTree() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 插入数据
     *
     * @param key
     * @param value
     */
    public void insert(int key, int value) {
        myInsert(root, key, value);
    }

    /**
     * 是否包含key
     *
     * @param key
     * @return
     */
    public boolean contain(int key) {
        return myContain(root, key);
    }

    /**
     * 找到以后返回value，找不到呢？
     * 随便返回一个
     *
     * @param key
     * @return
     */
    public int search(int key) {
        return mySearch(root, key);
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        myPreOrder(root);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        myInOrder(root);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        myPostOrder(root);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            Node poll = nodeQueue.poll();

            if (poll.getLeft() != null) {
                nodeQueue.add(poll.getLeft());
            }

            if (poll.getRight() != null) {
                nodeQueue.add(poll.getRight());
            }

            System.out.println(poll.getValue());
        }

    }

    /**
     * 返回二分搜索树的最小值
     *
     * @return
     */
    public int min() {
        assert count > 0;

        Node node = root;
        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node.getKey();
    }

    public int max() {
        assert count > 0;

        Node node = root;
        while (node.getRight() != null) {
            node = node.getRight();
        }

        return node.getKey();
    }

    public void removeMin() {
        if (root != null) {
            myRemoveMin(root);
        }
    }

    private Node myRemoveMin(Node node) {
        // if (node.getLeft() == null) {
        //     count--;
        //     return node.getRight();
        // }
        //
        // node.setLeft();

        // 有点难。。

        return null;
    }


    private void myPostOrder(Node node) {
        if (node != null) {
            myPostOrder(node.getLeft());
            myPostOrder(node.getRight());
            System.out.println(node.getValue());
        }
    }

    private void myInOrder(Node node) {
        if (node != null) {
            myInOrder(node.getLeft());
            System.out.println(node.getValue());
            myInOrder(node.getRight());
        }
    }

    private void myPreOrder(Node node) {
        if (node != null) {
            System.out.println(node.getValue());
            myPreOrder(node.getLeft());
            myPreOrder(node.getRight());
        }
    }


    private int mySearch(Node node, int key) {

        if (node == null) {
            return Integer.MIN_VALUE;
        }

        if (node.getKey() == key) {
            return node.getValue();
        } else if (key < node.getKey()) {
            return mySearch(node.getLeft(), key);
        } else {
            return mySearch(node.getRight(), key);
        }

    }

    private boolean myContain(Node node, int key) {

        if (node == null) {
            return false;
        }

        if (node.getKey() == key) {
            return true;
        } else if (key < node.getKey()) {
            return myContain(node.getLeft(), key);
        } else {
            return myContain(node.getRight(), key);
        }
    }

    private Node myInsert(Node node, int key, int value) {

        if (node == null) {
            count++;
            return new Node(key, value);
        }

        // update
        if (key == node.getKey()) {
            node.setValue(value);
        } else if (key < node.getKey()) {
            node.setLeft(myInsert(node.getLeft(), key, value));
        } else {
            node.setRight(myInsert(node.getRight(), key, value));
        }

        return node;
    }
}
