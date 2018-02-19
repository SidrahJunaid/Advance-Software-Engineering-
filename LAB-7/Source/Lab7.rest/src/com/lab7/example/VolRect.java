package com.lab7.example;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
 
@Path("/volrect")

public class VolRect {
	@GET
	  @Produces("application/json")
	  public Response convertFtoC() throws JSONException {

		JSONObject jsonObject = new JSONObject();
		int length = 10;
		int breadth = 5;
		int height = 5;
		int volume;
		volume = (length * breadth * height); 
		jsonObject.put("Length ", length);
		jsonObject.put("Breadth", breadth);
		jsonObject.put("Height", height);
		jsonObject.put("Volume Rectangle", volume);

		String output = "@Produces(\"application/json\") Output: \n Volume of Rectangle: " + jsonObject;
		return Response.status(200).entity(output).build();
	  }

	  @Path("/{l}/{b}/{h}")
	  @GET
	  @Produces("application/json")
	  public Response convertFtoCfromInput(@PathParam("l") Integer l, @PathParam("b") Integer b , @PathParam("h") Integer h) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		Integer volume;
		volume =  (l * b * h); 
		jsonObject.put("Length", l);
		jsonObject.put("Breadth ", b);
		jsonObject.put("Height ", h);
		jsonObject.put("Volume Rectangle", volume); 
		String output = "@Produces(\"application/json\") \n Volume of Rectangle:" + jsonObject;
		return Response.status(200).entity(output).build();
	  }

}
