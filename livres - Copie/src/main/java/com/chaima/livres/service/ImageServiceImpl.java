package com.chaima.livres.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.chaima.livres.entities.Image;
import com.chaima.livres.entities.Livre;
import com.chaima.livres.repos.ImageRepository;
import com.chaima.livres.repos.LivreRepository;






@Transactional
@Service
public class ImageServiceImpl implements ImageService {
	
	 @Autowired
	 ImageRepository imageRepository;


	 @Autowired
	LivreService livreService;
	 
	 @Autowired
	LivreRepository livreRepository;
	 
		@Override
		public Image uplaodImage(MultipartFile file) throws IOException {
			return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
					.image(file.getBytes()).build());
		}

		
		@Override
		public Image getImageDetails(Long id) throws IOException {
			final Optional<Image> dbImage = imageRepository.findById(id);
			return Image.builder()
					.idImage(dbImage.get().getIdImage())
					.name(dbImage.get().getName())
					.type(dbImage.get().getType())
					.image(dbImage.get().getImage()).build();
		}

		@Override
		public ResponseEntity<byte[]> getImage(Long id) throws IOException {
			final Optional<Image> dbImage = imageRepository.findById(id);
			return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
					.body(dbImage.get().getImage());
		}

		@Override
		public void deleteImage(Long id) {
			imageRepository.deleteById(id);
		}

		@Override
		public Image uplaodImageLivr(MultipartFile file,Long idLivr) 
		throws IOException {
				Livre p = new Livre();
				p.setIdLivre(idLivr);
		return imageRepository.save(Image.builder()
		 .name(file.getOriginalFilename())
		 .type(file.getContentType())
		 .image(file.getBytes())
		 .livre(p).build() );
		}
		
		@Override
		public Image addImageLivr(MultipartFile file,Long idLivr) 
		throws IOException {
				Livre p = new Livre();
				p.setIdLivre(idLivr);
		return imageRepository.save(Image.builder()
		 .name(file.getOriginalFilename())
		 .type(file.getContentType())
		 .image(file.getBytes())
		 .livre(p).build() );
		}

@Override
public List<Image> getImagesParLivr(Long livrId) {
	Livre p = livreRepository.findById(livrId).get();
		return p.getImages();
	}

		


		
		
	}
