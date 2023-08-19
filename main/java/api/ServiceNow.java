package api;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ServiceNow {

	static String accessToken;
	static String token;

	public String createOAuth() {
		RestAssured.baseURI="https://testleaf30-dev-ed.develop.my.salesforce.com/services/oauth2/token";
		Response post = RestAssured.given()
		.contentType("application/x-www-form-urlencoded")
		.accept("application/json")
		.formParam("grant_type", "password")
        .formParam("client_id", "3MVG9pRzvMkjMb6lZlt3YjDQwe0hk0f5ZPyWD38tfPYQ75KXUzZBGzM_c7I0o3yc6ua1IUk6lEQIy4U2sByrg")
        .formParam("client_secret", "79FFF874D54193B377A60354C71CBBE83120AD28A5D6BC536D2F68C94645DE98")
        .formParam("username", "ranjini.r@testleaf.com")
        .formParam("password", "Testleaf$321")
		.when()
		.post();
		
		System.out.println(post.asPrettyString());
		
		System.out.println(post.statusCode());
		
		accessToken = post.jsonPath().getString("access_token");
		
		return accessToken;
	}
	
	
	public String createLead() throws JsonProcessingException {
		
		 token="Bearer "+createOAuth();
		String createLeadDetails = CreateLead.createLeadDetails();
		RestAssured.baseURI="https://testleaf30-dev-ed.develop.my.salesforce.com/services/data/v58.0/sobjects/Lead/";
		Response res = RestAssured.given().log().all()
				.contentType("application/json")
				.header("Authorization",token)
				.body(createLeadDetails)			
				.post()
				.then().extract().response();
		System.out.println(res.prettyPrint());
		
		
		//return res.jsonPath().getString("id");
		CreateLeadResponsePojo as = res.as(CreateLeadResponsePojo.class);
		return as.getId();
			
	}
	
	@Test
	public void getLead() throws JsonProcessingException {
		String leadId = createLead();
		System.out.println("lead id---"+leadId);
		RestAssured.baseURI="https://testleaf30-dev-ed.develop.my.salesforce.com/services/data/v58.0/sobjects/Lead/";
		Response response = RestAssured.given().log().all()
		.accept("application/json")
		.header("Authorization",token)
		.when()
		.get(leadId)
		.then().extract().response();
		
		JsonPath jsonPath = response.jsonPath();
		
		System.out.println(response.prettyPrint());
		HashMap<String,String> map = jsonPath.get("attributes");
		
		System.out.println("****"+map.get("type"));
	}
	
}
