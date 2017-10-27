package lab.zlren.leetcode.heap;

import lab.zlren.leetcode.helper.ArrayHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * 最大索引堆
 *
 * @author zlren
 * @date 17/10/26
 */
public class IndexMapHeap {

    private int[] data;
    private int[] index;
    private int count;
    private int capacity;

    public IndexMapHeap(int capacity) {
        // 索引从1开始
        data = new int[capacity + 1];
        index = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public IndexMapHeap(int[] nums) {

        data = new int[nums.length + 1];
        capacity = nums.length;
        count = nums.length;

        for (int i = 0; i < nums.length; i++) {
            data[i + 1] = nums[i];
        }

        // 从最后一个非叶子节点开始往前执行shift down操作
        for (int i = nums.length / 2; i >= 1; i--) {
            shiftDown(i);
        }
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
     * @param i    传入的i对于用户而言，是从0索引的
     * @param item
     */
    public void insert(int i, int item) {

        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        // 从1开始索引
        i += 1;
        data[i] = item;
        index[count + 1] = i;

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

        while (k > 1 && data[index[k / 2]] < data[index[k]]) {
            ArrayHelper.swap(index, k / 2, k);
            k /= 2;
        }
    }


    /**
     * 取出最大的元素
     *
     * @return
     */
    public int extractMax() {

        assert count > 0;

        int ret = data[index[1]];
        ArrayHelper.swap(index, 1, count);
        count--;
        shiftDown(1);

        return ret;
    }


    /**
     * 取出最大元素，返回最大元素的索引
     *
     * @return
     */
    public int extractMaxIndex() {

        assert count > 0;

        int ret = index[1] - 1;
        ArrayHelper.swap(index, 1, count);
        count--;
        shiftDown(1);

        return ret;
    }

    /**
     * 取出元素
     *
     * @param i
     * @return
     */
    int getItem(int i) {
        return data[i + 1];
    }

    /**
     * 修改i位置的元素为newItem
     *
     * @param i
     * @param newItem
     */
    void change(int i, int newItem) {
        i += 1;

        data[i] = newItem;

        // 找到index[j] == i, j表示data[i]在堆中的位置
        // 之后shiftUp(j)，再shiftDown(j)就好了
        // TODO 遍历查找复杂度高，可以再记录一个reverse数组，reverse[i]表示索引i在index中的位置
        for (int j = 1; j <= count; j++) {
            if (index[j] == i) {
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }
    }


    /**
     * 对应的操作是取出元素
     *
     * @param k
     */
    private void shiftDown(int k) {

        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[index[j + 1]] > data[index[j]]) {
                j += 1;
            }

            if (data[index[k]] >= data[index[j]]) {
                break;
            }

            ArrayHelper.swap(index, k, j);
            k = j;
        }
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

        maxHeap.extractMax();
        maxHeap.treePrint();
    }
}
