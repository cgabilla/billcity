/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.common.types;

import hu.billcity.base.Domain;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static hu.billcity.util.StringUtil.isNullable;

/**
 * hu.billcity.common.<ClassName>
 * <ClassDescription>
 * <References>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 2/29/2016
 * @since 1.8
 */

public class PortalAddress extends Domain {
    public static final String DEFAULT_COUNTRY = "Hungary";
    public static final String DEFAULT_CITY = "Budapest";
    protected PortalAddress.Type type;
    protected String street;
    protected String city;
    protected String zipCode;
    protected String town;
    protected String country;

    public PortalAddress(Type type, String street, String city, String zipCode, String town, String country) {
        this.type = type;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.town = town;
        this.country = country;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public enum Type {
        MAIN_ADDRESS(0), BRANCH_ADDRESS(1), MAILING_ADDRESS(2);

        public static final Type DEFAULT = Type.MAIN_ADDRESS;
        private static final Map<Integer, Type> lookUpInts = new HashMap<>();

        static {
            int ordinalVal = 0;
            for (Type type : EnumSet.allOf(Type.class)) {
                lookUpInts.put(ordinalVal, type);
                ordinalVal += 1;
            }
        }

        int ordinalval;
        private int ordinalValue;


        Type(int ordinalval) {
            this.ordinalval = ordinalval;
        }

        /**
         * valueOf(1) => Type.BRANCH_ADDRESS
         *
         * @param ordinalVal
         * @return
         */
        public static Type valueOf(int ordinalVal) {
            return lookUpInts.get(ordinalVal);
        }

        /**
         * valueOfConstAsStringEnum("BRANCH_ADDRESS") => Type.BRANCH_ADDRESS
         * What is the equivalent value of constant enum given a string type instead of a constant enum?
         *
         * @param ordinalVal
         * @return
         */
        public static Type valueOfConstAsStringEnum(String ordinalVal) {


            if (isNullable(ordinalVal))
                return Type.DEFAULT;


            if (ordinalVal.equalsIgnoreCase("MAIN_ADDRESS"))
                return Type.MAIN_ADDRESS;
            else if (ordinalVal.equalsIgnoreCase("BRANCH_ADDRESS"))
                return Type.BRANCH_ADDRESS;
            else
                return Type.MAILING_ADDRESS;
        }

        /**
         * valueOfOrdinalAsStringInt("0") => Type.MAIN_ADDRESS
         * What is the equivalent value of ordinal given a string type instead of a value representation?
         *
         * @param ordinalVal
         * @return
         */
        public static Type valueOfOrdinalAsStringInt(String ordinalVal) {
            return isNullable(ordinalVal) ? Type.DEFAULT : Type.valueOf(Integer.valueOf(ordinalVal));
        }

    }
}
