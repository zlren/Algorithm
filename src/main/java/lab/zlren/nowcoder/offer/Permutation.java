package lab.zlren.nowcoder.offer;

/**
 * 字符串的全排列
 *
 * @author zlren
 * @date 2017-12-27
 */
public class Permutation {

    public static void main(String[] args) {
        Permutation test = new Permutation();
        String a = "abc";
        char[] arrayA = a.toCharArray();
        test.recursionArrange(arrayA, 0, arrayA.length - 1);
    }

    private void recursionArrange(char[] arrayA, int start, int end) {

        System.out.print("array情况：");
        for (char c : arrayA) {
            System.out.print(c);
        }
        System.out.println(", start：" + start + ", end：" + end);

        if (end <= 1) {
            return;
        }
        if (start == end) {
            // for (char anArrayA : arrayA) {
            //     System.out.print(anArrayA);
            // }
            // System.out.println();
        } else {
            for (int i = start; i <= end; i++) {
                swap(arrayA, i, start);
                recursionArrange(arrayA, start + 1, end);
                swap(arrayA, i, start);
            }
        }

    }

    private void swap(char[] arrayA, int m, int n) {
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }
}
