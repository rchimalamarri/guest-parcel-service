package com.challenge.guestparcelservice.service;

import com.challenge.guestparcelservice.entity.GuestInfo;
import com.challenge.guestparcelservice.exception.GuestParcelException;
import com.challenge.guestparcelservice.repository.GuestRepository;
import com.challenge.guestparcelservice.representation.GuestCheckInResponse;
import com.challenge.guestparcelservice.representation.GuestCheckOutResponse;
import com.challenge.guestparcelservice.representation.GuestDetails;
import com.challenge.guestparcelservice.representation.GuestInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
/***********************************
 * This  Service  ,which will handle service logic  for
 *  multiple end points checkIn,checkOut,guestdeatilsBydate
 *
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
@Service
public class GuestInfoServiceImpl implements GuestInfoService {

    private static final Logger logger = LoggerFactory.getLogger(GuestInfoServiceImpl.class);
    @Autowired
    GuestRepository guestRepository;

    /*************************
     * This method will handle the service logic for fetching the
     * Guest Details by date
     * @param date date
     * @return GuestInfoResponse
     * @throws GuestParcelException guestParcelException
     * @throws ParseException parseException
     *******************************/
    @Override
    public GuestInfoResponse getGuestInfoByDate(String date) throws GuestParcelException, ParseException {
        Date parseDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<GuestInfo> guestInfo = guestRepository.findAllBycheckInDateTime(parseDate);
        if (guestInfo.isEmpty()) {
            logger.info("invalid date format");
            throw new GuestParcelException("No records found for the date");
        }
        List<GuestDetails> getGuestDetailsList = guestInfo.stream().map(GuestInfoServiceImpl::mapToResponse).collect(Collectors.toList());
        GuestInfoResponse guestInfoResponse = new GuestInfoResponse();
        guestInfoResponse.setGuestDetailsList(getGuestDetailsList);
        return guestInfoResponse;
    }

    /*************************
     * This method will help to  map the guestInfo with Guest details
     * @param guestInfo gueestInfo
     * @return GuestDetails
     ************************/
    private static GuestDetails mapToResponse(GuestInfo guestInfo) {
        GuestDetails guestDetails = new GuestDetails();
        guestDetails.setGuestId(guestInfo.getGuestId());
        guestDetails.setFirstName(guestInfo.getFirstName());
        guestDetails.setLastName(guestInfo.getLastName());
        guestDetails.setCheckInDateTime(guestInfo.getCheckInDateTime());
        guestDetails.setEligibleToCollectParcel(guestInfo.isEligibleToCollectParcel());
        return guestDetails;

    }

    /******************
     * This method will handle the service logic for post Guest CheckIn
     * @param guestDetails guestDetails
     * @return GuestCheckInResponse
     */

    @Override
    public GuestCheckInResponse postGuestCheckIn(GuestDetails guestDetails) {
        GuestInfo guestInfo = new GuestInfo();
        guestInfo.setGuestId(UUID.randomUUID().toString());
        guestInfo.setCheckInDateTime(new Date());
        guestInfo.setEligibleToCollectParcel(true);
        guestInfo.setFirstName(guestDetails.getFirstName());
        guestInfo.setLastName(guestDetails.getLastName());
        guestRepository.save(guestInfo);
        GuestCheckInResponse response = new GuestCheckInResponse();
        response.setGuestCheckInResponse("CHECK IN COMPLETED SUCCESSFULLY");
        return response;
    }

    /******************************
     * his method will handle the service logic for post Guest CheckIn
     * @param guestId guestId
     * @return GuestCheckOutResponse
     * @throws GuestParcelException guestParcelException
     */
    @Override
    public GuestCheckOutResponse updateGuestCheckout(String guestId) throws GuestParcelException {
        try {
            GuestInfo guestInfo = guestRepository.findByGuestId(guestId);
            guestInfo.setCheckOutDateTime(new Date());
            guestInfo.setEligibleToCollectParcel(false);
            guestInfo.setCheckOutDateTime(new Date());
            guestRepository.saveAndFlush(guestInfo);
        } catch (EntityNotFoundException e) {
            logger.info("InValid GuestId");
            throw new GuestParcelException("Exception occurred while check out");
        }

        GuestCheckOutResponse guestCheckOutResponse = new GuestCheckOutResponse();
        guestCheckOutResponse.setCheckoutResponse("Guest Checkout has been completed");
        return guestCheckOutResponse;
    }
}
