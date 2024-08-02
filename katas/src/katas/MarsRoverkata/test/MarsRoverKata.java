package katas.MarsRoverkata.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import katas.MarsRoverkata.MarsObject;
import katas.MarsRoverkata.MarsRover;
import katas.MarsRoverkata.controllers.TowerControl;

public class MarsRoverKata {

    @Test
    public void doWalkTest() {
        assertMarsWalk("MMMMMLMMMRMMXMMMM", setUpTowerControl(new MarsObject[] {}, "eng"), 7, 1);
        assertMarsWalk("MMMMMLMMMRMMMMMM", setUpTowerControl(new MarsObject[] { new MarsObject(1, 1) }, "eng"), 7, 1);
        assertMarsWalk("MMMMMLMMMRMMMMMM", setUpTowerControl(new MarsObject[] { new MarsObject(8, 5) }, "eng"), 9, 5);
        assertMarsWalk("MMMMMLMMMRMMMMMM",
                setUpTowerControl(new MarsObject[] { new MarsObject(8, 5), new MarsObject(0, 3) }, "eng"), 0, 2);
        // en espaniol no se mueve por que no reconoce comandos
        assertMarsWalk("MMMMMLMMMRMMMMMM",
                setUpTowerControl(new MarsObject[] { new MarsObject(8, 5), new MarsObject(0, 3) }, "esp"), 0, 0);
        // en espanil
        assertMarsWalk("AAAAAIAAADAAXAAAA", setUpTowerControl(new MarsObject[] {}, "esp"), 7, 1);
        assertMarsWalk("AAAAAIAAADAAAAAA", setUpTowerControl(new MarsObject[] { new MarsObject(1, 1) }, "esp"), 7, 1);
        assertMarsWalk("AAAAAIAAADAAAAAA", setUpTowerControl(new MarsObject[] { new MarsObject(8, 5) }, "esp"), 9, 5);
        assertMarsWalk("AAAAAIAAADAAAAAA",
                setUpTowerControl(new MarsObject[] { new MarsObject(8, 5), new MarsObject(0, 3) }, "esp"), 0, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullLenguage_throwsIllegal() {
        setUpTowerControl(new MarsObject[] {}, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenBadLenguage_throwsIllegal() {
        setUpTowerControl(new MarsObject[] {}, "bad");
    }

    private void assertMarsWalk(String commands, TowerControl tower, int expX, int expY) {
        MarsRover rover = new MarsRover();
        tower.doWalk(rover, commands);
        assertEquals(expX, rover.getX());
        assertEquals(expY, rover.getY());
    }

    private TowerControl setUpTowerControl(MarsObject[] obstacles, String lenguage) {
        return new TowerControl(new LenguajeCommandBulderString().buildLenguaje(lenguage), 10, 10, obstacles);
    }

}
