package katas.ordenCompra;

import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import katas.ordenCompra.builder.OrdenCompraReportBuilder;


public class DomOrdenCompraBuilder implements OrdenCompraReportBuilder<Document> {
    
    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Document doc;

    private Element root;

    private boolean isRequeestor = true;

    private Element products;

    @Override
    public void createHeader(String no, Date fecha, String dirEntrega) {
        initDocument();
        root = doc.createElement("PurchaseOrder");
        root.setAttribute("date", df.format(fecha));
        root.setAttribute("deliveryTo", dirEntrega);
        root.setAttribute("number", no);
        doc.appendChild(root);
    }

    private void initDocument() {
        try {
            if (doc == null)
                doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void createPerson(String rfc, String nombre) {
        Element person = doc.createElement(isRequeestor ? "Requestor" : "Provider");
        person.setAttribute("name", nombre);
        person.setAttribute("rfc", rfc);
        root.appendChild(person);
        isRequeestor = !isRequeestor;
    }

    @Override
    public void createProduct(String cve, int cantidad, String desc) {
        initProductsIfNecesary();
        Element product = doc.createElement("Product");
        product.setAttribute("description", desc);
        product.setAttribute("id", cve);
        product.setAttribute("quantity", cantidad + "");
        products.appendChild(product);
    }

    private void initProductsIfNecesary() {
        if (products == null) {
            products = doc.createElement("Products");
            root.appendChild(products);
        }
    }

    @Override
    public Document createReport() {
        return doc;
    }

    public static String toString(Document doc) {
        try {

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", 4);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            Writer out = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(out));
            return out.toString();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

}
