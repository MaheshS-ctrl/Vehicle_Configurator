package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SgMfgMaster {
	private int sgmf_id;
	private Segment seg_id;
	private Manufacturer mfg_id;
	
	public SgMfgMaster() {
		super();
	}
	
	public SgMfgMaster(int sgmf_id, Segment seg_id, Manufacturer mfg_id) {
		super();
		this.sgmf_id = sgmf_id;
		this.seg_id = seg_id;
		this.mfg_id = mfg_id;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getSgmf_id() {
		return sgmf_id;
	}
	public void setSgmf_id(int sgmf_id) {
		this.sgmf_id = sgmf_id;
	}
	@ManyToOne
	@JoinColumn(name="seg_id",nullable = false)
	public Segment getSeg_id() {
		return seg_id;
	}
	public void setSeg_id(Segment seg_id) {
		this.seg_id = seg_id;
	}
	@ManyToOne
	@JoinColumn(name="mfg_id",nullable = false)
	public Manufacturer getMfg_id() {
		return mfg_id;
	}
	public void setMfg_id(Manufacturer mfg_id) {
		this.mfg_id = mfg_id;
	}

	@Override
	public String toString() {
		return "SgMfgMaster [sgmf_id=" + sgmf_id + ", seg_id=" + seg_id + ", mfg_id=" + mfg_id + "]";
	}

	
	
}
