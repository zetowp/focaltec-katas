package katas.ordenCompra.builder;

import java.util.Date;

public interface OrdenCompraReportBuilder<T> {

    void createHeader(String no, Date fecha, String dirEntrega);

    void createPerson(String rfc, String nombre);

    void createProduct(String cve, int cantidad, String desc);

    T createReport();

}
