package katas.MarsRoverkata.impl;

import java.util.Date;

import org.w3c.dom.Document;

import katas.ordenCompra.builder.OrdenCompraReportBuilder;


public class DomOrdenCompraBuilder implements OrdenCompraReportBuilder {

    private Document root;

    @Override
    public void createHeader(String no, Date fecha, String dirEntrega) {
    }

    @Override
    public void createPerson(String rfc, String nombre) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createProduct(String cve, int cantidad, String desc) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object createReport() {
        return root;
    }

}
