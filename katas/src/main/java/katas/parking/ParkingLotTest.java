package katas.parking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import katas.parking.impl.AvailableSubscriber;
import katas.parking.impl.GateSubscriber;
import katas.parking.impl.LedSubscriber;

public class ParkingLotTest {

    @Test
    public void testLot() {
        ParkingLot parkingLot = new ParkingLot(4);
        ParkingPublisher publisher = parkingLot.getPublisher();
        LedSubscriber led = new LedSubscriber();
        GateSubscriber gate = new GateSubscriber();
        AvailableSubscriber able = new AvailableSubscriber();
        publisher.addSubscriber(led);
        publisher.addSubscriber(gate);
        publisher.addSubscriber(able);
        assertEquals("GREEN", led.ledAt(0));
        parkingLot.parkAt(0);
        assertTrue(parkingLot.isOcupied(0));
        assertEquals("RED", led.ledAt(0));
        assertTrue(gate.isOpen());
        parkingLot.parkAt(1, 2, 3);
        assertFalse(gate.isOpen());
        assertEquals("RED", led.ledAt(0));
        assertEquals("RED", led.ledAt(1));
        assertEquals("RED", led.ledAt(2));
        assertEquals("RED", led.ledAt(3));
        parkingLot.parkAt(0);
        assertEquals("GREEN", led.ledAt(0));
        assertTrue(gate.isOpen());
    }

    @Test
    public void testLot_park() {
        ParkingLot parkingLot = new ParkingLot(4);
        ParkingPublisher publisher = parkingLot.getPublisher();
        LedSubscriber led = new LedSubscriber();
        GateSubscriber gate = new GateSubscriber();
        AvailableSubscriber able = new AvailableSubscriber();
        publisher.addSubscriber(led);
        publisher.addSubscriber(gate);
        publisher.addSubscriber(able);
        parkingLot.park();
        assertTrue(parkingLot.isOcupied(0));
        assertEquals("RED", led.ledAt(0));
        assertEquals(3, able.getAvailable());
        assertTrue(gate.isOpen());
        parkingLot.park();
        parkingLot.park();
        parkingLot.park();
        assertEquals("RED", led.ledAt(0));
        assertEquals("RED", led.ledAt(1));
        assertEquals("RED", led.ledAt(2));
        assertEquals("RED", led.ledAt(3));
        assertEquals(0, able.getAvailable());
        assertFalse(gate.isOpen());
        parkingLot.checkout(3);
        assertEquals("GREEN", led.ledAt(3));
        assertTrue(gate.isOpen());
        assertEquals(1, able.getAvailable());
    }

}
