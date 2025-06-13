package katas.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightStringFactory {

    private static final Map<String, FlyweightChar> chars = new HashMap<>();

    public static FlyweightString getString(String src) {
        FlyweightString result = new FlyweightString();
        for (char c : src.toCharArray()) {
            FlyweightChar cha = getOrCreateChar(c);
            result.add(cha);
        }
        return result;
    }

    private static FlyweightChar getOrCreateChar(char c) {
        return chars.computeIfAbsent(c + "", i -> new FlyweightChar(c));
    }

    public static int size() {
        return chars.size();
    }

}
