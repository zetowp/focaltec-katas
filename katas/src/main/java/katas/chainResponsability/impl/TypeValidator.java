package katas.chainResponsability.impl;

import katas.chainResponsability.Doc;
import katas.chainResponsability.Doc.Type;
import katas.chainResponsability.DocValidator;
import katas.chainResponsability.ValidationException;

public class TypeValidator extends DocValidator {


    @Override
    protected boolean isValid(Doc doc) {
        if (doc.getType() == Type.CFDI) {
            if (!isAnXml(doc.getContent()))
                throw new ValidationException(303, "CFDI content must be XML");
        } else if (doc.getType() == Type.INVOICE) {
            if (!isAFile(doc.getContent()))
                throw new ValidationException(304, "INVOICE content must be a file");
        } else {
            throw new ValidationException(404, "Unknown document type: " + doc.getType());
        }
        return true;
    }

    private boolean isAFile(byte[] content) {
        return true;
    }

    private boolean isAnXml(byte[] content) {
        if (content == null || content.length == 0) return false;
        try {
            javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            javax.xml.parsers.DocumentBuilder builder = factory.newDocumentBuilder();
            java.io.ByteArrayInputStream input = new java.io.ByteArrayInputStream(content);
            builder.parse(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}