package com.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TaskList")
public class TaskList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long Id;

	@ManyToOne
	@JoinColumn(name = "TaskID")
	private Tasks task;

	@ManyToOne
	@JoinColumn(name = "StateID")
	private States states;

	@ManyToOne
	@JoinColumn(name = "AgentID")
	private AgentList agentID;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "DataTaskListID")
	private DataTaskList datalist;

	public TaskList(Long id, Tasks task, States states, AgentList agentID, DataTaskList datalist) {
		super();
		Id = id;
		this.task = task;
		this.states = states;
		this.agentID = agentID;
		this.datalist = datalist;
	}

	public TaskList() {

	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Tasks getTask() {
		return task;
	}

	public void setTask(Tasks task) {
		this.task = task;
	}

	public States getStates() {
		return states;
	}

	public void setStates(States states) {
		this.states = states;
	}

	public AgentList getAgentID() {
		return agentID;
	}

	public void setAgentID(AgentList agentID) {
		this.agentID = agentID;
	}

	public DataTaskList getDatalist() {
		return datalist;
	}

	public void setDatalist(DataTaskList datalist) {
		this.datalist = datalist;
	}

}
