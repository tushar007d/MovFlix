package com.MovFlix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MovFlix.controller.MovieController;

@SpringBootApplication
public class MovFlixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovFlixApplication.class, args);
	}

}
