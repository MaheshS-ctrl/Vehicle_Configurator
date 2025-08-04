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
public class Component {
	private int comp_id;
	private String comp_name;
	private Set<Alternate_Component_Master> defaultComp;
	private Set<Alternate_Component_Master> altComp;
	
	
	public Component(){
		super();
	}
	
	
	public Component(int comp_id, String comp_name, Set<Alternate_Component_Master> defaultComp,
			Set<Alternate_Component_Master> altComp) {
		
		super();
		this.comp_id = comp_id;
		this.comp_name = comp_name;
		this.defaultComp = defaultComp;
		this.altComp = altComp;
		
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getComp_id() {
		return comp_id;
	}
	
	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}
	public String getComp_name() {
		return comp_name;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="comp_id", referencedColumnName="comp_id")
	public Set<Alternate_Component_Master> getDefaultComp() {
		return defaultComp;
	}

	public void setDefaultComp(Set<Alternate_Component_Master> defaultComp) {
		this.defaultComp = defaultComp;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="alt_comp_id", referencedColumnName="comp_id")
	public Set<Alternate_Component_Master> getAltComp() {
		return altComp;
	}

	public void setAltComp(Set<Alternate_Component_Master> altComp) {
		this.altComp = altComp;
	}


	@Override
	public String toString() {
		return "Component [comp_id=" + this.comp_id + ", comp_name=" + this.comp_name + ", defComp="+this.defaultComp+", altComp="+this.altComp+ ", vehicle_detail="+"]";
	}


	
}
