package com.challenge.guestparcelservice.controller;

import com.challenge.guestparcelservice.exception.GuestParcelException;
import com.challenge.guestparcelservice.representation.*;
import com.challenge.guestparcelservice.service.GuestInfoService;
import com.challenge.guestparcelservice.service.ParcelInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/***********************************
 * This is micro service controller ,which will handle request for
 *  multiple end points checkIn,checkOut,ParcelAccept,guestdeatilsBydate
 *
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
************************************/
@Named
@Controller
@Path("hotel/guest")
public class GuestParcelController {
    private static final Logger logger = LoggerFactory.getLogger(GuestParcelController.class);

    private final GuestInfoService guestInfoService;
    private final ParcelInfoService parcelInfoService;

    @Autowired
    public GuestParcelController(GuestInfoService guestInfoService, ParcelInfoService parcelInfoService) {
        this.guestInfoService = guestInfoService;
        this.parcelInfoService = parcelInfoService;
    }

    @POST
    @Path("/check/in")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGuestCheckIn(
            @RequestBody GuestDetails requestBody) {
        try {
            GuestCheckInResponse guestCheckInResponse = guestInfoService.postGuestCheckIn(requestBody);
            return Response.status(Response.Status.CREATED).entity(guestCheckInResponse).build();
        } catch (GuestParcelException e) {
            logger.info("Error occured in check in process Due to the  Guest data ");
            return badRequest();
        } catch (Exception e) {
            logger.info("Some thing went wrong in check in process of Guest");
            return internalServerError();
        }
    }

    @PUT
    @Path("/check/out")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGuestCheckout(
            @RequestBody GuestCheckOutRequest requestBody) {

        try {
            GuestCheckOutResponse guestCheckOutResponse = guestInfoService.updateGuestCheckout(requestBody.getGuestId());
            return Response.status(Response.Status.OK).entity(guestCheckOutResponse).build();
        } catch (GuestParcelException e) {
            logger.info("Error occured in check out process Due to the  Guest data ");
            return badRequest();
        } catch (Exception e) {
            logger.info("Some thing went wrong in check out process of Guest");
            return internalServerError();
        }
    }


    @GET
    @Path("/info/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGuestInfo(
            @PathParam("date") String date) {
        try {
            GuestInfoResponse guestInfoResponse = guestInfoService.getGuestInfoByDate(date);
            return Response.status(Response.Status.OK).entity(guestInfoResponse).build();
        } catch (GuestParcelException e) {
            logger.info("Error occured in check in process Due to the  Guest data ");
            return badRequest();
        } catch (Exception e) {
            logger.info("Some thing went wrong in check in process of Guest");
            return internalServerError();
        }
    }

    @PUT
    @Path("/parcel/accept")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createParcelAccept(
            @RequestBody ParcelAcceptRequest requestBody) {

        try {
            ParcelAcceptResponse parcelAcceptResponse = parcelInfoService.postParcelInfo(requestBody);
            return Response.status(Response.Status.OK).entity(parcelAcceptResponse).build();
        } catch (GuestParcelException e) {
            logger.info("Error occured in check in process Due to the  Guest data ");
            return badRequest();
        } catch (Exception e) {
            logger.info("Some thing went wrong in check in process of Guest");
            return internalServerError();
        }
    }

    private Response badRequest() {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    private Response internalServerError() {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
