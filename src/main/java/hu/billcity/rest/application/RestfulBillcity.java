package hu.billcity.rest.application;

import hu.billcity.rest.provider.MarshallingFeature;
import hu.billcity.rest.resource.DeveloperResource;
import hu.billcity.rest.resource.PartnerResource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@ApplicationPath("/ws")
public class RestfulBillcity extends Application {
    final  static Logger LOGGER = LogManager.getLogger(RestfulBillcity.class);

    private Set<Object> singletons = new HashSet<>();
    private Set<Class<?>> classes = new HashSet<>();
    private Map<String, Object> properties = new HashMap<>();

    public RestfulBillcity() {
        LOGGER.info("Initializing DbConst Application ...");
        LOGGER.info("Adding classes...");
        classes.add(MarshallingFeature.class);
        // classes.add(PartnerResource.class);
        // classes.add(DeveloperResource.class);

        LOGGER.info("Creating singleton objects...");
        singletons.add(new PartnerResource());
        LOGGER.info("... " + PartnerResource.class.getClass().getName());
        singletons.add(new DeveloperResource());
        LOGGER.info("... " + PartnerResource.class.getClass().getName());

        LOGGER.info("Configuring properties...");

        // Disabling WADL
        properties.put("jersey.config.server.wadl.disableWadl", true);
        LOGGER.info("... Disabling WADL");

        // Disabling Jersey auto discovery
        properties.put("jersey.config.disableAutoDiscovery", true);
        LOGGER.info("... Disabling Jersey auto discovery");
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }
}