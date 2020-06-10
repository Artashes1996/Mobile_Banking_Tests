package api;

import managers.PropertyManager;

import java.io.IOException;
import java.util.Properties;

public class JsonBody {
    private String loginRequest;

    public JsonBody() {
        {
            try {
                Properties properties = new PropertyManager().getProperties("json.properties");
                loginRequest = properties.getProperty("login.request.json.path");
                System.out.println(loginRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getLoginRequestBody() {
        return loginRequest; }
}
