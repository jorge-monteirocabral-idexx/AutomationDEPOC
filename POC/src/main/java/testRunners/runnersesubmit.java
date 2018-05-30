package testRunners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
//@RunWith(Cucumber.class)
//@CucumberOptions(features="resources/Urinalysis/features", glue="")

//public class runnersUrinalysis {

	@RunWith(Cucumber.class)
	@CucumberOptions(features="resources/esubmit/features", glue="")

	public class runnersesubmit {
	}	

