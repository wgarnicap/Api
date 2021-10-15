package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entity.TaskList;

@Repository
public interface ITaskList extends JpaRepository<TaskList, Long>{
	
}
