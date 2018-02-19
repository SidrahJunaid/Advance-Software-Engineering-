package com.labassig6.rest;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.*;

import org.junit.Test;

public class VolRectTest {

	@Test
	public void test() {
		
		VolRect test1 = new VolRect();
		Response rectVoltest = test1.volumeOfRectangleInput(10, 4,3);

		@Test
		public void rectvoltest2() throws JSONException{
			JSONObject jtest = new JSONObject();
			int l = 10;
			int b = 4;
			int h = 3;
			int a = 120;
			jtest.put("Length ", l); 
			jtest.put("Breadth ", b);
			jtest.put("Height", h);
			jtest.put("Volume", a);
			String res = "@Produces(\"application/json\") Volume of Rectangle: " + jtest;
			Response d = Response.status(200).entity(res).build();
			
			Object rectVoltest;
			System.out.println("@Test VolumeofRect():" + rectVoltest + " = " + d);
			assertEquals(rectVoltest, d);
		}





}
