package steps;

import io.cucumber.java.en.When;
import screens.HomeScreen;

public class HomeSteps {

    @When("^I click on Filter Icon - in Home Screen$")
    public void clickOnFilterIcon() { new HomeScreen().ClickOnFilterIcon(); }

    @When("^I click on Name_Z_To_A_Button - in Sort Items By Popup")
    public void clickOnNameZToAButton() { new HomeScreen().ClickOnNameAtoZButton(); }


}

