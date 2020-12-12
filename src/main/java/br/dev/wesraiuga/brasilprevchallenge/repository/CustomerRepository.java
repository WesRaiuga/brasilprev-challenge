package br.dev.wesraiuga.brasilprevchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.wesraiuga.brasilprevchallenge.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	Customer findByName(String name);

}
