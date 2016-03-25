/*
    Copyright (C) 2016 Masood Fallahpoor

    This file is part of Tehran BRT.

    Tehran BRT is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Tehran BRT is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Tehran BRT. If not, see <http://www.gnu.org/licenses/>.
 */

package com.fallahpoor.tehranbrt;

import java.util.Locale;

/**
 * This class provides some locale-related utility methods.
 *
 * @author Masood Fallahpoor
 */
class LocaleUtils {

    public final static String LANGUAGE_EN = "en";
    public final static String LANGUAGE_FA = "fa";
    private static Locale sLocale;

    private LocaleUtils() {
    }

    public static void initialize() {
        initialize(LANGUAGE_FA);
    }

    public static void initialize(String language) {
        setLocale(language);
    }

    public static Locale getLocale() {
        return sLocale;
    }

    public static void setLocale(String language) {

        if (language.equalsIgnoreCase(LANGUAGE_EN)) {
            sLocale = new Locale(LANGUAGE_EN, "US");
        } else {
            sLocale = new Locale(LANGUAGE_FA, "IR");
        }

    }

} // end class LocaleUtils
