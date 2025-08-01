package katas.chainResponsability;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import katas.chainResponsability.impl.ContentValidator;
import katas.chainResponsability.impl.TotalValidator;
import katas.chainResponsability.impl.TypeValidator;

public class ChainValidatorTest {

    @Test
    public void testChainValidator() {
        DocProcessor processor = new DocProcessor();
        assertEquals(200, processor.sendDocument(new Doc(Doc.Type.CFDI, null)));
        processor.setValidators(new ContentValidator(), new TypeValidator());
        assertEquals(301, processor.sendDocument(new Doc(Doc.Type.CFDI, null)));
        assertEquals(302, processor.sendDocument(new Doc(Doc.Type.CFDI, "".getBytes())));
        assertEquals(303, processor.sendDocument(new Doc(Doc.Type.CFDI, "hoa".getBytes())));
        assertEquals(200, processor.sendDocument(new Doc(Doc.Type.INVOICE, "hoa".getBytes())));
        assertEquals(200, processor.sendDocument(new Doc(Doc.Type.CFDI, "<cfdi></cfdi>".getBytes())));
        processor.setValidators(new ContentValidator(), new TypeValidator(), new TotalValidator());
        assertEquals(305, processor.sendDocument(new Doc(Doc.Type.INVOICE, "hoa".getBytes())));
        assertEquals(305, processor.sendDocument(new Doc(Doc.Type.CFDI, "<cfdi></cfdi>".getBytes())));
        assertEquals(200, processor.sendDocument(new Doc(Doc.Type.INVOICE, "hoa".getBytes(), 1)));
        assertEquals(200, processor.sendDocument(new Doc(Doc.Type.CFDI, "<cfdi></cfdi>".getBytes(), 0.001)));

    }

}
