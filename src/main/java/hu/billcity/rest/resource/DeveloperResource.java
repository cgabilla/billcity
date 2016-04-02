/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.rest.resource;

/**
 * hu.billcity.rest.resource.DeveloperResource
 * <ClassDescription>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @date Feb 2016
 * @see <a href="http://wiki.fasterxml.com/JacksonHowToCustomSerializers">Serializing null to something.</a> *
 * @since 1.8
 */
/**

 */

import hu.billcity.consts.Taylorsoft;
import hu.billcity.common.infotech.Developer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/billcity/about")
public class DeveloperResource {
    final static Logger LOGGER = LogManager.getLogger(DeveloperResource.class);

    public DeveloperResource() {
        LOGGER.info("Creating DeveloperResource object ...");
    }

    @GET
    @Path("/company/name/{nameType}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getCompanyName(@PathParam("nameType") String nameType) {
        if (nameType.equalsIgnoreCase("short"))
            return Taylorsoft.getCompanyName();
        else if (nameType.equals("full"))
            return Taylorsoft.getCompanyFullName();
        else
            return ("{message: \"Invalid company name type\"}");
    }

    @GET
    @Path("/company/location")
    @Produces({MediaType.APPLICATION_JSON})
    public String getCompanyHeadquarter() {
        return Taylorsoft.getCompanyHeadquarter();
    }

    @GET
    @Path("/tax/code")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCompanyTaxCode() {
        return Taylorsoft.getCompanyTaxCode();
    }

    @GET
    @Path("/developers")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Developer> getDevelopers() {
        return Taylorsoft.getDevelopersAsArrayList();
    }


    @GET
    @Path("easter")
    @Produces(MediaType.APPLICATION_JSON)
    public String greetUser(@DefaultValue("Cyrus") @QueryParam("name") String name) {
        return String.format("Maayong %s ka-ninyong tanan.", name);
    }
}