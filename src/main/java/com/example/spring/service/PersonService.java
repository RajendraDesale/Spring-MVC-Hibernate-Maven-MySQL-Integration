package com.example.spring.service;

import java.util.List;

import com.example.spring.model.PersonModel;

public interface PersonService {

	public void addPerson(PersonModel p);

	public void updatePerson(PersonModel p);

	public List<PersonModel> listPersons();

	public PersonModel getPersonById(int id);

	public void removePerson(int id);
}
