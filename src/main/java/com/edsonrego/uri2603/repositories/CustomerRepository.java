package com.edsonrego.uri2603.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edsonrego.uri2603.dto.CustomerMinDTO;
import com.edsonrego.uri2603.entities.Customer;
import com.edsonrego.uri2603.projections.CustomerMinProjection;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	//Consulta via SLQ raiz
	@Query(nativeQuery = true, value = "SELECT name, street "
			+ "FROM customers "
			+ "WHERE customers.city = :city")
	List<CustomerMinProjection> search1(String city);
	
	//Consulta via JPQA
	@Query("SELECT new com.edsonrego.uri2603.dto.CustomerMinDTO(obj.name, obj.street) "
			+ "FROM Customer obj "
			+ "WHERE obj.city = :city")
	List<CustomerMinDTO> search2(String city);

}
