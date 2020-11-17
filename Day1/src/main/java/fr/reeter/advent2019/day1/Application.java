package fr.reeter.advent2019.day1;

import fr.reeter.advent2019.day1.fuel.FuelCalculator;
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


	@Autowired
	FuelCalculator fuelCalculator;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public void reader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("input/module_mass.txt")));
			String line = reader.readLine();
			int fuel = 0;
			while(line != null) {
				int calc = fuelCalculator.fuelCompute(Integer.parseInt(line));
				fuel+=calc;
				line = reader.readLine();
			}

			LOGGER.info("Total fuel for modules: " + fuel);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
