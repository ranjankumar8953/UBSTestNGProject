package com.ubsdemo.util;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.response.Response;

public class ApiUtility {
	public static Response getAPI(String getURI) {
		return given().relaxedHTTPSValidation().when().get(getURI);
	}

	public static Response postAPI(String postURI, String body) {
		return given().relaxedHTTPSValidation().headers(Constants.contentType, Constants.applicationJson).body(body)
				.when().post(postURI);
	}

	public static Response putAPI(String putAPI, String body) {
		return given().relaxedHTTPSValidation().headers(Constants.contentType, Constants.applicationJson).body(body)
				.when().put(putAPI);
	}

}
