package steps;

import managers.DriverManager;
import utils.VideoRecorder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

import java.io.IOException;

public class Hooks {

    @Before
    public void initialize() throws Exception {
        new VideoRecorder().startRecording();
    }

    @After
    public void quit(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", scenario.getName());
        }
        new VideoRecorder().stopRecording(scenario.getName());

    }
}
