package com.challenge.guestparcelservice.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;
/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
public class GuestDetails {

    @JsonProperty("GuestId")
    private String guestId;
    @JsonProperty("FirstName")
    @NotNull
    private String firstName;
    @JsonProperty("LastName")
    @NotNull
    private String lastName;
    @JsonProperty("CheckInDateAndTime")
    private Date checkInDateTime;

    @JsonProperty("ParcelCollectionEligibility")
    @NotNull
    private boolean parcelCollectionEligibility;

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCheckInDateTime() {
        return checkInDateTime;
    }

    public void setCheckInDateTime(Date checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
    }

    public boolean isParcelCollectionEligibility() {
        return parcelCollectionEligibility;
    }

    public void setParcelCollectionEligibility(boolean parcelCollectionEligibility) {
        this.parcelCollectionEligibility = parcelCollectionEligibility;
    }
}
