package com.challenge.guestparcelservice.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.JoinColumn;

/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
public class ParcelAcceptResponse {

    @JsonProperty("Response")
    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }


}
