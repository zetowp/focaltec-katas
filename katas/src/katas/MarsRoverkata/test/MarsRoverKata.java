package katas.MarsRoverkata.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import katas.MarsRoverkata.MarsObject;
import katas.MarsRoverkata.MarsRover;
import katas.MarsRoverkata.controllers.TowerControl;
import katas.MarsRoverkata.controllers.TowerControlLangFactory;

public class MarsRoverKata {

    @Test
    public void givenFactory_doWalkRover() {
        TowerControlFactory factory = new TowerControlFactory(10);

        assertMarsWalk("MMMMMLMMMRMMXMMMM", factory.usTower(new MarsObject[] {}), 7, 1);
        assertMarsWalk("MMMMMLMMMRMMMMMM",
                factory.usTower(new MarsObject[] { new MarsObject(1, 1) }), 7, 1);
        assertMarsWalk("MMMMMLMMMRMMMMMM",
                factory.usTower(new MarsObject[] { new MarsObject(8, 5) }), 9, 5);
        assertMarsWalk("MMMMMLMMMRMMMMMM",
                factory.usTower(new MarsObject[] { new MarsObject(8, 5), new MarsObject(0, 3) }), 0, 2);
        // en espaniol no se mueve por que no reconoce comandos
        assertMarsWalk("MMMMMLMMMRMMMMMM",
                factory.mxTower(new MarsObject[] { new MarsObject(8, 5), new MarsObject(0, 3) }), 0, 0);
        // en espanil
        assertMarsWalk("AAAAAIAAADAAXAAAA", factory.mxTower(new MarsObject[] {}), 7, 1);
        assertMarsWalk("AAAAAIAAADAAAAAA",
                factory.mxTower(new MarsObject[] { new MarsObject(1, 1) }), 7, 1);
        assertMarsWalk("AAAAAIAAADAAAAAA",
                factory.mxTower(new MarsObject[] { new MarsObject(8, 5) }), 9, 5);
        assertMarsWalk("AAAAAIAAADAAAAAA",
                factory.mxTower(new MarsObject[] { new MarsObject(8, 5), new MarsObject(0, 3) }), 0, 2);
    }

    @Test
    public void givenAbstractFactory_doWalkRover() {
        TowerControlLangFactory factory = new TowerControlStringFactory(10, "eng");
        assertMarsWalk("MMMMMLMMMRMMXMMMM", factory.buildTower((new MarsObject[] {})), 7, 1);
        assertMarsWalk("MMMMMLMMMRMMMMMM", factory.buildTower(new MarsObject[] { new MarsObject(1, 1) }), 7, 1);
        assertMarsWalk("MMMMMLMMMRMMMMMM", factory.buildTower(new MarsObject[] { new MarsObject(8, 5) }), 9, 5);
        assertMarsWalk("MMMMMLMMMRMMMMMM",
                factory.buildTower(new MarsObject[] { new MarsObject(8, 5), new MarsObject(0, 3) }), 0, 2);
        // en espaniol no se mueve por que no reconoce comandos
        factory = new TowerControlStringFactory(10, "esp");
        assertMarsWalk("MMMMMLMMMRMMMMMM",
                factory.buildTower(new MarsObject[] { new MarsObject(8, 5), new MarsObject(0, 3) }), 0, 0);
        // en espanil
        assertMarsWalk("AAAAAIAAADAAXAAAA", factory.buildTower(new MarsObject[] {}), 7, 1);
        assertMarsWalk("AAAAAIAAADAAAAAA", factory.buildTower(new MarsObject[] { new MarsObject(1, 1) }), 7, 1);
        assertMarsWalk("AAAAAIAAADAAAAAA", factory.buildTower(new MarsObject[] { new MarsObject(8, 5) }), 9, 5);
        assertMarsWalk("AAAAAIAAADAAAAAA",
                factory.buildTower(new MarsObject[] { new MarsObject(8, 5), new MarsObject(0, 3) }), 0, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullLenguage_throwsIllegal() {
        new TowerControlStringFactory(10, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenBadLenguage_throwsIllegal() {
        new TowerControlStringFactory(10, "bad");
    }

    private void assertMarsWalk(String commands, TowerControl tower, int expX, int expY) {
        MarsRover rover = new MarsRover();
        tower.doWalk(rover, commands);
        assertEquals(expX, rover.getX());
        assertEquals(expY, rover.getY());
    }




}
