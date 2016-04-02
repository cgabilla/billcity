/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.common.types;
/**
 * hu.billcity.common.<ClassName>
 * <ClassDescription>
 * <References>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @date 2/29/2016
 * @since 1.8
 */

import hu.billcity.common.Person;

public class LocationAddress extends PortalAddress {
    protected Person contactPerson;

    public LocationAddress(Type type, String street, String city, String zipCode, String town, String country,
                           Person contactPerson) {
        super(type, street, city, zipCode, town, country);
        this.contactPerson = contactPerson;
    }

    public Person getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(Person contactPerson) {
        this.contactPerson = contactPerson;
    }
}
