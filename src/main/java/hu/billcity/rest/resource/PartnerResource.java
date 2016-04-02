package hu.billcity.rest.resource;

import hu.billcity.common.types.PortalAddress;
import hu.billcity.domain.Partner;
import hu.billcity.model.PartnerServices;
import hu.billcity.util.ObjectUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * hu.billcity.rest.resource
 * <p>
 * <Class Description>
 * <p>
 * <Reference source if any><a href=""></a>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 10:18 AM; 3/5/2016
 * @since 1.8
 */

@Path("/partners")
public class PartnerResource {
    final static Logger LOGGER = LogManager.getLogger(PartnerResource.class);

    private static PartnerServices model = PartnerServices.getInstance();

    public PartnerResource() {
        LOGGER.info("Creating PartnerResource object ...");
    }

    @GET
    @Path("find/{id}")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response getPartner(@PathParam("id") int id) {
        LOGGER.info("Filtered a coming web service request => /ws/partners/find/" + id);
        Partner partner = (Partner) model.fetch(id);

        if (ObjectUtil.isNullable(partner)) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(
                            "{message: \"Could not able to find /partners/" + id + " in the resource.\"}"
                    ).build();
        } else
            return Response.ok().entity(partner).build();

    }


    @DELETE
    @Path("purge/{id}")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response deletePartner(@PathParam("id") int id) {
        LOGGER.info("Filtered a coming web service request => /ws/partners/purge/" + id);
        boolean wasSuccessful = model.delete(id);
        if (wasSuccessful)
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(
                            "{message: \"No partner with id = " + id + " in the resource was found.\"}"
                    ).build();
        else
            return Response.ok().entity(
                    "{wasSuccessful: false}"
            ).build();

    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response createPartner(
            @DefaultValue("") @FormParam("partnerName") String partnerName,
            @DefaultValue("CUSTOMER") @FormParam("partnerType") String partnerType,
            @DefaultValue("") @FormParam("addressType") String addressType,
            @DefaultValue("") @FormParam("addressStreet") String addressStreet,
            @DefaultValue("") @FormParam("addressZipCode") String addressZipCode,
            @DefaultValue("") @FormParam("addressCity") String addressCity,
            @DefaultValue("") @FormParam("addressTown") String addressTown,
            @DefaultValue("") @FormParam("addressCountry") String addressCountry
    ) {
        // TODO Verify required values
        // and return a Response error if does not satisfy
        //        return Response.status(Response.Status.NOT_ACCEPTABLE)
        //                .entity(
        //                        "{message: \"Provide a non-empty values and locations is a must for a Partner.Type.CUSTOMER type.\"}"
        //        ).build();


        ///* If the web service request is customer type, we need the address fields
        // partnerType receives a const as string instead of enum, e.g.: CUSTOMER
        Partner.Type partnerTypeObj = Partner.Type.valueOfConstAsStringEnum(partnerType.toUpperCase());

        // addressType receives a const as string instead of enum, e.g.: MAIN_ADDRESS
        PortalAddress.Type addressTypeObj = PortalAddress.Type.valueOfConstAsStringEnum(addressType);

        boolean wasSuccessful;
        if (partnerTypeObj == Partner.Type.CUSTOMER) {

            wasSuccessful = model.createEntry(
                    partnerTypeObj,
                    partnerName,
                    // create the main address object
                    new PortalAddress(
                            addressTypeObj,
                            addressStreet,
                            addressCity,
                            addressZipCode,
                            addressTown,
                            addressCountry
                    )
            );
        } else {
            Object[] result = model.createEntry(
                    partnerTypeObj,
                    partnerName
            );
            wasSuccessful = (Boolean) result[0];

        }

        if (wasSuccessful) {
            return Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity(
                            "{message: \"Provide a non-empty values and locations is a must for a Partner.Type.CUSTOMER type.\"}"
                    ).build();
        } else {
            return Response.ok()
                    .entity(
                            "{message: \"" + partnerName + "(" + Partner.Type.CUSTOMER + ") was was successfully created.\"}"
                    ).build();
        }
    }
}