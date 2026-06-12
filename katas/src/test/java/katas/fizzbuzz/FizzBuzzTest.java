package katas.fizzbuzz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzTest {

    @Test
    public void fizzBuzzTesst() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("1", fizzBuzz.convert(1));
        assertEquals("2", fizzBuzz.convert(2));
        assertEquals("Fizz", fizzBuzz.convert(3));
        assertEquals("4", fizzBuzz.convert(4));
        assertEquals("Buzz", fizzBuzz.convert(5));
        assertEquals("Fizz", fizzBuzz.convert(6));
        assertEquals("7", fizzBuzz.convert(7));
        assertEquals("8", fizzBuzz.convert(8));
        assertEquals("Fizz", fizzBuzz.convert(9));
        assertEquals("Buzz", fizzBuzz.convert(10));
        assertEquals("FizzBuzz", fizzBuzz.convert(15));
        assertEquals("FizzBuzz", fizzBuzz.convert(150));

    }

}
