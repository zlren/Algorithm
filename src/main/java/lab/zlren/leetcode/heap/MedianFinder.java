package lab.zlren.leetcode.heap;

import java.util.PriorityQueue;

/**
 * 流式数据的中位数
 * 双堆
 *
 * @author zlren
 * @date 2018-04-10
 */
public class MedianFinder {

    private PriorityQueue<Integer> max = new PriorityQueue<>(16, (o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> min = new PriorityQueue<>();

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {

        // 第一次直接放入min中
        if (min.isEmpty()) {
            min.add(num);
        } else {
            // 放入合适的堆，再调整
            if (num >= min.element()) {
                min.add(num);
            } else {
                max.add(num);
            }

            // min == max || min == max + 1

            // min的最大值是max+1
            while (min.size() >= max.size() + 2) {
                max.add(min.poll());
            }

            // max的最大值是min
            while (max.size() >= min.size() + 1) {
                min.add(max.poll());
            }
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return (min.element() + max.element()) / 2.0;
        } else {
            return min.element();
        }
    }

}
