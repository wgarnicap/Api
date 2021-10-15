package com.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DataTaskList ")
public class DataTaskList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DataTaskListID")
	private Long ID;
	
	@ManyToOne
	@JoinColumn(name="ParamID")
	private ParamList paramID;
	
	@Column(name="Data")
	private String Data;
	
	@ManyToOne
	@JoinColumn(name="ClientID")
	private Clients clientID;
	
	@ManyToOne
	@JoinColumn(name="ProjectID")
	private Projects projectID;
	
	@Column(name="Source")
	private String Source;

	public DataTaskList(Long iD, ParamList paramID, String data, Clients clientID, Projects projectID, String source) {
		
		ID = iD;
		this.paramID = paramID;
		Data = data;
		this.clientID = clientID;
		this.projectID = projectID;
		Source = source;
	}
	
	

	public DataTaskList() {
		
	}



	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public ParamList getParamID() {
		return paramID;
	}

	public void setParamID(ParamList paramID) {
		this.paramID = paramID;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public Clients getClientID() {
		return clientID;
	}

	public void setClientID(Clients clientID) {
		this.clientID = clientID;
	}

	public Projects getProjectID() {
		return projectID;
	}

	public void setProjectID(Projects projectID) {
		this.projectID = projectID;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	
	
	
	
}
