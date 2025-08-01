package katas.chainResponsability.impl;

import katas.chainResponsability.Doc;
import katas.chainResponsability.DocValidator;
import katas.chainResponsability.ValidationException;


public class TotalValidator extends DocValidator {


    @Override
    protected boolean isValid(Doc doc) {
        if (doc.getTotal() <= 0.0) {
            throw new ValidationException(305, "Total cannot be negative or zero");
        }
        return true;
    }

}
