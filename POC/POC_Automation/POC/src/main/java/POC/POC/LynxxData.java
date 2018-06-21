package POC.POC;

public class LynxxData {
	
	   public static LynxxData instance = null;

	   /* A private Constructor prevents any other
	    * class from instantiating.
	    */
	//   LynxxData() { 
		   
	  // }

	   /* Static 'instance' method */
	   public static LynxxData getInstance() {
		   if(instance == null)
			   instance = new LynxxData();
	      return instance;
	   }

	public String requisitionId			  	;                    
	public String secondaryRequisitionId	; 
	public String customerId				;             
	public String veterinarian				;           
	public String clinicalDetails			;
	public String patientId					;
	public String previousRequisitionId		;  
	public String patientDOB				; 
	public String collectionDate			;
	public String firstname					;    
	public String lastName					;     
	public String street1					;      
	public String street2	    			;
	public String city						;         
	public String stateProvince				;
	public String postalCode				;   
	public String country					;		      
	public String testCode					;
	public static String createdRequest		;
	
	
	
	
	public static String getCreatedRequest() {
		return createdRequest;
	}

	public static void setCreatedRequest(String createdRequest) {
		LynxxData.createdRequest = createdRequest;
	}

	public String getRequisitionId() {
		return requisitionId;
	}
	public void setRequisitionId(String requisitiontId) {
		this.requisitionId = requisitionId;
	}
	public String getPatientDOB() {
		return patientDOB;
	}
	public void setPatientDOB(String patientDOB) {
		this.patientDOB = patientDOB;
	}
	public String getTestCode() {
		return testCode;
	}
	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getSecondaryRequisitionId() {
		return secondaryRequisitionId;
	}
	public void setSecondaryRequisitionId(String secondaryRequisitionId) {
		this.secondaryRequisitionId = secondaryRequisitionId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getVeterinarian() {
		return veterinarian;
	}
	public void setVeterinarian(String veterinarian) {
		this.veterinarian = veterinarian;
	}
	public String getClinicalDetails() {
		return clinicalDetails;
	}
	public void setClinicalDetails(String clinicalDetails) {
		this.clinicalDetails = clinicalDetails;
	}
	public String getPreviousRequisitionId() {
		return previousRequisitionId;
	}
	public void setPreviousRequisitionId(String previousRequisitionId) {
		this.previousRequisitionId = previousRequisitionId;
	}
	public String getCollectionDate() {
		return collectionDate;
	}
	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTestcode() {
		return testCode;
	}
	public void setTestcode(String testcode) {
		this.testCode = testcode;
	}
	
//    public LynxxData(String requisitionId, String customerId, String veterinarian, String clinicalDetails, String collectionDate, String patientDOB,
//		         String testCode)
//    {
//	this.requisitionId=requisitionId;
//	this.customerId=customerId; 
//    this.veterinarian=veterinarian; 
//    this.clinicalDetails=clinicalDetails; 
//    this.collectionDate=collectionDate;
//    this.patientDOB=patientDOB; 
//    this.testCode=testCode; 
//    }
//
//	public LynxxData(String CustomerId, String veterinarian, String ClinicalDetails, String CollectionData, String PatientID,
//			         String patientName, String birthdate, String Microchip, String SpeciesCode, String genderCode, String breedCode)
//			         
//	{
//		this.customerId=customerId; 
//	    this.veterinarian=veterinarian; 
//	    this.clinicalDetails=ClinicalDetails; 
//	    this.previousRequisitionId=previousRequisitionId;
//	    this.collectionDate=collectionDate;
//	    this.patientId=patientId; 
////	    this.patientName=patientName; 
////	    this.birthdate=birthdate; 
////	    this.Microchip=Microchip; 
////	    this.speciesCode=speciesCode; 
////	    this.genderCode=genderCode;
////	    this.breedCode=breedCode;
////	    this.ordering_practice_patientID=ordering_practice_patientID;
////		this.firstname=firstname; 
//		this.lastName=lastName; 
//		this.street1=street1; 
//		this.street2=street2; 
//		this.city=city;
////		this.state=state;
////		this.postalcode=postalcode; 
//		this.country=country;
//	}
}
