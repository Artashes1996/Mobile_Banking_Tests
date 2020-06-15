package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.Random;

public class HttpCallBuilder {

    private JsonBody jsonBody = new JsonBody();
    private Random random = new Random();
    private String generateTime = String.valueOf(random.nextInt(9999));
    public String entityName = "auto_entity_name" + generateTime;

    private RequestSpecification setContentType() {
        RequestSpecification given = RestAssured.given();
        return given.contentType(ContentType.JSON);
    }

//   TO DO Block
//    private JSONObject updateValueInJsonBody(String pathName, String itemName) throws IOException {
//        FileWriter fileWriter = new FileWriter("pathName");
//        ObjectMapper mapper = new ObjectMapper();
//        JSONObject root = mapper.readValue(new File(pathName), JSONObject.class);
//          root.replace("Name", entityName)
//          fileWriter.write(String.valueOf(root));
//    return root
//    }

    public void sendLoginRequest(String Url) throws IOException {
        RequestSpecification requestBody = setContentType().body(jsonBody.getLoginRequestBody());
        requestBody.when().post(Url).then().assertThat().statusCode(200);
    }
}