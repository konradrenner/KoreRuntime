/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.runtime.validation;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author koni
 */
public class ConstructorValidatorTest {

    ConstructorValidator validator;

    @Before
    public void setUp() {
        validator = new ConstructorValidator("Test", Integer.valueOf(5));
    }

    @Test
    public void testNullCheckFailsTrue() {
        assertFalse(validator.nullCheckFails());
    }

    @Test
    public void testNullCheckFailsFalse() {
        validator = new ConstructorValidator("Test", null);

        assertTrue(validator.nullCheckFails());
    }
}