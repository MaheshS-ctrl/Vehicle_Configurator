package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Model {
	private int model_id;
	private String model_name;
	private int min_qty;
	private String img_path;
	

	public Model() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getModel_id() {
		return model_id;
	}
	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	public int getMin_qty() {
		return min_qty;
	}
	public void setMin_qty(int min_qty) {
		this.min_qty = min_qty;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public Model(int model_id, String model_name, int min_qty, String img_path) {
		super();
		this.model_id = model_id;
		this.model_name = model_name;
		this.min_qty = min_qty;
		this.img_path = img_path;
	}
	@Override
	public String toString() {
		return "Model [model_id=" + this.model_id + ", model_name=" + this.model_name + ", min_qty=" + this.min_qty + ", img_path="
				+ this.img_path + "]";
	}
	
	
	
	
}
