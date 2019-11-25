package com.example.spring.dao;

import java.util.List;

import com.example.spring.model.PersonModel;

public interface PersonDAO {
	
	public void addPerson(PersonModel p);

	public void updatePerson(PersonModel p);

	public List<PersonModel> listPersons();

	public PersonModel getPersonById(int id);

	public void removePerson(int id);
}
