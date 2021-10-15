package com.api.services;

import java.util.List;

import com.api.entity.DataTaskList;

public interface IDataTaskListService {

	public List <DataTaskList> listarDataTaskList ();
	
	public DataTaskList guardarDataTaskList (DataTaskList dataTaskList) throws Exception ;
	
	public void borrarDataTaskList (Long id);
	
	public DataTaskList actualizarDataTaskList (DataTaskList dataTaskList);
	
	
	
}
