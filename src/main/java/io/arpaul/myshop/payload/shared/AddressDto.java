/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.payload.shared;

/**
 *
 * @author ARPaul
 */
public class AddressDto {
    private String address1;
    private String address2;
    private String city;
    private String postcode;
    private String country;
    
	public AddressDto(String address1, String address2, String city, String postcode, String country) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.postcode = postcode;
		this.country = country;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "AddressDto [address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", postcode="
				+ postcode + ", country=" + country + "]";
	}
    
}
