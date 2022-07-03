package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entidad.Propietario;
import com.cibertec.repository.PropietarioRepository;

@Service
public class ServicePropietarioImp implements PropietarioService {
	
	@Autowired
	private PropietarioRepository repository;

	@Override
	public List<Propietario> listaPropietario() {
		return repository.findAll() ;
	}

	@Override
	public List<Propietario> listaPropietarioPorId(int id) {
		return repository.listaPropietarioPorId(id);
	}

	@Override
	public Propietario insertaActualizaPropietario(Propietario obj) {
		return repository.save(obj);
	}

	@Override
	public List<Propietario> listaPropietarioPorNombreDni(String filtro) {
		return repository.listaPropietarioPorNombreDni(filtro);
	}

	@Override
	public void eliminaPropietario(int idPropietario) {
		 repository.deleteById(idPropietario);
		
	}

	@Override
	public Optional<Propietario> buscaPropietario(int idPropietario) {
		return repository.findById(idPropietario);
	}

}
