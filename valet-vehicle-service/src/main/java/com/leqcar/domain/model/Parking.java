package com.leqcar.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARKING_INFO")
public class Parking {
	
	@Id
    @GeneratedValue
    private Long id;
	
	private String parkingNo;
	private String vehicleNo;
	private Date entryDate;
	private Date exitDate;
	private String ticketNo;
	
	public Parking() {
		
	}
	
	public Parking(String parkingNo, String vehicleNo, Date entryDate, Date exitDate, String ticketNo) {
		this.parkingNo = parkingNo;
		this.vehicleNo = vehicleNo;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.ticketNo = ticketNo;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getParkingNo() {
		return parkingNo;
	}
	
	public void setParkingNo(String parkingNo) {
		this.parkingNo = parkingNo;
	}
	
	public String getVehicleNo() {
		return vehicleNo;
	}
	
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	
	public Date getEntryDate() {
		return entryDate;
	}
	
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	public Date getExitDate() {
		return exitDate;
	}
	
	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}
	
	public String getTicketNo() {
		return ticketNo;
	}
	
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
}
