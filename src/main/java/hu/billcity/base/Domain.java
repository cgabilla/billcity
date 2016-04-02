package hu.billcity.base;


/**
 * hu.billcity.domain
 * <p/>
 * <Class Description>
 * <p/>
 * <Reference source if any><a href=""></a>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 9:34 AM; 3/5/2016
 * @since 1.8
 */

public class Domain {
    protected static final String secretMessage = "I am a Domain";

    public static void showDisplayMessage() {
        System.out.println(secretMessage);
    }

    @Override
    public String toString() {
        // TODO this is not working
        // return StringUtil.formatObjectAsString(this);
        return "<The domain base>";
    }
}
