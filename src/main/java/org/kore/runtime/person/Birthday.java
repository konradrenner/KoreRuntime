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
import java.util.Date;
import java.util.Objects;
import org.kore.runtime.base.Scalar;

/**
 *
 * @author Konrad Renner
 */
public class Birthday extends Scalar<Date> {

    private Date birthday;

    Birthday() {
        //Constructor for Frameworks
    }

    public Birthday(Date birthday) {
        Objects.requireNonNull(birthday, "birthday value must not be null");
        if (birthday.after(new Date())) {
            throw new IllegalArgumentException("birthday must not be after now");
        }
        this.birthday = new Date(birthday.getTime());
    }

    @Override
    public Date getValue() {
        return new Date(birthday.getTime());
    }

    /**
     * Returns the difference in years between the birthday and now
     *
     * @return int - Age
     */
    public int getAge() {
        return getAge(new Date());
    }

    /**
     * Returns the difference in years between the birthday and the given date.
     * Throws an IllegalArgumentException if the given date, is before the date
     * of the Birthday Object
     *
     * @return int - Age
     * @see IllegalArgumentException
     */
    public int getAge(Date date) {
        Objects.requireNonNull(date, "given date must not be null");
        if (date.before(birthday)) {
            throw new IllegalArgumentException("given date must not be before the birthday");
        }


        Calendar day = Calendar.getInstance();
        day.setTime(birthday);

        Calendar now = Calendar.getInstance();
        now.setTime(date);
        return calculateAge(day, now);
    }

    public boolean isTodayBirthday() {
        Calendar day = Calendar.getInstance();
        day.setTime(birthday);

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());

        return isBirthday(day, now);
    }

    static int calculateAge(Calendar day, Calendar now) {
        int ret = now.get(Calendar.YEAR) - day.get(Calendar.YEAR);

        if (now.get(Calendar.MONTH) < day.get(Calendar.MONTH)) {
            ret--;
        } else if (now.get(Calendar.MONTH) == day.get(Calendar.MONTH) && now.get(Calendar.DAY_OF_MONTH) < day.get(Calendar.DAY_OF_MONTH)) {
            ret--;
        }

        return ret;
    }

    static boolean isBirthday(Calendar day, Calendar now) {

        return now.get(Calendar.MONTH) == day.get(Calendar.MONTH) && now.get(Calendar.DAY_OF_MONTH) == day.get(Calendar.DAY_OF_MONTH);
    }
}
