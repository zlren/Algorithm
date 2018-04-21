package lab.zlren.visualization.char3.fenqian;

import java.awt.*;
import java.util.Arrays;

/**
 * @author zlren
 * @date 2018-03-31
 */
public class AlgoVisualizer {

    /**
     * 数据
     * TODO: 创建自己的数据
     */
    private int[] money;

    /**
     * 视图
     */
    private AlgoFrame frame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight) {

        // 初始化数据
        // TODO: 初始化数据
        money = new int[100];
        Arrays.fill(money, 100);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            new Thread(this::run).start();
        });
    }

    /**
     * 动画逻辑
     */
    private void run() {

        // TODO: 编写自己的动画逻辑
        while (true) {
            // Arrays.sort(money);
            frame.render(money);
            AlgoVisHelper.pause(40);

            for (int k = 0; k < 10; k++) {
                for (int i = 0; i < money.length; i++) {
                    // if (money[i] > 0) {
                        money[i]--;
                        money[(int) (Math.random() * money.length)]++;
                    // }
                }
            }
        }
    }

    public static void main(String[] args) {

        int sceneWidth = 1000;
        int sceneHeight = 800;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
