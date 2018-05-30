#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@esubmit
Feature: esubmit
  I want to be able to check the result of the API request

  @Scenario1 
  Scenario: Check API result as created with result 201
    Given I will create a new request with <Data> <Mandatory>
    | Data                        | Mandatory | 
    | "requisitionId":            | "Yes"     |
    | "secondaryRequisitionId":   | "No"      |
    | "customerId":               | "Yes"     |
    | "veterinarian":             | "Yes"     |
    | "clinicalDetails":          | "Yes"     |
    | "previousRequisitionId":    | "No"      |
    | "collectionDate":           | "Yes"     |
    And the <patientData> has been populated  
    | PatientData       |  Mandatory  |
    |  "firstname":     |   "No"      |    
    |  "lastName":      |   "No"      |    
    |  "street1":       |   "No"      |    
    |  "street2":       |   "No"      |    
    |  "street3":       |   "No"      |    
    |  "street4":       |   "No"      |    
    |  "city":          |   "No"      |    
    |  "stateProvince": |   "No"      |    
    |  "postalCode":    |   "No"      |
    |  "country":       |   "No"      |
    And I have ordered the following <testCodes> <test> 
    | TestCode | test     |
    |          | "GCUP"   |
    When I submit the request   
    Then The result should <returnResult> <text>
    | Return   | text   |
    | 201      | OK     |
    And DataFiles has been updated

  @Scenario2 
  Scenario: Update request with result 201 
    Given I have a new get request with status created
    When I update the request 
    Then The result should <return> <text>
    | Return   | text   |
    | 200      | OK     |
    And DataFile has been updated
    
  @Scenario3 
  Scenario: Check if the results has been cancelled 
    Given I have already created a sucessful request  
    When I submit the delete request   
    Then The result should return NoContent
  
   
  @Scenario4 
  Scenario: Update Fails because request has been cancelled  
    Given I have already cancelled a request 
    When I submit the update request   
    Then The result should return Error
  
  @Scenario5 
  Scenario: Update Fails because request is in assertion   
    Given I have a request in assertion 
    When I submit the update request   
    Then The result should return Error
  
  @Scenario6
  Scenario: Display error because already crearted
    Given I will create a new request with <Data> <Mandatory>
    | Data                        | Mandatory | 
    | "requisitionId":            | "Yes"     |
    | "secondaryRequisitionId":   | "No"      |
    | "customerId":               | "Yes"     |
    | "veterinarian":             | "Yes"     |
    | "clinicalDetails":          | "Yes"     |
    | "previousRequisitionId":    | "No"      |
    | "collectionDate":           | "Yes"     |
    And the <patientData> has been populated  
    | PatientData       |  Mandatory  |
    |  "firstname":     |   "No"      |    
    |  "lastName":      |   "No"      |    
    |  "street1":       |   "No"      |    
    |  "street2":       |   "No"      |    
    |  "street3":       |   "No"      |    
    |  "street4":       |   "No"      |    
    |  "city":          |   "No"      |    
    |  "stateProvince": |   "No"      |    
    |  "postalCode":    |   "No"      |
    |  "country":       |   "No"      |
    And I have ordered the following <testCodes> <test> 
    | TestCode | test     |
    |          | "GCUP"   |
    When I submit the request   
    Then The result should be an error because it alreasy exists
    
     @Scenario7 
  Scenario: Check if the results has been cancelled 
    Given I will create a request with missing values  
    When I submit the get request   
    Then The result should be error
    