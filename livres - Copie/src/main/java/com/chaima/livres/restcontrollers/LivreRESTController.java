package com.chaima.livres.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaima.livres.dto.LivreDTO;
import com.chaima.livres.entities.Livre;
import com.chaima.livres.repos.BibliothequeRepository;
import com.chaima.livres.service.LivreService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LivreRESTController {
	@Autowired
	LivreService livreService;
	
	@Autowired
	BibliothequeRepository  bibliothequeRepository;
	
	@RequestMapping(path="all",method =RequestMethod.GET)
	public List<Livre> getAllLivres() {
	return livreService.getAllLivres();
	}

	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Livre getLivreById(@PathVariable("id") Long id) {
	return livreService.getLivre(id);
	 }
	
	@RequestMapping(path="/addlivr",method = RequestMethod.POST)
	public Livre createLivre(@RequestBody Livre livre) {
	return livreService.saveLivre(livre);
	}

	@RequestMapping(path="/updatelivr",method = RequestMethod.PUT)
	public Livre updateLivre(@RequestBody Livre livre) {
	return livreService.updateLivre(livre);
	}
	@RequestMapping(value="/dellivr/{id}",method = RequestMethod.DELETE)
	public void deleteLivre(@PathVariable("id") Long id)
	{
	livreService.deleteLivreById(id);
	}
	
	@DeleteMapping("/{id}/supprimerAvecImages")
    public ResponseEntity<Void> supprimerLivreAvecImages(@PathVariable Long id) {
        livreService.supprimerLivreAvecImages(id);
        return ResponseEntity.noContent().build();
    }
	
	
	
	
	
	@RequestMapping(value="/prodsbib/{idBib}",method = RequestMethod.GET)
	public List<Livre> getLivresByBibId(@PathVariable("idBib") Long idBib) {
	return livreService.findByBibliothequeIdBib(idBib);
	}
	
	@RequestMapping(value="/prodsByTitre/{titre}",method = RequestMethod.GET)
	public List<Livre> findByTitreLivreContains(@PathVariable("titre") String titre) {
	return livreService.findByTitreLivreContains(titre);
	}
	
	
}
