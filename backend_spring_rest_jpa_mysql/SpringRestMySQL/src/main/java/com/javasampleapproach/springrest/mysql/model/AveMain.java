package com.javasampleapproach.springrest.mysql.model;

import com.javasampleapproach.springrest.mysql.model.Ave;
import com.javasampleapproach.springrest.mysql.model.AvesPaises;
import com.javasampleapproach.springrest.mysql.model.Pais;
import com.javasampleapproach.springrest.mysql.model.Zona;
//import com.javasampleapproach.springrest.mysql.repo.AveRepository;

public class AveMain {
	private Ave ave;
	private Pais pais;
	private Zona zona;
	private AvesPaises avepais;

	public AveMain() {
	}

	public AveMain(Ave ave, Pais pais, Zona zona, AvesPaises avepais) {
		this.ave = ave;
		this.pais = pais;
		this.zona = zona;
		this.avepais = avepais;
	}

	public void setAve(String cdave, String dsnombre_comun, String dsnombre_cientifico) {
		this.ave.setCdAve(cdave);
		this.ave.setDsNombreComun(dsnombre_comun);
		this.ave.setDsNombreCientifico(dsnombre_cientifico);
	}
	
	public void setPais(String cdpais, String dsnombre, Zona zona) {
		this.pais.setCdPais(cdpais);
		this.pais.setDsNombre(dsnombre);
		this.pais.setZona(zona);
	}
	
	public void setZona(String cdzona, String dsnombre) {
		this.zona.setCdZona(cdzona);
		this.zona.setDsNombre(dsnombre);
	}
	
	public void setAvesPaises(String cdpais, String cdave) {
		this.avepais.setCdPais(cdpais);
		this.avepais.setCdAve(cdave);
	}
	
	public Ave getAve() {
		return this.ave;
	}
	
	public Pais getPais() {
		return this.pais;
	}
	
	public Zona getZona() {
		return this.zona;
	}
	
	public AvesPaises getAvePais() {
		return this.avepais;
	}
}
