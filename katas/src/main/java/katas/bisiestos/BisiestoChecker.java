package katas.bisiestos;

public class BisiestoChecker {

    public boolean isBisiesto(int anio) {
        return anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0);
    }

}
