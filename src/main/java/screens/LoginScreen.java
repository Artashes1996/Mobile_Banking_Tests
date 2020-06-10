package screens;

import utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginScreen extends BaseScreen {
    TestUtils utils = new TestUtils();

    @AndroidFindBy (accessibility = "test-Username")
    @iOSXCUITFindBy (id = "test-Username")
    private MobileElement usernameFieldElement;

    @AndroidFindBy (accessibility = "test-Password")
    @iOSXCUITFindBy (id = "test-Password")
    private MobileElement passwordFieldElement;

    @AndroidFindBy (accessibility = "test-LOGIN")
    @iOSXCUITFindBy (id = "test-LOGIN")
    private MobileElement loginButtonElement;

    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    @iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
    private MobileElement errorMessageElement;

    public LoginScreen(){
    }

    public void enterUserName(String username) throws InterruptedException {
        clear(usernameFieldElement);
        sendKeys(usernameFieldElement, username, "login with " + username);
    }

    public void enterPassword(String password) {
        clear(passwordFieldElement);
        sendKeys(passwordFieldElement, password, "password is " + password);
    }

    public void clickLoginButton() {
        loginButtonElement.click();
    }

    public String getErrTxt() {
        String errorMessage = getText(errorMessageElement, "error text is - ");
        return errorMessage;
    }

}
