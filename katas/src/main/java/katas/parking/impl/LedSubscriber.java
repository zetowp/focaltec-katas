package katas.parking.impl;

import java.util.HashMap;
import java.util.Map;

import katas.parking.ParkingSubscriber;

public class LedSubscriber implements ParkingSubscriber {

    private Map<Integer, String> leds = new HashMap<>();

    public String ledAt(int idx) {
        return leds.get(idx) == null ? "GREEN" : leds.get(idx);
    }

    @Override
    public void update(boolean[] lot) {
        for (int i = 0; i < lot.length; i++) {
           leds.put(i, lot[i]?"RED":"GREEN");
        }
    }

}
