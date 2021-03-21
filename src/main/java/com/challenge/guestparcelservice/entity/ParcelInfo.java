package com.challenge.guestparcelservice.entity;

import javax.persistence.*;
import java.util.Date;
/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
@Table
@Entity
public class ParcelInfo {

    @Id
    @Column(name ="PARCEL_ID", length = 36)
    private String parcelId ;
    @Column(name ="GUEST_ID", length = 36)
    private String gustId ;
    @Column(name ="PARCEL_COLLECTED_TS")
    private Date collectedDate;
    @Column(name ="PARCEL_ACCEPTED_TS")
    private Date acceptedDate;
    @Column(name ="PARCEL_COLLECTED_BY", length = 36)
    private String collectedBy;
    @Column(name ="PARCEL_ACCEPTED")
    private boolean IsParcelAccepted;
    @Column(name ="PARCEL_COLLECTED")
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

    public String getParcelId() {
        return parcelId;
    }

    public void setParcelId(String parcelId) {
        this.parcelId = parcelId;
    }
}
