package com.api.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LogTask")
public class LogTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TicketID")
	private Long TicketID;
	@Column(name="RecordID")
	private Date RecordDate;
	@Column(name="Client")
	private int Client;
	@Column(name="Project")
	private int Project;
	@Column(name="Task")
	private int Task;
	@Column(name="DataTaskList")
	private int DataTaskList;
	@Column(name="StateID")
	private int StateID;
	@Column(name="AgentID")
	private int AgentID;
	@Column(name="StartDate")
	private Date StartDate;
	@Column(name="EndDate")
	private Date EndDate;

	public LogTask() {
	
	}

	public LogTask(Long ticketID, Date recordDate, int client, int project, int task, int dataTaskList, int stateID,
			int agentID, Date startDate, Date endDate) {
		
		TicketID = ticketID;
		RecordDate = recordDate;
		Client = client;
		Project = project;
		Task = task;
		DataTaskList = dataTaskList;
		StateID = stateID;
		AgentID = agentID;
		StartDate = startDate;
		EndDate = endDate;
	}

	public Long getTicketID() {
		return TicketID;
	}

	public void setTicketID(Long ticketID) {
		TicketID = ticketID;
	}

	public Date getRecordDate() {
		return RecordDate;
	}

	public void setRecordDate(Date recordDate) {
		RecordDate = recordDate;
	}

	public int getClient() {
		return Client;
	}

	public void setClient(int client) {
		Client = client;
	}

	public int getProject() {
		return Project;
	}

	public void setProject(int project) {
		Project = project;
	}

	public int getTask() {
		return Task;
	}

	public void setTask(int task) {
		Task = task;
	}

	public int getDataTaskList() {
		return DataTaskList;
	}

	public void setDataTaskList(int dataTaskList) {
		DataTaskList = dataTaskList;
	}

	public int getStateID() {
		return StateID;
	}

	public void setStateID(int stateID) {
		StateID = stateID;
	}

	public int getAgentID() {
		return AgentID;
	}

	public void setAgentID(int agentID) {
		AgentID = agentID;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	
	
	
	
	

}
