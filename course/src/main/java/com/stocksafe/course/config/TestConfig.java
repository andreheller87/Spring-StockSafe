package com.stocksafe.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.stocksafe.course.entities.Usuario;
import com.stocksafe.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Maria Brown", "123456", 1); 
		Usuario u2 = new Usuario(null, "Alex Green", "123456", 1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	}

}
