package lab.zlren.leetcode.queue;

import java.util.*;

/**
 * @author zlren
 * @date 2017-11-28
 */
public class LC347TopKFrequentElements {

    private class Tuple implements Comparable<Tuple> {
        int v;
        int count;

        public Tuple(int v, int count) {
            this.v = v;
            this.count = count;
        }

        public int getV() {
            return v;
        }

        @Override
        public int compareTo(Tuple o) {
            return o.count - this.count;
        }
    }


    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        List<Integer> list = new LC347TopKFrequentElements().topKFrequent(nums, k);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>(k);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            // 手动维护一个大小为k的优先队列
            if (priorityQueue.size() == k && entry.getValue() > priorityQueue.peek().count) {
                priorityQueue.poll();
            }

            priorityQueue.add(new Tuple(entry.getKey(), entry.getValue()));
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            result.add(priorityQueue.poll().getV());
        }

        return result;
    }
}
