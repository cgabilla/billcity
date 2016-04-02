/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.rest.provider;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * hu.billcity.rest.provider.CustomJsonProvider - <ClassTitle>
 * <ClassDescription>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version Feb 2016
 * @see <a href="https://github.com/FasterXML/jackson-databind">Jackson Databind</a>
 * @since 1.8
 */

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class CustomJsonProvider extends JacksonJaxbJsonProvider {
    // final static Logger LOGGER = LogManager.getLogger(CustomJsonProvider.class);

    private static ObjectMapper mapper = new ObjectMapper();

    static {

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // To avoid null, let us our own customized serializer class
        mapper.getSerializerProvider().setNullKeySerializer(new CustomNullKeySerializer());

        // SerializationFeature for changing how JSON is written

        // to enable standard indentation ("pretty-printing"):
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // to allow serialization of "empty" POJOs (no properties to serialize)
        // (without this setting, an exception is thrown in those cases)
        // mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // to write java.util.Date, Calendar as number (timestamp):
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // DeserializationFeature for changing how JSON is read as POJOs:

        // to prevent exception when encountering unknown property:
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        // to allow coercion of JSON empty String ("") to null Object value:
        // mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        // JsonParser.Feature for configuring parsing settings:

        // to allow C/C++ style comments in JSON (non-standard, disabled by default)
        // (note: with Jackson 2.5, there is also `mapper.enable(feature)` / `mapper.disable(feature)`)
        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        // to allow (non-standard) unquoted field names in JSON:
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // to allow use of apostrophes (single quotes), non standard
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);


        // Always include a non-ASCII
        mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, false);
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
    }

    public CustomJsonProvider() {
        super();
        setMapper(mapper);
    }
}