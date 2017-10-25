package lab.zlren.leetcode.heap;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zlren
 * @date 17/10/25
 */
public class MaxHeap {


    private int[] data;
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        // 索引从1开始
        data = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }


    /**
     * 首先将元素放在最后，然后shift up调整
     *
     * @param item
     */
    public void insert(int item) {

        assert count + 1 <= capacity;

        data[count + 1] = item;
        count++;

        shiftUp(count);
    }

    /**
     * 对应的操作为插入元素
     * 将k位置的元素挪动到正确的位置
     *
     * @param k
     */
    private void shiftUp(int k) {

        int value = data[k];

        int indexOfN = k, indexOfParent = indexOfN / 2;
        while (indexOfParent > 0 && data[indexOfParent] < value) {
            data[indexOfN] = data[indexOfParent];
            indexOfN = indexOfParent;
            indexOfParent = indexOfParent / 2;
        }

        data[indexOfN] = value;
    }


    /**
     * 取出最大的元素
     *
     * @return
     */
    public int extractMax() {
        int res = data[1];
        data[1] = data[count];
        count--;
        shiftDown(1);
        return res;
    }


    /**
     * 对应的操作是取出元素
     *
     * @param k
     */
    private void shiftDown(int k) {
        int indexLeftChild = k / 2, indexRightChild = indexLeftChild + 1;

        while (indexLeftChild)

    }


    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    /**
     * 打印堆
     */
    public void treePrint() {

        if (size() >= 100) {
            System.out.println("This print function can only work for less than 100 integer");
            return;
        }

        System.out.println("The max heap size is: " + size());
        System.out.println("Data in the max heap: ");
        for (int i = 1; i <= size(); i++) {
            // 我们的print函数要求堆中的所有整数在[0, 100)的范围内
            assert (Integer) data[i] >= 0 && (Integer) data[i] < 100;
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println();

        int n = size();
        int maxLevel = 0;
        int numberPerLevel = 1;
        while (n > 0) {
            maxLevel += 1;
            n -= numberPerLevel;
            numberPerLevel *= 2;
        }

        int maxLevelNumber = (int) Math.pow(2, maxLevel - 1);
        int curTreeMaxLevelNumber = maxLevelNumber;
        int index = 1;
        for (int level = 0; level < maxLevel; level++) {

            String line1 = new String(new char[maxLevelNumber * 3 - 1]).replace('\0', ' ');

            int curLevelNumber = Math.min(count - (int) Math.pow(2, level) + 1, (int) Math.pow(2, level));
            boolean isLeft = true;
            for (int indexCurLevel = 0; indexCurLevel < curLevelNumber; index++, indexCurLevel++) {
                line1 = putNumberInLine((Integer) data[index], line1, indexCurLevel, curTreeMaxLevelNumber * 3 - 1,
                        isLeft);
                isLeft = !isLeft;
            }
            System.out.println(line1);

            if (level == maxLevel - 1) {
                break;
            }

            String line2 = new String(new char[maxLevelNumber * 3 - 1]).replace('\0', ' ');
            for (int indexCurLevel = 0; indexCurLevel < curLevelNumber; indexCurLevel++) {
                line2 = putBranchInLine(line2, indexCurLevel, curTreeMaxLevelNumber * 3 - 1);
            }
            System.out.println(line2);

            curTreeMaxLevelNumber /= 2;
        }
    }

    private String putNumberInLine(Integer num, String line, int indexCurLevel, int curTreeWidth, boolean isLeft) {

        int subTreeWidth = (curTreeWidth - 1) / 2;
        int offset = indexCurLevel * (curTreeWidth + 1) + subTreeWidth;
        assert offset + 1 < line.length();
        if (num >= 10) {
            line = line.substring(0, offset) + num.toString()
                    + line.substring(offset + 2);
        } else {
            if (isLeft) {
                line = line.substring(0, offset) + num.toString()
                        + line.substring(offset + 1);
            } else {
                line = line.substring(0, offset + 1) + num.toString()
                        + line.substring(offset + 2);
            }
        }
        return line;
    }

    private String putBranchInLine(String line, int indexCurLevel, int curTreeWidth) {

        int subTreeWidth = (curTreeWidth - 1) / 2;
        int subSubTreeWidth = (subTreeWidth - 1) / 2;
        int offsetLeft = indexCurLevel * (curTreeWidth + 1) + subSubTreeWidth;
        assert offsetLeft + 1 < line.length();
        int offsetRight = indexCurLevel * (curTreeWidth + 1) + subTreeWidth + 1 + subSubTreeWidth;
        assert offsetRight < line.length();

        line = line.substring(0, offsetLeft + 1) + "/" + line.substring(offsetLeft + 2);
        line = line.substring(0, offsetRight) + "\\" + line.substring(offsetRight + 1);

        return line;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);
        Random random = new Random();
        for (int i = 0; i < 31; i++) {
            maxHeap.insert(random.nextInt(100));
        }
        maxHeap.treePrint();
    }

}
