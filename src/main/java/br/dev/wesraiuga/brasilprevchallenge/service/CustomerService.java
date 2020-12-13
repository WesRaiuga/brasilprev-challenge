package br.dev.wesraiuga.brasilprevchallenge.service;

import static br.dev.wesraiuga.brasilprevchallenge.controller.dto.AddressDTO.toAddressDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.wesraiuga.brasilprevchallenge.controller.dto.CustomerUpdateDTO;
import br.dev.wesraiuga.brasilprevchallenge.entity.Customer;
import br.dev.wesraiuga.brasilprevchallenge.exception.NotFoundException;
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
	
	public Customer findById(Long id) {
		return customerRepository.findById(id)
								.orElseThrow( () -> new NotFoundException("Customer not found"));
	}
	
	public void delete(Customer customer) {
		customerRepository.delete(customer);
	}

	public Customer update(Long id, CustomerUpdateDTO customerUpdateDTO) {
		Customer customer = customerRepository.findById(id)
												.orElseThrow( () -> new NotFoundException("Customer not found"));
		
		customer.setName(customerUpdateDTO.getName()
											.orElse(customer.getName()) );
		customer.setCpf(customerUpdateDTO.getCpf()
											.orElse(customer.getCpf()));
		customer.setAddress(customerUpdateDTO.getAddress()
												.orElse(toAddressDTO(customer.getAddress()))
												.toAddress()
							);
		
		return customerRepository.save(customer);
	}

}
