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
import java.util.Objects;

/**
 * Represents an identifier, which internal value is a String
 *
 * @author Konrad Renner
 */
public class Identifier extends Term {

    private String value;

    Identifier() {
        //frameworks
    }

    public Identifier(String value) {
        Objects.requireNonNull(value, "Given value must not be null");
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public Identifier toUpperCase(Locale locale) {
        return new Identifier(value.toUpperCase(locale));
    }

    @Override
    public Identifier toLowerCase(Locale locale) {
        return new Identifier(value.toLowerCase(locale));
    }

    @Override
    public Identifier toLowerCase() {
        return new Identifier(value.toLowerCase());
    }

    @Override
    public Identifier toUpperCase() {
        return new Identifier(value.toUpperCase());
    }

}
