/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.common;

/**
 * Employee
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @date February 26, 2016
 * @since 1.8
 */

import hu.billcity.util.StringUtil;

import java.util.Date;

public class Employee extends Person {

    // protected String emailAddress;
    protected String employeeId;
    protected Date dateHired;
    protected Date dateTerminated;
    protected boolean isTerminated;

    public Employee(String firstName, String lastName, String email) {
        super(String.format("%s %s", firstName, lastName));
    }

    @Override
    public String toString() {
        return StringUtil.formatObjectAsString(this);
    }
}