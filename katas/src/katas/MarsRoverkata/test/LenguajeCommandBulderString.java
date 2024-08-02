package katas.MarsRoverkata.test;

import org.junit.platform.commons.util.StringUtils;

import katas.MarsRoverkata.controllers.LenguageCommands;
import katas.MarsRoverkata.controllers.LenguageCommandsBuilder;

public class LenguajeCommandBulderString implements LenguageCommandsBuilder {

    @Override
    public LenguageCommands buildLenguaje(String lenguage) {
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
