package com.leqcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leqcar.domain.model.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
	Parking findByTicketNo(@Param("ticketNo") String ticketNo);
}
