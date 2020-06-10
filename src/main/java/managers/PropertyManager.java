package managers;

import utils.TestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private Properties properties = new Properties();
    private TestUtils utils = new TestUtils();

    public Properties getProperties(String propertiesFileName) throws IOException {
        InputStream is = null;

        if(properties.isEmpty()){
            try{
                utils.log().info("loading" + propertiesFileName);
                is = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
                assert is != null;
                properties.load(is);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Failed to load" + propertiesFileName + "ABORT!!" + e.toString());
                throw e;
            } finally {
                if(is != null){
                    is.close();
                }
            }
        }
        return properties;
    }
}
