package lab.zlren.leetcode.test;

import java.util.PriorityQueue;

/**
 * @author zlren
 * @date 2017-12-27
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<String> maxHeap = new PriorityQueue<>();

        maxHeap.offer("ab");
        maxHeap.offer("ac");


        System.out.println(maxHeap.poll());

    }
}
