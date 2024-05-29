package com.restAssured.RestAssuredDemo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserGetDataTest1 {
	RequestSpecification req;
	Response res;
	JsonPath data;
	@BeforeTest
	public void init() {
		RestAssured.baseURI="https://reqres.in/";
	}
	@Test(priority=-1)
	public void getData() {
		req=RestAssured.given();
		res=req.get("api/users?page=2");
		System.out.println(res.asString());
		data=res.jsonPath();
		String email=data.getString("data[0].email");
		System.out.println(email);
		Assert.assertEquals(email, "michael.lawson@reqres.in");
		data=res.jsonPath();
		String first_name=data.getString("data[0].first_name");
		System.out.println(first_name);
		Assert.assertEquals(first_name, "Michael");
	}
	@Test(priority=0,enabled=false)
	public void addData() {
		req=RestAssured.given();
		JSONObject obj=new JSONObject();
		obj.put("name","Narasimhulu");
		obj.put("job", "Capgemini");
		req.body(obj.toJSONString());
		res=req.post("api/users");
		System.out.println(res.asPrettyString());
	}
	@AfterTest
	public void deallocateMem() {
		req=null;
		res=null;
	}

}
