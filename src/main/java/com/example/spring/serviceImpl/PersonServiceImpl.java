package com.example.spring.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.dao.PersonDAO;
import com.example.spring.model.PersonModel;
import com.example.spring.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	@Transactional
	public void addPerson(PersonModel p) {
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public void updatePerson(PersonModel p) {
		this.personDAO.updatePerson(p);
	}

	@Override
	@Transactional
	public List<PersonModel> listPersons() {
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public PersonModel getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}

}
