package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.DataTaskList;
import com.api.services.DataTaskListImplemen;

@RestController
@RequestMapping("/api")
public class DataTaskListController {
	
	@Autowired
	DataTaskListImplemen implemen;

	@GetMapping("/datatasklist")
	public List<DataTaskList> obtenerDataTaskList() {

		return implemen.listarDataTaskList();
	}

	@PostMapping("/datatasklist")
	public String crearDataTaskList(@RequestBody DataTaskList datatasklist) throws Exception {

		implemen.guardarDataTaskList(datatasklist);

		return "Creado Exitosamente";
	}

	@PutMapping("/datatasklist/{ID}")
	public String ModificarDataTaskList(@PathVariable Long ID, @RequestBody DataTaskList datatasklist) {

		datatasklist.setID(ID);

		implemen.actualizarDataTaskList(datatasklist);

		return "Modificado Exitosamente";
	}

	@DeleteMapping("/datatasklist/{ID}")
	public String BorrarDataTaskList(@PathVariable Long ID) {

		implemen.borrarDataTaskList(ID);

		return "Eliminado Exitosamente";
	}

}
