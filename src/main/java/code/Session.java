package code;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Session {
	Properties prop=new Properties();
	
	@BeforeTest

		public void Config() throws IOException
		{
			FileInputStream fis= new FileInputStream("/Users/manish/Documents/workspace-sts-3.9.4.RELEASE/JiraAPI/src/test/java/methods/config.properties");
			prop.load(fis);
		}


	@Test
	public void UpdatingComment() throws IOException
	{
		//Updating comment
		RestAssured.baseURI=prop.getProperty("LOCAL");
		Response res=
		given().header("Content-Type",prop.getProperty("Content-Type")).and().log().all().and().header("Cookie","JSESSIONID="+JiraReusable.GetSessionKey()).
		body(JiraPayload.Comment1()).
		when().
		    put(JiraResource.REST4()).
		    then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().log().all().and().extract().response(); 
		

	}

}
