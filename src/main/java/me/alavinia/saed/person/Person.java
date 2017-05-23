package me.alavinia.saed.person;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	private int sin; 
	
	private String firstName;
	private String lastName;
	
	public Person(){}

	public Person(int sin, String firstName, String lastName, String pass) {
		//this.sin = Integer.parseInt(sin);
		this.sin = sin;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public int getSin() {
		return sin;
	}


	public void setSin(int sin) {
		this.sin = sin;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return this.getSin() + ":" + this.getFirstName() + " " +  this.getLastName();
	}



}
