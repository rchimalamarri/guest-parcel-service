package com.challenge.guestparcelservice.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version 1.0
 * @since 20-MAR-2021
 ************************************/
public class GuestCheckInResponse {

    @JsonProperty("CheckInResponse")
    private String guestCheckInResponse;

    public String getGuestCheckInResponse() {
        return guestCheckInResponse;
    }

    public void setGuestCheckInResponse(String guestCheckInResponse) {
        this.guestCheckInResponse = guestCheckInResponse;
    }


}
