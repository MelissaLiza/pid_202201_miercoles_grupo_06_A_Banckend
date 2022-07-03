package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entidad.Incidente;
import com.cibertec.repository.IncidenteRepository;

@Service
public class IncidenteServiceImp implements IncidenteService{

	@Autowired
	private IncidenteRepository repository;

	@Override
	public Incidente registraActualizaIndicente(Incidente obj) {
		return repository.save(obj);
	}

	@Override
	public List<Incidente> listaIncidente() {
		return repository.findAll();
	}

	@Override
	public List<Incidente> listaIncidenteConFiltro(String filtro) {
		return repository.listaIncidenteConFiltro(filtro);
	}

	@Override
	public List<Incidente> listaIncidentePorIdCausaEstado(int id, String causa, int estado) {
		return repository.listaIncidentePorIdCausaEstado(id, causa, estado);
		
	}

	@Override
	public List<Incidente> listaIncidenteConFiltro2(String filtro) {
		return repository.listaIncidenteConFiltro2(filtro);

	}
	
}
