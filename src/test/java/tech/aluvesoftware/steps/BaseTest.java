package tech.aluvesoftware.steps;

import io.restassured.response.Response;
import lombok.Getter;
import tech.aluvesoftware.api.http.Request;
public class BaseTest {

    @Getter
    private static Request request;
    @Getter
    private Response response;

    public void BaseUrlIs(String baseUrl) {
        request = new Request(baseUrl);
        request.build();
    }

    public void UserClicksOnTheButton(String endpoint, String http) {
        request.setEndPoint(endpoint);
        request.setHTTPMethod(http);
        response = getRequest().send();
    }

    public void ResponseStatus() {
        int actualStatusCode = response.getStatusCode();
        assert actualStatusCode == 200 : "Expected status code: " + 200 + ", but got: " + actualStatusCode;
    }

}
