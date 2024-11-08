package katas.ordenCompra.builder;

import java.util.Date;

import katas.ordenCompra.data.OrdenCompra;

public interface OrdenCompraBuilder {

    void createHeader(String no, Date fecha, String dirEntrega);

    void createSolicitante(String rfc, String nombre);

    void createProveedor(String rfc, String nombre);

    void createProduct(String cve, int cantidad, String desc);

    OrdenCompra create();


}
