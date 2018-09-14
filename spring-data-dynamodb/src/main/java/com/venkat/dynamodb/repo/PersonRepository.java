package com.venkat.dynamodb.repo;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import com.venkat.dynamodb.model.Person;

@EnableScan
public interface PersonRepository extends DynamoDBCrudRepository<Person, String> { //CrudRepository<Customer, String> {

	List<Person> findByName(String lastName);
}
