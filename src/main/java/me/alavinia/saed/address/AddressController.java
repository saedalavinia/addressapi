package me.alavinia.saed.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.alavinia.saed.person.PersonService;




@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/persons/{sin}/addresses")
	public List<Address> getAllAddresses(@PathVariable("sin") int sin){
		return addressService.getAddresses(sin);			
	}
	
	

	@RequestMapping(method=RequestMethod.POST, value="/persons/{sin}/addresses")
	public void addAddress(@PathVariable("sin") int sin, @RequestBody Address address){
		address.setPerson(personService.getPerson(sin));
		addressService.addAddress(address);
	}
	
	
}
