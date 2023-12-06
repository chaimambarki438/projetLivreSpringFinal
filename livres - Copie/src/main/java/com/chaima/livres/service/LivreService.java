package com.chaima.livres.service;

import java.util.List;

import com.chaima.livres.dto.LivreDTO;
import com.chaima.livres.entities.Bibliotheque;
import com.chaima.livres.entities.Image;
import com.chaima.livres.entities.Livre;

public interface LivreService {
	Livre saveLivre(Livre p);
	Livre updateLivre(Livre livre);
	 void deleteLivre(Livre p);
    void deleteLivreById(Long id);
    Livre getLivre(Long id);

	 List<Livre> getAllLivres();
	
	 
	 List<Livre> findByTitreLivre(String titre);
	 List<Livre> findByTitreLivreContains(String titre);
	 
	 List<Livre> findByTitrePrix (String titre, Double prix);
	 List<Livre> findByBibliotheque (Bibliotheque  Bibliotheque );
	 List<Livre> findByBibliothequeIdBib(Long id);
	 List<Livre> findByOrderByTitreLivreAsc();
	 List<Livre> trierLivresTitresPrix();
	 
	 Livre convertEntityToDto (Livre livre);
	Livre convertDtoToEntity(Livre livre);
	void supprimerLivreAvecImages(Long idLivre);

}
