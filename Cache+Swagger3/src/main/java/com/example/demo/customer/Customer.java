package com.example.demo.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
		
	@Id
	@Column(name="FIRSTNAME")
	String firstName;
	@Column(name="LASTNAME")
	String lastName;
	@Column(name="PHONENUMBER")
	long phoneNumber;
	@Column(name="EMAILID")
	String email;
	@Column(name="SALARY")
	long salary;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String firstName, String lastName, long phoneNumber, String email, long salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.salary = salary;
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
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", salary=" + salary + "]";
	}
}
