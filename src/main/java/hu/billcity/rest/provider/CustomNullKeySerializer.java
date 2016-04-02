package hu.billcity.rest.provider;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import hu.billcity.util.ObjectUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * hu.billcity.rest.provider
 * <p/>
 * <Class Description>
 * <p/>
 * <Reference source if any><a href=""></a>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 2:58 PM; 3/8/2016
 * @since 1.8
 */


public class CustomNullKeySerializer extends JsonSerializer<Object> {
    final static Logger LOGGER = LogManager.getLogger(CustomNullKeySerializer.class);

    @Override
    public void serialize(Object nullKey, JsonGenerator jsonGenerator, SerializerProvider unused)
            throws IOException {
        /**
         * if json found null values, it will consider as a value and will not throw
         * a runtime exception error.
         */
        LOGGER.info("Configuring custom serialization for null object to avoid runtime exception ...");
        jsonGenerator.writeFieldName(ObjectUtil._NULL_OBJECT);
    }
}
