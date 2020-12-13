package br.dev.wesraiuga.brasilprevchallenge.generator;

import static br.dev.wesraiuga.brasilprevchallenge.generator.AddressGenerator.simpleAddress;

import br.dev.wesraiuga.brasilprevchallenge.controller.dto.CustomerDTO;

public class CustomerGenerator {
	
	public static CustomerDTO simpleCustomer() {
		return CustomerDTO.builder()
							.name("Weslley Aguiar")
							.cpf("42947749839")
							.address(simpleAddress())
						.build();
	}
	
	public static CustomerDTO customerWithNewName() {
		return CustomerDTO.builder()
							.name("João da Silva")
						.build();
	}

}
