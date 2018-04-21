package lab.zlren.visualization.template;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * @author zlren
 * @date 2018-03-29
 */
public class AlgoVisHelper {

    private AlgoVisHelper() {
    }

    public static final Color RED = new Color(0xF44336);
    public static final Color PINK = new Color(0xE91E63);
    public static final Color PURPLE = new Color(0x9C27B0);
    public static final Color DEEP_PURPLE = new Color(0x673AB7);
    public static final Color INDIGO = new Color(0x3F51B5);
    public static final Color BLUE = new Color(0x2196F3);
    public static final Color LightBlue = new Color(0x03A9F4);
    public static final Color CYAN = new Color(0x00BCD4);
    public static final Color TEAL = new Color(0x009688);
    public static final Color GREEN = new Color(0x4CAF50);
    public static final Color LIGHT_GREEN = new Color(0x8BC34A);
    public static final Color LIME = new Color(0xCDDC39);
    public static final Color YELLOW = new Color(0xFFEB3B);
    public static final Color AMBER = new Color(0xFFC107);
    public static final Color ORANGE = new Color(0xFF9800);
    public static final Color DEEP_ORANGE = new Color(0xFF5722);
    public static final Color BROWN = new Color(0x795548);
    public static final Color GREY = new Color(0x9E9E9E);
    public static final Color BLUE_GREY = new Color(0x607D8B);
    public static final Color BLACK = new Color(0x000000);
    public static final Color WHITE = new Color(0xFFFFFF);


    /**
     * 空心圆
     *
     * @param g g
     * @param x x
     * @param y y
     * @param r r
     */
    public static void strokeCircle(Graphics2D g, int x, int y, int r) {

        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g.draw(circle);
    }

    /**
     * 实心圆
     *
     * @param g g
     * @param x x
     * @param y y
     * @param r r
     */
    public static void fillCircle(Graphics2D g, int x, int y, int r) {

        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g.fill(circle);
    }


    /**
     * 空心矩形
     *
     * @param g g
     * @param x x
     * @param y y
     * @param w w
     * @param h h
     */
    public static void strokeRectangle(Graphics2D g, int x, int y, int w, int h) {

        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        g.draw(rectangle);
    }

    /**
     * 实心矩形
     *
     * @param g g
     * @param x x
     * @param y y
     * @param w w
     * @param h h
     */
    public static void fillRectangle(Graphics2D g, int x, int y, int w, int h) {

        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        g.fill(rectangle);
    }

    /**
     * 设置颜色
     *
     * @param g     g
     * @param color color
     */
    public static void setColor(Graphics2D g, Color color) {
        g.setColor(color);
    }

    /**
     * 画笔粗度
     *
     * @param g g
     * @param w w
     */
    public static void setStrokeWidth(Graphics2D g, int w) {
        g.setStroke(new BasicStroke(w, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    /**
     * 暂停
     *
     * @param t t
     */
    public static void pause(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            System.out.println("Error sleeping");
        }
    }

    /**
     * 贴图
     *
     * @param g        画笔
     * @param x        x
     * @param y        y
     * @param imageURL 图片链接
     */
    public static void putImage(Graphics2D g, int x, int y, String imageURL) {

        ImageIcon icon = new ImageIcon(imageURL);
        Image image = icon.getImage();

        g.drawImage(image, x, y, null);
    }

    /**
     * 贴字符
     *
     * @param g       g
     * @param text    text
     * @param centerx centerx
     * @param centery centery
     */
    public static void drawText(Graphics2D g, String text, int centerx, int centery) {

        if (text == null) {
            throw new IllegalArgumentException("Text is null in drawText function!");
        }

        FontMetrics metrics = g.getFontMetrics();
        int w = metrics.stringWidth(text);
        int h = metrics.getDescent();
        g.drawString(text, centerx - w / 2, centery + h);
    }
}
