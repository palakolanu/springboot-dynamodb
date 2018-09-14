package com.venkat.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Person")
public class Person {

	private String id;
	private String name;

	public Person() {
	}

	public Person(String id, String name) {
		this.id = id;
		this.name=name;
	}

	@DynamoDBHashKey(attributeName = "Id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute(attributeName = "Name")
	public String getFirstName() {
		return name;
	}

	public void setFirstName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return String.format("User[id=%s, name='%s']", id, name);
	}

}