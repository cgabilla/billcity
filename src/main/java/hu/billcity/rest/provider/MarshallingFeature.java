/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.rest.provider;

/**
 * hu.billcity.rest.provider.<ClassName> - <ClassTitle>
 * <ClassDescription>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @date Feb 2016
 * @since 1.8
 */

import com.fasterxml.jackson.jaxrs.base.JsonMappingExceptionMapper;
import com.fasterxml.jackson.jaxrs.base.JsonParseExceptionMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.glassfish.jersey.internal.InternalProperties;
import org.glassfish.jersey.internal.util.PropertiesHelper;

import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

public class MarshallingFeature implements Feature {
    final static Logger LOGGER = LogManager.getLogger(MarshallingFeature.class);

    private final static String JSON_FEATURE = MarshallingFeature.class.getSimpleName();

    @Override
    public boolean configure(FeatureContext context) {

        LOGGER.info("Registering marshalling features ...");
        context.register(JsonParseExceptionMapper.class);
        context.register(JsonMappingExceptionMapper.class);
        context.register(CustomJsonProvider.class, MessageBodyReader.class, MessageBodyWriter.class);
        context.register(CharsetResponseFilter.class);
        context.register(CustomServletContextListener.class);

        final Configuration config = context.getConfiguration();

        LOGGER.info("Disabling discoverability of org.glassfish.jersey.jackson.JacksonFeature ...");
        context.property(
                PropertiesHelper.getPropertyNameForRuntime(InternalProperties.JSON_FEATURE,
                        config.getRuntimeType()), JSON_FEATURE);

        return true;
    }
}