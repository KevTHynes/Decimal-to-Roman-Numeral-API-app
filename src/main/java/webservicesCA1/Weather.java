
package webservicesCA1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 *
 * @author x09092943/x14110768
 */
@Path("/weather")
public class Weather {
       String APIkey="fef3a15e6e7b783ae902f19e690be684";
    @GET
    @Path("/{param}")
    public Response GetGeocodeInfo(@PathParam("param") String city) 
    {
        String URL = "http://api.openweathermap.org/data/2.5/weather?q="
                + city + "&mode=json&appid=" + APIkey + "&units=Metric" ;
        // http://api.openweathermap.org/data/2.5/forecast?q=[Dublin]&mode=json&appid=[fef3a15e6e7b783ae902f19e690be684]
        Client c = ClientBuilder.newClient();
        Response r = c.target(URL).request().get();
        return r;
    } 
}
