package Common_method;

import io.restassured.RestAssured;

import static  io.restassured.RestAssured.given;

public class Common_method_get {
	public static int responsestatuscodeextractor(String baseuri, String resource)
{
    //Declare base URI through arguments
	RestAssured.baseURI = baseuri;
	
	//Configure and return the status code
	int response_statuscode = given().when().get(resource).then().extract().statusCode();
	return response_statuscode;
			
}
public static String responsebodyextractor(String baseuri, String resource)
{
  //Declare base URI through arguments
	RestAssured.baseURI = baseuri;
	//Configure and return the response body
	String response_body = given().when().get(resource).then().extract().response().asString();
	return response_body;
	
}

}
