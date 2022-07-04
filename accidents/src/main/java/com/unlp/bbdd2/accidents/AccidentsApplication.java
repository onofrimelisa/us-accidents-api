package com.unlp.bbdd2.accidents;

import com.unlp.bbdd2.accidents.repository.AccidentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses= AccidentRepository.class)
public class AccidentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccidentsApplication.class, args);
	}

}
