package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entity.Clients;

public interface IClients extends JpaRepository<Clients, Long>{
	
	public List<Clients> findByID(Long ID);

}
