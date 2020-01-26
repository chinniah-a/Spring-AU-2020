package com.springAU.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="payments") 
public class Payment {
	
	@Id
	@GeneratedValue
	private int payment_id;
	private String payment_mode;
	private int payment_amt;
	
	@Temporal(TemporalType.DATE)
	private Date payment_date;

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public int getPayment_amt() {
		return payment_amt;
	}

	public void setPayment_amt(int payment_amt) {
		this.payment_amt = payment_amt;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", payment_mode=" + payment_mode + ", payment_amt=" + payment_amt
				+ ", payment_date=" + payment_date + "]";
	}
	
	
	
	

}
