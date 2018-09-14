package com.venkat.dynamodb.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.dynamodb.model.Person;
import com.venkat.dynamodb.repo.PersonRepository;

@RestController
public class WebController implements ErrorController {

	@Autowired
	PersonRepository repository;
	
	private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

	@RequestMapping("/delete")
	public String delete() {
		repository.deleteAll();
		return "Done";
	}

	@RequestMapping("/save")
	public String save() {
		// save a single Customer
		repository.save(new Person("1", "Venkat"));

		// save a list of Customers
		repository.saveAll(Arrays.asList(new Person("2", "Bharath"), new Person("3", "Sarath"),
				new Person("4", "Vishnu"), new Person("5", "Potti")));

		return "Done";
	}

	@RequestMapping("/findall")
	public String findAll() {
		String result = "";
		Iterable<Person> persons = repository.findAll();

		for (Person cust : persons) {
			result += cust.toString() + "<br>";
		}

		return result;
	}

	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") String id) {
		String result = "";
		result = repository.findById(id).toString();
		return result;
	}

	@RequestMapping("/findbyname")
	public String fetchDataByName(@RequestParam("name") String name) {
		String result = "";

		for (Person cust : repository.findByName(name)) {
			result += cust.toString() + "<br>";
		}

		return result;
	}
}
