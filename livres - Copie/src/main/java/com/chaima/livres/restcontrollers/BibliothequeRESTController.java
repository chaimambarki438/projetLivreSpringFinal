package com.chaima.livres.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaima.livres.entities.Bibliotheque;
import com.chaima.livres.repos.BibliothequeRepository;
import com.chaima.livres.service.LivreService;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")

public class BibliothequeRESTController {
	@Autowired
	BibliothequeRepository bibliothequeRepository;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Bibliotheque> getAllBibliotheques()
	{
	return bibliothequeRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Bibliotheque getBibliothequeById(@PathVariable("id") Long id) {
	return bibliothequeRepository.findById(id).get();
	}

}
