/**
 * KoreRuntime Copyright (C) 2010 Free Software Foundation, Inc.
 * <http://fsf.org/>
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.kore.runtime.currency;

import java.util.Currency;

/**
 * Translates a given Money object to the given currency
 *
 * @author Konrad Renner
 */
public interface MoneyTranslater {

    /**
     * Creates a new Money instance in the given currency.
     *
     * @param money
     * @param currency
     * @return Money
     */
    Money translate(Money money, Currency currency);
}