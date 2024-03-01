package com.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Addproduct {
	@Id
	private Integer pid;
	private String prodname;
	private Double price;
	private String paymode;
	private String availability;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public Addproduct(Integer pid, String prodname, Double price, String paymode, String availability) {
		super();
		this.pid = pid;
		this.prodname = prodname;
		this.price = price;
		this.paymode = paymode;
		this.availability = availability;
	}

	public Addproduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPaymode() {
		return paymode;
	}

	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
}
