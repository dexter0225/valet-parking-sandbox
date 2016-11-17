package com.leqcar.services;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leqcar.domain.model.Parking;
import com.leqcar.domain.model.ParkingSlot;
import com.leqcar.domain.model.Ticket;
import com.leqcar.domain.model.Vehicle;
import com.leqcar.repository.ParkingRepository;
import com.leqcar.repository.ParkingSlotRepository;
import com.leqcar.util.ParkingConstant;

@Service
public class VehicleService {
	
	@Autowired
	ParkingSlotRepository parkingSlotRepository;
	
	@Autowired
	ParkingRepository parkingRepository;
	
	public Ticket parkVehicle(Vehicle vehicle) {
		Parking parking = null;
		ParkingSlot parkingSlot = null;
		Ticket ticket = null;
		
		List<ParkingSlot> parkingSlotList = parkingSlotRepository.findByStatus(ParkingConstant.STATUS_VACANT);
		
		if (parkingSlotList!= null && !parkingSlotList.isEmpty()) {
			parkingSlot = parkingSlotList.get(0);
			parkingSlot.setStatus(ParkingConstant.STATUS_OCCUPIED);
			parkingSlotRepository.saveAndFlush(parkingSlot);
			
			parking = new Parking(parkingSlot.getParkingNo(),vehicle.getPlateNo(),DateTime.now().toDate(),null,parkingSlot.getParkingNo());
			parkingRepository.saveAndFlush(parking);
			
			parkingRepository.findAll().forEach(p->System.out.println("Currently Park = " + p.getId() + " " + p.getParkingNo()+ " " + p.getVehicleNo()));
			parkingSlotRepository.findAll().forEach(ps->System.out.println("Available Slots: " + ps.getId() + " " + ps.getParkingNo() + " " + ps.getStatus()));
			
			ticket = new Ticket(parkingSlot.getParkingNo(), vehicle.getPlateNo());
		}
		return ticket;
	}
	
	public Vehicle unParkVehicle(Ticket ticket) {
		Vehicle vehicle = null;
		ParkingSlot parkingSlot = null;
		Parking parking = parkingRepository.findByTicketNo(ticket.getTicketId());
		
		if (parking != null) {
			parking.setExitDate(DateTime.now().toDate());
			parkingRepository.save(parking);
			
			parkingSlot = new ParkingSlot(parking.getParkingNo(), ParkingConstant.STATUS_VACANT);
			parkingSlotRepository.saveAndFlush(parkingSlot);
			
			parkingRepository.findAll().forEach(p->System.out.println("Currently Park = " + p.getId() + " " + p.getParkingNo()+ " " + p.getVehicleNo()));
			parkingSlotRepository.findAll().forEach(ps->System.out.println("Available Slots: " + ps.getId() + " " + ps.getParkingNo() + " " + ps.getStatus()));
			
			vehicle = new Vehicle(parking.getParkingNo());
		}
		
		return vehicle;
	}
}
