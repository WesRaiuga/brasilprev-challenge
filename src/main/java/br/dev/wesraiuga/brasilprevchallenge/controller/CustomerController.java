package br.dev.wesraiuga.brasilprevchallenge.controller;

import static br.dev.wesraiuga.brasilprevchallenge.controller.dto.CustomerDTO.toCustomerDTO;
import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.dev.wesraiuga.brasilprevchallenge.controller.dto.CustomerDTO;
import br.dev.wesraiuga.brasilprevchallenge.controller.dto.CustomerUpdateDTO;
import br.dev.wesraiuga.brasilprevchallenge.entity.Customer;
import br.dev.wesraiuga.brasilprevchallenge.service.CustomerService;

@RestController
@RequestMapping(CustomerController.URL_PATH)
public class CustomerController {
	
	public static final String URL_PATH = "/customers";
	
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
	
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public CustomerDTO findById(@PathVariable Long id) {
		Customer customer = customerService.findById(id);
		
		return toCustomerDTO(customer);
	}
	
	@GetMapping("/count")
	@ResponseStatus(value = HttpStatus.OK)
	public Long count() {
		return customerService.count();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		Customer customer = customerService.findById(id);
		
		customerService.delete(customer);
	}
	
	@PutMapping("/{id}")
	public CustomerDTO update(@PathVariable Long id,
								@RequestBody CustomerUpdateDTO customerUpdateDTO) {
		
		Customer updatedCustomer = customerService.update(id, customerUpdateDTO);
		
		return toCustomerDTO(updatedCustomer);
	}

}
