package com.ubsdemo.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.ubsdemo.baseclass.TestBase;
import com.ubsdemo.util.ApiUtility;
import com.ubsdemo.util.Constants;

public class RestAssuredTC extends TestBase {
	public static Response response;
	public static JsonPath jsonpath;

	@Test(priority = 2)
	public void getAPIExecution() {
		response = ApiUtility.getAPI(prop.getProperty("getAPIURI"));
		String responseStr = response.getBody().asString();
		System.out.println("Get API Response is " + responseStr);
		jsonpath = new JsonPath(responseStr);
		String emailID = jsonpath.get("data[1].email");
		Assert.assertEquals(emailID, "lindsay.ferguson@reqres.in");
		System.out.println("Get API test is pass");
	}

	@Test(priority = 3)
	public void postAPIExecution() {
		response = ApiUtility.postAPI(prop.getProperty("postAPIURI"), Constants.postBody);
		String responseStr = response.getBody().asString();
		System.out.println("Post API Response is " + responseStr);
	}

	@Test(priority = 1, enabled = true)
	public void putAPIExecution() {
		response = ApiUtility.putAPI(prop.getProperty("putAPIURI"), Constants.putBody);
		String responseStr = response.getBody().asString();
		System.out.println("Put API Response is " + responseStr);
	}

}
