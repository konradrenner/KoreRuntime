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
 * work, if you use the Scalar in a JPA Environment, where Proxies are used. If
 * you want to activate it, you have to use the {@link ScalarProxySupport}
 * Annotation
 *
 * @author Konrad Renner
 * @see ScalarProxySupport
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
        if (obj == null || !(obj instanceof Scalar)) {
            return false;
        }
        if (getClass().isAnnotationPresent(ScalarProxySupport.class) && getClass().getAnnotation(ScalarProxySupport.class).equalsSupport()) {
            if (negativeClassCheckWithProxySupport(obj)) {
                return false;
            }
        } else {
            if (negativeClassCheckWithoutProxySupport(obj)) {
                return false;
            }
        }
        final Scalar other = (Scalar) obj;
        return Objects.equals(getValue(), other.getValue());

    }
    
    boolean negativeClassCheckWithProxySupport(Object obj) {
        
        return !getClass().isAssignableFrom(obj.getClass());
    }

    private boolean negativeClassCheckWithoutProxySupport(Object obj) {
        return getClass() != obj.getClass();
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
