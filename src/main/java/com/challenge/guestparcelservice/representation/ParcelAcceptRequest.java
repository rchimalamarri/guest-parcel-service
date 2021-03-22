package com.challenge.guestparcelservice.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;
/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
public class ParcelAcceptRequest {

    @NotNull
    @JsonProperty("GuestId")
    private String gustId ;
    @JsonProperty("CollectedDate")
    private Date collectedDate;
    @JsonProperty("AcceptedDate")
    private Date acceptedDate;
    @JsonProperty("CollectedBy")
    private String collectedBy;
    @JsonProperty("IsParcelAccepted")
    private boolean IsParcelAccepted;
    @JsonProperty("isParcelCollected")
    private boolean isParcelCollected;

    public String getGustId() {
        return gustId;
    }

    public void setGustId(String gustId) {
        this.gustId = gustId;
    }

    public Date getCollectedDate() {
        return collectedDate;
    }

    public void setCollectedDate(Date collectedDate) {
        this.collectedDate = collectedDate;
    }

    public Date getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(Date acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public String getCollectedBy() {
        return collectedBy;
    }

    public void setCollectedBy(String collectedBy) {
        this.collectedBy = collectedBy;
    }

    public boolean isParcelAccepted() {
        return IsParcelAccepted;
    }

    public void setParcelAccepted(boolean parcelAccepted) {
        IsParcelAccepted = parcelAccepted;
    }

    public boolean isParcelCollected() {
        return isParcelCollected;
    }

    public void setParcelCollected(boolean parcelCollected) {
        isParcelCollected = parcelCollected;
    }
}
