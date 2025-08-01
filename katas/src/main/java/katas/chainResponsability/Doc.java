package katas.chainResponsability;

public class Doc {

    public enum Type {
        CFDI, INVOICE
    }

    private Type type;

    private byte[] content;

    private double total;

    public Doc(Type type, byte[] content) {
        this(type, content, 0.0);
    }

    public Doc(Type type, byte[] content, double total) {
        this.type = type;
        this.content = content;
        this.total = total;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public byte[] getContent() {
        return content;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
