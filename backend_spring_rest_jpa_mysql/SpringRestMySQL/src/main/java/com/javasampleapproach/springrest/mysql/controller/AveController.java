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

import com.javasampleapproach.springrest.mysql.model.Ave;
import com.javasampleapproach.springrest.mysql.repo.AveRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AveController {

	@Autowired
	AveRepository repository;

	@GetMapping("/aves")
	public List<Ave> getAves() {
		System.out.println("Seleccionar todas las aves...");

		List<Ave> aves = new ArrayList<>();
		repository.findAll().forEach(aves::add);
		return aves;
	}

	@PostMapping(value = "/aves/crear")
	public Ave postAve(@RequestBody Ave ave) {
		System.out.println("......");
		System.out.println(ave);
		Ave _ave = repository.save(new Ave(ave.getCdAve(), ave.getDsNombreComun(), ave.getDsNombreCientifico()));
		return _ave;
	}

	@DeleteMapping("/aves/{cdave}")
	public ResponseEntity<String> deleteAve(@PathVariable("id") String cdave) {
		System.out.println("Borrar ave con cdave = " + cdave + "...");

		repository.deleteByCdAve(cdave);
		repository.deleteRelationByCdAve(cdave);

		return new ResponseEntity<>("El ave ha sido borrada!", HttpStatus.OK);
	}

	@DeleteMapping("/aves/delete")
	public ResponseEntity<String> deleteAllAves() {
		System.out.println("Se eliminaron todas las aves...");

		repository.deleteAll();

		return new ResponseEntity<>("Todas las aves han sido borradas!", HttpStatus.OK);
	}

	//@RequestBody Object params
	@GetMapping(value = "aves/buscar/list")
	//@RequestBody
	public List<Ave> findNombreAndZona(@PathVariable("dsnombre_ave") String dsnombre_ave, @PathVariable("cdzona") String cdzona) {
		//System.out.println(params);
		List<Ave> ave = repository.findAveByNombreAndZona(dsnombre_ave, cdzona);
		return ave;
	}

	@PutMapping("/aves/{cdave}")
	public ResponseEntity<Ave> updateAve(@PathVariable("cdave") String cdave, @RequestBody Ave ave) {
		System.out.println("Actualizar ave con codigo = " + cdave + "...");

		Ave aveData = repository.findByCdAve(cdave);

		if (aveData.getCdAve() != null) {
			Ave _ave = new Ave();
			_ave.setCdAve(ave.getCdAve());
			_ave.setDsNombreComun(ave.getDsNombreComun());
			_ave.setDsNombreCientifico(ave.getDsNombreCientifico());
			return new ResponseEntity<>(repository.save(_ave), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
