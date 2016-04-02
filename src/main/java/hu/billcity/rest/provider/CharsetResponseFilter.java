/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.rest.provider;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * hu.billcity.rest.provider.<ClassName> - <ClassTitle>
 * <ClassDescription>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version Feb 2016
 * @see <a href="http://stackoverflow.com/questions/5514087/jersey-rest-default-character-encoding/20569571">Charset and UTF-8</a>
 * @since 1.8
 */

@Provider
public class CharsetResponseFilter implements ContainerResponseFilter {
    final static Logger LOGGER = LogManager.getLogger(MarshallingFeature.class);

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) {
        MediaType type = response.getMediaType();
        if (type != null) {
            LOGGER.info("Configuring content type with utf-8 charset ...");
            if (!type.getParameters().containsKey(MediaType.CHARSET_PARAMETER)) {
                MediaType typeWithCharset = type.withCharset("utf-8");
                response.getHeaders().putSingle("Content-Type", typeWithCharset);
            }
        }
    }
}