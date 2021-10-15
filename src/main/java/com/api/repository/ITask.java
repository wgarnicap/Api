package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entity.Tasks;

@Repository
public interface ITask extends JpaRepository<Tasks, Long>{

	public List<Tasks> findByID(Long ID);
}
