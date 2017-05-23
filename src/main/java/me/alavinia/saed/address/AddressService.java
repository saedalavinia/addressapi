package me.alavinia.saed.address;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	public List<Address> getAddresses(int sin) {
		//return courses;
		List<Address> addresses = new ArrayList<>();
		addressRepository.findByPersonSin(sin)
		.forEach(addresses::add);
		return addresses;
	}


	public void addAddress(Address address) {
		addressRepository.save(address);
	}


	public void deleteAddress(String id) {
		addressRepository.delete(id);
	}
	
	
}
