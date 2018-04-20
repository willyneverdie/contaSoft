package com.dao.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dao.commonentities.Address;


@Entity
@Table(name = "CONT_TAXPAYER")
public class TaxPayer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	@Id
	private String rut;
	@Column
	private String name;
	@Column
	private String lastName;
	@Column
	private String email;
	
	@OneToOne(cascade = {
			CascadeType.ALL
	})
	@JoinColumn(name="code")
	private Address address;
	
	public TaxPayer(String rut, String name, String lastName, String email) {
	
		this.rut = rut;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}

	
	
	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public TaxPayer() {
		
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "TaxPayer [rut=" + rut + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", address="
				+ address + "]";
	}

		
	
	
	
}
