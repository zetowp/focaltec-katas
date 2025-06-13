package katas.flyweight;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextProcessorTest {

    @Test
    public void testProcessor() {
        String input = "";
        FlyweightString result = FlyweightStringFactory.getString(input);
        assertEquals(input, result.toString());
        assertEquals(0, FlyweightStringFactory.size());
        input = "TextProcessorTest";
        result = FlyweightStringFactory.getString(input);
        assertEquals(input, result.toString());
        assertEquals(9, FlyweightStringFactory.size());
        result = FlyweightStringFactory.getString(input);
        assertEquals(input, result.toString());
        assertEquals(9, FlyweightStringFactory.size());
        input = "Hey, how are you";
        result = FlyweightStringFactory.getString(input);
        assertEquals(input, result.toString());
        assertEquals(17, FlyweightStringFactory.size());
    }

}
