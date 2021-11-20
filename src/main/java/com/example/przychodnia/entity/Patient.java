package com.example.przychodnia.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotNull
	@Size(min=2, max=60)
	private String name;
	@NotNull
	@Size(min=2, max=60)
	private String surname;
	@NotNull
	@Size(min=2, max=60)
	private String city;
	@NotNull
	@Size(min=2, max=60)
	private String street;
	@NotNull
	@Min(1)	
	private int streetNumber;
	@Column(nullable = false, unique = true)
	@DecimalMin("11111111111")
	private long pesel;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
	private List<Visit> patientVisit;	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	public long getPesel() {
		return pesel;
	}
	public void setPesel(long pesel) {
		this.pesel = pesel;
	}
	public List<Visit> getPatientVisit() {
		return patientVisit;
	}
	public void setPatientVisit(List<Visit> patientVisit) {
		this.patientVisit = patientVisit;
	}	
}
