package lab.zlren.nowcoder.toutiao;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {
    public static void main(String[] args) throws Exception {
        String expr = "(1+2/5)*3";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = engine.eval(expr);
        System.out.println(result);
    }
}