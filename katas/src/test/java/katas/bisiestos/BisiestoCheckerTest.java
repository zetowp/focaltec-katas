package katas.bisiestos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BisiestoCheckerTest {

    @Test
    public void testIsBisiesto() {
        BisiestoChecker checker = new BisiestoChecker();
        assertFalse(checker.isBisiesto(1));
        assertTrue(checker.isBisiesto(4));
        assertFalse(checker.isBisiesto(100));
        assertTrue(checker.isBisiesto(400));
        assertTrue(checker.isBisiesto(2020));
        assertTrue(checker.isBisiesto(2000));
        assertFalse(checker.isBisiesto(1800));
        assertFalse(checker.isBisiesto(1900));
    }
}
