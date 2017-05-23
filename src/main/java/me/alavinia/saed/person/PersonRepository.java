package me.alavinia.saed.person;


import org.springframework.data.repository.CrudRepository;


public interface PersonRepository extends CrudRepository<Person, String> {

	public Person findBySin(int sin);
	

}
