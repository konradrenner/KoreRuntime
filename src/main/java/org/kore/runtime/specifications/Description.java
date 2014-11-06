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
 * Represents a textual description
 *
 * @author Konrad Renner
 */
public class Description extends Term {

    private String value;

    Description() {
        //frameworks
    }

    public Description(String value) {
        Objects.requireNonNull(value, "Given value must not be null");
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public Description toUpperCase(Locale locale) {
        return new Description(value.toUpperCase(locale));
    }

    @Override
    public Description toLowerCase(Locale locale) {
        return new Description(value.toLowerCase(locale));
    }

    @Override
    public Description toLowerCase() {
        return new Description(value.toLowerCase());
    }

    @Override
    public Description toUpperCase() {
        return new Description(value.toUpperCase());
    }
}
