package katas.MarsRoverkata.controllers;

import katas.MarsRoverkata.MarsObject;

public interface TowerControlLangFactory {

    TowerControl buildTower(MarsObject... obstacles);

}
