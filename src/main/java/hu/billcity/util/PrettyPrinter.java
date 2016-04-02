/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.util;

import hu.billcity.base.Domain;
import hu.billcity.consts.Const;

import java.lang.reflect.Field;

/**
 * com.akam.util.<ClassName>
 * <ClassDescription>
 * <References>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 2/28/2016
 * @since 1.8
 */

// TODO: Revise
public class PrettyPrinter {
    public static String formatObjectAsString(Object object) {

        StringBuilder sb = new StringBuilder("(\n");
        sb.append(String.format("%4s", "("));
        sb.append(object.getClass().getName());
        sb.append("),\n");
        sb.append(String.format("%4s", "("));

        Field[] fields = object.getClass().getDeclaredFields(); // get all the fields from your class.
        for (Field f : fields) {                                // iterate over each field...
            try {
                sb.append(f.getName()).append("=");

                Object value = f.get(object);

                if (f.get(object) == null) {                    // evaluate field value.
                    sb.append(Const._NULL_OBJECT);
                } else if (value instanceof String) {
                    sb.append(String.format("%s%s%s", "\"", f.get(object).toString(), "\""));
                } else if (value instanceof Domain) {
                    sb.append(PrettyPrinter.formatObjectAsString(value));
                }
                sb.append(value.getClass());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            sb.append(",").append("\n");
        }
        sb.append(String.format("%4s", ")"));
        sb.append("),\n");

        return sb.toString();
    }
}
