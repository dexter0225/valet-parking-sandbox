package com.leqcar.domain.model;

public class Ticket {
	private String ticketId;
	private String vehicleNo;
	
	public Ticket() {
		
	}
	
	public Ticket(String ticketId, String vehicleNo ) {
		this.ticketId = ticketId;
		this.vehicleNo = vehicleNo;
	}
	
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
}
