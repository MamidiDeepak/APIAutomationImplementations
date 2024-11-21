package org.APIImplementationFramework.base;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.APIImplementationFramework.asserts.AssertActions;
import org.APIImplementationFramework.endpoints.APIConstants;
import org.APIImplementationFramework.listeners.ReTryAnalyzer;
import org.APIImplementationFramework.listeners.ReTryListeners;
import org.APIImplementationFramework.payload.CreateBookingPayload;
import org.apiguardian.api.API;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    public APIConstants apiConstants;
    public CreateBookingPayload createBookingPayload;
    public AssertActions assertActions;
    public ReTryAnalyzer reTryAnalyzer;
    public ReTryListeners reTryListeners;
    public RequestSpecification requestSpecification;
    public Response response;
    public JsonPath jsonPath;

    @BeforeClass
    public void runInitialClass(){
       requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASEURL)
                .contentType("application/json");
//                .log().all();
    }

}
