//get
package com.restAssured.RestAssuredDemo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class AppTest1 {
	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification a=RestAssured.given();
		Response b=a.get("api/users?page=1");
		System.out.println(b.asPrettyString());
		System.out.println(b.getStatusCode());
		System.out.println(b.getTime());
		System.out.println(b.statusLine());
	}
}
