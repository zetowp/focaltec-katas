package katas.ordenCompra.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class OrdenCompra {

    private String no;

    private Date fecha;

    private String lugarEntrega;

    private OrdenCompraUser solicitante;

    private OrdenCompraUser proveedor;

    private List<OrdenCompraProduct> products;


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }


    public OrdenCompraUser getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(OrdenCompraUser solicitante) {
        this.solicitante = solicitante;
    }

    public OrdenCompraUser getProveedor() {
        return proveedor;
    }

    public void setProveedor(OrdenCompraUser proveedor) {
        this.proveedor = proveedor;
    }

    public List<OrdenCompraProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrdenCompraProduct> products) {
        this.products = products;
    }

    public void addProduct(OrdenCompraProduct ordenCompraProduct) {
        if (products == null)
            products = new ArrayList<>();
        products.add(ordenCompraProduct);

    }

}
