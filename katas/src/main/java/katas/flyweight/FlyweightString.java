package katas.flyweight;

import java.util.ArrayList;
import java.util.List;

public class FlyweightString {

    private List<FlyweightChar> str = new ArrayList<>();

    public void add(FlyweightChar cha) {
        str.add(cha);
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (FlyweightChar c : str) {
            res.append(c.get());
        }
        return res.toString();
    }
}
