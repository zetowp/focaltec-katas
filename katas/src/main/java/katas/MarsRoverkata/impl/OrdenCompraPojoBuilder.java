package katas.MarsRoverkata.impl;

import java.util.ArrayList;
import java.util.Date;

import katas.ordenCompra.builder.OrdenCompraBuilder;
import katas.ordenCompra.data.OrdenCompra;
import katas.ordenCompra.data.OrdenCompraProduct;
import katas.ordenCompra.data.OrdenCompraUser;


public class OrdenCompraPojoBuilder implements OrdenCompraBuilder {

    private OrdenCompra obj;

    @Override
    public void createHeader(String no, Date fecha, String dirEntrega) {
        obj = new OrdenCompra();
        obj.setNo(no);
        obj.setFecha(fecha);
        obj.setLugarEntrega(dirEntrega);
    }


    @Override
    public void createSolicitante(String rfc, String nombre) {
        obj.setSolicitante(new OrdenCompraUser(rfc, nombre));
    }

    @Override
    public void createProveedor(String rfc, String nombre) {
        obj.setProveedor(new OrdenCompraUser(rfc, nombre));
    }

    @Override
    public void createProduct(String cve, int cantidad, String desc) {
        if (obj.getProducts() == null)
            obj.setProducts(new ArrayList<>());
        obj.getProducts().add(new OrdenCompraProduct(cve, cantidad, desc));
    }

    @Override
    public OrdenCompra create() {
        return obj;
    }

}
