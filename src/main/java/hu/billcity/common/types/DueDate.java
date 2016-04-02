/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.common.types;

import hu.billcity.base.Domain;

/**
 * hu.billcity.common.BaseDate
 * <p/>
 * A BaseDate is a kind of date that will determine what date option that the payment will be
 * based on:
 * (0) No option
 * (1) The date the invoice was made; or
 * (2) The fulfillment date
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 2/29/2016
 * @since 1.8
 */


public class DueDate extends Domain {
    // duration of days
    public static final int ALPHA_DAYS = 3;
    public static final DueDate DEFAULT = new DueDate(Type.DEFAULT, ALPHA_DAYS);
    protected int alphaDays;
    protected DueDate.Type type;

    public DueDate(DueDate.Type type, int alphaDays) {
        this.type = type;
        this.alphaDays = alphaDays;
    }

    public enum Type {
        SINCE_INVOICE_DATE(0), FULFILLMENT_DATE(1);

        public static final Type DEFAULT = Type.SINCE_INVOICE_DATE;

        int ordinalVal;

        Type(int ordinalVal) {
            this.ordinalVal = ordinalVal;
        }
    }
}
