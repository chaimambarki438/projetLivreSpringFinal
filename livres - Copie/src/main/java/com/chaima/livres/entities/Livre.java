package com.chaima.livres.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Livre {

	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idLivre;
		private String titreLivre;
		private Double prixLivre;
		private Date dateOuverture;
		
		
	
		@ManyToOne
		private Bibliotheque bibliotheque;


		@OneToMany (mappedBy = "livre")
		 private List<Image> images;
private String imagePath;

 
		public Livre() {
			super();
		}
		public Livre(String titreLivre, Double prixLivre, Date dateOuverture) {
			super();
			this.titreLivre = titreLivre;
			this.prixLivre = prixLivre;
			this.dateOuverture = dateOuverture;
		}

		

	
		@Override
		public String toString() {
			return "Livre [idLivre=" + idLivre + ", titreLivre=" + titreLivre + ", prixLivre=" + prixLivre
					+ ", dateOuverture=" + dateOuverture +  "]";
		}
		public Long getIdLivre() {
			return idLivre;
		}

		public void setIdLivre(Long idLivre) {
			this.idLivre = idLivre;
		}

		

		public String getTitreLivre() {
			return titreLivre;
		}
		public void setTitreLivre(String titreLivre) {
			this.titreLivre = titreLivre;
		}
		public Double getPrixLivre() {
			return prixLivre;
		}

		public void setPrixLivre(Double prixLivre) {
			this.prixLivre = prixLivre;
		}

		public Date getDateOuverture() {
			return dateOuverture;
		}

		public void setDateOuverture(Date dateOuverture) {
			this.dateOuverture = dateOuverture;
		}

		public Bibliotheque getBibliotheque() {
			return bibliotheque;
		}

		public void setBibliotheque(Bibliotheque bibliotheque) {
			this.bibliotheque = bibliotheque;
		}
		
		
		

		public List<Image> getImages() {
			return images;
		}

		public void setImages(List<Image> images) {
			this.images = images;
		}

		public String getImagePath() {
			return imagePath;
		}

		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}

		
		

		

	

	
	}


