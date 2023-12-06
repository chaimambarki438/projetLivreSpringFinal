package com.chaima.livres.dto;

import java.util.Date;

import com.chaima.livres.entities.Bibliotheque;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

 @Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivreDTO {
	private Long idLivre;
	private String titreLivre;
	private Double prixLivre;
	private Date dateOuverture;
	private Bibliotheque bibliotheque;
	private String nomBib;

}
