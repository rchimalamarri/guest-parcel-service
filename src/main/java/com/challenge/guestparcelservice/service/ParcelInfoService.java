package com.challenge.guestparcelservice.service;

import com.challenge.guestparcelservice.exception.GuestParcelException;
import com.challenge.guestparcelservice.representation.ParcelAcceptRequest;
import com.challenge.guestparcelservice.representation.ParcelAcceptResponse;
import org.springframework.stereotype.Service;
/***********************************
 * This  Service  ,which will handle service logic  for
 *  guestParcel Accept logic
 *
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
@Service
public interface ParcelInfoService {

    ParcelAcceptResponse postParcelInfo(ParcelAcceptRequest parcelRequestBody) throws GuestParcelException;
}
