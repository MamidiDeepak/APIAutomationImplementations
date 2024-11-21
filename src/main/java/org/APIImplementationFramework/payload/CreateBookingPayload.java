package org.APIImplementationFramework.payload;

import com.google.gson.Gson;
import org.APIImplementationFramework.pojo.CreateBookingDatesPojo;
import org.APIImplementationFramework.pojo.CreateBookingPojo;
import org.APIImplementationFramework.pojo.CreateBookingResponsePojo;

public class CreateBookingPayload {

    static Gson gson = new Gson();

    public static String getCreateBookingPayload(){

        CreateBookingPojo createBookingPojo = new CreateBookingPojo();
        createBookingPojo.setFirstname("Deepak");
        createBookingPojo.setLastname("Mamidi");
        createBookingPojo.setTotalprice(40002);
        createBookingPojo.setDepositpaid(true);

        CreateBookingDatesPojo createBookingDatesPojo = new CreateBookingDatesPojo();
        createBookingDatesPojo.setCheckin("2024-11-20");
        createBookingDatesPojo.setCheckout("2024-11-25");

        createBookingPojo.setBookingdates(createBookingDatesPojo);
        createBookingPojo.setAdditionalneeds("Dinner");

//        Convert Java payload to JSON Payload
        String jsonPayload = gson.toJson(createBookingPojo);
        return jsonPayload;
    }

    public static CreateBookingResponsePojo deSerializeTheResponse(String response){
        CreateBookingResponsePojo createBookingResponsePojo = gson.fromJson(response, CreateBookingResponsePojo.class);
        return createBookingResponsePojo;
    }
}
