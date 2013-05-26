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
 * Formats a numeric into a specific String
 *
 * @author Konrad Renner
 */
public class NumericFormatter {
    
    private final Number value;
    private final String zero;
    
    public NumericFormatter(Number v) {
        if (v == null) {
            this.value = Integer.valueOf(0);
        } else {
            this.value = v;
        }
        this.zero = "0";
    }
    
    public NumericFormatter(int v) {
        this(Integer.valueOf(v));
    }

    /**
     *
     * Creates a String with forerun zeros. count speficies the desired size of
     * the String
     *
     * @param count
     * @return String
     */
    public String withForerunZeros(int count) {
        String ret = value.toString();
        if (ret.length() >= count) {
            return ret;
        }

        do {
            ret = zero + ret;
        } while (ret.length() < count);

        return ret;
    }
}
