package steps;

import io.cucumber.java.en.When;
import screens.HomeScreen;

public class HomeSteps {

    @When("^I click on Filter Icon - In Home Screen$")
    public void clickOnLoginButton() { new HomeScreen().ClickOnFilterIcon(); }

    @When("^I click on NameToZButton - In Sort Items By Popup")
    public void clickOnSortItems() { new HomeScreen().ClickOnNameAtoZButton(); }


}

