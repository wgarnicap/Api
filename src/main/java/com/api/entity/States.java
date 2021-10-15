package com.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="States")
public class States {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StateID")
	private Long ID;
	@Column(name="State")
	private int State;
	@Column(name="Name")
	private String Name;
	@Column(name="Description")
	private String Description;
	
	
	

	public States(Long iD, int state, String name, String description) {
		
		ID = iD;
		State = state;
		Name = name;
		Description = description;
	}

	public States() {
	
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public int getState() {
		return State;
	}

	public void setState(int state) {
		State = state;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
	
}
