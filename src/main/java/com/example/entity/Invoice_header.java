package com.example.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;


@Entity
public class Invoice_header {
	private int inv_id;
	private LocalDate inv_date;
	private double total_amt;
	private double tax;
	private double amt;
	private String customer_detail;
	private Model model_id;
	
	public Invoice_header()
	{
		super();
	}
	
	public Invoice_header(int inv_id, double total_amt, double tax, double amt,
			String customer_detail, Model md) {
		super();
		this.inv_id = inv_id;
		this.inv_date = LocalDate.now();
		this.total_amt = total_amt;
		this.tax = tax;
		this.amt = amt;
		this.customer_detail = customer_detail;
		this.model_id = md;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getInv_id() {
		return inv_id;
	}
	public void setInv_id(int inv_id) {
		this.inv_id = inv_id;
	}
	public LocalDate getInv_date() {
		return inv_date;
	}
	public void setInv_date(LocalDate inv_date) {
		this.inv_date = inv_date;
	}
	public double getTotal_amt() {
		return total_amt;
	}
	public void setTotal_amt(double total_amt) {
		this.total_amt = total_amt;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	public String getCustomer_detail() {
		return customer_detail;
	}
	public void setCustomer_detail(String customer_detail) {
		this.customer_detail = customer_detail;
	}

	@Override
	public String toString() {
		return "invoice_header [inv_id=" + this.inv_id + ", inv_date=" + this.inv_date + ", total_amt=" + this.total_amt + ", tax="
				+ this.tax + ", amt=" + this.amt + ", customer_detail=" + this.customer_detail + "]";
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="model_id")
	public Model getModel_id() {
		return model_id;
	}

	public void setModel_id(Model model) {
		this.model_id = model;
	}
	
	
}
