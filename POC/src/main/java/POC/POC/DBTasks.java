package POC.POC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DBTasks {

	ConnectToDB connectGetData = new ConnectToDB(); 
	ResultSet resultSet;	
	String CustomerID="string";
	String RequisitionID="string"; 
	String ClinicalDetails="string";
	String veterinarian="string";
	String CollectionDate="string";
    String testCode="string"; 
    String patientDOB="string"; 
	
	public String getRequisitonID() throws SQLException
	{
		int count=0;
		String SQL="SELECT COUNT(RequisitiontID) FROM Automation.eSubmitRequest";
		Connection conn=ConnectToDB.connect(); 	
		Statement pstmt = conn.createStatement();
		ResultSet res = pstmt.executeQuery(SQL);
        while (res.next()){
            count = res.getInt(1);
        	}
      
      
        NumberFormat formatter = new DecimalFormat("000000");
        String counter = String.valueOf(count+1);
        counter = formatter.format(count+1); 
        return RequisitionID="VCPA"+(counter);
    }
	
    public String getTestCode() throws SQLException
    {
    	String SQL="SELECT CollectionCode FROM (Select * from Collection Order BY DBMS_RANDOM.VALUE)";
    	Connection conn=ConnectToDB.connectLynxx(); 	
		Statement pstmt = conn.createStatement();
		ResultSet res = pstmt.executeQuery(SQL);
		res.next();
    	testCode=res.getString("CollectionCode"); 
    	return testCode;
    }

	public String getCustomerID() throws SQLException
	{
		String SQL="SELECT ordering_Practice_id FROM (SELECT * FROM ORDER_HEADER ORDER BY DBMS_RANDOM.VALUE)";	
		Connection conn=ConnectToDB.connectLynxx(); 	
		Statement pstmt = conn.createStatement();
		ResultSet res = pstmt.executeQuery(SQL);
		res.next();
        CustomerID=res.getString("ordering_practice_id"); 
        return CustomerID; 
    }
	
	public String getveterinarian() throws SQLException
	{
		String veterinarian="";
		String SQL="SELECT ordering_vet_txt FROM ORDER_HEADER WHERE ORDERING_PRACTICE_ID="+CustomerID;	
		Connection conn=ConnectToDB.connectLynxx(); 	
		Statement pstmt = conn.createStatement();
		ResultSet res = pstmt.executeQuery(SQL);
		res.next();
        veterinarian=res.getString("ordering_vet_txt"); 
        return veterinarian; 
    }
	
	public String getCollectionDate() 
	{
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar cal = Calendar.getInstance();
	    System.out.println("Today's date is "+dateFormat.format(cal.getTime()));
	    cal.add(Calendar.DATE, -1);
	    return dateFormat.format(cal.getTime());
	}
	
	public String getClinicalDetails()
	{
		String Text="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet tellus eget mauris luctus hendrerit. "
				+ "Aliquam nibh urna, bibendum nec semper et, ultrices quis justo. "
				+ "Suspendisse arcu lacus, ultricies tempor lacus a, dignissim ullamcorper sem. " 
	            + "Vivamus quis efficitur neque, in semper neque. Nulla sit amet tortor at urna tristique."; 
		
		Random cutText=new Random(); 
		int  n = cutText.nextInt(200) + 1;
		String ClinicalDetails=Text.substring(0,n); 
		
				
				
		
		
		return ClinicalDetails; 
	}
	
	public String GetDataForRequest() throws SQLException 
	{
		//"{\"requisitionId\": \"VCP0012397\", \"customerId\": \"G700, ISTI, 39488\", \"veterinarianv\": \"DR SMITH\"}";
		String request=null; 
    	//Clinical Details 
		//CollectionDate     order_sample
		//patient birthdate 
		//testcode
		request="{\"requisitionId\":\\" + getRequisitonID() + 
				",\\customerID\\: \\" + getCustomerID() +  
			    ",\\veterinarian\\: \\" + getveterinarian() + 
			    ",\\CollectionData :" + getCollectionDate() +
			    ",\\ClinicalDetails:" + getClinicalDetails() +
			    "}";
				//,\"customerId\": \"G700, ISTI, 39488\", \"veterinarianv\": \"DR SMITH\"}";
		System.out.println("Request is : " + request);
		return request; 
	}
}
