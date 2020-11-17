package fr.reeter.advent2019.day2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.*;

@SpringBootApplication
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
