package hu.billcity.common.types;

/**
 * hu.billcity.common
 * <p/>
 * ISO-4217 Codes
 * <p/>
 * <p/>
 * Reference <a href="https://www.countries-ofthe-world.com/world-currencies.html">List of currencies of the world</a>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 6:34 AM; 3/5/2016
 * @since 1.8
 */
public enum CurrencyUnit {
    UNITED_STATES_DOLLAR("usd"),
    PHILIPPINE_PESO("php"),
    HUNGARIAN_FORINT("huf"),
    ROMANIAN_LEU("ron"),
    EUROPEAN_EURO("eur");

    public static final CurrencyUnit DEFAULT = HUNGARIAN_FORINT;
    String moneyUnitCode;

    CurrencyUnit(String moneyUnitCode) {
        this.moneyUnitCode = moneyUnitCode;
    }

    public String getValue() {
        return moneyUnitCode;
    }

    @Override
    public String toString() {
        return getValue();
    }
}