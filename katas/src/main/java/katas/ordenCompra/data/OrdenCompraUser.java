package katas.ordenCompra.data;


public class OrdenCompraUser {

    private String nombre;

    private String rfc;

    public OrdenCompraUser(String rfc, String nombre) {
        this.rfc = rfc;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

}
