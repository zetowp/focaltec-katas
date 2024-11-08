package katas.ordenCompra.builder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PsvStringOcDirector {

    private OrdenCompraBuilder builder;

    private final DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public PsvStringOcDirector(OrdenCompraBuilder builder) {
        this.builder = builder;
    }

    public void make(String src) {
        String[] lines = src.split("\\n");
        for (int i = 0; i < lines.length; i++) {
            String[] vars = lines[i].split("\\|");
            if (i == 0) {
                builder.createHeader(vars[0], toDate(vars[1]), vars[2]);
            } else if (i == 1) {
                builder.createSolicitante(vars[0], vars[1]);
            } else if (i == 2) {
                builder.createProveedor(vars[0], vars[1]);
            } else {
                builder.createProduct(vars[0], Integer.parseInt(vars[1]), vars[2]);
            }
        }
    }

    private Date toDate(String var) {
        try {
            return format.parse(var);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

}
