package lab.zlren.nowcoder.wangyi;

import java.util.*;

public class Overlap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] xRangeHaha = new int[n][2];
        int[][] yRangeHehe = new int[n][2];

        for (int i = 0; i < n; i++) {
            xRangeHaha[i][0] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            yRangeHehe[i][0] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            xRangeHaha[i][1] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            yRangeHehe[i][1] = scanner.nextInt();
        }

        Arrays.sort(xRangeHaha, (o1, o2) -> o1[0] - o2[0]);

        List<Set<Integer>> xOver = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> subO = new HashSet<>();
            subO.add(i);
            for (int j = i + 1; j < n; j++) {
                if (xRangeHaha[j][0] < xRangeHaha[i][1]) {
                    subO.add(j);
                } else break;
            }
            if (subO.size() > 0) xOver.add(subO);
        }

        Arrays.sort(yRangeHehe, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<Set<Integer>> yOver = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> subO = new HashSet<>();
            subO.add(i);
            for (int j = i + 1; j < n; j++) {
                if (yRangeHehe[j][0] < yRangeHehe[i][1]) {
                    subO.add(j);
                } else break;
            }
            if (subO.size() > 0) yOver.add(subO);
        }

        int ret = 1;
        for (int i = 0; i < xOver.size(); i++) {
            for (int j = 0; j < yOver.size(); j++) {
                Set<Integer> tmp = new HashSet<>();
                tmp.addAll(xOver.get(i));
                tmp.retainAll(yOver.get(j));
                ret = Math.max(ret, tmp.size());
            }
        }

        System.out.print(ret);

    }


}