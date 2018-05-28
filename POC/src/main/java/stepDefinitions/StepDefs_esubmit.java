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

import POC.POC.ConnectToDB;
import POC.POC.DBTasks;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class StepDefs_esubmit {

	public int value=0; 
	DBTasks dbTasks;
	
	public void connection(String request) throws SQLException
	{
	    ConnectToDB connections=new ConnectToDB();
	    if ("Lynxx".equals(request))
	    	    connections.connectLynxx();
	    	    else
	    	    connections.connect(); 
	}
	
	
	 @Given("^I will create a new request with <Data> <Mandatory>$")
	 public void i_will_create_a_new_request_with_data_mandatory(DataTable clientData) throws Throwable  
	 {
		 DBTasks dbTasks=new DBTasks();
		 dbTasks.GetDataForRequest();
		 List<List<String>> data = clientData.raw();
	 	 Method[] methods = DBTasks.class.getDeclaredMethods();
		 Map<String, Method> methodsMap = new HashMap<String, Method>();
		 for (int i = 0; i < methods.length; i++) {
			methodsMap.put(methods[i].getName(), methods[i]);
			}	
		 		System.out.println("j:" + data.size() + "k:" + methods.length);
		 		for (int j = 1; j < data.size(); j++) {
		 			for (int i = 1; i < methods.length; i++) {
		 				// invoke
		 				System.out.println("data at j:" + j + ":" + "click"+data.get(j).get(0));
		 				System.out.println("data at i:" + i + ":" + methods[i].getName());
		 				if (("click"+ data.get(j).get(0)).equals(methods[i].getName())) 
		 					System.out.println("Found equal!!\n");
		 					else
		 						System.out.println("Not Found equal!!\n");
		 			}
		 		}
		 	dbTasks.GetDataForRequest();
	 }
	 
	 @And("^the <patientData> has been populated$")
	 public void the_patientdata_has_been_populated(DataTable patientData) throws Throwable 
	 {
		 
	 }

	 @And("^I have ordered the following <testCodes> <test>$")
	 public void i_have_ordered_the_folloing_testcodes_test(DataTable testCodes) throws Throwable
	 {
		 
	 }
	 
	 
	 @When("^I submit the request$")
	 public void i_submit_the_request(String requestString) throws Throwable
	 {
		 
	 }
	 
	 @Then("^The result should <returnResult> <text>$")
	 public void the_result_should_return_text(DataTable returnResult)
	 {
		 
	 }
	 
	 
	   
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
//Scenario 4 
//				
//	@Given("^I have already created a sucessful request$")
//	public void i_have_already_created_a_sucessful_request() throws Exception {
// 
//		
//		String json="";
//		String createNewVPC="";
//		
//		String http="http://lnx-us-pre-order-service-dev.appspot.com/ESubmit/1.0.0/orders/"; //should this be in a definition ?
//		
//		String Data = dbTasks.GetDataForRequest();
//				//"{\"requisitionId\": \"VCP012397\", \"customerId\": \"G700, ISTI, 39488\", \"veterinarianv\": \"DR SMITH\"}";
//		connection(""); 
//		System.out.println("ReuqisitionID" + dbTasks.getRequisitonID());
//		URL url = new URL(http);
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//		
//		String loginPassword = "action:jackson";
//		String encoded = new sun.misc.BASE64Encoder().encode (loginPassword.getBytes());
//		
//		connection.setRequestProperty ("Authorization", "Basic " + encoded);
//		connection.setRequestMethod("POST");
//		connection.setRequestProperty("Content-type", "text/json;charset=\"utf-8\"");
//		connection.setReadTimeout(60000);
//		connection.setDoOutput(true);
//		connection.setDoInput(true);
//		connection.getOutputStream().write(Data.getBytes());
//		connection.connect();
//		if ("201".equals(connection.getResponseCode()))
//			System.out.println("201");
//		else
//			System.out.println(connection.getResponseCode());
//		System.out.println(dbTasks.getRequisitonID());
//		
//		
//	}
//
//	@When("^I submit the delete request$") 
//	public void i_submit_the_delete_request() throws IOException, SQLException
//	{
//    
//		connection("");
//		String http="http://lnx-us-pre-order-service-dev.appspot.com/ESubmit/1.0.0/orders/VPC0000309"; //should this be in a definition ?
//		
//		String Data = "{\"requisitionId\": \"VCP0000309\", \"customerId\": \"G700, ISTI, 39488\", \"veterinarian\": \"DR SMITH\"}";
//		
//		URL url = new URL(http);
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//		
//		String loginPassword = "action:jackson";
//		String encoded = new sun.misc.BASE64Encoder().encode (loginPassword.getBytes());
//		connection.setRequestProperty ("Authorization", "Basic " + encoded);
//		
//		
//		connection.setRequestMethod("DELETE");
//		connection.setRequestProperty("Content-type", "text/json;charset=\"utf-8\"");
//		connection.setReadTimeout(60000);
//		connection.setDoOutput(true);
//		connection.setDoInput(true);
//		connection.getOutputStream().write(Data.getBytes());
//		connection.connect();
//		value=connection.getResponseCode();
//		System.out.println("ReuqisitionID" + dbTasks.getRequisitonID());
//		
//	}
//	
//	@Then("^The result should return NoContent$")
//	public void the_result_should_return_nocontent()
//	{
//		if("204".equals(value))
//			System.out.println("OK");
//		else
//	    // Write code here that turns the phrase above into concrete actions
//			System.out.println(value);
		  
	//}
}