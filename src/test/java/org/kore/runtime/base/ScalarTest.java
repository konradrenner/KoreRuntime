/*
 * Copyright (C) 2013 Konrad Renner.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package org.kore.runtime.base;

import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Konrad Renner
 */
public class ScalarTest {

    Scalar<String> underTest;

    @Before
    public void setUp() {
        underTest = new TestScalar("TEST");
    }

    public void testEqualsSameInstance() {
        assertTrue(underTest.equals(underTest));
    }

    public void testEqualsOK() {
        assertTrue(underTest.equals(new TestScalar("TEST")));
    }

    public void testEqualsDifferentType() {

        Scalar<String> scalar = new Scalar<String>() {
            @Override
            public String getValue() {
                return "TEST";
            }
        };

        assertFalse(underTest.equals(scalar));
    }

    public void testDifferentValue() {
        assertTrue(underTest.equals(new TestScalar("TeST")));
    }

    class TestScalar extends Scalar<String> {

        private final String value;

        TestScalar(String v) {
            this.value = v;
        }

        @Override
        public String getValue() {
            return value;
        }
    }
}
