package com.chaima.livres;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.chaima.livres.entities.Bibliotheque;
import com.chaima.livres.entities.Livre;
import com.chaima.livres.repos.LivreRepository;

@SpringBootTest
class LivresApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private LivreRepository livreRepository;

	@Test
	 public void testCreateLivre() {
		Livre prod = new Livre("livre1",50.000,new Date());
		livreRepository.save(prod);
	}	
	
	   @Test
		public void testFindLivre()
		 {
		   Livre p = livreRepository.findById(2L).get();		  
			 System.out.println(p);
		 }

		@Test
		public void testUpdateLivre()
		 {
			Livre p = livreRepository.findById(2L).get();
			 p.setPrixLivre(40.0);
			 livreRepository.save(p);
		 }
		
		
	@Test
		public void testDeleteLivre()
		 {
		livreRepository.deleteById(1L);;
			 
		 }

	   
	@Test
		public void testListerTousLivres()
		 {
			 List<Livre>  prods = livreRepository.findAll();	 
				for (Livre p : prods)
				{
					System.out.println(p);
				}	 
		 }
	
	@Test
	public void testFindByTitreLivre()
	 {
	List<Livre>  prods = livreRepository.findByTitreLivre("livre2");
			for (Livre p : prods)
			{
				System.out.println(p);
			}
		
	 }
	
	@Test
	public void testFindByTitreLivreContains ()
	 {
	List<Livre> prods=livreRepository.findByTitreLivreContains("livre2");
			for (Livre p : prods)
			{
				System.out.println(p);
			} 
	}
	
	@Test
	public void testfindByTitrePrix()
		 {
		List<Livre>  prods = livreRepository.findByTitrePrix("livre2", 100.0);
			for (Livre p : prods)
				{
					System.out.println(p);
				}
			
		 }
	
	@Test
	public void testfindByBibliotheque()
	 {
		Bibliotheque Bib = new Bibliotheque();
		Bib.setIdBib(1L);			
		List<Livre>  prods = livreRepository.findByBibliotheque(Bib);
			for (Livre p : prods)
			{
				System.out.println(p);
			}
	 }
	
	@Test
	public void findByBibliothequeIdBib()
		 {			
			List<Livre>  prods = livreRepository.findByBibliothequeIdBib(1L);
				for (Livre p : prods)
				{
					System.out.println(p);
				}
	       }
	
	@Test
	public void testfindByOrderByTitreLivreAsc()
	 {
		List<Livre>  prods =    livreRepository.findByOrderByTitreLivreAsc();	 
			for (Livre p : prods)
			{
				System.out.println(p);
			}
	 }
	
	@Test
	public void testTrierLivresTitresPrix()
	 {
		List<Livre>  prods =livreRepository.trierLivresTitresPrix();	 
			for (Livre p : prods)
			{
				System.out.println(p);
			}
	 }









	

}

