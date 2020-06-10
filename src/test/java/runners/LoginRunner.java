package runners;

import managers.GlobalParamsManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import managers.DriverManager;
import managers.ServerManager;


import static io.cucumber.junit.CucumberOptions.SnippetType.UNDERSCORE;

@RunWith(Cucumber.class) @CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "summary",
        "de.monochromata.cucumber.report.PrettyReports:target/cucumber-html-reports"},
        features = {"src/test/java/features"},
        snippets = UNDERSCORE, glue = {"steps"}, dryRun = false,
        monochrome = true, strict = true, tags = {"@test"})

public class LoginRunner {

    @BeforeClass
    public static void initialize() throws Exception {
        GlobalParamsManager params = new GlobalParamsManager();
        params.initializeGlobalParams();
        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_"
                + params.getDeviceName());
        new ServerManager().startServer();
        new DriverManager().initializeDriver();
    }

    @AfterClass
    public static void quit() {
        DriverManager driverManager = new DriverManager();
        if (driverManager.getDriver() != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        ServerManager serverManager = new ServerManager();
        if (serverManager.getServer() != null) {
            serverManager.getServer().stop();
        }
    }
}
