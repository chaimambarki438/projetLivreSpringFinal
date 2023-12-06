package com.chaima.livres.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.chaima.livres.entities.Image;

public interface ImageService {
	Image uplaodImage(MultipartFile file) throws IOException;
	
	Image getImageDetails(Long id) throws IOException;
	
	 ResponseEntity<byte[]> getImage(Long id) throws IOException;
	 
	 void deleteImage(Long id) ;
	 
	 Image uplaodImageLivr(MultipartFile file,Long idLivr) throws IOException;
		
	 List<Image> getImagesParLivr(Long livrId);

	Image addImageLivr(MultipartFile file, Long idLivr) throws IOException;
	

}
