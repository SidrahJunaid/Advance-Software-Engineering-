package com.labassig6.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
@Path("/volume")
public class Volume {
	@GET
	@Produces("application/xml")
	public String volumeofCube() {
 
		int volume;
	    int side = 30;
		volume = (side * side * side);
 
		String a = "@Produces(\"application/xml\") \n Volume of cube: " + volume;
		return "<conversion>" + "<side>" + side + "</side>" + "<output>" + a + "</output>" + "</conversion>";
	}
 
	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String volumeofCubeInput(@PathParam("c") int c) {
		int volume;
		int side = c;
		volume= (side * side * side);
 
		String a= "@Produces(\"application/xml\") \n Volume of cube: " + volume;
		return "<conversion>" + "<side>" + side + "</side>" + "<output>" + a + "</output>" + "</conversion>";
	}

}
