package lab.zlren.zk;

import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.zookeeper.WatchedEvent;

/**
 * @author zlren
 */
public class MyCuratorWatcher implements CuratorWatcher {

    public static void main(String[] args) {
        int a = 10;

    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("触发watcher，节点路径为：" + event.getPath());
    }
}
