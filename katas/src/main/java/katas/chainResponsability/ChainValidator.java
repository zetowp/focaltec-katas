package katas.chainResponsability;


public interface ChainValidator {

    void setNext(ChainValidator next);

    boolean validate(Doc doc);

}
