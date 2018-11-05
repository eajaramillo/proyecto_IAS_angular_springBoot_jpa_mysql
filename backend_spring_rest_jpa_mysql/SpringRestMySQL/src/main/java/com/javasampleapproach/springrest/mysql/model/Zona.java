package com.javasampleapproach.springrest.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TONT_ZONAS")
public class Zona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "CDZONA", columnDefinition="VARCHAR(3)")
	private String cdzona;

	@Column(name = "DSNOMBRE", columnDefinition="VARCHAR(45)")
	private String dsnombre;

	public Zona() {
	}

	public Zona(String cdzona, String dsnombre) {
		this.cdzona = cdzona;
		this.dsnombre = dsnombre;
	}

	public long getId() {
		return id;
	}

	public void setCdZona(String cdzona) {
		this.cdzona = cdzona;
	}

	public String getCdZona() {
		return this.cdzona;
	}
	
	public void setDsNombre(String dsnombre) {
		this.dsnombre = dsnombre;
	}

	public String getDsNombre() {
		return this.dsnombre;
	}

	@Override
	public String toString() {
		return "Zona [id=" + id + ", cdzona=" + cdzona + ", dsnombre=" + dsnombre + "]";
	}
}