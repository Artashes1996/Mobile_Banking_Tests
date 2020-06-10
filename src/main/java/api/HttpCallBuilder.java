//package api;
//
//import io.restassured.http.ContentType;
//import io.restassured.specification.RequestSpecification;
//
//import java.io.IOException;
//
//public class HttpCalls {
//
//    private HttpCallBuilder httpCallBuilder = new HttpCallBuilder();
//    private JsonBody jsonBody = new JsonBody();
//
////    public void SendPostRequest(String Url) {
////        RequestSpecification request = null;
////        RequestSpecification post = null;
////                request = (RequestSpecification) httpCallBuilder.GetContentType(ContentType.JSON).with().body(jsonBody.getLoginRequestBody());
////                post = (RequestSpecification) request.when().post(Url).
////                        then().assertThat().statusCode(200);
////        }
////    }
//
//}