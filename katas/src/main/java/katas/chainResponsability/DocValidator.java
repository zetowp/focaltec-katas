package katas.chainResponsability;

public abstract class DocValidator implements ChainValidator {

    private ChainValidator next;

    @Override
    public void setNext(ChainValidator next) {
        this.next = next;
    }

    @Override
    public boolean validate(Doc doc) {
        if (isValid(doc)) {
            if (next != null) {
                return next.validate(doc);
            }
        }
        return true;
    }

    protected abstract boolean isValid(Doc doc);

}
