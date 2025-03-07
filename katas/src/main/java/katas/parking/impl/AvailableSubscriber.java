package katas.parking.impl;

import katas.parking.ParkingSubscriber;

public class AvailableSubscriber implements ParkingSubscriber {

    private int available;

    @Override
    public void update(boolean[] lot) {
        int areAvailable = 0;
        for (boolean b : lot) {
            if (!b)
                areAvailable++;
        }
        available = areAvailable;
    }

    public int getAvailable() {
        return available;
    }

}
