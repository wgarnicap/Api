package com.api.services;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.Clients;
import com.api.entity.DataTaskList;
import com.api.entity.ParamList;
import com.api.entity.Projects;
import com.api.repository.IClients;
import com.api.repository.IDataTaskList;
import com.api.repository.IParamList;
import com.api.repository.IProjects;

@Service
public class DataTaskListImplemen implements IDataTaskListService {

	@Autowired
	IDataTaskList IdataTaskList;
	@Autowired
	IParamList repoParam;
	@Autowired
	IClients repoClients;
	@Autowired
	IProjects repoProjects;

	@Override
	public List<DataTaskList> listarDataTaskList() {

		return IdataTaskList.findAll();
	}

	@Override
	public DataTaskList guardarDataTaskList(DataTaskList dataTaskList) throws Exception {

		if (dataTaskList == null) {
			throw new  Exception("Objeto dataTaskList llego nulo");
		}
		
		if (dataTaskList.getParamID() == null) {
			throw new  Exception("param llego nulo");
		}
		ParamList param = dataTaskList.getParamID();
		Long paramId = param.getID();
		List<ParamList> listParam = repoParam.findByID(paramId);
		if (listParam == null || listParam.isEmpty()) {
			throw new Exception("Param No existe, ingrese uno que exista o cree un Param por favor");
		}
		if (dataTaskList.getClientID() == null) {
			throw new  Exception("Clients llego nulo");
		}
		Clients client = dataTaskList.getClientID();
		Long clientID = client.getID();
		List<Clients> listClient = repoClients.findByID(clientID);
		if (listClient == null || listClient.isEmpty()) {
			throw new Exception("Cliente No existe, ingrese uno que exista o cree un Cliente por favor");
		}
		if (dataTaskList.getProjectID() == null) {
			throw new  Exception("Project llego nulo");
		}
		Projects project = dataTaskList.getProjectID();
		Long projectId = project.getID();
		List<Projects> projecID = repoProjects.findByID(projectId);
		if (projecID == null || projecID.isEmpty()) {
			throw new Exception("Project No existe, ingrese uno que exista o cree un Project por favor");
		}

		try {

			new JSONObject(dataTaskList.getData());
		} catch (Exception e) {

			throw new Exception("Error en la estructura del JSON en DATA ");
		}

		try {

			new JSONObject(dataTaskList.getSource());
		} catch (Exception e) {

			throw new Exception("Error en la estructura del JSON en SOURCE ");
		}

		return IdataTaskList.save(dataTaskList);
	}

	@Override
	public void borrarDataTaskList(Long id) {

		IdataTaskList.deleteById(id);

	}

	@Override
	public DataTaskList actualizarDataTaskList(DataTaskList dataTaskList) {

		return IdataTaskList.save(dataTaskList);
	}

}
