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

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a type with a single property. Warning: The equals method may not
 * work, if you use the Scalar in a JPA Environment, where Proxies are used! You
 * have to override it
 *
 * @author Konrad Renner
 */
public abstract class Scalar<T extends Comparable<? super T>>
        implements Comparable<Scalar<T>>, Serializable {

    public abstract T getValue();

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Scalar other = (Scalar) obj;
        return Objects.equals(getValue(), other.getValue());

    }

    @Override
    public String toString() {
        return getClass().getName() + "[value=" + getValue() + "]";
    }

    @Override
    public int compareTo(Scalar<T> o) {
        if (this.equals(o)) {
            return 0;
        }

        return getValue().compareTo(o.getValue());
    }
}
