package com.restAssured.RestAssuredDemo;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AutherizationTest1 {

	public static void main(String[] args) {
		RestAssured.baseURI="https://bookstore.toolsqa.com/";
		JSONObject obj=new JSONObject();
		obj.put("userName", "Narasimha");
		obj.put("password", "Nara@123");
		RequestSpecification req=RestAssured.given().auth().basic("Narasimha", "@123").
				header("content-type","application/json").body(obj.toJSONString());
		Response res=req.post("Account/v1/Authorized");
		String data=res.asString();
		System.out.println(data);
		RequestSpecification req1=RestAssured.given().header("content-type","application/json").body(obj.toJSONString());
		Response res1=req1.post("Account/v1/GenerateToken");
		String data1=res1.asPrettyString();
		System.out.println(data1);
	}

}
