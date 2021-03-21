package com.challenge.guestparcelservice.controller;

import com.challenge.guestparcelservice.exception.GuestParcelException;
import com.challenge.guestparcelservice.representation.GuestDetails;
import com.challenge.guestparcelservice.representation.GuestInfoResponse;
import com.challenge.guestparcelservice.representation.ParcelAcceptRequest;
import com.challenge.guestparcelservice.service.GuestInfoService;
import com.challenge.guestparcelservice.service.ParcelInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import java.text.ParseException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
@ExtendWith(MockitoExtension.class)
class GuestParcelControllerTest {


    @Mock
    private HttpServletRequest httpServletRequest;
    @Mock
    private GuestInfoService guestInfoService;
    @Mock
    private ParcelInfoService parcelInfoService;

    @InjectMocks
    private GuestParcelController guestParcelController;

    @Mock
    GuestDetails guestDetails;

    @Mock
    GuestInfoResponse guestInfoResponse;


    @Test
    public void createGuestCheckIn() {
        Response response = guestParcelController.createGuestCheckIn(getGuestDetails());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    public void createGuestCheckInError() throws GuestParcelException {
        doThrow(GuestParcelException.class).when(guestInfoService).postGuestCheckIn(getGuestDetails());
        Response response = guestParcelController.createGuestCheckIn(getGuestDetails());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    public void createGuestCheckOut() {
        Response response = guestParcelController.createGuestCheckout(getGuestDetails());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    public void createGuestCheckOutError() throws GuestParcelException {
        doThrow(GuestParcelException.class).when(guestInfoService).updateGuestCheckout("f4166d5e-318b-40f9-a43d-0fcbadaa5296");
        Response response = guestParcelController.createGuestCheckout(getGuestDetails());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    public void getGuestDetailsForDate() throws GuestParcelException, ParseException {
        when(guestInfoService.getGuestInfoByDate(anyString())).thenReturn(guestInfoResponse);
        Response response = guestParcelController.getGuestInfo("2021-03-19");
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void getGuestDetailsForInvaildDateError() throws GuestParcelException, ParseException {
        doThrow(GuestParcelException.class).when(guestInfoService).getGuestInfoByDate("2021-03");
        Response response = guestParcelController.getGuestInfo("2021-03-19");
        assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    public void getGuestDetailsForDateError() throws GuestParcelException, ParseException {
        doThrow(GuestParcelException.class).when(guestInfoService).getGuestInfoByDate("2021-03-19");
        Response response = guestParcelController.getGuestInfo("2021-03-19");
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void postParcelAccept() {
        Response response = guestParcelController.createParcelAccept(getParcelDetails());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    public void postParcelAcceptError() throws GuestParcelException {
        doThrow(GuestParcelException.class).when(parcelInfoService).postParcelInfo(getParcelDetails());
        Response response = guestParcelController.createParcelAccept(getParcelDetails());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }


    private GuestDetails getGuestDetails() {
        GuestDetails guestDetails = new GuestDetails();
        guestDetails.setFirstName("TestFirstName");
        guestDetails.setLastName("TestLastName");
        guestDetails.setEligibleToCollectParcel(true);
        return guestDetails;
    }

    private ParcelAcceptRequest getParcelDetails() {
        ParcelAcceptRequest parcelAcceptRequest = new ParcelAcceptRequest();
        parcelAcceptRequest.setGustId("f180b8e3-1d2b-4eef-8b3d-6379116c6888");
        parcelAcceptRequest.setParcelAccepted(true);
        return parcelAcceptRequest;
    }
}
