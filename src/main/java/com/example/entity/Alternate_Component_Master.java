package com.example.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Alternate_Component_Master {
	private int alt_id;
	private double delta_price;
	private Model model_id;
	
	public Alternate_Component_Master() {
		super();
	}
	
	public Alternate_Component_Master(int alt_id, double delta_price,Model md) {
		super();
		this.alt_id = alt_id;
		this.delta_price = delta_price;
		this.model_id = md;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getAlt_id() {
		return alt_id;
	}
	public void setAlt_id(int alt_id) {
		this.alt_id = alt_id;
	}
	public double getDelta_price() {
		return delta_price;
	}
	public void setDelta_price(double delta_price) {
		this.delta_price = delta_price;
	}
	@Override
	public String toString() {
		return "Alternate_Component_Master [alt_id=" + this.alt_id + ", delta_price=" + this.delta_price + "]";
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="model_id", referencedColumnName = "model_id")
	public Model getModel_id() {
		return model_id;
	}

	public void setModel_id(Model model_id) {
		this.model_id = model_id;
	}
	
	
}
