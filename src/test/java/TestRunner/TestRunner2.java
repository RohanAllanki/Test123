package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resource\\Features\\AddUser2.feature",glue="Steps",tags="",
//dryRun=true,//-it is used to get the details of all steps and step defination
monochrome=false,//true -- it is user to read more easier and simple format
plugin= {"pretty","html:target/HtmlReport/UserReport.html",
		"json: target/JsonReport/UserReport.json",
		"junit: target/JunitReport/UserReport.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}) //usage is used to run the code fast and display the proper output in details
public class TestRunner2 extends AbstractTestNGCucumberTests{

}
