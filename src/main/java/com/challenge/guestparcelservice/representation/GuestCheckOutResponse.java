package com.challenge.guestparcelservice.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version 1.0
 * @since 20-MAR-2021
 ************************************/
public class GuestCheckOutResponse {

    @JsonProperty("Response")
    private String checkoutResponse;
    @JsonProperty("ParcelNotification")
    private String parcelNotification;

    public String getParcelNotification() {
        return parcelNotification;
    }

    public void setParcelNotification(String parcelNotification) {
        this.parcelNotification = parcelNotification;
    }


    public String getCheckoutResponse() {
        return checkoutResponse;
    }

    public void setCheckoutResponse(String checkoutResponse) {
        this.checkoutResponse = checkoutResponse;
    }


}
