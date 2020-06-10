package steps;

import api.HttpCallBuilder;
import io.cucumber.java.en.*;

import java.io.IOException;

public class ApiSteps {

    @When("^For Login I send request with this URL \"([^\"]*)\"$")
    public void For_Login(String Url) throws IOException {
        new HttpCallBuilder().sendLoginRequest(Url);
    }
}
