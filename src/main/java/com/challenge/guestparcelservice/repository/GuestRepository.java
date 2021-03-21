package com.challenge.guestparcelservice.repository;

import com.challenge.guestparcelservice.entity.GuestInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
public interface GuestRepository extends JpaRepository<GuestInfo, String> {

    List<GuestInfo> findAllBycheckInDateTime(Date checkinDate);
    GuestInfo findByGuestId  (String guestId);

}
