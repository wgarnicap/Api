package com.api.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="Tasks")
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TaskID")
	private Long ID;
	@Column(name="TaskName")
	private String Task;
	@Column(name="Service")
	private String Service;
	@Column(name="Description")
	private String Description;
	@Column(name="DataIn")
	private String dataIn;
	@Column(name="DataOut")
	private String dataOut;
	
	public Tasks(Long iD, String task, String service, String description, String dataIn, String dataOut) {
		super();
		ID = iD;
		Task = task;
		Service = service;
		Description = description;
		this.dataIn = dataIn;
		this.dataOut = dataOut;
	}

	public Tasks() {
		super();
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getTask() {
		return Task;
	}

	public void setTask(String task) {
		Task = task;
	}

	public String getService() {
		return Service;
	}

	public void setService(String service) {
		Service = service;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getDataIn() {
		return dataIn;
	}

	public void setDataIn(String dataIn) {
		this.dataIn = dataIn;
	}

	public String getDataOut() {
		return dataOut;
	}

	public void setDataOut(String dataOut) {
		this.dataOut = dataOut;
	}
	
	
	
	
	
}
