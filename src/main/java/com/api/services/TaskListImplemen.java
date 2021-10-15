package com.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.entity.AgentList;
import com.api.entity.States;
import com.api.entity.TaskList;
import com.api.entity.Tasks;
import com.api.repository.IAgentList;
import com.api.repository.IDataTaskList;
import com.api.repository.IStates;
import com.api.repository.ITask;
import com.api.repository.ITaskList;

@Service
public class TaskListImplemen implements ITaskListService {

	@Autowired
	RestTemplate clienteRest;
	@Autowired
	ITaskList itasklist;
	@Autowired
	IDataTaskList repoDataList;
	@Autowired
	ITask repoTasks;
	@Autowired
	IStates repoStates;
	@Autowired
	IAgentList repoAgentList;

	@Override
	public List<TaskList> listarTaskList() {

		return itasklist.findAll();
	}

	@Override
	public void ValidarTaskList(TaskList taskList) throws Exception {

		if (taskList == null) {
			throw new  Exception("Objeto TaskList llego nulo");
		}

		if (taskList.getTask() == null) {
			throw new Exception("Task llego nulo");
		}
		Tasks task = taskList.getTask();
		Long taskid = task.getID();
		List<Tasks> listaTasks = repoTasks.findByID(taskid);
		if (listaTasks == null || listaTasks.isEmpty()) {
			throw new Exception("Task No existe, ingrese uno que exista o cree un task por favor");
		}

		if (taskList.getStates() == null) {
			throw new  Exception("State llego nulo");
		}
		States state = taskList.getStates();
		Long stateId = state.getID();
		List<States> listState = repoStates.findByID(stateId);
		if (listState == null || listState.isEmpty()) {
			throw new Exception("State No existe, ingrese uno que exista o cree un state por favor");
		}

		if (taskList.getAgentID() != null) {
			AgentList agent = taskList.getAgentID();
			Long agentId = agent.getID();
			List<AgentList> listAgentID = repoAgentList.findByID(agentId);

			if (listAgentID != null && !listAgentID.isEmpty()) {
				throw new Exception("El campo Agent no debe estar diligenciado (Null o vacio)");
			}
		}

	}

	@Override
	public void borrarTaskList(Long id) {

		itasklist.deleteById(id);

	}

	@Override
	public TaskList actualizarTaskList(TaskList taskList) {
		// TODO Auto-generated method stub
		return itasklist.save(taskList);
	}

	@Override
	public TaskList guardarTaskList(TaskList taskList) throws Exception {
		// TODO Auto-generated method stub
		return itasklist.save(taskList);
	}

	@Override
	public void ValidarToken(TaskList tasklist) {
		
		clienteRest.postForLocation("http://localhost:8081/auth/validaciontoken", tasklist);
	
	
		
	}

}
