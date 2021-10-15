package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entity.Projects;

public interface IProjects extends JpaRepository<Projects, Long>{

	public List<Projects> findByID(Long ID);
}
