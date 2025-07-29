package com.example.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Segment {
	private int seg_id;
	private String seg_name;
	private Set<Model> models;
	
	
	public Segment() {
		super();
	}
	
	public Segment(int id, String name) {
		super();
		this.seg_id = id;
		this.seg_name = name;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getSeg_id() {
		return seg_id;
	}
	
	public void setSeg_id(int seg_id) {
		this.seg_id = seg_id;
	}
	

	public String getSeg_name() {
		return seg_name;
	}
	public void setSeg_name(String seg_name) {
		this.seg_name = seg_name;
	}
	
	@Override
	public String toString() {
		return "Segment [seg_id=" + this.seg_id + ", seg_name=" + this.seg_name + "]";
	}

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="seg_id", referencedColumnName="seg_id")
	public Set<Model> getModels() {
		return models;
	}

	public void setModels(Set<Model> models) {
		this.models = models;
	}

}
