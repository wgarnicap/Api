package com.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AgentsList")
public class AgentList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AgentID")
	private Long ID;
	@Column(name="Name")
	private String Name;
	@Column(name="Description")
	private String Description;
	@Column(name="StatusID")
	private Long Status;
	@Column(name="TaskListID")
	private Long TaskListID;
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
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
	public Long getStatus() {
		return Status;
	}
	public void setStatus(Long status) {
		Status = status;
	}
	public Long getTaskListID() {
		return TaskListID;
	}
	public void setTaskListID(Long taskListID) {
		TaskListID = taskListID;
	}
	public AgentList(Long iD, String name, String description, Long status, Long taskListID) {
		
		ID = iD;
		Name = name;
		Description = description;
		Status = status;
		TaskListID = taskListID;
	}
	public AgentList() {
		
	}

	

	
	
}
