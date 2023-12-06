package com.chaima.livres.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chaima.livres.dto.LivreDTO;
import com.chaima.livres.entities.Bibliotheque;
import com.chaima.livres.entities.Image;
import com.chaima.livres.entities.Livre;
import com.chaima.livres.repos.BibliothequeRepository;
import com.chaima.livres.repos.ImageRepository;
import com.chaima.livres.repos.LivreRepository;


@Service
public class LivreServiceImpl implements LivreService {

	@Autowired
	LivreRepository  livreRepository;
	
	@Autowired
	BibliothequeRepository  bibliothequeRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
@Autowired
ModelMapper modelMapper;

	@Override
	public Livre saveLivre(Livre p) {
		return livreRepository.save(p);
	}

	@Override
	public Livre updateLivre(Livre p) {
	
	Livre livrUpdated = livreRepository.save(p);

	return livrUpdated;
	}
	
	 public void supprimerLivreAvecImages(Long idLivre) {
	        Optional<Livre> optionalLivre = livreRepository.findById(idLivre);

	        if (optionalLivre.isPresent()) {
	            Livre livre = optionalLivre.get();

	            // Delete all associated images
	            if (livre.getImages() != null && !livre.getImages().isEmpty()) {
	                for (Image image : livre.getImages()) {
	                    imageRepository.deleteById(image.getIdImage());
	                }
	            }

	            // Delete the book
	            livreRepository.deleteById(idLivre);
	        } 
	    }

	  
	
	
	@Override
	public void deleteLivre(Livre p) {
		 livreRepository.delete(p);
	}

	@Override
	public void deleteLivreById(Long id) {
	
	 //supprimer l'image avant de supprimer le produit
   Livre p = getLivre(id);
   try {
	Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
   } 
   catch (IOException e) {
	
	e.printStackTrace();
   }
	livreRepository.deleteById(id);	
}
	
	@Override
	public Livre getLivre(Long id) {
		return  livreRepository.findById(id).get();
	}

	@Override
	public List<Livre> getAllLivres() {
		return livreRepository.findAll();
	}

	@Override
	public List<Livre> findByTitreLivre(String titre) {
		return livreRepository. findByTitreLivre(titre);
	}

	@Override
	public List<Livre> findByTitreLivreContains(String titre) {
		return livreRepository.findByTitreLivreContains(titre);
	}

	@Override
	public List<Livre> findByTitrePrix(String titre, Double prix) {
		return livreRepository.findByTitrePrix(titre, prix);
	}

	@Override
	public List<Livre> findByBibliotheque(Bibliotheque bibliotheque) {
		return livreRepository. findByBibliotheque(bibliotheque);
	}

	
	
	
	@Override
	public List<Livre> findByBibliothequeIdBib(Long id) {
		return livreRepository.findByBibliothequeIdBib(id);
	}

	@Override
	public List<Livre> findByOrderByTitreLivreAsc() {
		return livreRepository.findByOrderByTitreLivreAsc();
	}

	@Override
	public List<Livre> trierLivresTitresPrix() {
		return livreRepository.trierLivresTitresPrix();
	}
	

	@Override
	public Livre convertEntityToDto(Livre livre) {
		
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		 livre=  modelMapper.map(livre, Livre.class);
		
		return livre;
		
		
	}

	@Override
	public Livre convertDtoToEntity(Livre livre)
	{
	
	livre = modelMapper.map(livre, Livre.class);
		   return livre;
	}	
		
	}

	






