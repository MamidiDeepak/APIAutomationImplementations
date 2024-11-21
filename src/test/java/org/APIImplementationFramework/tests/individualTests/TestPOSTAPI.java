package org.APIImplementationFramework.tests.individualTests;

import io.restassured.RestAssured;
import org.APIImplementationFramework.asserts.AssertActions;
import org.APIImplementationFramework.base.BaseClass;
import org.APIImplementationFramework.endpoints.APIConstants;
import org.APIImplementationFramework.listeners.ReTryAnalyzer;
import org.APIImplementationFramework.payload.CreateBookingPayload;
import org.APIImplementationFramework.pojo.CreateBookingResponsePojo;
import org.APIImplementationFramework.utils.ReadKey;
import org.testng.annotations.Test;

public class TestPOSTAPI extends BaseClass {

    @Test (retryAnalyzer = ReTryAnalyzer.class)
    public void testPOSTCreateBookingAPI(){

        requestSpecification.basePath(APIConstants.CREATEBOOKING);

       response = RestAssured.given(requestSpecification)
                .when().body(CreateBookingPayload.getCreateBookingPayload()).post();

       response.then().log().all();

        CreateBookingResponsePojo cbrp = CreateBookingPayload.deSerializeTheResponse(response.asString());
        String bookingId = cbrp.getBookingid();
        System.out.printf("Created Booking ID : "+bookingId);

        AssertActions.validateTheResponseData(cbrp.getBooking().getFirstname(), ReadKey.readKey("booking.post.firstName"));
    }
}
