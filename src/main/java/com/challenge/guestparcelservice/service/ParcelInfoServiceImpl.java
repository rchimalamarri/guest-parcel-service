package com.challenge.guestparcelservice.service;

import com.challenge.guestparcelservice.entity.ParcelInfo;
import com.challenge.guestparcelservice.repository.ParcelRepository;
import com.challenge.guestparcelservice.representation.ParcelAcceptRequest;
import com.challenge.guestparcelservice.representation.ParcelAcceptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
/***********************************
 * This  Service  ,which will handle service logic  for
 *  guestParcel Accept logic
 *
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
@Service
public class ParcelInfoServiceImpl implements ParcelInfoService {

    @Autowired
    ParcelRepository parcelRepository;

    /***************************
     * This method will handle the logic for saving the parcel info into
     * the data base .
     * @param parcelRequestBody parcelRequest
     * @return parcel Response
     ******************************/
    @Override
    public ParcelAcceptResponse postParcelInfo(ParcelAcceptRequest parcelRequestBody) {
        ParcelInfo parcelInfo = new ParcelInfo();
        parcelInfo.setParcelId(UUID.randomUUID().toString());
        parcelInfo.setParcelAccepted(parcelRequestBody.isParcelAccepted());
        parcelInfo.setAcceptedDate(new Date());
        parcelInfo.setGustId(parcelRequestBody.getGustId());
        parcelInfo.setParcelAccepted(true);
        parcelRepository.save(parcelInfo);
        ParcelAcceptResponse response = new ParcelAcceptResponse();
        response.setResponse("PARCEL ACCEPTED SUCCESSFULLY");
        return response;
    }
}
