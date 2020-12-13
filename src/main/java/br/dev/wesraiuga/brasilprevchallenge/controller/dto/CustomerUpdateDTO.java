package br.dev.wesraiuga.brasilprevchallenge.controller.dto;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerUpdateDTO {
	
	private String name;
	
	private String cpf;
	
	private AddressDTO address;
	
	public Optional<String> getName() {
		return ofNullable(name);
	}
	
	public Optional<String> getCpf() {
		return ofNullable(cpf);
	}
	
	public Optional<AddressDTO> getAddress() {
		return ofNullable(address);
	}

}
