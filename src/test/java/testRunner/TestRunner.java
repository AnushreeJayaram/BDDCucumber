package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = {
				"D://Eclipse Workspace//Selenium Workspace//SDET Workspace//BDDCucumber//src//test//java//cucumber//Registration.feature",
				"D://Eclipse Workspace//Selenium Workspace//SDET Workspace//BDDCucumber//src//test//java//cucumber//Login.feature"
				},
		glue = "stepDefinitions",
		dryRun= true,
		monochrome = true,
		plugin= {"pretty","html:test-output"
				}
				
				)

public class TestRunner 
{

}
