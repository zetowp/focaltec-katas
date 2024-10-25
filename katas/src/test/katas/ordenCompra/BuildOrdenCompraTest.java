package katas.ordenCompra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import java.util.Date;

import org.junit.Test;

import katas.ordenCompra.PsvOrdenCompraBuilder;
import katas.ordenCompra.builder.OrdenCompraBuilder;
import katas.ordenCompra.builder.ReportDirector;
import katas.ordenCompra.data.OrdenCompra;
import katas.ordenCompra.data.OrdenCompraProduct;
import katas.ordenCompra.data.OrdenCompraUser;

public class BuildOrdenCompraTest {

    @Test
    public void buildTest() {
        OrdenCompraBuilder mock = mock(OrdenCompraBuilder.class);
        new ReportDirector(mock).makeReport();
        assertNull(mock.createReport());
    }

    @Test
    public void psvBulderTest() {
        OrdenCompraBuilder builder = new PsvOrdenCompraBuilder();
        new ReportDirector(builder).makeReport();
        assertEquals(
                "10001|2021-10-22 17:13:31|Ofificina\n" + "FOC140516174|Focaltec S.A.P.I. de C.V.\n"
                        + "MOSA8311152G0|Alberto Montellano Sandoval\n" + "P1234567890|5|Caja de 100 tornillos\n"
                        + "P0000012345|5|Caja de 100 tuercas\n" + "P0000056789|5|Caja de 100 arandelas",
                new String(builder.createReport()));

    }

    @Test
    public void psvBulderDataTest() {
        OrdenCompraBuilder builder = new PsvOrdenCompraBuilder();
        new ReportDirector(builder).makeReport(buildData());
        assertEquals(
                "10001|2021-10-22 17:13:31|Ofificina\n" + "FOC140516174|Focaltec S.A.P.I. de C.V.\n"
                        + "MOSA8311152G0|Alberto Montellano Sandoval\n" + "P1234567890|5|Caja de 100 tornillos\n"
                        + "P0000012345|5|Caja de 100 tuercas\n" + "P0000056789|5|Caja de 100 arandelas",
                new String(builder.createReport()));

    }

    private OrdenCompra buildData() {
        OrdenCompra oc = new OrdenCompra();
        oc.setNo("10001");
        oc.setFecha(new Date(1634940811000l));
        oc.setLugarEntrega("Ofificina");
        oc.setSolicitante(new OrdenCompraUser("FOC140516174", "Focaltec S.A.P.I. de C.V."));
        oc.setProveedor(new OrdenCompraUser("MOSA8311152G0", "Alberto Montellano Sandoval"));
        oc.addProduct(new OrdenCompraProduct("P1234567890", 5, "Caja de 100 tornillos"));
        oc.addProduct(new OrdenCompraProduct("P0000012345", 5, "Caja de 100 tuercas"));
        oc.addProduct(new OrdenCompraProduct("P0000056789", 5, "Caja de 100 arandelas"));
        return oc;
    }

}
