/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.model;

import hu.billcity.base.Domain;
import hu.billcity.common.types.PortalAddress;
import hu.billcity.consts.DbConst;
import hu.billcity.domain.Partner;
import hu.billcity.sql.QueryHelper;
import hu.billcity.util.ObjectUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * hu.billcity.model.<ClassName>
 * <ClassDescription>
 * <References>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 3/1/2016
 * @since 1.8
 */

public class PartnerServices {
    static final Logger LOGGER = LogManager.getLogger(PartnerServices.class);
    public static final String TABLE_NAME = "partner";

    public static final String INSERT_PARTNER_QFMT = "INSERT INTO partner(name, type) VALUES('%s', %d)";
    public static final String INSERT_ADDRESS_QFMT
            = "INSERT INTO portalAddresses  (partner_id, address_type, street, city, zip_code, town, country) VALUES (%d, %d, '%s', '%s','%s','%s', '%s')";


    private static PartnerServices anInstance;

    public static PartnerServices getInstance() {
        return (anInstance == null) ?
                (anInstance = new PartnerServices()) :
                anInstance;
    }

    public Domain fetch(int id) {
        return Partner.valueOf(
                QueryHelper
                        .execSelectAllSingleResultById(TABLE_NAME, id, DbConst.getBillcityConnection())
        );
    }

    public boolean delete(int id) {
        return QueryHelper.execDeleteAsPreparedStatement(TABLE_NAME, id, DbConst.getBillcityConnection());
    }

    public boolean createEntry(Map<String, String> partnerMap) {
        if (ObjectUtil.isNullable(partnerMap))
            return false;

        Partner partnerVal;

        // If the a partner is a customer then the main location address is required
        if (Partner.Type.valueOfConstAsStringEnum(partnerMap.get("partner_type")) == Partner.Type.SUPPLIER) {
            partnerVal = new Partner(
                    // TODO Take note: the type value should be in the form of String but you have to consider
                    // the abbreviated value to convert it to an enum type

                    Partner.Type.valueOf(partnerMap.get("partner_type")),
                    partnerMap.get("partner_name")
            );
        } else {
            partnerVal = new Partner(
                    // TODO Take note: the type value should be in the form of String but you have to consider
                    // the abbreviated value to convert it to an enum type

                    // Partner.Type.CUSTOMER == Partner.Type.valueOfConstAsStringEnum("CUSTOMER") => true
                    Partner.Type.valueOfConstAsStringEnum(partnerMap.get("partner_type")),
                    partnerMap.get("partner_name")
            );
            partnerVal.addAddress(
                    new PortalAddress(
                            // PortalAddress.Type.MAIN_OFFICE == Partner.Type.valueOfConstAsStringEnum("MAIN_OFFICE") => true

                            PortalAddress.Type.valueOfConstAsStringEnum(partnerMap.get("partner_type")),
                            partnerMap.get("address_street"),
                            partnerMap.get("address_city"),
                            partnerMap.get("address_zip_code"),
                            partnerMap.get("address_town"),
                            partnerMap.get("address_country")
                    ));
        }

        return !ObjectUtil.isNullable(partnerVal);
    }

    //* Helper methods to add an entry to the database
    //*
    public Object[] createEntry(Partner.Type partnerType, String partnerName) {
        boolean wasSuccessful;

        String query = String.format(PartnerServices.INSERT_PARTNER_QFMT, partnerName, partnerType.ordinal());
        LOGGER.info("Query constructed: " + query);

        wasSuccessful = QueryHelper.executeQuery(query, DbConst.getBillcityConnection()) > 0;
        LOGGER.info("Query result: " + wasSuccessful);

        if (wasSuccessful)
            LOGGER.info(partnerName + " was successfully added to the database.");
        else
            LOGGER.info(partnerName + " was NOT successfully added to the database.");

        query = String.format(QueryHelper.QUERY_SELECT_ID_FMT, PartnerServices.TABLE_NAME, String.format("name LIKE '%s%%'", partnerName));
        LOGGER.info("Query constructed: " + query);
        int partnerId = QueryHelper.executeQueryFetchIdOnly(query, DbConst.getBillcityConnection());
        LOGGER.info("Query result: " + partnerId);
        return (new Object[]{Boolean.valueOf(wasSuccessful), Integer.valueOf(partnerId)});
    }

    public boolean createEntry(Partner.Type partnerType, String partnerName, PortalAddress portalAddress) {
        Object[] result = createEntry(partnerType, partnerName);
        boolean wasSuccessful = (Boolean) result[0];
        if (wasSuccessful) {
            int partnerId = (Integer)result[1];
            String query = String.format(INSERT_ADDRESS_QFMT,
                    partnerId,
                    portalAddress.getType().ordinal(),
                    portalAddress.getStreet(),
                    portalAddress.getCity(),
                    portalAddress.getZipCode(),
                    portalAddress.getTown(),
                    portalAddress.getCountry()
            );
            LOGGER.info("Query constructed: " + query);
            wasSuccessful = QueryHelper.executeQuery(query, DbConst.getBillcityConnection()) > 0;
            LOGGER.info("Query result: " + wasSuccessful);
        }

        if (wasSuccessful)
            LOGGER.info(portalAddress + " was successfully added to the database.");
        else
            LOGGER.info(portalAddress + " was NOT successfully added to the database.");

        return wasSuccessful;
    }
}
