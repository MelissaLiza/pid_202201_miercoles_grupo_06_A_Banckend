package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cibertec.entidad.Visitante;
import com.cibertec.repository.VisitanteRepository;

@Controller
public class VisitanteServiceImp implements VisitanteService {

	@Autowired
	private VisitanteRepository repository;
	@Override
	public List<Visitante> listaVisitante() {
		return repository.findAll() ;
	}

	@Override
	public List<Visitante> listaVisitanteoPorId(int id) {
		return repository.listaVisitantePorId(id);
	}

	@Override
	public Visitante insertaActualizaVisitante(Visitante obj) {
		return repository.save(obj);
	}

}
