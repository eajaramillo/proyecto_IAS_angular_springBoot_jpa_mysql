package com.javasampleapproach.springrest.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TONT_AVES")
public class Ave {

	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CDAVE", columnDefinition="VARCHAR(5)",unique=true, nullable = false)
	private String cdave;

	@Column(name = "DSNOMBRE_COMUN", columnDefinition="VARCHAR(100)")
	private String dsnombre_comun;

	@Column(name = "DSNOMBRE_CIENTIFICO", columnDefinition="VARCHAR(200)")
	private String dsnombre_cientifico;

	public Ave() {
	}

	public Ave(String cdave, String dsnombre_comun, String dsnombre_cientifico) {
		this.cdave = cdave;
		this.dsnombre_comun = dsnombre_comun;
		this.dsnombre_cientifico = dsnombre_cientifico;
	}

	/*public long getId() {
		return id;
	}*/

	public void setCdAve(String cdave) {
		this.cdave = cdave;
	}

	public String getCdAve() {
		return this.cdave;
	}

	public void setDsNombreComun(String dsnombre_comun) {
		this.dsnombre_comun = dsnombre_comun;
	}

	public String getDsNombreComun() {
		return this.dsnombre_comun;
	}
	public void setDsNombreCientifico(String dsnombre_cientifico) {
		this.dsnombre_cientifico = dsnombre_cientifico;
	}

	public String getDsNombreCientifico() {
		return this.dsnombre_cientifico;
	}
	@Override
	public String toString() {
		return "Ave [cdave=" + cdave + ", dsnombre_comun=" + dsnombre_comun + ", dsnombre_cientifico=" + dsnombre_cientifico + "]";
	}
}
