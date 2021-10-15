package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.DataTaskList;
import com.api.entity.TaskList;
import com.api.services.DataTaskListImplemen;
import com.api.services.TaskListImplemen;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin	
public class TaskListController {

	
	@Autowired
	TaskListImplemen implementandoTaskList;
	@Autowired
	DataTaskListImplemen implementandoDataTaskList;
	

	
	@PostMapping("/tasklist")
	public String crearTaskList(@RequestBody TaskList tasklist) throws Exception {
		

		implementandoTaskList.ValidarTaskList(tasklist);

		DataTaskList dataTask = tasklist.getDatalist();

		implementandoDataTaskList.guardarDataTaskList(dataTask);

		implementandoTaskList.guardarTaskList(tasklist);

		return "Creado Exitosamente";

	}

	@GetMapping("/tasklist")

	public List<TaskList> obtenerTaskList() {

		return implementandoTaskList.listarTaskList();
	}

	@PutMapping("/tasklist/{ID}")
	public String ModificarTaskList(@PathVariable Long ID, @RequestBody TaskList tasklist) throws Exception {

		tasklist.setId(ID);

		implementandoTaskList.guardarTaskList(tasklist);

		return "Modificado Exitosamente";
	}

	@DeleteMapping("/tasklist/{ID}")
	public String BorrarTask(@PathVariable Long ID) {

		implementandoTaskList.borrarTaskList(ID);

		return "Eliminado Exitosamente";
	}

	/*
	@PostMapping("/validar")
	public String validacion(@RequestBody TaskList tasklist) {
		
	
		implementandoTaskList.ValidarToken(tasklist);
		
		return "proceso exitoso";
	}
	*/

}
