package com.springAU.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Users") 
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="userType", discriminatorType = DiscriminatorType.STRING)
public class User {
	
	@Id
	@GeneratedValue()
	private int userid;
	private String username;
	private String mobile_no;
	private String email;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="Street",column=@Column(name="homeStreetName")),
		@AttributeOverride(name="pincode",column=@Column(name="homePincode"))
	})
	private Address home_address;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="Street",column=@Column(name="officeStreetName")),
		@AttributeOverride(name="pincode",column=@Column(name="officePincode"))
	})
	private Address office_address;
	
	
	public User( String username, String mobile_no, String email) {
		super();
		this.username = username;
		this.mobile_no = mobile_no;
		this.email = email;
	}
	
	public User( String username, String mobile_no, String email, Address homeAddress) {
		super();
		this.username = username;
		this.mobile_no = mobile_no;
		this.email = email;
		this.home_address = homeAddress;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
