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
  Scenario: Check API result was created with result 201
    Given I will create a new request with <Data>
    | Data                        | Mandatory | 
    | "requisitionId":            | "Yes"     |
    | "secondaryRequisitionId":   | "Yes"     |
    | "customerId":               | "Yes"     |
    | "veterinarian":             | "Yes"     |
    | "previousRequisitionId":    | "No"      |
    | "collectionDate":           | "Yes"     |
    | "clinicalDetails":          | "Yes"     |
    And the <animalData> has been populated
    | "patientName"								| "Yes"     |
    | "speciesCode"               | "Yes"     |
    | "breedCode"       					| "Yes"     |
    | "genderCode"                | "Yes"     |
    | "birthdate"                 | "Yes"     |
    | "microchip"                 | "No"      |
    And the <patientData> has been populated  
    | PatientData       |  Mandatory  | 
    |  "lastName":      |   "No"      |    
    |  "street1":       |   "No"      |    
    |  "street2":       |   "No"      |    
    |  "city":          |   "No"      |    
    |  "stateProvince": |   "No"      |    
    |  "postalCode":    |   "No"      |
    |  "country":       |   "No"      |
    And I have ordered the following <TestCodes>
    | TestCode   | test     |
    |  UK        | "GCUP"   |
    |  US        | 1234     |
    |  US        | 9001     |
    |  CA        | 					|
    When I submit the request   
    Then The result should return created
   # And DataFiles has been updated

  @Scenario2
  Scenario: Display error because already crearted
    Given I will create a new request with data already created
    When I submit the request   
    Then The result should be an error because it already exists

  @Scenario3 
  Scenario: Update request with result 
    Given I have a new get request with status created
    When I update the request
    Then The result should return
    #And DataFile has been updated
    
  @Scenario4 
  Scenario: Check if the results has been cancelled 
    Given I have already created a sucessful request  
    When I submit the delete request   
    Then The result should return NoContent
  
   
  @Scenario5 
  Scenario: Update Fails because request has been cancelled  
    Given I have already cancelled a request 
    When I submit the update request   
    Then The result should return Error
  
#  @Scenario6 
#  Scenario: Update Fails because request is in assetion   
#    Given I have a request in assertion 
#    When I submit the update request   
#    Then The result should return Error
  
    
#     @Scenario7 
#  Scenario: Check if the results has been cancelled 
#    Given I will create a request with missing values  
#    When I submit the get request   
#    Then The result should be error
    