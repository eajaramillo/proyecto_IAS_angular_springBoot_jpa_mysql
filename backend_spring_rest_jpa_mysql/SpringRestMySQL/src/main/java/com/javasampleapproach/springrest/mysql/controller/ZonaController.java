package com.javasampleapproach.springrest.mysql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.springrest.mysql.model.Zona;
import com.javasampleapproach.springrest.mysql.repo.ZonaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/zonas")
public class ZonaController {

	@Autowired
	ZonaRepository repository;
	
	@GetMapping("/listar")
	public List<Zona> getZonas() {
		System.out.println("Seleccionar todas las zonas...");

		List<Zona> zonas = new ArrayList<>();
		repository.findAll().forEach(zonas::add);
		return zonas;
	}
	

	@PutMapping("/{cdzona}")
	public Zona getZona(@PathVariable("cdzona") String cdzona) {
		System.out.println("Buscar zona codigo= " + cdzona + "...");

		Zona zonaData = repository.findByCdZona(cdzona);
		return zonaData;
	}
}