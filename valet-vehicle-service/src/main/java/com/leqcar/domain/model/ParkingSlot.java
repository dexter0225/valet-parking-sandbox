package com.leqcar.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARKINGSLOT")
public class ParkingSlot {
	
	@Id
    @GeneratedValue
    private Long id;
	
	private String parkingNo;
	private String status;
	
	public ParkingSlot() {
		
	}
	
	public ParkingSlot(String parkingNo, String status) {
		this.parkingNo = parkingNo;
		this.status = status;
	}
	
	public String getParkingNo() {
		return parkingNo;
	}
	public void setParkingNo(String parkingNo) {
		this.parkingNo = parkingNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
