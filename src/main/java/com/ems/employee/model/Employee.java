package com.ems.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String full_name;
	private String contact_number;
	
	public Employee(String email, String full_name, String contact_number) {
		super();
		this.email = email;
		this.full_name = full_name;
		this.contact_number = contact_number;
	}
	
}
