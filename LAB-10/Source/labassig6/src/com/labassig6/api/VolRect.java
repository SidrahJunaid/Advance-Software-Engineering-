package com.labassig6.rest;
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
	  public Response volumeOfRectangle() throws JSONException {

		JSONObject jsonObject = new JSONObject();
		int length = 10;
		int breadth = 4;
		int height = 3;
		int volume;
		volume = (length * breadth * height); 
		jsonObject.put("Length ", length);
		jsonObject.put("Breadth", breadth);
		jsonObject.put("Height", height);
		jsonObject.put("Volume", volume);

		String result = "@Produces(\"application/json\") Output: \n Volume of rectangle: " + jsonObject;
		return Response.status(200).entity(result).build();
	  }

	  @Path("/{l}/{b}/{h}")
	  @GET
	  @Produces("application/json")
	  public Response volumeOfRectangleInput(@PathParam("l") int l, @PathParam("b") int b ,@PathParam("h") int h) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		int volume;
		volume =  (l * b * h); 
		jsonObject.put("Length ", l);
		jsonObject.put("Breadth ", b);
		jsonObject.put("Height ", h);
		jsonObject.put("Volume", volume); 
		String result = "@Produces(\"application/json\") \n Volume of Rectangle:" + jsonObject;
		return Response.status(200).entity(result).build();
	  }

}
