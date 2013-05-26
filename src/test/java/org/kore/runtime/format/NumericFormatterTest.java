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
public class NumericFormatterTest {

    NumericFormatter formatter;

    @Before
    public void setUp() {
        formatter = new NumericFormatter(50);
    }

    @Test
    public void testWithForerunZerosLengthLower() {
        String expResult = "0050";
        String result = formatter.withForerunZeros(4);
        assertEquals(expResult, result);
    }

    @Test
    public void testWithForerunZerosEqualsLength() {
        String expResult = "50";
        String result = formatter.withForerunZeros(2);
        assertEquals(expResult, result);
    }

    @Test
    public void testWithForerunZerosNULL() {
        String expResult = "00";
        this.formatter = new NumericFormatter(null);
        String result = formatter.withForerunZeros(2);
        assertEquals(expResult, result);
    }
}