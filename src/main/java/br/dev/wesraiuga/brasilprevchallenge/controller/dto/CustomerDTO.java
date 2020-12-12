package br.dev.wesraiuga.brasilprevchallenge.controller.dto;

import br.dev.wesraiuga.brasilprevchallenge.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static br.dev.wesraiuga.brasilprevchallenge.controller.dto.AddressDTO.toAddressDTO;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
	
	private Long id;
	
	private String name;
	
	private String cpf;
	
	private AddressDTO address;
	
	public Customer toCustomer() {
		return Customer.builder()
							.id(id)
							.name(name)
							.cpf(cpf)
							.address(address.toAddress())
						.build();
	}
	
	public static CustomerDTO toCustomerDTO(Customer customer) {
		return CustomerDTO.builder()
							.id(customer.getId())
							.name(customer.getName())
							.cpf(customer.getCpf())
							.address(toAddressDTO(customer.getAddress()))
						.build();
	}

}
