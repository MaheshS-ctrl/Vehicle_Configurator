package com.example.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity

public class Manufacturer {
	private int mfg_id;
	private String mfg_name;
	private Set<Model> models;
	
	public Manufacturer() {
		super();
	}
	public Manufacturer(int mfg_id, String mfg_name, Set<Model> models) {
		super();
		this.mfg_id = mfg_id;
		this.mfg_name = mfg_name;
		this.models = models;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getMfg_id() {
		return mfg_id;
	}
	public void setMfg_id(int mfg_id) {
		this.mfg_id = mfg_id;
	}
	public String getMfg_name() {
		return mfg_name;
	}
	public void setMfg_name(String mfg_name) {
		this.mfg_name = mfg_name;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="mfg_id", referencedColumnName="mfg_id")
	public Set<Model> getModels() {
		return models;
	}
	public void setModels(Set<Model> models) {
		this.models = models;
	}
	@Override
	public String toString() {
		return "Manufacturer [mfg_id=" + this.mfg_id + ", mfg_name=" + this.mfg_name + ", models=" + this.models + "]";
	}

	
}
