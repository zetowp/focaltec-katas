package katas.chainResponsability.impl;

import katas.chainResponsability.Doc;
import katas.chainResponsability.DocValidator;
import katas.chainResponsability.ValidationException;

public class ContentValidator extends DocValidator {


    @Override
    protected boolean isValid(Doc doc) {
        if (doc.getContent() == null) {
            throw new ValidationException(301, "Content cannot be null");
        }
        if (doc.getContent().length == 0) {
            throw new ValidationException(302, "Content cannot be empty");
        }
        return true;
    }
}
