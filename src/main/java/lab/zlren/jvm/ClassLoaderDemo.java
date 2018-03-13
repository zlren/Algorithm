package lab.zlren.jvm;

import java.io.InputStream;

/**
 * 自定义类加载器
 *
 * @author zlren
 * @date 2018-02-27
 */
public class ClassLoaderDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream inputStream = getClass().getResourceAsStream(fileName);
                if (inputStream == null) {
                    // 当前包下面没有就交给其他的加载器
                    return super.loadClass(name);
                } else {
                    try {
                        byte[] buff = new byte[inputStream.available()];
                        inputStream.read(buff);
                        return defineClass(name, buff, 0, buff.length);
                    } catch (Exception ignored) {
                        throw new ClassNotFoundException();
                    }
                }
            }
        };

        Object c = loader.loadClass("lab.zlren.jvm.ClassLoaderDemo").newInstance();
        System.out.println(c.getClass());
        // 不是同一个类加载器加载的
        System.out.println(c instanceof ClassLoaderDemo);

    }
}
