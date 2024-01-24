package com.edsonrego.uri2603;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edsonrego.uri2603.dto.CustomerMinDTO;
import com.edsonrego.uri2603.projections.CustomerMinProjection;
import com.edsonrego.uri2603.repositories.CustomerRepository;

@SpringBootApplication
public class Uri2603Application implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2603Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		List<CustomerMinProjection> list = repository.search1("Porto Alegre");
		List<CustomerMinDTO> result1 = list.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());
		
		System.out.println("\n*** RESULTADO SQL RAIZ:");
		for (CustomerMinDTO obj : result1) {
			System.out.println(obj);
		}
		System.out.println("\n\n");
		
		List<CustomerMinDTO> result2 = repository.search2("Porto Alegre");
		
		System.out.println("\n*** RESULTADO JPQL:");
		for (CustomerMinDTO obj : result2) {
			System.out.println(obj);
		}
		
	}
}