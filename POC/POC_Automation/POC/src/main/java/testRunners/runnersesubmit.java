package testRunners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.junit.Cucumber;
 

	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/test/resources/esubmit",
			glue= {"stepDefinitions"},
			plugin = { "pretty", "html:target/cucumber" })
					   		     
	public class runnersesubmit {
	}	

