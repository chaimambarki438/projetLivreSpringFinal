package com.chaima.livres.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.chaima.livres.entities.Bibliotheque;

@RepositoryRestResource(path = "cat")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular 
public interface BibliothequeRepository extends JpaRepository<Bibliotheque, Long> {

	

}
