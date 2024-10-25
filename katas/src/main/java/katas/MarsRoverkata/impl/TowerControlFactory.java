package katas.MarsRoverkata.impl;

import katas.MarsRoverkata.MarsObject;
import katas.MarsRoverkata.controllers.TowerControl;

public class TowerControlFactory  {

    private int limit;

    public TowerControlFactory(int limit) {
        super();
        this.limit = limit;
    }

    public TowerControl mxTower(MarsObject... obstacles) {
        return new TowerControl(new LenguageCommandsEspaniol(), limit, limit, obstacles);
    }

    public TowerControl usTower(MarsObject... obstacles) {
        return new TowerControl(new LenguageCommandsEnglish(), limit, limit, obstacles);
    }

}
