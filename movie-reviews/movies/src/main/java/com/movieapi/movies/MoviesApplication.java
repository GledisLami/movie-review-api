package com.movieapi.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RestController //lets the app know this class is a REST API controller
public class MoviesApplication {
	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
}