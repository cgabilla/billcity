package hu.billcity.util;

import java.math.BigDecimal;

/**
 * hu.billcity.util.extras
 * <p/>
 * <Class Description>
 * <p/>
 * <Reference source if any><a href=""></a>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 8:41 PM; 3/9/2016
 * @since 1.8
 */


public class MathUtil {

    /**
     * Rounding up a money value in a reasonable way with two decimal places.
     *
     * @param aMoneyValue      Then amount of money to be rounded up.
     * @param aNoDecimalPlaces Tbe number of decimal places.
     * @return The rounded up money value in two decimal places.
     */
    public static BigDecimal roundMoneyValue(BigDecimal aMoneyValue, int aNoDecimalPlaces) {
        return aMoneyValue.setScale(aNoDecimalPlaces, BigDecimal.ROUND_HALF_UP);
    }
}
