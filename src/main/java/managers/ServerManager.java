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
            utils.log().fatal("Appium Server Not Started.");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium Server Not Started.");
        }
//        server.clearOutPutStreams();
        ServerManager.server.set(server);
        utils.log().info("Appium server started");
    }

    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }

    private AppiumDriverLocalService WindowsGetAppiumService() {
        GlobalParamsManager params = new GlobalParamsManager();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File(params.getPlatformName() + "_"
                        + params.getDeviceName() + File.separator + "Server.log")));
    }

    public AppiumDriverLocalService MacGetAppiumService() {
        GlobalParamsManager params = new GlobalParamsManager();
        HashMap<String, String> environment = new HashMap<String, String>();
        environment.put("PATH", "/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/bin:/Users/Om/Library/Android/sdk/tools:/Users/Om/Library/Android/sdk/platform-tools:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin" + System.getenv("PATH"));
        environment.put("ANDROID_HOME", "/Users/Om/Library/Android/sdk");
        environment.put("JAVA_HOME", "/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home");
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withEnvironment(environment)
                .withLogFile(new File(params.getPlatformName() + "_"
                        + params.getDeviceName() + File.separator + "Server.log")));
    }
}
