package lab.zlren.nowcoder.offer;

/**
 * @author zlren
 * @date 2018-01-19
 */
public class MovingCount {

    public static void main(String[] args) {

    }

    public boolean canreach(int threshold, int x, int y) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y > 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum <= threshold;
    }
}
