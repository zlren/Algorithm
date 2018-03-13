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


        swap(1, 2);

    }

    private int add(int a, int b) {
        return a + b;
    }

    private String add(String a, String b) {
        return a + b;
    }

    private static void swap(int a, int b) {
        // a = a ^ b;
        // b = a ^ b;
        // a = a ^ b;
        // System.out.println(a + " " + b);

        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + " " + b);
    }

    int random_0_1() {

        while (true) {
            int i = RANDOM();
            int j = RANDOM();
            if (i == 0 && j == 1) {
                return 0;
            } else if (i == 1 && j == 0) {
                return 1;
            }
        }
    }

    private int RANDOM() {
        return 0;
    }


}
