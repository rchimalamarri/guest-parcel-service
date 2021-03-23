package com.challenge.guestparcelservice.service;

import com.challenge.guestparcelservice.entity.GuestInfo;
import com.challenge.guestparcelservice.entity.ParcelInfo;
import com.challenge.guestparcelservice.exception.GuestParcelException;
import com.challenge.guestparcelservice.repository.GuestRepository;
import com.challenge.guestparcelservice.repository.ParcelRepository;
import com.challenge.guestparcelservice.representation.GuestDetails;
import com.challenge.guestparcelservice.representation.GuestInfoResponse;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.quality.Strictness;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
@ExtendWith(MockitoExtension.class)
public class GustInfoServiceImplTest {

    @Mock
    GuestRepository guestRepository;


    @Mock
    ParcelRepository parcelRepository;

    @Mock
    GuestInfoService guestInfoService;

    @Mock
    HttpServletResponse response;
    @Mock
    GuestInfo guestInfo;

    @InjectMocks
    GuestInfoServiceImpl guestInfoServiceImpl;


    @Test
    public void testPostGuestCheckin() throws ParseException {
        ParcelInfo parcelInfo =getParcelInfo();
        lenient().when(parcelRepository.findByGuestId(any())).thenReturn(parcelInfo);
        guestInfoServiceImpl.postGuestCheckIn(getGuestDetails());
    }

    @Test
    public void testUpdateGuestCheckout() throws GuestParcelException, ParseException {
        GuestInfo guestInfo = getGuestInfo();
        ParcelInfo parcelInfo =getParcelInfo();
        when(guestRepository.findByGuestId(any())).thenReturn(guestInfo);
        when(parcelRepository.findByGuestId(any())).thenReturn(parcelInfo);
        guestInfoServiceImpl.updateGuestCheckout("f180b8e3-1d2b-4eef-8b3d-6379116c6888");
    }

    @Test
    public void testGetGuestInfo() throws GuestParcelException, ParseException {
        List<GuestInfo> guestInfoList = getGuestInfoList();
        when(guestRepository.findAllBycheckInDateTime(any(Date.class))).thenReturn(guestInfoList);
        GuestInfoResponse response = guestInfoServiceImpl.getGuestInfoByDate("2021-03-20");
        assertEquals("f180b8e3-1d2b-4eef-8b3d-6379116c6888", response.getGuestDetailsList().get(0).getGuestId());
        assertEquals("TestFirstName", response.getGuestDetailsList().get(0).getFirstName());
        assertEquals("TestLastName", response.getGuestDetailsList().get(0).getLastName());
        assertEquals("U180b8e3-1d2b-4eef-8b3d-6379116c6800", response.getGuestDetailsList().get(1).getGuestId());
        assertEquals("FirstName", response.getGuestDetailsList().get(1).getFirstName());
        assertEquals("LastName", response.getGuestDetailsList().get(1).getLastName());

    }

    private GuestDetails getGuestDetails() {
        GuestDetails guestDetails = new GuestDetails();
        guestDetails.setFirstName("TestFirstName");
        guestDetails.setLastName("TestLastName");
        guestDetails.setParcelCollectionEligibility(true);
        return guestDetails;
    }

    private List<GuestInfo> getGuestInfoList() throws ParseException {
        List<GuestInfo> guestInfoList = new ArrayList<>();
        GuestInfo guest1 = new GuestInfo();
        guest1.setGuestId("f180b8e3-1d2b-4eef-8b3d-6379116c6888");
        guest1.setFirstName("TestFirstName");
        guest1.setLastName("TestLastName");
        Date parseDate = new SimpleDateFormat("yyyy-MM-dd").parse("2021-03-20");
        guest1.setCheckInDateTime(parseDate);
        guest1.setEligibleToCollectParcel(true);
        guestInfoList.add(guest1);
        GuestInfo guest2 = new GuestInfo();
        guest2.setGuestId("U180b8e3-1d2b-4eef-8b3d-6379116c6800");
        guest2.setFirstName("FirstName");
        guest2.setLastName("LastName");
        guest1.setCheckInDateTime(parseDate);
        guest2.setEligibleToCollectParcel(true);
        guestInfoList.add(guest2);
        return guestInfoList;
    }

    private GuestInfo getGuestInfo() throws ParseException {
        GuestInfo guest = new GuestInfo();
        guest.setGuestId("f180b8e3-1d2b-4eef-8b3d-6379116c6888");
        guest.setFirstName("TestFirstNgetGuestDetailsame");
        guest.setLastName("TestLastName");
        Date parseDate = new SimpleDateFormat("yyyy-MM-dd").parse("2021-03-20");
        guest.setCheckInDateTime(parseDate);
        guest.setEligibleToCollectParcel(true);
        return guest;
    }
    private ParcelInfo getParcelInfo() throws ParseException {
        ParcelInfo parcelInfo = new ParcelInfo();
        Date parseDate = new SimpleDateFormat("yyyy-MM-dd").parse("2021-03-20");
        parcelInfo.setAcceptedDate(parseDate);
        parcelInfo.setGustId("f180b8e3-1d2b-4eef-8b3d-6379116c6888");
        parcelInfo.setParcelAccepted(false);
        return parcelInfo;
    }
}
