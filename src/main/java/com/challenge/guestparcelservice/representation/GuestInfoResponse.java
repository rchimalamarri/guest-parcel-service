package com.challenge.guestparcelservice.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
public class GuestInfoResponse {

    @JsonProperty("GuestDetailsList")
    private List<GuestDetails> GuestDetailsList = new ArrayList<>();

    public List<GuestDetails> getGuestDetailsList() {
        return GuestDetailsList;
    }

    public void setGuestDetailsList(List<GuestDetails> guestDetailsList) {
        GuestDetailsList = guestDetailsList;
    }


}
