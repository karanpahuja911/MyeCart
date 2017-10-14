package com.niit.eCart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class BillingAddress  implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int billsId;
	
	@NotEmpty(message="streetname is mandatory")
	private String streetname;
	private String apartmentnumber;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String state;
	
	@NotEmpty
	private String country;
	
	@NotEmpty
	private String zipcode;
	


    @OneToOne
    private Customer customer;

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getBillsId() {
		return billsId;
	}
	public void setBillsId(int billsId) {
		this.billsId = billsId;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getApartmentnumber() {
		return apartmentnumber;
	}
	public void setApartmentnumber(String apartmentnumber) {
		this.apartmentnumber = apartmentnumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
	
}
