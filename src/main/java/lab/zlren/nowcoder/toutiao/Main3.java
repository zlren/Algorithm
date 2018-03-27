package lab.zlren.nowcoder.toutiao;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

/**
 * @author zlren
 * @date 2018-03-24
 */
public class Main3 {

    public static void main(String[] args) {

        String[][] numbers = new String[10][5];

        numbers[0] = new String[]{"66666", "6...6", "6...6", "6...6", "66666"};
        numbers[1] = new String[]{"....6", "....6", "....6", "....6", "....6"};
        numbers[2] = new String[]{"66666", "....6", "66666", "6....", "66666"};
        numbers[3] = new String[]{"66666", "....6", "66666", "....6", "66666"};
        numbers[4] = new String[]{"6...6", "6...6", "66666", "....6", "....6"};
        numbers[5] = new String[]{"66666", "6....", "66666", "....6", "66666"};
        numbers[6] = new String[]{"66666", "6....", "66666", "6...6", "66666"};
        numbers[7] = new String[]{"66666", "....6", "....6", "....6", "....6"};
        numbers[8] = new String[]{"66666", "6...6", "66666", "6...6", "66666"};
        numbers[9] = new String[]{"66666", "6...6", "66666", "....6", "66666"};

        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());

        String[] asdf = new String[n];
        for (int i = 0; i < n; i++) {
            asdf[i] = sc.nextLine();
        }

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        for (int z = 0; z < n; z++) {

            String res = null;
            try {
                res = String.valueOf(engine.eval(asdf[z]));
            } catch (ScriptException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < res.length(); j++) {
                    if (j == 0) {
                        System.out.print(numbers[res.charAt(j) - '0'][i]);
                    } else {
                        System.out.print(".." + numbers[res.charAt(j) - '0'][i]);
                    }
                }
                System.out.println();
            }
        }
    }
}
