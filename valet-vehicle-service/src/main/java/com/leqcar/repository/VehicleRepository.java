package com.leqcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leqcar.domain.model.Vehicle;

/**
 * Created by jongtenerife on 09/11/2016.
 */
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
