package com.frc2367.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
	private String apiKey;
	
	public WebApi()
	{
		Scanner scan=null;
		try
		{
			scan = new Scanner(new File("apiKey.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("error reading key");
		}
		apiKey = scan.nextLine();
		System.out.println(apiKey);
	}
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
    	Response response = client.target("https://frc-api.firstinspires.org/v2.0/2016/events")
    			  .request(MediaType.TEXT_PLAIN_TYPE)
    			  .header("Authorization", apiKey)
    			  .get();
    	System.out.println("status: " + response.getStatus()); 
    	System.out.println("headers: " + response.getHeaders());
    	System.out.println("body:" + response.readEntity(String.class));
    }
}
