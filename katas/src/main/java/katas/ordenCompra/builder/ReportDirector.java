package katas.ordenCompra.builder;

import katas.ordenCompra.data.OrdenCompra;
import katas.ordenCompra.data.OrdenCompraProduct;

public class ReportDirector {

    private OrdenCompraReportBuilder builder;

    public ReportDirector(OrdenCompraReportBuilder builder) {
        super();
        this.builder = builder;
    }


    public void makeReport(OrdenCompra data) {
        builder.createHeader(data.getNo(), data.getFecha(), data.getLugarEntrega());
        builder.createPerson(data.getSolicitante().getRfc(), data.getSolicitante().getNombre());
        builder.createPerson(data.getProveedor().getRfc(), data.getProveedor().getNombre());
        for (OrdenCompraProduct i : data.getProducts()) {
            builder.createProduct(i.getCve()    , i.getCant(), i.getDesc());
        }

    }

}
