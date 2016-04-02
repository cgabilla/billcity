package hu.billcity.common.types;

/*
 * DbConst is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

/**
 * com.akam.domain.<ClassName>
 * <ClassDescription>
 * <References>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 2/29/2016
 * @since 1.8
 */

public class TelephoneNumber {
    protected Type description;
    protected String number;

    public TelephoneNumber(Type description, String number) {
        this.description = description;
        this.number = number;
    }

    public Type getDescription() {
        return description;
    }

    public String getNumber() {
        return number;
    }

    public enum Type {
        LAND_LINE, MOBILE
    }
}
