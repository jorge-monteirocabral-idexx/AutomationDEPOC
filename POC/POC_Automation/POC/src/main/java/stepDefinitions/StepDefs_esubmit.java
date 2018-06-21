package stepDefinitions;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection.Request;

import POC.POC.ConnectToDB;
import POC.POC.DBTasks;
import POC.POC.LynxxData;
import POC.POC.Requests;
import POC.POC.Singleton;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.Transformer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs_esubmit {

	static int value = 0;
	static int requestedResult=0; 
	DBTasks dbTasks;
	public static String requestID = "string";
	String request = "string";
	private String customerId;
	private String requistionId;
	private String veterinarian;
	private String collectionDate;
	private String clinicalDetails;
	private String patientDOB;
	private String testCode;
	private String requestedCode; 
	static long startTime;
	static long endTime;
	LynxxData lynxxdata; 
	
	
	public void connection(String request) throws SQLException {
		ConnectToDB connections = new ConnectToDB();
		if ("Lynxx".equals(request))
			ConnectToDB.connectLynxx();
		else
			ConnectToDB.connect();
	}

	@Before
	public void Calculate_Time()
	{
			startTime=System.nanoTime(); 
	}
	
	/**
	 * /* Scenario 1
	 * 
	 * @param scenario
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws ParseException
	 */
	
	@Scenario1
	@Given("^I will create a new request with <Data>$")
	public void i_will_create_a_new_request_with_data(DataTable clientData) throws Throwable {
		//TODO add invoce methods for what is missing 
		// Evernote has it saved 
		DBTasks dbTasks = new DBTasks();
		request = dbTasks.GetDataForRequest();
		requestID = dbTasks.getRequisitonID();
		lynxxdata.createdRequest=request; 
	}

	@And("the <animalData> has been populated$")
	public void the_animaldata_has_been_populated(DataTable animalData)
	{
		
	}
	
	@And("^the <patientData> has been populated$")
	public void the_patientdata_has_been_populated(DataTable patientData) throws Throwable {

	}

	@And("^I have ordered the following <TestCodes>$")
	public void i_have_ordered_the_following_testcodes(DataTable testCodes) throws Throwable {

	}

	@When("^I submit the request$")
	public int i_submit_the_request() throws Throwable {
		lynxxdata.getInstance();
		Requests nRequest=new Requests();
		String http = "http://lnx-us-pre-order-service-dev.appspot.com/ESubmit/1.0.0/orders/" + requestID;
		requestedResult=nRequest.request("GET", http, request);
		System.out.println("result is " + requestedResult);
		return requestedResult; 
	}

	@Then("^The result should return created$")
	public void the_result_should_return_created() throws SQLException, IOException {
		DBTasks dbTasks = new DBTasks();
		if(requestedResult==201)
		{
			System.out.println("Success in creating Request with result " + requestedResult);
			System.out.println(lynxxdata.createdRequest); 
			System.out.println("\n" + request); 
		}
		else
		{
			System.out.println("SCENARIO 1::::: ERRORS" + requestedResult);
		}


		dbTasks.saveRequestDatatoDB(requestID,customerId,veterinarian,clinicalDetails, collectionDate, patientDOB,testCode);
	}
	
	/**
	 * /* Scenario 2
	 * 
	 * @param scenario
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws ParseException
	 */
	
	
	@Given("^I will create a new request with data already created$")
	public void i_will_create_a_new_request_with_data_already_created()
	{
		request=lynxxdata.createdRequest;
		System.out.println(request + "its the neew request:" + requestedResult );
	}
	
	@Then("^The result should be an error because it already exists$")
	public void the_result_should_be_error_because_it_already_exists() throws IOException, SQLException
	{
		if(requestedResult==409)
		{
			System.out.println("Result: Request has already been created" + requestedResult);
			requestedResult=201; 
		}
		else
		{
			System.out.println("SCENARIO 2::::: ERRORS" + requestedResult);
		}
	}
	
	/**
	 * /* Scenario 3
	 * 
	 * @param scenario
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws ParseException
	 */
	
	 //@Scenario3
	 @Given("^I have a new get request with status created$")
	 public void i_have_a_new_request_with_status_created()
	 {
		 if(requestedResult==201)
		 {
			 System.out.println("Scenario Approved");
		     System.out.println("Previous Created Request="+ lynxxdata.createdRequest);
		 }
		 else
			 System.out.println("Scenario Failed" +  requestedResult);
	 }
	 
	 @When("^I update the request")
	 public void i_update_the_request() throws IOException
	 {
		 String http = "http://lnx-us-pre-order-service-dev.appspot.com/ESubmit/1.0.0/orders/" + requestID;
		 Requests nRequest=new Requests(); 
		 DBTasks dbTasks=new DBTasks(); 
		 System.out.println(lynxxdata.createdRequest);
		 String newRequest=lynxxdata.createdRequest; 
		 newRequest= lynxxdata.createdRequest.replace("}",",") + "\"speciesCode\":\"CANINE\"}";
		 System.out.println("New REquest is " + newRequest);
		 System.out.println("\n Request total is " + nRequest.request("PUT", http, newRequest)); 
		 lynxxdata.createdRequest=newRequest; 
	 }
	 
	 @Then("^The result should return$")
	 public void the_result_should_return()
	 {
		 
		 System.out.println("Time is: work it out");
	 }
	 
	  /**
		 * /* Scenario 4
		 * 
		 * 
		 * @param scenario
		 * @return
		 * @throws InterruptedException
		 * @throws IOException
		 * @throws ParseException
		 */
		 
	 	@Given("^I have already created a sucessful request$")
		public void i_have_already_created_a_sucessful_request() throws Exception {
		
	 			 if(requestedResult==201)
	 			 {
	 				 System.out.println("Scenario Approved");
	 			     System.out.println("Previous Created Request="+ lynxxdata.createdRequest);
	 			 }
	 			 else
	 				 System.out.println("Scenario Failed" +  requestedResult);
	 		 }
		 
		
		 @When("^I submit the delete request$")
		 public void i_submit_the_delete_request() throws IOException, SQLException
		 {
			 String http = "http://lnx-us-pre-order-service-dev.appspot.com/ESubmit/1.0.0/orders/" + requestID;
			 Requests nRequest=new Requests(); 
			 DBTasks dbTasks=new DBTasks(); 
			 System.out.println(lynxxdata.createdRequest);
			 //lynxxdata.createdRequest=lynxxdata.createdRequest + ",\"SpeciesCode\":\"Cannine\"";
			 value=nRequest.request("DELETE", http, lynxxdata.createdRequest); 
		 }
		
		 
		 @Then("^The result should return NoContent$")
		 public void the_result_should_return_nocontent()
		 {
			 
			 if(value==204)
				  System.out.println("OK");
			 else
				 System.out.println(value);
		 }
	
		 /**
			 * /* Scenario 5
			 * 
			 * 
			 * @param scenario
			 * @return
			 * @throws InterruptedException
			 * @throws IOException
			 * @throws ParseException
			 */
		 
		 
		   @Given("^I have already cancelled a request$")
		   public void i_have_alread_cancelled_a_request()
		   {
			   if (value==204)
			   {
				   value=204;
				   System.out.println("Scenario valid to be verified");
			   }
				   else
					 System.out.println(value);
		   }
		   
		   @When("^I submit the update request$")
		   public void i_submit_the_update_request() throws IOException
		   {
			   
			   String http = "http://lnx-us-pre-order-service-dev.appspot.com/ESubmit/1.0.0/orders/" + requestID;
				 Requests nRequest=new Requests(); 
				 DBTasks dbTasks=new DBTasks(); 
				 System.out.println(lynxxdata.createdRequest);
				 String newRequest= lynxxdata.createdRequest; 
				 System.out.println("New Request is " + newRequest);
				 System.out.println("\n Request total is " + nRequest.request("GET", http, newRequest)); 	   
		   }
		   
		   @Then("^The result should return Error$")
		   public void the_result_should_return_error()
		   {
			   System.out.println(value + "is Error");
		   }
		   
	
	@After
	public void endTime()
	{
		endTime=System.nanoTime(); 
		long duration = (endTime - startTime); 
		System.out.println("Time =" + duration /1000000 );
	}
	
	
	


}

