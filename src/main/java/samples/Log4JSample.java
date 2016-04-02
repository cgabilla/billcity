package samples;
/**
 * hu.billcity.samples
 * <p>
 * <Class Description>
 * <p>
 * <Reference source if any><a href=""></a>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 7:01 PM; 3/22/2016
 * @since 1.8
 */


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log4JSample {

    final  static Logger logger = LogManager.getLogger(Log4JSample.class);

    public static void main(String[] args) {

        Log4JSample obj = new Log4JSample();
        obj.runMe("Poloy");

    }

    private void runMe(String parameter) {

        if (logger.isDebugEnabled()) {
            logger.debug("This is debug : " + parameter);
        }

        if (logger.isInfoEnabled()) {
            logger.info("This is info : " + parameter);
        }

        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);

    }

}