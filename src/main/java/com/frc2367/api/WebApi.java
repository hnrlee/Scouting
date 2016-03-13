package com.frc2367.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class WebApi {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void getTeams(String competition) 
    {
    	Client client = ClientBuilder.newClient();
    	Response response = client.target("http://thebluealliance.com/api/v2/event/" + competition + "/teams")
    	  .request(MediaType.TEXT_PLAIN_TYPE)
    	  .header("X-TBA-App-Id", "frc2367:team-analysis:v0.1")
    	  .get();

    	System.out.println("status: " + response.getStatus());
    	System.out.println("headers: " + response.getHeaders());
    	System.out.println("body:" + response.readEntity(String.class));
    }
}
