package katas.ordenCompra;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import katas.ordenCompra.builder.OrdenCompraReportBuilder;


public class ExcelOrdenCompraBuilder implements OrdenCompraReportBuilder<Workbook> {
    
    private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    private Workbook book;

    private Sheet sheet;

    private int index = 0;

    private int rowNumber = 0;

    private Row row;

    private boolean isSolicitante = true;

    private boolean firstProduct = true;

    @Override
    public void createHeader(String no, Date fecha, String dirEntrega) {
        initDocument();
        getOrCreateByRow();
        getOrCreate().setCellValue("Número de orden de compra");
        getOrCreate().setCellValue(no);
        getOrCreateByRow();
        getOrCreate().setCellValue("Fecha");
        getOrCreate().setCellValue(fecha);
        getOrCreateByRow();
        getOrCreate().setCellValue("Entregar en");
        getOrCreate().setCellValue(dirEntrega);
        getOrCreateByRow();
    }

    private void initDocument() {
        if (book == null) {
            book = new HSSFWorkbook();
            sheet = book.createSheet();
        }
    }

    @Override
    public void createPerson(String rfc, String nombre) {
        getOrCreateByRow();
        getOrCreate().setCellValue(isSolicitante ? "Solicitante" : "Proveedor");
        getOrCreateByRow();
        getOrCreate().setCellValue("RFC");
        getOrCreate().setCellValue("Nombre");
        getOrCreateByRow();
        getOrCreate().setCellValue(rfc);
        getOrCreate().setCellValue(nombre);
        getOrCreateByRow();
        isSolicitante = !isSolicitante;
    }

    @Override
    public void createProduct(String cve, int cantidad, String desc) {
        initProductsIfNecesary();
        getOrCreateByRow();
        getOrCreate().setCellValue(cve);
        getOrCreate().setCellValue(desc);
        getOrCreate().setCellValue("" + cantidad);
    }

    private void initProductsIfNecesary() {
        if (firstProduct) {
            getOrCreateByRow();
            getOrCreate().setCellValue("Productos");
            getOrCreateByRow();
            getOrCreate().setCellValue("ID");
            getOrCreate().setCellValue("Descripción");
            getOrCreate().setCellValue("Cantidad");
            firstProduct = false;
        }
    }

    @Override
    public Workbook createReport() {
        return book;
    }

    private Cell getOrCreate() {
        Cell cell = row.getCell(index);
        return cell == null ? row.createCell(index++) : cell;
    }

    private void getOrCreateByRow() {
        index = 0;
        row = sheet.getRow(rowNumber);
        if (row == null)
            row = sheet.createRow(rowNumber++);
    }


}
