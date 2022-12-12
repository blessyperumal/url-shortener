package com.example.urlShortener;

import com.example.urlShortener.model.ShortURL;
import com.example.urlShortener.repository.ShortURLRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UrlShortenerApplication {

	private static final Logger log = LoggerFactory.getLogger(UrlShortenerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ShortURLRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(new ShortURL.ShortURLBuilder("Bilbo Baggins", "burglar").build()));
			log.info("Preloading " + repository.save(new ShortURL.ShortURLBuilder("Frodo Baggins", "thief").build()));
		};
	}
}
