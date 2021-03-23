package com.challenge.guestparcelservice.service;

import com.challenge.guestparcelservice.entity.GuestInfo;
import com.challenge.guestparcelservice.entity.ParcelInfo;
import com.challenge.guestparcelservice.exception.GuestParcelException;
import com.challenge.guestparcelservice.repository.ParcelRepository;
import com.challenge.guestparcelservice.representation.ParcelAcceptRequest;
import com.challenge.guestparcelservice.representation.ParcelAcceptResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.UUID;

/***********************************
 * This  Service  ,which will handle service logic  for
 *  guestParcel Accept logic
 *
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version 1.0
 * @since 20-MAR-2021
 ************************************/
@Service
public class ParcelInfoServiceImpl implements ParcelInfoService {
    private static final Logger logger = LoggerFactory.getLogger(ParcelInfoServiceImpl.class);


    @Autowired
    ParcelRepository parcelRepository;

    /***************************
     * This method will handle the logic for saving the parcel info into
     * the data base .
     * @param parcelRequestBody parcelRequest
     * @return parcel Response
     ******************************/
    @Override
    public ParcelAcceptResponse postParcelInfo(ParcelAcceptRequest parcelRequestBody) throws GuestParcelException {
        try {
            ParcelInfo parcelInfo = parcelRepository.findByGuestId(parcelRequestBody.getGustId());
            parcelInfo.setAcceptedDate(new Date());
            parcelInfo.setParcelAccepted(true);
            parcelRepository.save(parcelInfo);
        } catch (EntityNotFoundException e) {
            logger.info("InValid GuestId");
            throw new GuestParcelException("Exception occurred while check out");
        }
        ParcelAcceptResponse response = new ParcelAcceptResponse();
        response.setResponse("PARCEL ACCEPTED SUCCESSFULLY");
        return response;
    }
}
