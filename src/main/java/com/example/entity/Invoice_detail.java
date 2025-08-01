package com.example.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Invoice_detail {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invDtl_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inv_id", referencedColumnName = "inv_id",unique = true)
    private Invoice_header invoice;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comp_id", referencedColumnName = "comp_id", unique = true)
    private Component component;
	
	
	public Invoice_detail() {
		super();
	}
	
	public Invoice_detail(int invDtl_id, Invoice_header invoice, Component component) {
        this.invDtl_id = invDtl_id;
        this.invoice = invoice;
        this.component = component;
    }

	public int getInvDtl_id() {
		return invDtl_id;
	}
	public void setInvDtl_id(int invDtl_id) {
		this.invDtl_id = invDtl_id;
	}
	public Invoice_header getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice_header invoice) {
        this.invoice = invoice;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public String toString() {
        return "Invoice_detail [invDtl_id=" + invDtl_id + ", invoice=" + invoice + ", component=" + component + "]";
    }
	
}
