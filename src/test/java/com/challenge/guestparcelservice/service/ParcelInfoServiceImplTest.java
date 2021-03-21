package com.challenge.guestparcelservice.service;

import com.challenge.guestparcelservice.exception.GuestParcelException;
import com.challenge.guestparcelservice.representation.ParcelAcceptRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
@ExtendWith(MockitoExtension.class)
public class ParcelInfoServiceImplTest {


    @Mock
    ParcelInfoService parcelInfoService;


    @Test
    public void testPostParcelData() throws GuestParcelException {
        parcelInfoService.postParcelInfo(getParcelDetails());
    }

    @Test()
    public void testPostParcelDataError()  {
        try {
          ParcelAcceptRequest parcelAcceptRequest=  getParcelDetails();
            parcelAcceptRequest.setGustId(null);
            parcelInfoService.postParcelInfo(parcelAcceptRequest);
        } catch (GuestParcelException e) {
            assertEquals("some thing went wrong",e.getMessage());
        }
    }

    private ParcelAcceptRequest getParcelDetails() {
        ParcelAcceptRequest parcelAcceptRequest = new ParcelAcceptRequest();
        parcelAcceptRequest.setGustId("f180b8e3-1d2b-4eef-8b3d-6379116c6888");
        parcelAcceptRequest.setParcelAccepted(true);
        return parcelAcceptRequest;
    }
}
