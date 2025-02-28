package katas.parking.impl;

import katas.parking.ParkingSubscriber;

public class GateSubscriber implements ParkingSubscriber {

    private boolean isOpen;

    @Override
    public void update(boolean[] lot) {
        isOpen = hasSpace(lot);
    }

    private boolean hasSpace(boolean[] lot) {
        for (boolean ocupied : lot) {
            if (!ocupied)
                return true;

        }
        return false;
    }

    public boolean isOpen() {
        return isOpen;
    }

}
