package br.dev.wesraiuga.brasilprevchallenge.controller;

import static br.dev.wesraiuga.brasilprevchallenge.controller.dto.CustomerDTO.toCustomerDTO;
import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.dev.wesraiuga.brasilprevchallenge.controller.dto.CustomerDTO;
import br.dev.wesraiuga.brasilprevchallenge.entity.Customer;
import br.dev.wesraiuga.brasilprevchallenge.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	@ResponseStatus(CREATED)
	public CustomerDTO save(@RequestBody CustomerDTO customerDTO) {
		Customer savedCustomer = customerService.save(customerDTO.toCustomer());
		
		return toCustomerDTO(savedCustomer);
	}
	
	@GetMapping
	public List<CustomerDTO> list() {
		List<Customer> customers = customerService.getAll();
		
		return customers.stream().map(CustomerDTO::toCustomerDTO).collect(Collectors.toList());
	}

}
