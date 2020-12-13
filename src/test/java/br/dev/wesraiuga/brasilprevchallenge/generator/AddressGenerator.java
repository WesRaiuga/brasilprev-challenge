package br.dev.wesraiuga.brasilprevchallenge.generator;

import br.dev.wesraiuga.brasilprevchallenge.controller.dto.AddressDTO;

public class AddressGenerator {
	
	public static AddressDTO simpleAddress() {
		return AddressDTO.builder()
							.description("Avenida Paulista")
							.number("1578")
							.district("Bela Vista")
							.zipCode("01310-200")
						.build();
	}

}
