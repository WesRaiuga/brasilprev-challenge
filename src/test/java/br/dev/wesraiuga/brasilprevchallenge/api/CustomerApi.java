package br.dev.wesraiuga.brasilprevchallenge.api;

import static br.dev.wesraiuga.brasilprevchallenge.util.JsonConverter.fromJson;
import static br.dev.wesraiuga.brasilprevchallenge.util.JsonConverter.fromJsonList;
import static br.dev.wesraiuga.brasilprevchallenge.util.JsonConverter.toJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;

import br.dev.wesraiuga.brasilprevchallenge.controller.CustomerController;
import br.dev.wesraiuga.brasilprevchallenge.controller.dto.CustomerDTO;
import lombok.SneakyThrows;

@Component
public class CustomerApi {
	
	@Autowired
	private MockMvc mockMvc;
	
	@SneakyThrows
	public CustomerDTO create(CustomerDTO customerDTO) {
		String bodyAsJson = mockMvc.perform(
											post(CustomerController.URL_PATH)
											.contentType(MediaType.APPLICATION_JSON)
											.content(toJson(customerDTO))
									)
									.andReturn()
									.getResponse()
									.getContentAsString();
		
		return fromJson(bodyAsJson, CustomerDTO.class);
	}

	@SneakyThrows
	public List<CustomerDTO> getAll() {
		String bodyAsJson = mockMvc.perform(
											get(CustomerController.URL_PATH)
									)
									.andReturn()
									.getResponse()
									.getContentAsString();
		
		return fromJsonList(bodyAsJson, CustomerDTO.class);
	}
	
	@SneakyThrows
	public CustomerDTO getById(Long id) {
		String bodyAsJson = mockMvc.perform(
											get(CustomerController.URL_PATH + "/" + id)
									)
									.andReturn()
									.getResponse()
									.getContentAsString();
		
		return fromJson(bodyAsJson, CustomerDTO.class);
	}

	@SneakyThrows
	public Long count() {
		String bodyAsJson = mockMvc.perform(
											get(CustomerController.URL_PATH + "/count")
									)
									.andReturn()
									.getResponse()
									.getContentAsString();
		
		return Long.valueOf(bodyAsJson);
	}
	
	@SneakyThrows
	public CustomerDTO update(Long id, CustomerDTO customerWithNewName) {
		String bodyAsJson = mockMvc.perform(
											put(CustomerController.URL_PATH + "/" + id)
											.contentType(MediaType.APPLICATION_JSON)
											.content(toJson(customerWithNewName))
									)
									.andReturn()
									.getResponse()
									.getContentAsString();
							
		return fromJson(bodyAsJson, CustomerDTO.class);
	}

	@SneakyThrows
	public void deleteById(Long id) {
		mockMvc.perform(
						delete(CustomerController.URL_PATH + "/" + id)
				)
				.andExpect(status().isOk());
	}

}
