package samples;
/**
 * samples
 * <p>
 * <Class Description>
 * <p>
 * <Reference source if any><a href=""></a>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 2:10 PM; 3/23/2016
 * @since 1.8
 */

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.varia.NullAppender;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class PartnerResourceSample {
    final static Logger LOGGER = LogManager.getLogger(PartnerResourceSample.class);
    public static void main(String[] args) {
        // only for a test
        org.apache.log4j.BasicConfigurator.configure(new NullAppender());
        createPartnerSample();
    }

    public static void createPartnerSample() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/billcity/ws/partners/create");
        MultivaluedMap<String, String> partnerData = new MultivaluedHashMap<>();
        partnerData.add("partnerName", "Cyrus G. Gabilla");
        partnerData.add("partnerType", "SUPPLIER");
        Response response = webTarget.request().post(Entity.form(partnerData));

        LOGGER.info(response.toString());

        partnerData = new MultivaluedHashMap<>();
        partnerData.add("partnerName", "Pedro G. Penduko");
        partnerData.add("partnerType", "CUSTOMER");
        response = webTarget.request().post(Entity.form(partnerData));

        LOGGER.info(response.toString());
    }
}