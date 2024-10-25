package katas.ordenCompra;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import katas.ordenCompra.builder.OrdenCompraBuilder;


public class PsvOrdenCompraBuilder implements OrdenCompraBuilder {
    
    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private final StringBuilder builder = new StringBuilder();

    @Override
    public void createHeader(String no, Date fecha, String dirEntrega) {
        builder.append(no);
        builder.append('|');
        builder.append(df.format(fecha));
        builder.append('|');
        builder.append(dirEntrega);
        builder.append('\n');
    }

    @Override
    public void createPerson(String rfc, String nombre) {
        builder.append(rfc);
        builder.append('|');
        builder.append(nombre);
        builder.append('\n');
    }

    @Override
    public void createProduct(String cve, int cantidad, String desc) {
        builder.append(cve);
        builder.append('|');
        builder.append(cantidad);
        builder.append('|');
        builder.append(desc);
        builder.append('\n');
    }

    @Override
    public byte[] createReport() {
        String result = builder.toString();
        return result.substring(0, result.length() - 1).getBytes();
    }

}
