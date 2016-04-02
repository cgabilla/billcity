package hu.billcity.consts;

/**
 * hu.billcity.common.infotech
 * <p>
 * <Class Description>
 * <p>
 * <Reference source if any><a href=""></a>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 4:39 PM; 3/7/2016
 * @since 1.8
 */

public final class Const {
    // Debugging
    public static final boolean DEBUGGING_MODE = true;

    // Company information
    public static final Taylorsoft DEVELOPER = Taylorsoft.createInstance();

    // The table names
    public static final String TABLE_PARTNER = "partner";


    /**
     * Literal Constants
     * <p>
     * Code conventions:
     * _? String literal values
     * ?_ Numbers such as integer, byte, float, double
     */
    public static final String _SPACE = " ";
    public static final String _COMMA = ",";
    public static final String _EMPTY = "";
    public static final String _UNINITIALIZED_STRING = "?[UNINITIALIZED_STRING]";
    public static final String _NULL_OBJECT = "?[NULL_OBJECT]";
    public static final String _NEWLINE = "\n";
    public static final String _UNKNOWN_OBJECT = "?[UNKNOWN_OBJECT]";

    public static final Byte UNINITIALIZED_ID_ = -5;
    public static final Float UNINITIALIZED_FLOAT_ = 0f;

    private Const() {

        throw new AssertionError();
    }
}
