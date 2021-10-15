package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entity.States;

public interface IStates extends JpaRepository<States, Long>{

	public List<States> findByID(Long ID);
	
}
