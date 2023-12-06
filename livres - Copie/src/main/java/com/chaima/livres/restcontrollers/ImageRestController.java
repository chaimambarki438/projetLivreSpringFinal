package com.chaima.livres.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.chaima.livres.entities.Image;
import com.chaima.livres.entities.Livre;
import com.chaima.livres.service.ImageService;
import com.chaima.livres.service.LivreService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	 @Autowired
	 ImageService imageService ;
	 
	 @Autowired
	LivreService livreService;
	 
	 
	 @RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
	 public void uploadImageFS(@RequestParam("image") MultipartFile 
			 file,@PathVariable("id") Long id) throws IOException {
		 Livre p = livreService.getLivre(id);
		 p.setImagePath(id+".jpg");

		 Files.write(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath())
				 , file.getBytes());
		 livreService.saveLivre(p);

	 }
	 @RequestMapping(value = "/loadfromFS/{id}" , 
			 method = RequestMethod.GET,
			 produces = MediaType.IMAGE_JPEG_VALUE)
	 public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

		 Livre p = livreService.getLivre(id);
		 return	 Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
	 }

	 
	 @RequestMapping(value = "/upload" , method = RequestMethod.POST)
	 public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
		 	return imageService.uplaodImage(file);
	 }
	 
	 @PostMapping(value = "/uplaodImageLivr/{idLivr}" )
	 public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
			 @PathVariable("idLivr") Long idLivr) 
					 throws IOException {
		 return imageService.uplaodImageLivr(file,idLivr);
	 }
	 
	 @RequestMapping(value = "/getImagesLivr/{idLivr}" , method = RequestMethod.GET)
	 public List<Image> getImagesProd(@PathVariable("idLivr") Long idLivr) 
			 throws IOException {
		 return imageService.getImagesParLivr(idLivr);
	 }
	 
	 
	 @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	 public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
	 return imageService.getImageDetails(id) ;
	 }
	 
	 
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException 
	{
	 return imageService.getImage(id);
	 }
	 
	 
	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteImage(@PathVariable("id") Long id){
	 imageService.deleteImage(id);
	 }
	 
	 
	
	 @RequestMapping(value="/update",method = RequestMethod.PUT)
	 public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	}