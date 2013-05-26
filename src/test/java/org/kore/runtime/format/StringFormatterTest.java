/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.runtime.format;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author koni
 */
public class StringFormatterTest {
    
    StringFormatter formatter;

    @Before
    public void setUp() {
        formatter = new StringFormatter("TEST");
    }

    @Test
    public void testForerunBlanksTooShort() {
        String expected = "  TEST";
        
        String value = formatter.forerunBlanks(6);
        
        assertEquals(expected, value);
    }

    @Test
    public void testForerunBlanksTooLong() {
        String expected = "TES";

        String value = formatter.forerunBlanks(3);

        assertEquals(expected, value);
    }

    @Test
    public void testForerunBlanksLengthEquals() {
        String expected = "TEST";

        String value = formatter.forerunBlanks(4);

        assertEquals(expected, value);
    }

    @Test
    public void testForerunBlanksNULL() {
        String expected = "      ";
        formatter = new StringFormatter(null);
        String value = formatter.forerunBlanks(6);

        assertEquals(expected, value);
    }

    @Test
    public void testappendBlanksTooShort() {
        String expected = "TEST  ";

        String value = formatter.appendBlanks(6);

        assertEquals(expected, value);
    }

    @Test
    public void testappendBlanksTooLong() {
        String expected = "TES";

        String value = formatter.appendBlanks(3);

        assertEquals(expected, value);
    }

    @Test
    public void testappendBlanksLengthEquals() {
        String expected = "TEST";

        String value = formatter.appendBlanks(4);

        assertEquals(expected, value);
    }

    @Test
    public void testappendBlanksNULL() {
        String expected = "      ";
        formatter = new StringFormatter(null);
        String value = formatter.appendBlanks(6);

        assertEquals(expected, value);
    }
}