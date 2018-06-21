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
@Urinalysis
Feature: Uranalysis
  I want to be able to check the results of the various analysis performed

	Background: I am Logged with User and password and in westbrook 
	Given  I have logged in with User and Password
	| User  | Password |
	|       |          | 
	When I am in <Language> with <Lab>
	| Language  | Lab   |
	|           |       | 
	Then Order Entry Page is selected
		

  #check names of screens or tabs 
  #if there are any we need to add it either as a table variable or a text
  #add masterdata values to confirm flags
  @Scenario1 
  Scenario: Check Results based on the Collection 943
    Given I have created a new order with customer <xxxxx are we going to use DB for all the animals and customers>
    And have entered the following <Collections> and <Order> 
    | Collections | Order   |
    |         910 |     943 |
    |        9101 |     943 | 
    |        9100 |     943 |
    |        9102 |     943 |
    |         917 |     943 |
    When I get the <Selected> result of the test <Assay> in the new Window with the <Status><Results>
    | Selected | Assay    | Status  |Results     |
    |          | SP-GR    |   <     |1,016       |
    |  OR      | WBC UA   |   >=    |6           |
    |  OR      | BACT     |   !=    |"None Seen" |
    Then The new Screen will display <CollectionNumber><TextDisplayed><SystemCode><Assay>   
    |CollectionNumber | TextDisplayed       | SystemCode   | Assay         |
    |   444           | "CULTURE RECIEVED"  | "NTRM"       | "CULT RECD"   |
    |                 |                     | "CULTURE IF" | "CULTI"       |
   

  @Scenario2 
  Scenario: Check Results based on the Collection 9430 with Urine Culture
    Given I have created a new order with customer <xxxxx are we going to use DB>
    And have entered the following <Collections> and <Order> 
    | Collections | Order    |
    |         910 |     9430 |
    |        9101 |     9430 | 
    |        9100 |     9430 |
    |        9102 |     9430 |
    |         917 |     9430 |
    When I get the <Selected> result of the test <Assay> in the new Window with the <Status><Results>
    | Selected | Assay    | Status  |Results     |
    |          | SP-GR    |   <     |1,016       |
    |  OR      | WBC UA   |   >=    |6           |
    |  OR      | BACT     |   !=    |"None Seen" |
    Then The new Screen will display <CollectionNumber><TextDisplayed><SystemCode><Assay>   
    |CollectionNumber | TextDisplayed             | SystemCode   | Assay         |
    |   440350        | "URINE CULTURE RECIEVED"  | "NTRM"       | "CULT RECD"   |
    |                 |                           | "CULTURE IF" | "CULTI"       |
    
    
  @Scenario3 
  Scenario: Check Results based on the Collections 9430 and 943  with Urine Culture
    Given I have created a new order with customer <xxxxx are we going to use DB>
    And have entered the following <Collections> and <Order> 
    | Collections | Order    |
    |         910 |     9430 |
    |        9101 |     9430 | 
    |        9100 |     9430 |
    |        9102 |     9430 |
    |         917 |     9430 |
    |         910 |     943  |
    |        9101 |      943 | 
    |        9100 |      943 |
    |        9102 |      943 |
    |         917 |      943 |
    
    When I get the <Selected> result of the test <Assay> in the new Window with the <Status><Results>
    | Selected | Assay    | Status  |Results     |
    |          | SP-GR    |   >=     |1,016       |
    |  OR      | WBC UA   |   <     |6           |
    |  OR      | BACT     |   =    |"None Seen" |
    Then The new Screen will display <TextDisplayed><SystemCode><Assay>   
    | SystemCode   | Assay         |
    | "CULTURE IF" | "CNI"         |
  