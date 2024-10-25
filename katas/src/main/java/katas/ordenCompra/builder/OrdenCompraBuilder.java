package katas.ordenCompra.builder;

import java.util.Date;

public interface OrdenCompraBuilder {

    void createHeader(String no, Date frcha, String dirEntrega);

    void createPerson(String rfc, String nombre);

    void createProduct(String cve, int cantidad, String desc);

    byte[] createReport();

}
