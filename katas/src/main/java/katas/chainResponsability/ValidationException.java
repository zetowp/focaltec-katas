package katas.chainResponsability;

public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 3847065280672689758L;

    private int code;

    public ValidationException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
