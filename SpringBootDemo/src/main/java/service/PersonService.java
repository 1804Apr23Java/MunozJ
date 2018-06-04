package service;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import model.person;

@Service
public class PersonService {
	
	Hashtable<String, person> persons = new Hashtable<String, person>();
	public PersonService() {
		person p = new person();
		p.setId("1");
		p.setAge(21);
		p.setFirstName("Jose");
		p.setLastName("Luis");
		persons.put("1", p);

		p = new person();
		p.setId("2");
		p.setAge(21);
		p.setFirstName("Dee");
		p.setLastName("Alvarez");
		persons.put("2", p);
	}
	public person getPerson(String id) {
		if (persons.containsKey(id))
			return persons.get(id);
		else
			return null;
	}
	public Hashtable<String, person> getAll() {
		return persons;
	}
}