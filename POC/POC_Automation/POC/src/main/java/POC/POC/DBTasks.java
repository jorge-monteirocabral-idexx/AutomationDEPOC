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
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;

public class DBTasks {

	ConnectToDB connectGetData = new ConnectToDB(); 
	ResultSet resultSet;	
	String customerID="string";
	String requisitionID="string"; 
	String clinicalDetails="string";
	String veterinarian="string";
	String collectionDate="string";
    String testCode="string"; 
    String patientDOB="string"; 
    String createdData = "string";
    LynxxData lynxxdata=LynxxData.getInstance(); 
    
    
	public String getRequisitonID() throws SQLException
	{
		int count=0;
		String SQL="SELECT COUNT(RequisitionID) FROM Automation.eSubmitRequest";
		Connection conn=ConnectToDB.connect(); 	
		Statement pstmt = conn.createStatement();
		ResultSet res = pstmt.executeQuery(SQL);
        while (res.next()){
            count = res.getInt(1);
       	}
        NumberFormat formatter = new DecimalFormat("00000");
        String counter = String.valueOf(count+1);
        counter = formatter.format(count+1);
        lynxxdata.requisitionId="VCPB"+(counter);
        
        return requisitionID="VCPB"+(counter);
    }
	
    public String getTestCode() throws SQLException
    {
    	String SQL="SELECT Collection_Code FROM (Select * from Collection Order BY DBMS_RANDOM.VALUE)";
    	Connection conn=ConnectToDB.connectLynxx(); 	
		Statement pstmt = conn.createStatement();
		ResultSet res = pstmt.executeQuery(SQL);
		res.next();
    	testCode=res.getString("Collection_Code");
    
    	return testCode;
    }

	public String getCustomerID() throws SQLException
	{
		String SQL="SELECT ordering_Practice_id FROM (SELECT * FROM ORDER_HEADER ORDER BY DBMS_RANDOM.VALUE)";	
		Connection conn=ConnectToDB.connectLynxx(); 	
		Statement pstmt = conn.createStatement();
		ResultSet res = pstmt.executeQuery(SQL);
		res.next();
        customerID=res.getString("ordering_practice_id");
        lynxxdata.customerId=customerID; 
    
        return customerID; 
    }
	
	public String getveterinarian() throws SQLException
	{
		String veterinarian="";
		String SQL="SELECT ordering_vet_txt FROM ORDER_HEADER WHERE ORDERING_PRACTICE_ID="+customerID;	
		Connection conn=ConnectToDB.connectLynxx(); 	
		Statement pstmt = conn.createStatement();
		ResultSet res = pstmt.executeQuery(SQL);
		res.next();
        veterinarian=res.getString("ordering_vet_txt");
        lynxxdata.veterinarian=veterinarian; 
        
        return veterinarian; 
    }
	
	public String getCollectionDate() 
	{
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar cal = Calendar.getInstance();
	    System.out.println("Today's date is "+dateFormat.format(cal.getTime()));
	    cal.add(Calendar.DATE, -1);
	    collectionDate=dateFormat.format(cal.getTime());
	    lynxxdata.collectionDate=collectionDate; 
	    
	    return dateFormat.format(cal.getTime());
	}
	
	public String getClinicalDetails()
	{
		String Text="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet tellus eget mauris luctus hendrerit. "
				+ "Aliquam nibh urna, bibendum nec semper et, ultrices quis justo. "
				+ "Suspendisse arcu lacus, ultricies tempor lacus a, dignissim ullamcorper sem. " 
	            + "Vivamus quis efficitur neque, in semper neque. Nulla sit amet tortor at urna tristique."; 
		
		Random cutText=new Random(); 
		int  n = cutText.nextInt(100) + 1;
		clinicalDetails=Text.substring(0,n);
		lynxxdata.clinicalDetails=clinicalDetails; 
		
		return clinicalDetails; 
	}
	
	public String getPatientDOB()
	{
		Random random = new Random();
		int minDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);
		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
		
		patientDOB= randomBirthDate.toString(); 
		lynxxdata.patientDOB=patientDOB; 
		return patientDOB; 
	}
	
	public String GetDataForRequest() throws SQLException 
	{
			
		    String request="string";
			if ("string".equals(createdData))
			{
				//{"requisitionId":"VCPA000001","customerID":"3593","veterinarian":"OG","CollectionData":"2018-05-28","ClinicalDetails":"Lorem ipsum dolor sit amet, consectetur adipiscing eli","TestCode":"59011","patientBithday":"2006-05-03"}
				request="{\"requisitionId\":\""  + getRequisitonID() + "\"" +  
				",\"customerId\":\"" + getCustomerID() +  "\"" +
			    ",\"veterinarian\":\"" + getveterinarian() + "\"" +
			    ",\"CollectionData\":\"" + getCollectionDate() +"\"" +
			    ",\"ClinicalDetails\":\"" + getClinicalDetails() +"\"" +
			    ",\"TestCode\":\"" + getTestCode() +"\"" +
			    ",\"patientBirthday\":\"" + getPatientDOB() +"\"" +
			    "}";
				System.out.println("Request is : " + request);
				lynxxdata.createdRequest=request; 
				}
	else
		request=lynxxdata.createdRequest;
			
		return request; 
	}
	
	public void checkDataGoogleCloud()
	{
		
	}
	
	public void saveRequestDatatoDB(String requisitionId, String customerId, String veterinarian, String clinicalDetails, String collectionDate, String patientDOB,
	         String testCode) throws SQLException
	{
	    Connection conn=ConnectToDB.connect();
		String SQL="INSERT INTO esubmitRequest(RequisitionId, customerId, veterinarian, collectionDate, ClinicalDetails, testcode, patientDOB,TypeRequest, Status)"+ "VALUES(?,?,?,?,?,?,?,?,?)";
		try 
			{	
				LynxxData lynxxdata=LynxxData.getInstance();
				PreparedStatement pstmt = conn.prepareStatement(SQL,  Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1,lynxxdata.requisitionId);
				pstmt.setString(2,lynxxdata.customerId);
				pstmt.setString(3,lynxxdata.veterinarian);
				pstmt.setString(4,lynxxdata.collectionDate);
				pstmt.setString(5,lynxxdata.clinicalDetails);
				pstmt.setString(6,lynxxdata.testCode);
				pstmt.setString(7,lynxxdata.patientDOB);
				pstmt.setString(8, "GET");
				pstmt.setString(9,"PASS");
				pstmt.executeUpdate();
				conn.close();
			}
			catch (SQLException ex)
			{
				System.out.print("Error into Saving Data! \n Error defined as (add Logfile) \n | ");
				ex.printStackTrace();
			}
	}

}
