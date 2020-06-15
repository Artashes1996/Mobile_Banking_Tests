@test
Feature: Login scenarios

   Scenario: Login with invalid user name

	 Given I enter username as "standard_user_fef" - in Login Screen
	 Given I enter password as "secret_sauce_efe" - in Login Screen
	 When I click on Login Button - in Login Screen
	 Then I should see error "a" message - in Login Screen

       Given I send login request with this URL "https://prime-uat.savethechildren.net/authservice/v1/prime/oauth/token"



