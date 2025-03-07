package katas.parking;

public class ParkingLot {

    private boolean[] lot;

    private ParkingPublisher publisher;

    public ParkingLot(int spaces) {
        this.publisher = new ParkingPublisher();
        lot = new boolean[spaces];
    }

    public void parkAt(int... changes) {
        for (int idx : changes) {
            lot[idx] = !lot[idx];
        }
        publisher.notifyPark(lot);
    }

    public int park() {
        for (int i = 0; i < lot.length; i++) {
            if (!lot[i]) {
                lot[i] = true;
                publisher.notifyPark(lot);
                return i;
            }
        }
        return -1;
    }

    public void checkout(int slot) {
        if (slot > -1 && slot < lot.length && lot[slot]) {
            lot[slot] = false;
            publisher.notifyPark(lot);
        }
    }

    public boolean isOcupied(int idx) {
        return lot[idx];
    }

    public ParkingPublisher getPublisher() {
        return publisher;
    }

}
