/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Person Domain Class
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version February 26, 2016
 * @since 1.8
 */

public class Person {

    protected String name;
    protected List<String> phoneNumbers;
    protected String fax;
    protected String email;

    public Person() {
        this("", new ArrayList<>(), "", "");
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, List<String> phoneNumbers, String fax, String email) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.fax = fax;
        this.email = email;
    }
}
