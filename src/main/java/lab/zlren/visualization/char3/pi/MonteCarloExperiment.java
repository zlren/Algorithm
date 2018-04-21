package lab.zlren.visualization.char3.pi;

/**
 * 蒙特卡洛模拟π值
 *
 * @author zlren
 * @date 2018-04-08
 */
public class MonteCarloExperiment {

    private int squareSide;
    private int N;

    public MonteCarloExperiment(int squareSide, int N) {
        if (squareSide <= 0 || N <= 0) {
            throw new IllegalArgumentException("must lager than 0");
        }
        this.squareSide = squareSide;
        this.N = N;
    }

    public void run() {

    }
}
