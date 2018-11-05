package com.javasampleapproach.springrest.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TONT_PAISES")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "CDPAIS", columnDefinition="VARCHAR(3)")
	private String cdpais;

	@Column(name = "DSNOMBRE", columnDefinition="VARCHAR(100)")
	private String dsnombre;
	
	@ManyToOne
	private Zona zona;

	public Pais() {
	}

	public Pais(String cdpais, String dsnombre, Zona zona) {
		this.cdpais = cdpais;
		this.dsnombre = dsnombre;
		this.zona = zona;
	}

	public long getId() {
		return id;
	}

	public void setCdPais(String cdpais) {
		this.cdpais = cdpais;
	}

	public String getCdPais() {
		return this.cdpais;
	}
	
	public void setDsNombre(String dsnombre) {
		this.dsnombre = dsnombre;
	}

	public String getDsnombre() {
		return this.dsnombre;
	}
		
	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Zona getZona() {
		return this.zona;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", cdpais=" + cdpais + ", dsnombre=" + dsnombre + ", zona=" + zona + "]";
	}
}