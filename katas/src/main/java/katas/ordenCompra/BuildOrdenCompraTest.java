package katas.ordenCompra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.w3c.dom.Document;

import katas.MarsRoverkata.impl.OrdenCompraPojoBuilder;
import katas.ordenCompra.builder.OrdenCompraBuilder;
import katas.ordenCompra.builder.OrdenCompraReportBuilder;
import katas.ordenCompra.builder.PsvStringOcDirector;
import katas.ordenCompra.builder.ReportDirector;
import katas.ordenCompra.data.OrdenCompra;

public class BuildOrdenCompraTest {

    private static final String XML_TEST = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"
            + "<PurchaseOrder date=\"2021-10-22 17:13:31\" deliveryTo=\"Ofificina\" number=\"10001\">\n"
            + "    <Requestor name=\"Focaltec S.A.P.I. de C.V.\" rfc=\"FOC140516174\"/>\n"
            + "    <Provider name=\"Alberto Montellano Sandoval\" rfc=\"MOSA8311152G0\"/>\n" + "    <Products>\n"
            + "        <Product description=\"Caja de 100 tornillos\" id=\"P1234567890\" quantity=\"5\"/>\n"
            + "        <Product description=\"Caja de 100 tuercas\" id=\"P0000012345\" quantity=\"5\"/>\n"
            + "        <Product description=\"Caja de 100 arandelas\" id=\"P0000056789\" quantity=\"5\"/>\n"
            + "    </Products>\n" + "</PurchaseOrder>\n" + "";
    private static final String TEST_DATA = "10001|2021-10-22 17:13:31|Ofificina\n" + "FOC140516174|Focaltec S.A.P.I. de C.V.\n"
            + "MOSA8311152G0|Alberto Montellano Sandoval\n" + "P1234567890|5|Caja de 100 tornillos\n"
            + "P0000012345|5|Caja de 100 tuercas\n" + "P0000056789|5|Caja de 100 arandelas";


    @Test
    public void psvBulderDataTest() {
        OrdenCompraReportBuilder<String> builder = new PsvOrdenCompraBuilder();
        new ReportDirector(builder).makeReport(buildData());
        assertEquals(TEST_DATA, builder.createReport());
    }

    @Test
    public void bulderPojoTest() {
        OrdenCompra obj = buildData();
        assertEquals("Ofificina", obj.getLugarEntrega());
        assertEquals(3, obj.getProducts().size());
    }

    private OrdenCompra buildData() {
        OrdenCompraBuilder builder = new OrdenCompraPojoBuilder();
        new PsvStringOcDirector(builder).make(TEST_DATA);
        return builder.create();
    }

    @Test
    public void domBulderDataTest() {
        OrdenCompraReportBuilder<Document> builder = new DomOrdenCompraBuilder();
        OrdenCompra data = buildData();
        new ReportDirector(builder).makeReport(data);
        Document report = builder.createReport();
        String strResult = DomOrdenCompraBuilder.toString(report);
        assertEquals(XML_TEST, strResult);
        assertEquals(data.getProducts().size(), report.getElementsByTagName("Product").getLength());
    }

    @Test
    public void xlsxBulderDataTest() {
        OrdenCompraReportBuilder<Workbook> builder = new ExcelOrdenCompraBuilder();
        OrdenCompra data = buildData();
        new ReportDirector(builder).makeReport(data);
        Workbook report = builder.createReport();
        assertNotNull(report);
        Sheet sheet = report.getSheetAt(0);
        assertEquals("Focaltec S.A.P.I. de C.V.", sheet.getRow(6).getCell(1).getStringCellValue());
        assertEquals("P0000056789", sheet.getRow(16).getCell(0).getStringCellValue());
        assertEquals("Caja de 100 arandelas", sheet.getRow(16).getCell(1).getStringCellValue());
        assertEquals("5", sheet.getRow(16).getCell(2).getStringCellValue());
    }

}
