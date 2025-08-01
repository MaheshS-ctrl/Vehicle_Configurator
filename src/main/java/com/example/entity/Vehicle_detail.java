package com.example.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



enum type{
	Core,
	Standard,
	Exterior,
	Interior
}

@Entity
public class Vehicle_detail {
	
	private int config_id;
	private Component component;
	
	private type comp_type;
	
	@Enumerated(EnumType.STRING)
	@Column(name="comp_type")
	public type getComp_type() {
		return comp_type;
	}

	public void setComp_type(type comp_type) {
		this.comp_type = comp_type;
	}


	private boolean isConfig;
	private Model model_id;
	
	
	public Vehicle_detail() {
		super();
	}
	
	public Vehicle_detail(int config_id, type comp_type, boolean isConfig,Model mid) {
		super();
		this.config_id = config_id;
		this.comp_type = comp_type;
		this.isConfig = isConfig;
		this.model_id = mid;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getConfig_id() {
		return config_id;
	}
	public void setConfig_id(int config_id) {
		this.config_id = config_id;
	}
	public boolean isConfig() {
		return isConfig;
	}
	public void setConfig(boolean isConfig) {
		this.isConfig = isConfig;
	}
	@Override
	public String toString() {
		return "vehicle_detail [config_id=" + this.config_id + ", comp_type=" + this.comp_type + ", isConfig=" + this.isConfig + ", model_id=" + this.model_id +"]";
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="model_id", referencedColumnName = "model_id",unique = true)
	public Model getModel_id() {
		return model_id;
	}
	

	public void setModel_id(Model model_id) {
		this.model_id = model_id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="comp_id",referencedColumnName = "comp_id")
	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}
	
}
