//package api;
//
//import java.io.IOException;
//
//public class HttpCalls {
//
//    private HttpCallBuilder httpCallBuilder = new HttpCallBuilder();
//    private JsonBody jsonBody = new JsonBody();
//
//    public void CreateEntity(String entityName, String Url) throws IOException {
//        httpCallBuilder.AddRequestBody(httpCallBuilder.AddUniqueNameInJsonBody(jsonBody.getLoginRequestBody(), entityName)).when().post(Url);
//    }
//}
