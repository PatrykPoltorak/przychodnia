package com.example.przychodnia.entity;

import java.util.List;
import javax.persistence.*;

@Entity
public class Dates {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String time;
	@OneToMany(mappedBy = "dates", cascade = CascadeType.REMOVE)
	private List<Visit> vissitDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}	
}