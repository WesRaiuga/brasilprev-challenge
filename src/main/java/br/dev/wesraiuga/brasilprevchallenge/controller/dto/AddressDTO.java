package br.dev.wesraiuga.brasilprevchallenge.controller.dto;

import br.dev.wesraiuga.brasilprevchallenge.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
	
	private Long id;
	
	private String description;
	
	private String number;
	
	private String district;
	
	private String zipCode;
	
	public Address toAddress() {
		return Address.builder()
							.id(id)
							.description(description)
							.number(number)
							.district(district)
							.zipCode(zipCode)
						.build();
	}
	
	public static AddressDTO toAddressDTO(Address address) {
		return AddressDTO.builder()
							.id(address.getId())
							.description(address.getDescription())
							.number(address.getNumber())
							.district(address.getDistrict())
							.zipCode(address.getZipCode())
						.build();
	}

}
