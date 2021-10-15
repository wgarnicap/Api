package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entity.DataTaskList;

@Repository
public interface IDataTaskList extends JpaRepository<DataTaskList, Long>{

	
	public List<DataTaskList> findByID(Long iD);
	
}
