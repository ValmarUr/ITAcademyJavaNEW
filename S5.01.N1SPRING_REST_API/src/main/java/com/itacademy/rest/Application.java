package com.itacademy.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.itacademy.rest.model.Picture;
import com.itacademy.rest.model.Shop;
import com.itacademy.rest.repository.IPictureRepository;
import com.itacademy.rest.repository.IShopRepository;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner initData(IShopRepository shopRepository, IPictureRepository pictureRepository) {
		return args -> {

			//save a few shops
			Shop s1 = shopRepository.save(new Shop("First", 15));
			Shop s2 = shopRepository.save(new Shop("Second", 25));
			Shop s3 = shopRepository.save(new Shop("Third", 35));
			
			//save a few pictures
//			Picture p1 = pictureRepository.save(new Picture("Munch","The Scream", 1000, new Date(), s1));
//			Picture p2 = pictureRepository.save(new Picture("Picasso","Gernica", 22000, new Date(), s1));
//			Picture p3 = pictureRepository.save(new Picture("Mucha","Iris", 5000, new Date(), s2));
//			Picture p4 = pictureRepository.save(new Picture("Anonim","Gioconda", 100000, new Date(), s3));
//			Picture p5 = pictureRepository.save(new Picture("Van Gogh","Sunflowers", 6000, new Date(), s2));
			
			Picture p1 = pictureRepository.save(new Picture("Munch","The Scream", 1000, s1));
			Picture p2 = pictureRepository.save(new Picture("Picasso","Gernica", 22000, s1));
			Picture p3 = pictureRepository.save(new Picture("Mucha","Iris", 5000, s2));
			Picture p4 = pictureRepository.save(new Picture("Anonim","Gioconda", 100000, s3));
			Picture p5 = pictureRepository.save(new Picture("Van Gogh","Sunflowers", 6000, s2));
			
//			// fetch all shops
//		      log.info("Shops found with findAll():");
//		      log.info("-------------------------------");
//		      for (Shop shop : shopRepository.findAll()) {
//		        log.info(shop.toString());
//		      }
//		      log.info("");
//		      
//			// fetch all pictures
//		      log.info("Pictures found with findAll():");
//		      log.info("-------------------------------");
//		      for (Picture picture : pictureRepository.findAll()) {
//		        log.info(picture.toString());
//		      }
//		      log.info("");
		      
		      

//		      // fetch an individual customer by ID
//		      Customer customer = repository.findById(1L);
//		      log.info("Customer found with findById(1L):");
//		      log.info("--------------------------------");
//		      log.info(customer.toString());
//		      log.info("");
//
//		      // fetch customers by last name
//		      log.info("Customer found with findByLastName('Bauer'):");
//		      log.info("--------------------------------------------");
//		      repository.findByLastName("Bauer").forEach(bauer -> {
//		        log.info(bauer.toString());
//		      });
		      // for (Customer bauer : repository.findByLastName("Bauer")) {
		      //  log.info(bauer.toString());
		      // }
		      log.info("");
			
		};
	}
}
