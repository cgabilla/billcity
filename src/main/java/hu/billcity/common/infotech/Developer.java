package hu.billcity.common.infotech;

/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */


import hu.billcity.common.Employee;


/**
 * com.akam.infotech.Developer
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version February 26, 2016
 * @since 1.8
 */

public class Developer extends Employee {
    protected ITJobRole itJobRole;

    public Developer(String firstName, String lastName, String email, ITJobRole itJobRole) {
        super(firstName, lastName, email);
        this.itJobRole = itJobRole;
    }

    public void setRole(ITJobRole itJobRole) {
        this.itJobRole = itJobRole;
    }
}
