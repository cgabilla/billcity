/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

/*
 * DbConst is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.consts;

import hu.billcity.common.infotech.Developer;
import hu.billcity.common.infotech.ITJobRole;

import java.util.ArrayList;

//@XmlRootElement       //only needed if we also want to generate XML
public final class Taylorsoft {

    public static final String COMPANY_FULL_NAME = "Taylorsoft Magyarország Informatikai Korlátolt Felelősségű Társaság";
    public static final String COMPANY_NAME = "Taylorsoft Magyarország Kft.";
    public static final String COMPANY_HEADQUARTER = "1134 Budapest, Angyalföldi út 5/B.";
    public static final String COMPANY_TAX_CODE = "24984096-2-41";
    public static final Developer DEV_CGABILLA = new Developer("Cyrus", "Gabilla", "cgabilla@gmail.com", ITJobRole
            .SOFTWARE_ENGINEER);
    private static Taylorsoft anInstance = new Taylorsoft();

    private Taylorsoft() {
        // TODO: None so far to include
    }

    public static Taylorsoft createInstance() {
        if (anInstance == null)
            anInstance = new Taylorsoft();
        return anInstance;
    }

    public static String getCompanyName() {
        return Taylorsoft.COMPANY_NAME;
    }

    public static String getCompanyFullName() {
        return Taylorsoft.COMPANY_FULL_NAME;
    }

    public static String getCompanyHeadquarter() {
        return Taylorsoft.COMPANY_HEADQUARTER;
    }

    public static String getCompanyTaxCode() {
        return Taylorsoft.COMPANY_TAX_CODE;
    }

    public static Developer getDeveloper() {
        return Taylorsoft.DEV_CGABILLA;
    }

    public static Developer[] getDevelopersAsArray() {
        ArrayList<Developer> devs = new ArrayList<>();
        devs.add(Taylorsoft.DEV_CGABILLA);
        return devs.toArray(new Developer[devs.size()]);
    }

    public static ArrayList<Developer> getDevelopersAsArrayList() {
        ArrayList<Developer> devs = new ArrayList<>();
        devs.add(Taylorsoft.DEV_CGABILLA);
        return devs;
    }
}
