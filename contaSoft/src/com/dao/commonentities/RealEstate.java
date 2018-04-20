package com.dao.commonentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RealEstate {

	@Column
	@Id
	private String rol;
	
	@Column
	private String comuna;
	
	@Column
	private String address;
	
	@Column
	private boolean expQuotes;
	
	@Column
	private boolean curQuotes;
}
