package com.labassig6.rest;

import static org.junit.Assert.*;

import org.junit.Test;

public class VolumeTest {

	

	@Test
	public  void test() {
		Volume testvol = new Volume();
		String d = testvol.volumeofCubeInput(30);
		int z = 27000;
		String res1 = "@Produces(\"application/xml\") \n Volume of Cube: " + z;
		System.out.println("@Test Volume(): " + res1 + " = " + d);
		assertEquals(res1, d);
	}
	
	
}
