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
package org.kore.runtime.specifications;

import java.util.Locale;
import org.kore.runtime.base.Scalar;

/**
 * Represents a description, identifier, text, etc.
 *
 * @author Konrad Renner
 */
public abstract class Term extends Scalar<String> {

    /**
     * Returns a Term object, which internal value is upper case formatted
     *
     * @param locale
     * @return Term
     * @see java.lang.String.toUpperCase(Locale locale)
     */
    public abstract Term toUpperCase(Locale locale);

    /**
     * Returns a Term object, which internal value is lower case formatted
     *
     * @param locale
     * @return Term
     * @see java.lang.String.toLowerCase(Locale locale)
     */
    public abstract Term toLowerCase(Locale locale);

    /**
     * Returns a Term object, which internal value is upper case formatted, in
     * the actual locale
     *
     * @return Term
     * @see java.lang.String.toUpperCase()
     */
    public Term toUpperCase() {
        return toUpperCase(Locale.getDefault());
    }

    /**
     * Returns a Term object, which internal value is lower case formatted, in
     * the actual locale
     *
     * @return Term
     * @see java.lang.String.toLowerCase()
     */
    public Term toLowerCase() {
        return toLowerCase(Locale.getDefault());
    }

    /**
     * Returns the internal value formatted with the given String. For details
     * about formatting see java.util.Formatter
     *
     * @param format
     * @return String
     * @see java.util.Formatter
     */
    public String getValueFormatted(String format) {
        return String.format(format, getValue());
    }
}
