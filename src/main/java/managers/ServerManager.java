package managers;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utils.TestUtils;

import java.io.File;
import java.util.HashMap;

public class ServerManager {
    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    private TestUtils utils = new TestUtils();

    public AppiumDriverLocalService getServer() {
        return server.get();
    }

    public void startServer() {
        utils.log().info("Starting Appium Server.");
        AppiumDriverLocalService server = WindowsGetAppiumService();
        server.start();
        if (!server.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium Server Not Started.");
        }
        ServerManager.server.set(server);
        utils.log().info("Appium server started");
    }

    private AppiumDriverLocalService WindowsGetAppiumService() {
        GlobalParamsManager params = new GlobalParamsManager();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File(params.getPlatformName() + "_"
                        + params.getDeviceName() + File.separator + "Server.log")));
    }

}
