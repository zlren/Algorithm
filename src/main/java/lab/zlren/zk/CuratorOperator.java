package lab.zlren.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.retry.RetryNTimes;

/**
 * @author zlren
 * @date 2018-04-01
 */
@Slf4j
public class CuratorOperator {

    private CuratorFramework client;
    private static final String ZK_SERVER_PATH = "10.109.246.70:2181";

    /**
     * 实例化zk客户端
     */
    public CuratorOperator() {

        RetryPolicy retryPolicy = new RetryNTimes(3, 3000);

        client = CuratorFrameworkFactory.builder()
                .connectString(ZK_SERVER_PATH)
                .sessionTimeoutMs(10000).retryPolicy(retryPolicy)
                .namespace("workspace").build();
        client.start();
    }

    /**
     * 关闭zk客户端连接
     */
    public void closeZKClient() {
        if (client != null) {
            this.client.close();
        }
    }

    public static void main(String[] args) throws Exception {

        // 实例化
        CuratorOperator operator = new CuratorOperator();
        log.info("当前客户的状态：{}", operator.client.getState());

        String path = "/super/imooc";

        // 创建
        // operator.client.create()xcreatingParentsIfNeeded()
        //         .withMode(CreateMode.PERSISTENT)
        //         .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
        //         .forPath(path, "superme".getBytes());

        // 更新数据
        // operator.client.setData().withVersion(0).forPath(path, "batman".getBytes());

        // 删除节点
        // 删除叶子节点及其子节点
        // operator.client.delete()
        //         .guaranteed()                   // 如果删除失败，那么在后端还是继续会删除，直到成功
        //         .deletingChildrenIfNeeded()     // 如果有子节点，就删除
        //         .withVersion(1)
        //         .forPath(path);

        // 读取节点数据
        // Stat stat = new Stat();
        // byte[] data = operator.client.getData().storingStatIn(stat).forPath(path);
        // log.info("数据为: {}", new String(data));
        // log.info("该节点的版本号为: {}", stat.getVersion());

        // 查询子节点
        // List<String> childNodes = operator.client.getChildren().forPath(path);
        // log.info("子节点列表");
        // for (String s : childNodes) {
        //     log.info("{}", s);
        // }

        // 判断节点是否存在,如果不存在则为空
        // Stat statExist = operator.client.checkExists().forPath(path + "/child1");
        // log.info("{}", statExist);

        // watcher 事件  当使用usingWatcher的时候，监听只会触发一次，监听完毕后就销毁
        // operator.client.getData().usingWatcher(new MyCuratorWatcher()).forPath(path);


        // 为节点添加watcher，这种方式则不会一次失效，可以持久生效
        // NodeCache: 监听数据节点的变更，会触发事件
        final NodeCache nodeCache = new NodeCache(operator.client, path);
        // buildInitial : 初始化的时候获取node的值并且缓存
        nodeCache.start(true);
        if (nodeCache.getCurrentData() != null) {
            System.out.println("节点初始化数据为：" + new String(nodeCache.getCurrentData().getData()));
        } else {
            System.out.println("节点初始化数据为空...");
        }
        nodeCache.getListenable().addListener(() -> {
            if (nodeCache.getCurrentData() == null) {
                System.out.println("空");
                return;
            }
            String data = new String(nodeCache.getCurrentData().getData());
            System.out.println("节点路径：" + nodeCache.getCurrentData().getPath() + "数据：" + data);
        });



        // 关闭
        operator.closeZKClient();
        log.info("当前客户的状态：{}", operator.client.getState());
    }
}
