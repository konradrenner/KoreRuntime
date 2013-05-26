/*
 * Copyright (C) 2013 Free Software Foundation.
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

package org.kore.runtime.format;

/**
 *
 * @author Konrad Renner
 */
public class StringFormatter {

    private final String value;
    private final String blank = " ";

    public StringFormatter(String value) {
        this.value = value == null ? "" : value;
    }

    /**
     * Fills the String with forerun blanks, if possible. If the length of the
     * String is longer than count, then the String will be substringed
     *
     * @param count
     * @return String
     */
    public String forerunBlanks(int count) {
        if (value.length() == count) {
            return value;
        }

        if (value.length() > count) {
            return value.substring(0, count);
        }

        String newString = value;
        do {
            newString = this.blank + newString;
        } while (newString.length() < count);

        return newString;
    }

    /**
     * Fills the String with appending blanks, if possible. If the length of the
     * String is longer than count, then the String will be substringed
     *
     * @param count
     * @return String
     */
    public String appendBlanks(int count) {
        if (value.length() == count) {
            return value;
        }

        if (value.length() > count) {
            return value.substring(0, count);
        }

        String newString = value;
        do {
            newString = newString + this.blank;
        } while (newString.length() < count);

        return newString;
    }
}
