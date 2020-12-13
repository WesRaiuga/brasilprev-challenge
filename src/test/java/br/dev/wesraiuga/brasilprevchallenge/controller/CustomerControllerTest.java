package br.dev.wesraiuga.brasilprevchallenge.controller;

import static br.dev.wesraiuga.brasilprevchallenge.generator.CustomerGenerator.simpleCustomer;
import static br.dev.wesraiuga.brasilprevchallenge.generator.CustomerGenerator.customerWithNewName;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import br.dev.wesraiuga.brasilprevchallenge.api.CustomerApi;
import br.dev.wesraiuga.brasilprevchallenge.controller.dto.CustomerDTO;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@SpringJUnitConfig
public class CustomerControllerTest {

	@Autowired
	private CustomerApi customerApi;

	@Test
	public void shouldGetAllCustomers() {
		customerApi.create(simpleCustomer());
		
		List<CustomerDTO> customers = customerApi.getAll();
		
		assertAll(
				() -> assertNotNull(customers),
				() -> assertTrue(customers.size() > 0)
		);
	}
	
	@Test
	public void shouldGetCustomerById() {
		CustomerDTO savedCustomer = customerApi.create(simpleCustomer());
		
		CustomerDTO returnedCustomer = customerApi.getById(savedCustomer.getId());
		
		assertNotNull(returnedCustomer);
	}

	@Test
	public void shouldSaveCustomer() {
		Long totalCustomersBeforeCreatingANew = customerApi.count();
		
		CustomerDTO savedCustomer = customerApi.create(simpleCustomer());
		
		Long totalCustomersNow = customerApi.count();
		
		assertAll(
				() -> assertEquals(totalCustomersBeforeCreatingANew + 1, totalCustomersNow),
				() -> assertNotNull(savedCustomer)
		);
	}
	
	@Test
	public void shouldUpdateCustomer() {
		CustomerDTO savedCustomer = customerApi.create(simpleCustomer());
		
		CustomerDTO updatedCustomer = customerApi.update(savedCustomer.getId(), customerWithNewName());
		
		assertAll(
				() -> assertNotNull(updatedCustomer),
				() -> assertNotEquals(savedCustomer.getName(), updatedCustomer.getName())
		);
	}
	
	@Test
	@SuppressWarnings("unused")
	public void shouldDeleteCustomer() {
		Long totalCustomersBeforeCreatingSome = customerApi.count();
		
		CustomerDTO savedCustomer = customerApi.create(simpleCustomer());
		CustomerDTO customerToBeDeleted = customerApi.create(simpleCustomer());
		
		customerApi.deleteById(customerToBeDeleted.getId());
		
		Long totalCustomersNow = customerApi.count();
		
		assertEquals(totalCustomersBeforeCreatingSome + 1, totalCustomersNow);
	}

}
