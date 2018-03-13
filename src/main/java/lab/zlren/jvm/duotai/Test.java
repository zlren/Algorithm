package lab.zlren.jvm.duotai;

/**
 * @author zlren
 * @date 2018-02-27
 */
public class Test {

    static class Water {
        public void showTem() {
            System.out.println("摸水");
        }
    }

    static class IceWater extends Water {
        @Override
        public void showTem() {
            System.out.println("我的温度是: 0度");
        }
    }

    static class WarmWater extends Water {
        @Override
        public void showTem() {
            System.out.println("我的温度是: 40度");
        }
    }

    static class HotWater extends Water {
        @Override
        public void showTem() {
            System.out.println("我的温度是: 100度");
        }
    }

    public static void main(String[] args) {
        Water w = new WarmWater();
        w.showTem();

        w = new IceWater();
        w.showTem();

        w = new HotWater();
        w.showTem();
    }
}
