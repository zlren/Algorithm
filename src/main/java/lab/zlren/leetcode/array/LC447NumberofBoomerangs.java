package lab.zlren.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 查找表问题
 *
 * @author zlren
 * @date 2017-11-13
 */
public class LC447NumberofBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        // 以每个点为研究对象，将其他的点按照距离自己的距离分类，如果同一距离的点存在两个以及两个以上，那么就可以组成三元组
        // 并且顺序不同代表的结果不同 所以是n * (n - 1)

        int result = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {

            map.clear();

            // 本轮研究对象的点的x和y坐标
            int x = points[i][0];
            int y = points[i][1];

            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }

                long dist = (points[j][0] - x) * (points[j][0] - x) + (points[j][1] - y) * (points[j][1] - y);

                if (map.containsKey(dist)) {
                    map.put(dist, map.get(dist) + 1);
                } else {
                    map.put(dist, 1);
                }
            }

            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                result += (entry.getValue() * (entry.getValue() - 1));
            }
        }

        return result;
    }
}
