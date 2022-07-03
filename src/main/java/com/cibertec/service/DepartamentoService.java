package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entidad.Departamento;
import com.cibertec.entidad.Propietario;

public interface DepartamentoService  {
	
	public abstract List<Departamento> listaDepartamento();
	public abstract List<Departamento> listaDepartamentoPorId(int id); 
	public abstract Departamento insertaActualizaDepartamento(Departamento obj);
	public abstract void eliminaDepartamento(int idDepartamento);
	public abstract Optional<Departamento> buscaDepartamento(int idDepartamento);
}
