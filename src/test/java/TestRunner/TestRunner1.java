package TestRunner;


import io.cucumber.testng.CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
//@CucumberOptions(features="src\\test\\resource\\Features\\AddUser.feature",glue="Steps")
//public class TestRunner1 {
//}
@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resource\\Features\\AddUser1.feature",glue="Steps")
public class TestRunner1 extends AbstractTestNGCucumberTests {

}