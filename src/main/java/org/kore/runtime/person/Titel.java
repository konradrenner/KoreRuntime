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

package org.kore.runtime.person;

import java.util.Objects;
import org.kore.runtime.base.Scalar;

/**
 * Represents the titel of a person
 *
 * @author Konrad Renner
 */
public class Titel extends Scalar<String> {

    private String value;

    Titel() {
        //Constructor for Frameworks
    }

    public Titel(String value) {
        Objects.requireNonNull(value, "Given value must not be null");

        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
      
}
