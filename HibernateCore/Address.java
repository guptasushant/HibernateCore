package com.sushant.HibernateCore;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity 	
@Table(name="student_address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")
	private int addressid;
	
	@Column(length = 50 ,name= "STREET")
	private String street;
	
	@Column(length = 100,name = "CITY")
	private String city;
	
	@Column(name = "IS_OPEN")
	private boolean isOPen;
	
	
	@Column(name = "added_date")
	private Date addedDate;
	
	
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isOPen() {
		return isOPen;
	}
	public void setOPen(boolean isOPen) {
		this.isOPen = isOPen;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", street=" + street + ", city=" + city + ", isOPen=" + isOPen
				+ ", addedDate=" + addedDate + "]";
	}

	

}
