package StepExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SingleUserFromExcel {
	RequestSpecification req;
	Response res;
	File file;
	FileInputStream fis;
	Workbook w;
	Sheet s;
	JsonPath path;
	JSONObject obj;
	String expJ, expN;
	@Given("User is on reqres website")
	public void user_is_on_reqres_website() {
		RestAssured.baseURI="https://reqres.in/";
	    req=RestAssured.given();
	    System.out.println("Given step");
	}

	@When("User enters the data from the excel sheet")
	public void user_enters_the_data_from_the_excel_sheet() throws IOException {
		file=new File("C:\\Users\\NARADASA\\Desktop\\RestAssuredDemo\\src\\test\\resource\\ExcelData\\Data.xlsx");
		fis=new FileInputStream(file);
		w=new XSSFWorkbook(fis);
		s=w.getSheet("Userdata");
		String name=s.getRow(0).getCell(0).toString();
		String job=s.getRow(0).getCell(1).getStringCellValue();
		obj=new JSONObject();
		obj.put("name", name);
		obj.put("job", job);
		  expJ=job;
		  expN=name;
		  req.header("Content-Type", "application/json");
		  System.out.println("When Step");
	}

	@And("User hits the users API")
	public void user_hits_the_users_api() {
		res=req.body(obj.toJSONString()).post("api/users");
		  System.out.println("And Step");
	}

	@Then("Users are added to the List")
	public void users_are_added_to_the_list() {
		System.out.println(res.asPrettyString());
		path=res.jsonPath();
		  String job1=path.getString("job");
		  System.out.println(job1);
		  Assert.assertEquals(job1, expJ);
	 
	}

}
