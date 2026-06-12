package katas.fizzbuzz;

import java.util.HashMap;
import java.util.Map;

public class FizzBuzz {

    Map<Integer, String> rules = createRules();

    private Map<Integer, String> createRules() {
        Map<Integer, String> rules = new HashMap<Integer, String>();
        rules.put(3, "Fizz");
        rules.put(5, "Buzz");
        return rules;
    }

    public String convert(int i) {
        String result = fuzziResult(i);
        return result.isEmpty() ? i + result : result;
    }

    private String fuzziResult(int i) {
        String result = "";
        for (Integer key : rules.keySet()) {
            if (i % key == 0) {
                result += rules.get(key);
            }
        }
        return result;
    }

}
