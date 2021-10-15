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
@Table(name="ParamList")
public class ParamList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ParamID")
	private Long ID;
	

	@ManyToOne
	@JoinColumn(name="TaskID")
	private Tasks task;
	
	@Column(name="Param")
	private Long ParamList;
	
	@Column(name="ClassName")
	private String className;
	
	@Column(name="DefName")
	private String defName;
	
	@Column(name="Description")
	private String Description;

	

	public ParamList(Long iD, Tasks task, Long paramList, String className, String defName, String description) {
		super();
		ID = iD;
		this.task = task;
		ParamList = paramList;
		this.className = className;
		this.defName = defName;
		Description = description;
	}


	public ParamList() {
		
	}


	public Long getID() {
		return ID;
	}


	public void setID(Long iD) {
		ID = iD;
	}


	public Tasks getTask() {
		return task;
	}


	public void setTask(Tasks task) {
		this.task = task;
	}


	public Long getParamList() {
		return ParamList;
	}


	public void setParamList(Long paramList) {
		ParamList = paramList;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getDefName() {
		return defName;
	}


	public void setDefName(String defName) {
		this.defName = defName;
	}
	
	
	
	
	
	
}
