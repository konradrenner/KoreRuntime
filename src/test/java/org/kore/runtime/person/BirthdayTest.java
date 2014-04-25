/*
 * Copyright (C) 2014 Konrad Renner.
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
package org.kore.runtime.person;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author Konrad Renner
 */
public class BirthdayTest {

    @Test
    public void testCalcualteAgeSameYear() {
        Calendar birthday = new GregorianCalendar(1988, 7, 11);

        Calendar now = new GregorianCalendar(1988, 8, 5);

        assertEquals(0, Birthday.calculateAge(birthday, now));
    }

    @Test
    public void testCalcualteAgeMonthBefore() {
        Calendar birthday = new GregorianCalendar(1988, 7, 11);

        Calendar now = new GregorianCalendar(1990, 6, 5);

        assertEquals(1, Birthday.calculateAge(birthday, now));
    }

    @Test
    public void testCalcualteAgeDayBefore() {
        Calendar birthday = new GregorianCalendar(1988, 6, 11);

        Calendar now = new GregorianCalendar(1990, 6, 10);

        assertEquals(1, Birthday.calculateAge(birthday, now));
    }

    @Test
    public void testCalcualteAge() {
        Calendar birthday = new GregorianCalendar(1988, 5, 5);

        Calendar now = new GregorianCalendar(1990, 6, 5);

        assertEquals(2, Birthday.calculateAge(birthday, now));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateBirthdayIllegalState() {
        Calendar cal = new GregorianCalendar(2800, 2, 5);
        Birthday birthday = new Birthday(cal.getTime());
        
        assertTrue(false);
    }

    @Test
    public void testisBirthdayTrue() {
        Calendar birthday = new GregorianCalendar(1988, 5, 5);

        Calendar now = new GregorianCalendar(1990, 5, 5);

        assertTrue(Birthday.isBirthday(birthday, now));
    }

    @Test
    public void testisBirthdayFalseMonth() {
        Calendar birthday = new GregorianCalendar(1988, 5, 5);

        Calendar now = new GregorianCalendar(1990, 6, 5);

        assertFalse(Birthday.isBirthday(birthday, now));
    }

    @Test
    public void testisBirthdayFalseDay() {
        Calendar birthday = new GregorianCalendar(1988, 5, 5);

        Calendar now = new GregorianCalendar(1990, 5, 1);

        assertFalse(Birthday.isBirthday(birthday, now));
    }
}
