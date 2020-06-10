@test
Feature: Login scenarios

   Scenario: Login with invalid user name

	 Given I enter username as "standard_user"
	 Given I enter password as "secret_sauce"
	 When I click on Login Button
#    Then I should see error "a" message
	 And I click on Filter Icon - In Home Screen
	 And I click on NameToZButton - In Sort Items By Popup


