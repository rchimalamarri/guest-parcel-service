package com.challenge.guestparcelservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/

@Table
@Entity
public class GuestInfo {
    @Id
    @Column(name ="GUEST_ID", length = 36)
    private String guestId;
    @Column(name ="GUEST_FIRST_NAME", length = 20)
    @NotNull
    private String firstName;
    @Column(name ="GUEST_LAST_NAME", length = 20)
    @NotNull
    private String lastName;
    @Column(name ="GUEST_CHECK_IN_TS")
    @Temporal(TemporalType.DATE)
    private Date checkInDateTime;
    @Column(name ="GUEST_CHECK_OUT_TS", length = 20)
    @Temporal(TemporalType.DATE)
    private Date checkOutDateTime;
    @Column(name ="GUEST_IS_ELIGIBLE_TO_COLLECT",length =3)
    @NotNull
    private boolean isEligibleToCollectParcel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GUEST_ID")
    private ParcelInfo parcelInfo;

    public GuestInfo() {
    }

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

    public Date getCheckOutDateTime() {
        return checkOutDateTime;
    }

    public void setCheckOutDateTime(Date checkOutDateTime) {
        this.checkOutDateTime = checkOutDateTime;
    }

    public boolean isEligibleToCollectParcel() {
        return isEligibleToCollectParcel;
    }

    public void setEligibleToCollectParcel(boolean eligibleToCollectParcel) {
        isEligibleToCollectParcel = eligibleToCollectParcel;
    }

}

