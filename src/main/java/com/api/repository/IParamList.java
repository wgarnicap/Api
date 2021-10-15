package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entity.ParamList;

@Repository
public interface IParamList extends JpaRepository<ParamList, Long>{

	public List<ParamList> findByID(Long ID);
}
