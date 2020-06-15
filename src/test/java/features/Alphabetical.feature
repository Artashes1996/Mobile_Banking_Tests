@Alphabetical
Feature: Select Alphabetical functionality

   Scenario: Select Alphabetical functionality

	 Given I enter username as "standard_user" - in Login Screen
	 Given I enter password as "secret_sauce" - in Login Screen
	 And I click on Login Button - in Login Screen
	 And I click on Filter Icon - in Home Screen
	 When I click on Name_Z_To_A_Button - in Sort Items By Popup
#	 Then Assertions
