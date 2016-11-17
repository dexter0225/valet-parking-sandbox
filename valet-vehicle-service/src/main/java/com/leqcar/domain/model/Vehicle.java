package com.leqcar.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jongtenerife on 09/11/2016.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    private String plateNo;
    
    public Vehicle() {
    	
    }
    
    public Vehicle(String plateNo) {
    	this.plateNo = plateNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
		this.id = id;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}
    
    
}
