package me.alavinia.saed.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/persons")
	public List<Person> getAllPersons(){
		return personService.getPersons();			
	}
	
	@RequestMapping("/persons/{sin}")
	public Person getlPerson(@PathVariable("sin") int sin){
		return personService.getPerson(sin);	
	}
	


	@RequestMapping(method=RequestMethod.POST, value="/persons")
	public void addPerson(@RequestBody Person person){
		personService.addPerson(person);
	}
	
	
}
