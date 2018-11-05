package com.javasampleapproach.springrest.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TONT_AVES_PAIS")
public class AvesPaises {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "CDPAIS", columnDefinition="VARCHAR(3)")
	private String cdpais;

	@Column(name = "CDAVE", columnDefinition="VARCHAR(5)")
	private String cdave;
	
	@OneToOne
	private Ave ave;
	
	@OneToOne
	private Pais pais;

	public AvesPaises() {
	}

	public AvesPaises(String cdpais, String cdave) {
		this.cdpais = cdpais;
		this.cdave = cdave;
	}

	/*public long getId() {
		return id;
	}*/

	public void setCdPais(String cdpais) {
		this.cdpais = cdpais;
	}

	public String getCdPais() {
		return this.cdpais;
	}

	public void setCdAve(String cdave) {
		this.cdave = cdave;
	}

	public String getCdAve() {
		return this.cdave;
	}

	@Override
	public String toString() {
		return "AvesPaises [cdpais=" + cdpais + ", cdave=" + cdave + "]";
	}
}