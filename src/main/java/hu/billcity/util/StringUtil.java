/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.util;

import hu.billcity.common.types.CurrencyUnit;
import hu.billcity.consts.Const;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * com.akam.util.<ClassName>
 * <ClassDescription>
 * <References>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 2/29/2016
 * @since 1.8
 */

public class StringUtil {

    public static String formatObjectAsString(Object o) {
        return PrettyPrinter.formatObjectAsString(o);
    }

    public static String implode(ArrayList<String> values) {
        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            sb.append(value);
            sb.append(Const._COMMA);
            sb.append(Const._SPACE);
        }
        int idxLastComma = sb.toString().lastIndexOf(Const._COMMA);
        if (idxLastComma != -1) {
            sb.replace(idxLastComma, idxLastComma, Const._SPACE);
        }
        return sb.toString();
    }

    public static boolean isNullable(String stringVal) {
        return (stringVal == null);
    }

    public static Integer toIntIgnoreNull(String intVal) {
        if (isNullable(intVal))
            return null;
        return Integer.valueOf(intVal);
    }

    public static CurrencyUnit toCurrencyUnitIgnoreNull(String currencyVal) {
        if (isNullable(currencyVal))
            return null;
        return CurrencyUnit.valueOf(currencyVal);
    }

    public static Long toLongIgnoreNull(String longVal) {
        if (isNullable(longVal))
            return null;
        return Long.valueOf(longVal);
    }

    public static BigDecimal toBigDecimalIgnoreNull(String doubleVal) {
        if (isNullable(doubleVal))
            return null;
        return BigDecimal.valueOf(Double.valueOf(doubleVal));
    }

    public static Timestamp toTimestampIgnoreNull(String timeStampVal) {
        if (isNullable(timeStampVal))
            return null;
        return Timestamp.valueOf(timeStampVal);
    }

    /**
     * ignoreNull(null) => null
     * ignoreNull("hello") => "hello"
     *
     * @param stringVal
     * @return
     */
    public static String ignoreNull(String stringVal) {
        if (isNullable(stringVal))
            return null;
        return stringVal;
    }

    /**
     * falsifyIfNull(null) => false
     * falsifyIfNull("true") => Boolean.TRUE
     * falsifyIfNull("t") => Boolean.TRUE
     *
     * @param stringVal
     * @return
     */
    public static Boolean falsifyIfNull(String stringVal) {
        if (isNullable(stringVal))
            return Boolean.FALSE;
        else if (stringVal.toUpperCase().charAt(0) == 'f')
            return Boolean.FALSE;
        else if (stringVal.toUpperCase().charAt(0) == 'T')
            return Boolean.FALSE;
        else
            return Boolean.FALSE;
    }

    public static BigDecimal makeZeroIfNull(String stringVal) {
        if (isNullable(stringVal))
            return BigDecimal.valueOf(0);

        return new BigDecimal(stringVal);
    }
}
