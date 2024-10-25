package katas.ordenCompra.builder;

import java.util.Date;

import katas.ordenCompra.data.OrdenCompra;
import katas.ordenCompra.data.OrdenCompraProduct;

public class ReportDirector {

    private OrdenCompraBuilder builder;

    public ReportDirector(OrdenCompraBuilder builder) {
        super();
        this.builder = builder;
    }

    public void makeReport() {
        builder.createHeader("10001", new Date(1634940811000l), "Ofificina");
        builder.createPerson("FOC140516174", "Focaltec S.A.P.I. de C.V.");
        builder.createPerson("MOSA8311152G0", "Alberto Montellano Sandoval");
        builder.createProduct("P1234567890", 5, "Caja de 100 tornillos");
        builder.createProduct("P0000012345", 5, "Caja de 100 tuercas");
        builder.createProduct("P0000056789", 5, "Caja de 100 arandelas");
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
