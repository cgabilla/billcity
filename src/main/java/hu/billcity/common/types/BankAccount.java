package hu.billcity.common.types;

/**
 * hu.billcity.types
 *
 * <Class Description>
 *
 * <Reference source if any><a href=""></a>
 *
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 10:06 AM; 3/9/2016
 * @since 1.8
 */

public class BankAccount {
    protected String accountName;
    protected String accountNumber;

    public BankAccount(String accountName, String accountNumber) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }
}
