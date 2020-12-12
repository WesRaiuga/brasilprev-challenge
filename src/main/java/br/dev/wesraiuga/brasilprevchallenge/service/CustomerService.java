package br.dev.wesraiuga.brasilprevchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.wesraiuga.brasilprevchallenge.entity.Customer;
import br.dev.wesraiuga.brasilprevchallenge.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

}
