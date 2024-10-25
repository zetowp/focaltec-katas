package katas.MarsRoverkata.impl;


import org.apache.commons.lang3.StringUtils;

import katas.MarsRoverkata.MarsObject;
import katas.MarsRoverkata.controllers.LenguageCommands;
import katas.MarsRoverkata.controllers.TowerControl;
import katas.MarsRoverkata.controllers.TowerControlLangFactory;

public class TowerControlStringFactory implements TowerControlLangFactory  {

    private int limit;

    private LenguageCommands lang;

    public TowerControlStringFactory(int limit, String lang) {
        super();
        this.limit = limit;
        this.lang = buildLenguaje(lang);
    }

    @Override
    public TowerControl buildTower(MarsObject... obstacles) {
        return new TowerControl(lang, limit, limit, obstacles);
    }


    private LenguageCommands buildLenguaje(String lenguage) {
        if (StringUtils.isBlank(lenguage))
            throw new IllegalArgumentException("Lenguaje no soportdo");
        if (lenguage.toLowerCase().startsWith("esp")) {
            return new LenguageCommandsEspaniol();
        }
        if (lenguage.toLowerCase().startsWith("eng")) {
            return new LenguageCommandsEnglish();
        }
        throw new IllegalArgumentException("Lenguaje no soportdo");
    }

}
