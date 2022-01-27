Feature: Account Page Feature 

Background: 
	Given user has already logged in to application 
		| username      | password     |
		| standard_user | secret_sauce |
		
@accounts 
Scenario: Home page title 
	Given user is on Home page 
	When user gets the title of the page 
	Then page title should be "Swag Labs" 
	
@accounts 
Scenario: Menu section count 
	Given user is on Home page 
	When user clicks on Menu icon 
	Then user gets Menu section 
		| ALL ITEMS |
		| ABOUT     |
		| LOGOUT    |
		| RESET APP STATE |
	And menu section count should be 4 
