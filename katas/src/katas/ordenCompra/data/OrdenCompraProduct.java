package katas.ordenCompra.data;


public class OrdenCompraProduct {

    private String desc;

    private String cve;

    private int cant;

    public OrdenCompraProduct() {
    }

    public OrdenCompraProduct(String cve, int cant, String desc) {
        this.cve = cve;
        this.cant = cant;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCve() {
        return cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

}
