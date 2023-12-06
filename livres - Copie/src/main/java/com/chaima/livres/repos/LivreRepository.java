package com.chaima.livres.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chaima.livres.entities.Bibliotheque;
import com.chaima.livres.entities.Livre;

@RepositoryRestResource(path = "rest")
public interface LivreRepository extends JpaRepository<Livre, Long> {

	  
	List<Livre> findByTitreLivre(String titre);
	List<Livre> findByTitreLivreContains(String titre);  
	
	@Query("select p from Livre p where p.titreLivre like %:titre and p.prixLivre > :prix")
	List<Livre> findByTitrePrix (@Param("titre") String titre,@Param("prix") Double prix);
    
	@Query("select p from Livre p where p.bibliotheque = ?1")
	List<Livre> findByBibliotheque (Bibliotheque bibliotheque);
	
	List<Livre> findByBibliothequeIdBib(Long id);
	
	List<Livre> findByOrderByTitreLivreAsc();
	
	@Query("select p from Livre p order by p.titreLivre ASC, p.prixLivre DESC")
	List<Livre> trierLivresTitresPrix ();
	
	 

}
