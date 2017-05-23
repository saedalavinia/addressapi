package me.alavinia.saed.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> getPersons() {
		//return topics;
		List<Person> persons = new ArrayList<>();
		personRepository.findAll()
		.forEach(persons::add);
		return persons;
	}

	public Person getPerson(int sin){
		return personRepository.findBySin(sin);
	}
	

	public void addPerson(Person person) {
		personRepository.save(person);
	}


	public void deletePerson(String id) {
		personRepository.delete(id);
	}
	
	public void getBySin(int sin){
		personRepository.findBySin(sin);
	}
}
