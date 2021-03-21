package com.challenge.guestparcelservice.configuration;

import com.challenge.guestparcelservice.controller.GuestParcelController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(GuestParcelController.class);

    }
}