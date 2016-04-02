/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.domain;

import hu.billcity.base.Domain;
import hu.billcity.common.types.*;
import hu.billcity.util.ObjectUtil;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

import static hu.billcity.util.StringUtil.*;

/**
 * hu.billcity.domain.Partner
 * <p>
 * A Partner Domain
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 10:15PM; 2/28/2016
 * @see <a href="http://www.java2s.com/Code/Java/Database-SQL-JDBC/StandardSQLDataTypeswithTheirJavaEquivalents.htm">JDBC Types to Standard SQL Types</a>
 * @since 1.8
 */

public class Partner extends Domain {

    protected Integer id;
    protected String name;

    protected Partner.Type type;
    protected List<BankAccount> bankAccountDetails;
    protected String companyRegisteredId;
    protected String taxNumber;
    protected String euTaxNumber;
    protected DueDate dueDate;
    protected PaymentMethod paymentMethod;
    protected Integer priceGroupId;
    protected BigDecimal remainingCreditValue;
    protected String website;
    protected CurrencyUnit defaultCurrencyUnit;
    protected Integer groupId;
    protected String note;
    protected Timestamp dateInserted;
    protected Integer taxGroupId;
    protected Long serialNumber;
    protected Timestamp dateCreated;
    protected String salesmanPartnerId;
    protected Timestamp dateLastModified;
    protected Boolean isArchived;
    protected Integer displayPhotoBlobId;
    protected Integer journalId;
    protected List<PortalAddress> portalAddresses;

    // The person who modifies or creates an entry of a Partner
    // and this is a Partner ID as well of the person or an operator/user.
    protected Integer userOperatorId;


    public Partner(Partner.Type type, String name) {
        this(
                type,
                name,
                null,

                // taxes are not integer values
                null,
                null,

                // TODO Query and fill this attribute to update
                null,

                // TODO Query and fill this attribute to update
                PaymentMethod.DEFAULT,
                null,

                // the id ordinalval will be used for the look up table
                null,

                null,

                // TODO Query and fill this attribute to update
                CurrencyUnit.DEFAULT,

                // the id ordinalval will be used for the look up table
                null,
                null,

                null,

                // the id ordinalval will be used for the look up table
                null,

                // the ordinalval is expected to be series of integer values
                null,

                null,

                // the ordinalval from the old database is a form of string
                // that is why it is a string ordinalval
                null,
                null,
                null,

                // TODO Query and fill this attribute to update
                new ArrayList<>(),
                null,
                null,

                // TODO Query and fill this attribute to update
                new ArrayList<>(),

                // there is a case that the operator of the system
                // is not the business man partner
                // this will be used to trace who modified an entry ordinalval
                null

        );
    }

    public Partner(Partner.Type partnerType, String name,
                   // the address fields
                   PortalAddress.Type addressType, String street, String city, String zipCode, String town, String country) {
        this(partnerType, name);

        // add an instance to the list of address as the main office type
        addAddress(new PortalAddress(addressType, street, city, zipCode, town, country));
    }

    public Partner(Partner.Type type, String name, String companyRegisteredId, String taxNumber, String euTaxNumber, DueDate dueDate, PaymentMethod paymentMethod, Integer priceGroupId, BigDecimal remainingCreditValue, String website, CurrencyUnit currency, Integer groupId, String note, Timestamp dateInserted, Integer taxGroupId, Long serialNumber, Timestamp dateCreated, String salesmanPartnerId, Timestamp dateLastModified, Boolean isArchived, List<BankAccount> bankAccountDetails, Integer displayPhotoBlobId, Integer journalId, List<PortalAddress> portalAddresses, Integer userOperatorId) {
        this.type = type;
        this.name = name;
        this.companyRegisteredId = companyRegisteredId;
        this.taxNumber = taxNumber;
        this.euTaxNumber = euTaxNumber;
        this.dueDate = dueDate;
        this.paymentMethod = paymentMethod;
        this.priceGroupId = priceGroupId;
        this.remainingCreditValue = remainingCreditValue;
        this.website = website;
        this.defaultCurrencyUnit = currency;
        this.groupId = groupId;
        this.note = note;
        this.dateInserted = dateInserted;
        this.taxGroupId = taxGroupId;
        this.serialNumber = serialNumber;
        this.dateCreated = dateCreated;
        this.salesmanPartnerId = salesmanPartnerId;
        this.dateLastModified = dateLastModified;
        this.isArchived = isArchived;
        this.bankAccountDetails = bankAccountDetails;
        this.displayPhotoBlobId = displayPhotoBlobId;
        this.journalId = journalId;
        this.portalAddresses = portalAddresses;
        this.userOperatorId = userOperatorId;
    }

    public static Partner valueOf(Map<String, String> partnerMap) {
        if (ObjectUtil.isNullable(partnerMap))
            return null;
        return new Partner(
                // the type expected here is an ordinal which came from the database
                // in the string form
                // valueOfOrdinalAsStringInt("0") => Partner.Type.Customer
                Partner.Type.valueOfOrdinalAsStringInt(partnerMap.get("type")),
                ignoreNull(partnerMap.get("name")),
                ignoreNull(partnerMap.get("company_registered_id")),

                // taxes are not integer values
                ignoreNull(partnerMap.get("tax_number")),
                ignoreNull(partnerMap.get("eu_tax_number")),

                // TODO Query and fill this attribute to update
                DueDate.DEFAULT,

                // TODO Query and fill this attribute to update
                PaymentMethod.DEFAULT,
                toIntIgnoreNull(partnerMap.get("price_group_id")),

                // the id ordinalval will be used for the look up table
                makeZeroIfNull(partnerMap.get("remaining_credit_value")),

                ignoreNull(partnerMap.get("website")),

                // TODO Query and fill this attribute to update
                CurrencyUnit.DEFAULT,

                // the id ordinalval will be used for the look up table
                toIntIgnoreNull(partnerMap.get("group_id")),
                ignoreNull(partnerMap.get("note")),

                toTimestampIgnoreNull(partnerMap.get("date_inserted")),

                // the id ordinalval will be used for the look up table
                toIntIgnoreNull(partnerMap.get("tax_group_id")),

                // the ordinalval is expected to be series of integer values
                toLongIgnoreNull(partnerMap.get("serial_number")),

                toTimestampIgnoreNull(partnerMap.get("date_created")),

                // the ordinalval from the old database is a form of string
                // that is why it is a string ordinalval
                ignoreNull(partnerMap.get("salesman_partner_id")),
                toTimestampIgnoreNull(partnerMap.get("last_date_modified")),
                falsifyIfNull(partnerMap.get("is_archived")),

                // TODO Query and fill this attribute to update
                new ArrayList<>(),
                toIntIgnoreNull(partnerMap.get("display_photo_blog_id")),
                toIntIgnoreNull(partnerMap.get("journal_id")),

                // TODO Query and fill this attribute to update
                new ArrayList<>(),

                // there is a case that the operator of the system
                // is not the business man partner
                // this will be used to trace who modified an entry ordinalval
                toIntIgnoreNull(partnerMap.get("user_operator_dd"))
        );
    }


    @Override
    public String toString() {
        return (new StringBuilder()).append("Partner{").
                append("id=").append(id).
                append(", name='").append(name).append('\'').
                append(", type=").append(type).
                append(", companyRegisteredId='").append(companyRegisteredId).append('\'').
                append(", taxNumber='").append(taxNumber).append('\'').
                append(", euTaxNumber='").append(euTaxNumber).append('\'').
                append(", dueDate=").append(dueDate).
                append(", paymentMethod=").append(paymentMethod).
                append(", priceGroupId=").append(priceGroupId).
                append(", remainingCreditValue=").append(remainingCreditValue).
                append(", website='").append(website).append('\'').
                append(", defaultCurrencyUnit=").append(defaultCurrencyUnit).
                append(", groupId=").append(groupId).
                append(", note='").append(note).append('\'').
                append(", dateInserted=").append(dateInserted).
                append(", taxGroupId=").append(taxGroupId).
                append(", serialNumber=").append(serialNumber).
                append(", dateCreated=").append(dateCreated).
                append(", salesmanPartnerId='").append(salesmanPartnerId).append('\'').
                append(", dateLastModified=").append(dateLastModified).
                append(", isArchived=").append(isArchived).
                append(", bankAccountDetails=").append(bankAccountDetails).
                append(", displayPhotoBlobId=").append(displayPhotoBlobId).
                append(", journalId=").append(journalId).
                append(", portalAddresses=").append(portalAddresses.toString()).
                append(", userOperatorId=").append(userOperatorId).
                append('}').toString();
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Partner.Type getType() {
        return type;
    }


    public void setType(Partner.Type type) {
        this.type = type;
    }


    public String getCompanyRegisteredId() {
        return companyRegisteredId;
    }


    public void setCompanyRegisteredId(String companyRegisteredId) {
        this.companyRegisteredId = companyRegisteredId;
    }


    public String getTaxNumber() {
        return taxNumber;
    }


    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }


    public String getEuTaxNumber() {
        return euTaxNumber;
    }


    public void setEuTaxNumber(String euTaxNumber) {
        this.euTaxNumber = euTaxNumber;
    }


    public DueDate getDueDate() {
        return dueDate;
    }


    public void setDueDate(DueDate dueDate) {
        this.dueDate = dueDate;
    }


    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }


    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public Integer getPriceGroupId() {
        return priceGroupId;
    }


    public void setPriceGroupId(Integer priceGroupId) {
        this.priceGroupId = priceGroupId;
    }


    public BigDecimal getRemainingCreditValue() {
        return remainingCreditValue;
    }


    public void setRemainingCreditValue(BigDecimal remainingCreditValue) {
        this.remainingCreditValue = remainingCreditValue;
    }


    public String getWebsite() {
        return website;
    }


    public void setWebsite(String website) {
        this.website = website;
    }


    public CurrencyUnit getDefaultCurrencyUnit() {
        return defaultCurrencyUnit;
    }

    public void setDefaultCurrencyUnit(CurrencyUnit defaultCurrencyUnit) {
        this.defaultCurrencyUnit = defaultCurrencyUnit;
    }

    public void setCurrencyUnit(CurrencyUnit currencyUnit) {
        this.defaultCurrencyUnit = currencyUnit;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<BankAccount> getBankAccountDetails() {
        return bankAccountDetails;
    }

    public void setBankAccountDetails(List<BankAccount> bankAccountDetails) {
        this.bankAccountDetails = bankAccountDetails;
    }

    public Timestamp getDateInserted() {
        return dateInserted;
    }

    public void setDateInserted(Timestamp dateInserted) {
        this.dateInserted = dateInserted;
    }

    public Integer getTaxGroupId() {
        return taxGroupId;
    }

    public void setTaxGroupId(Integer taxGroupId) {
        this.taxGroupId = taxGroupId;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getSalesmanPartnerId() {
        return salesmanPartnerId;
    }

    public void setSalesmanPartnerId(String salesmanPartnerId) {
        this.salesmanPartnerId = salesmanPartnerId;
    }

    public Timestamp getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(Timestamp dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    public Integer getDisplayPhotoBlobId() {
        return displayPhotoBlobId;
    }

    public void setDisplayPhotoBlobId(Integer displayPhotoBlobId) {
        this.displayPhotoBlobId = displayPhotoBlobId;
    }

    public Boolean isArchived() {
        return isArchived;
    }

    public Integer getJournalId() {
        return journalId;
    }


    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }


    public List<PortalAddress> getPortalAddresses() {
        return portalAddresses;
    }


    public void setPortalAddresses(List<PortalAddress> portalAddresses) {
        this.portalAddresses = portalAddresses;
    }


    public void addAddress(PortalAddress portalAddress) {
        portalAddresses.add(portalAddress);

    }


    public Integer getUserOperatorId() {
        return userOperatorId;
    }

    public void setUserOperatorId(Integer userOperatorId) {
        this.userOperatorId = userOperatorId;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    public enum Type {
        // Default
        CUSTOMER(0),
        SUPPLIER(1);

        public static final Type DEFAULT = CUSTOMER;
        public static final String DEFAULT_AS_STRING = DEFAULT.toString();

        private static final Map<Integer, Type> lookUpInts = new HashMap<>();

        static {
            int ordinalVal = 0;
            for (Type type : EnumSet.allOf(Type.class)) {
                lookUpInts.put(ordinalVal, type);
                ordinalVal += 1;
            }
        }

        int ordinalval;


        Type(int ordinalval) {
            this.ordinalval = ordinalval;
        }

        /**
         * valueOf(1) => Type.SUPPLIER
         *
         * @param ordinalVal
         * @return
         */
        public static Type valueOf(int ordinalVal) {
            return lookUpInts.get(ordinalVal);
        }

        /**
         * valueOfConstAsStringEnum("CUSTOMER") => Type.Customer
         *
         * @param ordinalVal
         * @return
         */
        public static Type valueOfConstAsStringEnum(String ordinalVal) {

            if (isNullable(ordinalVal))
                return Type.CUSTOMER;


            if (ordinalVal.equalsIgnoreCase("CUSTOMER"))
                return Type.CUSTOMER;
            else
                return Type.SUPPLIER;
        }

        /**
         * valueOfOrdinalAsStringInt("0") => Type.Customer
         *
         * @param ordinalVal
         * @return
         */
        public static Type valueOfOrdinalAsStringInt(String ordinalVal) {
            if (isNullable(ordinalVal))
                return Type.CUSTOMER;
            else
                return Partner.Type.valueOf(Integer.valueOf(ordinalVal));
        }

        public static  String getDefaultString() {
            return DEFAULT.toString();
        }
    }
}

