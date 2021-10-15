package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entity.AgentList;

public interface IAgentList extends JpaRepository<AgentList, Long>{
	
	public List<AgentList> findByID(Long ID);

}
