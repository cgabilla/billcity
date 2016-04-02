package hu.billcity.common.types;


import java.util.ArrayList;

/**
 * hu.billcity.domain.<ClassName>
 * <ClassDescription>
 * <References>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 2/29/2016
 * @since 1.8
 */

public class ContactInformation {
    protected String faxNumber;
    protected String emailAddress;
    protected ArrayList<TelephoneNumber> telephoneNumbers;

    public ContactInformation() {
        telephoneNumbers = new ArrayList<>();
    }

    public ContactInformation(String emailAddress, ArrayList<TelephoneNumber> telephoneNumbers) {
        this.emailAddress = emailAddress;
        this.telephoneNumbers = telephoneNumbers;
    }
}
