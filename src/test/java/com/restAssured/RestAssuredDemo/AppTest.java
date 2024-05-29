//get
package com.restAssured.RestAssuredDemo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class AppTest 
{
	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification a=RestAssured.given();
		Response b=a.get("api/users?page=2");
		System.out.println(b.asPrettyString());
		System.out.println(b.asString());
		System.out.println(b.statusCode());
		System.out.println(b.getStatusLine());
		System.out.println(b.equals(b));
		System.out.println(b.getTime());
	}
}
