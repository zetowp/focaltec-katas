package katas.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingPublisher {

    private List<ParkingSubscriber> subscribers = new ArrayList<>();

    public void addSubscriber(ParkingSubscriber sub) {
        subscribers.add(sub);
    }

    public void notifyPark(boolean[] lot) {
        for (ParkingSubscriber sub : subscribers) {
            sub.update(lot);
        }
    }

}
