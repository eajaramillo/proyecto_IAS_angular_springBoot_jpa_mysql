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

import com.javasampleapproach.springrest.mysql.model.AvesPaises;
import com.javasampleapproach.springrest.mysql.model.Pais;
import com.javasampleapproach.springrest.mysql.repo.PaisRepository;
import com.javasampleapproach.springrest.mysql.repo.AvesPaisesRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/paises")
public class PaisAveController {

	@Autowired
	PaisRepository repository;
	AvesPaisesRepository repository_aves_paises;

	@PostMapping(value = "/aves/crear/{cdave}")
	public Pais postPais(@PathVariable("cdave") String cdave,@RequestBody Pais pais) {
		System.out.println("......");
		System.out.println(pais);
		Pais _pais = repository.save(new Pais(pais.getCdPais(), pais.getDsnombre(), pais.getZona()));
		AvesPaises _avespaises = repository_aves_paises.save(new AvesPaises(pais.getCdPais(), cdave));
		return _pais;
	}
}