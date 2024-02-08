package fib.asw.waslab01_cs;

import org.apache.hc.client5.http.fluent.Request;

//This code uses the Fluent API

public class SimpleFluentClient {

	private static String URI = "http://localhost:8080/waslab01_ss/";

	public final static void main(String[] args) throws Exception {
  	
  	/* Insert code for Task #4 here */
  	
  	System.out.println(Request.get(URI).execute().returnContent());
  	
  	/* Insert code for Task #5 here */
  }
}