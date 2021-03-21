package com.challenge.guestparcelservice.service;

import com.challenge.guestparcelservice.exception.GuestParcelException;
import com.challenge.guestparcelservice.representation.GuestCheckInResponse;
import com.challenge.guestparcelservice.representation.GuestCheckOutResponse;
import com.challenge.guestparcelservice.representation.GuestDetails;
import com.challenge.guestparcelservice.representation.GuestInfoResponse;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
/***********************************
 * This  Service  ,which will handle service logic  for
 *  multiple end points checkIn,checkOut,guestdeatilsBydate
 *
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
@Service
public interface GuestInfoService {

    GuestInfoResponse getGuestInfoByDate(String date) throws GuestParcelException, ParseException;

    GuestCheckInResponse postGuestCheckIn(GuestDetails guestDetails)throws GuestParcelException;

    GuestCheckOutResponse updateGuestCheckout(String guestId)throws GuestParcelException;
}
