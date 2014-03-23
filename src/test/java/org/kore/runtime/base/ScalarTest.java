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

import java.util.ArrayList;
import java.util.Collections;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void testEqualsSameInstance() {
        assertTrue(underTest.equals(underTest));
    }

    @Test
    public void testEqualsOK() {
        assertTrue(underTest.equals(new TestScalar("TEST")));
    }

    @Test
    public void testEqualsProxyOK() {
        ProxyBaseScalar base = new ProxyBaseScalar("Hallo");
        assertTrue(base.equals(new ProxyScalar("Hallo")));
    }

    @Test
    public void testEqualsProxyNOK() {
        ProxyBaseScalar base = new ProxyBaseScalar("Hallo");
        assertFalse(base.equals(new ProxyScalar("hallo")));
    }

    @Test
    public void testEqualsDifferentType() {

        Scalar<String> scalar = new Scalar<String>() {
            @Override
            public String getValue() {
                return "TEST";
            }
        };

        assertFalse(underTest.equals(scalar));
    }

    @Test
    public void testDifferentValue() {
        assertFalse(underTest.equals(new TestScalar("TeST")));
    }

    @Test
    public void testCompareableEquals() {
        assertTrue(underTest.compareTo(new TestScalar("TEST")) == 0);
    }

    @Test
    public void testCompareableLower() {
        IntegerScalar higher = new IntegerScalar(5);
        IntegerScalar lower = new IntegerScalar(2);

        assertTrue(lower.compareTo(higher) < 0);
    }

    @Test
    public void testCompareableHigher() {
        IntegerScalar higher = new IntegerScalar(5);
        IntegerScalar lower = new IntegerScalar(2);

        assertTrue(higher.compareTo(lower) > 0);
    }

    @Test
    public void testCompareableList() {
        ArrayList<IntegerScalar> liste = new ArrayList<IntegerScalar>(2);
        liste.add(new IntegerScalar(5));
        liste.add(new IntegerScalar(2));

        Collections.sort(liste);
        assertEquals(new IntegerScalar(2), liste.get(0));
        assertEquals(new IntegerScalar(5), liste.get(1));

        Collections.reverse(liste);
        assertEquals(new IntegerScalar(5), liste.get(0));
        assertEquals(new IntegerScalar(2), liste.get(1));
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

    class IntegerScalar extends Scalar<Integer> {

        private final int value;

        public IntegerScalar(int value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return value;
        }
    }

    @ScalarProxySupport
    class ProxyBaseScalar extends Scalar<String> {

        private final String value;

        public ProxyBaseScalar(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    class ProxyScalar extends ProxyBaseScalar {
        public ProxyScalar(String value) {
            super(value);
        }
    }
}
