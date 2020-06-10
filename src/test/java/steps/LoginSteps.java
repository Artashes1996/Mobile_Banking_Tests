package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import screens.LoginScreen;

public class LoginSteps {
    @When("^I enter username as \"([^\"]*)\"$")
    public void iEnterUsernameAs(String username) throws InterruptedException {
        new LoginScreen().enterUserName(username); }

    @When("^I enter password as \"([^\"]*)\"$")
    public void iEnterPasswordAs(String password) {
        new LoginScreen().enterPassword(password); }

    @When("^I click on Login Button$")
    public void clickOnLoginButton() {
        new LoginScreen().clickLoginButton(); }

    @Then("^I should see error \"([^\"]*)\" message$")
    public void loginShouldFailWithAnError(String err) {
        Assert.assertEquals(new LoginScreen().getErrTxt(), err); }

}
