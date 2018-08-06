package methods;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JiraReusable {
	
	public static JsonPath rawtoJSON(Response res)
	{
		 String resp=res.asString();
         JsonPath x=new JsonPath(resp);
     	 return x;
	}
	
	public static String GetSessionKey()
	{
		RestAssured.baseURI="http://localhost:8080";
		Response res=
		given().header("Content-Type","application/json").log().all().
		body(JiraPayload.Login()).
		when().
		    post(JiraResource.REST1()).
		    then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().log().all().and().extract().response(); 
		JsonPath js=JiraReusable.rawtoJSON(res);
		String key=js.get("session.value");
		System.out.println(key);
		return key;
	}
	public static String Getid() {
		
		//Creating issue
		RestAssured.baseURI="http://localhost:8080";
		Response res=
		given().header("Content-Type","application/json").log().all().header("Cookie","JSESSIONID="+JiraReusable.GetSessionKey()).
		body(JiraPayload.Create()).
		when().
		    post(JiraResource.REST2()).
		    then().assertThat().statusCode(201).and().contentType(ContentType.JSON).and().log().all().and().extract().response(); 
		JsonPath js=JiraReusable.rawtoJSON(res);
		String id=js.get("id");
		System.out.println(id);
		return id;
		}
	public static String GetCommentid() 
	{
		//Adding comment
		RestAssured.baseURI="http://localhost:8080";
		Response res=
		given().header("Content-Type","application/json").log().all().header("Cookie","JSESSIONID="+JiraReusable.GetSessionKey()).
		body(JiraPayload.Comment()).
		when().
		    post(JiraResource.REST3()).
		    then().assertThat().statusCode(201).and().contentType(ContentType.JSON).and().log().all().extract().response(); 
		JsonPath js=JiraReusable.rawtoJSON(res);
		String cid=js.get("id");
		System.out.println(cid);
		return cid;
		  
		   
	}
	
}
