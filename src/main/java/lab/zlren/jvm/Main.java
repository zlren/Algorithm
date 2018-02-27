package lab.zlren.jvm;

/**
 * @author zlren
 * @date 2018-02-24
 */
public class Main {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        // byte[] allocation1, allocation2, allocation3, allocation4;
        // allocation1 = new byte[4 * _1MB];
        // swap(1, 2);
        // int[] nums = {1, 3, 2};
        // new Main().nextPermutation(nums);
        // System.out.println(Arrays.toString(nums));

    }

    private static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }



}
