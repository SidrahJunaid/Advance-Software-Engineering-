package com.lab7.example;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.json.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

 
@Path("/volume")
public class Volume {
	  @Path("create/{l}")

	@GET
	@Produces("application/xml")
	public String calculateArea(@PathParam("l") Integer l){
		int volume;
		int side = l;
		volume = (side * side * side);
		MongoClientURI uri = new MongoClientURI("mongodb://sidrah:junaid@ds019648.mlab.com:19648/asedemo1");

		MongoClient client = new MongoClient(uri);

		DB db = client.getDB(uri.getDatabase());
		DBCollection users = db.getCollection("volume");
		BasicDBObject doc = new BasicDBObject();
		doc.put("length", side);
		
		doc.put("Volume", volume);
		users.insert(doc);

		String output = "@Produces(\"application/xml\") \n Volume of cube: " + volume;
		System.out.println("Inserted");

		return "<conversion>" + "<side>" + side + "</side>" + "<output>" + output + "</output>" + "</conversion>";
	}
 
	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String volumeInput(@PathParam("c") Integer c) {
		int volume;
		int side = c;
		volume = (side * side * side);
 
		String output = "@Produces(\"application/xml\") \n Volume of cube: " + volume;
		return "<conversion>" + "<side>" + side + "</side>" + "<output>" + output + "</output>" + "</conversion>";
	}
	  @Path("find")
	  @GET
	  @Produces("text/plain")
	  public void rectanglearearetrieve(){
		  
			MongoClientURI uri = new MongoClientURI("mongodb://sidrah:junaid@ds019648.mlab.com:19648/asedemo1");
			MongoClient client = new MongoClient(uri);

			DB db = client.getDB(uri.getDatabase());
			DBCollection users = db.getCollection("volume");
			BasicDBObject doc = new BasicDBObject();
			doc.put("volume", 27000);
			DBCursor cursor = users.find(doc);
			while (cursor.hasNext()) {
			    System.out.println(cursor.next());
			}
	  }
	  @Path("update/{z}/{x}")
	  @GET
	  @Produces("text/plain")
	  public String rectangleareaupdate(@PathParam("z") Integer z, @PathParam("x") Integer x){
			MongoClientURI uri = new MongoClientURI("mongodb://sidrah:junaid@ds019648.mlab.com:19648/asedemo1");
			MongoClient client = new MongoClient(uri);

			DB db = client.getDB(uri.getDatabase());
			DBCollection users = db.getCollection("volume");
			BasicDBObject doc = new BasicDBObject();
			doc.put("volume", z);
			DBCursor testItemsCursor = users.find(doc);
			if(testItemsCursor.hasNext()) {
			    DBObject testCodeItem = testItemsCursor.next();
			    testCodeItem.put("volume", x);
			    users.save(testCodeItem); }
			return "Updated";
			
	  }
	  @Path("delete/{w}")
	  @GET
	  @Produces("text/plain")
	  public String rectangleareadelete(@PathParam("w") Integer w){

			MongoClientURI uri = new MongoClientURI("mongodb://sidrah:junaid@ds019648.mlab.com:19648/asedemo1");
			MongoClient client = new MongoClient(uri);

			DB db = client.getDB(uri.getDatabase());
			DBCollection users = db.getCollection("volume");
			BasicDBObject doc = new BasicDBObject();
			doc.put("volume", w);
			DBCursor cursor = users.find(doc);
			while (cursor.hasNext()) {
			    DBObject item = cursor.next();
			    users.remove(item);
			}
			return "Deleted";
}

}


