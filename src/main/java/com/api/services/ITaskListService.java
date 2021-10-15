package com.api.services;

import java.util.List;

import com.api.entity.TaskList;

public interface ITaskListService {
	
	public List <TaskList> listarTaskList ();
	
	public void ValidarTaskList (TaskList taskList) throws Exception ;
	
	public TaskList guardarTaskList (TaskList taskList) throws Exception ;
	
	public void borrarTaskList (Long id);
	
	public TaskList actualizarTaskList (TaskList taskList);
	
	public void ValidarToken(TaskList tasklist);
}
