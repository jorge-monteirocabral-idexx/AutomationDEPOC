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
    | "previousRequisitionId":    | "Yes"     |
    | "collectionDate":           | "Yes"     |
    And the <patientData> has been populated  
    | PatientData       |  Mandatory  |
    |  "firstname":     |   "Yes"     |    
    |  "lastName":      |   "Yes"     |    
    |  "street1":       |   "No"      |    
    |  "street2":       |   "Yes"     |    
    |  "street3":       |   "Yes"     |    
    |  "street4":       |   "Yes"     |    
    |  "city":          |   "Yes"     |    
    |  "stateProvince": |   "Yes"     |    
    |  "postalCode":    |   "Yes"     |
    |  "country":       |   "No"      |
    And I have ordered the following <testCodes> <test> 
    | TestCode | test     |
    |          | "GCUP"   |
    When I submit the request   
    Then The result should <return> <text>
    | Return   | text   |
    | 201      | OK     |


 @Scenario4 
  Scenario: Check if the results has been cancelled 
    Given I have already created a sucessful request  
    When I submit the delete request   
    Then The result should return NoContent
   # | Return   | text   |
   # | 200      | OK     |
 
  