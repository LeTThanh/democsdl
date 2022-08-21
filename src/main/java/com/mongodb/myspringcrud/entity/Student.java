package com.mongodb.myspringcrud.entity;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Students")
public class Student {

	public Student(){}

	public Student(String firstName, String lastName, String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private Double gpa;
}
