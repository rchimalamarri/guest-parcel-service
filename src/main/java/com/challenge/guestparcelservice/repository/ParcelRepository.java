package com.challenge.guestparcelservice.repository;

import com.challenge.guestparcelservice.entity.ParcelInfo;
import org.springframework.data.jpa.repository.JpaRepository;
/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version  1.0
 * @since 20-MAR-2021
 ************************************/
public interface ParcelRepository extends JpaRepository<ParcelInfo, String> {


}
