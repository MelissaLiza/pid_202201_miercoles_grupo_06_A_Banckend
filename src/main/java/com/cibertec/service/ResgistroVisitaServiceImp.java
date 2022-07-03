package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entidad.RegistroVisita;
import com.cibertec.repository.RegistroVisitaRepository;

@Service
public class ResgistroVisitaServiceImp implements RegistroVisitaService{
	
	@Autowired
	private RegistroVisitaRepository repository;

	@Override
	public List<RegistroVisita> listaRegistroVisita() {
		return repository.findAll();
	}

	@Override
	public List<RegistroVisita> listaRegistroVisitaPorId(int id) {
		return repository.listaRegistroVisitaPorId(id);
	}

	@Override
	public RegistroVisita insertaActualizaRegistroVisita(RegistroVisita obj) {
		return repository.save(obj);
	}

}
