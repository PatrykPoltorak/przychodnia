package com.example.przychodnia.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
public class Visit {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	private boolean status;
	@NotNull
	private String visit_date;	
	@ManyToOne
	private Dates dates;
	@ManyToOne
	private Patient patient;
	@ManyToOne
	private Users users;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVisit_date() {
		return visit_date;
	}
	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Dates getDates() {
		return dates;
	}
	public void setDates(Dates dates) {
		this.dates = dates;
	}
}