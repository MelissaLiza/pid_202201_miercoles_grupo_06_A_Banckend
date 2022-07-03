package com.cibertec.service;

import java.util.List;

import com.cibertec.entidad.RegistroVisita;

public interface RegistroVisitaService {
	
	public abstract List<RegistroVisita> listaRegistroVisita();
	public abstract List<RegistroVisita> listaRegistroVisitaPorId(int id); 
	public abstract RegistroVisita insertaActualizaRegistroVisita(RegistroVisita obj);

}
