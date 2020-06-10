package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    @iOSXCUITFindBy(id = "IOS_XPATH")
    private MobileElement filterIconElement;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "IOS_XPATH")
    private MobileElement NameAtoZElement;

    public void ClickOnFilterIcon() {
        filterIconElement.click();
    }

    public void ClickOnNameAtoZButton() {
        waitForVisibility(NameAtoZElement);
        NameAtoZElement.click();
    }
}
