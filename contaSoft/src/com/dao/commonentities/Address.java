package com.dao.commonentities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONT_TAXPAYER_ADDR")
public class Address {

	
	public Address() {
		
	}
		
	@Column
	@Id
	private String code;
	@Column
	private String type;
	@Column
	private String address;
	@Column
	private LocalDate startdate;
	
	public Address(String code, String type, String address, LocalDate startdate) {
		super();
		this.code = code;
		this.type = type;
		this.address = address;
		this.startdate = startdate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	@Override
	public String toString() {
		return "Address [code=" + code + ", type=" + type + ", address=" + address + ", startdate=" + startdate + "]";
	}
	
	
	
	
}
