package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entidad.Propietario;


public interface PropietarioService {
	public abstract List<Propietario> listaPropietario();
	public abstract List<Propietario> listaPropietarioPorId(int id); 
	public abstract Propietario insertaActualizaPropietario(Propietario obj);
	public List<Propietario> listaPropietarioPorNombreDni(String filtro);
	public abstract void eliminaPropietario(int idPropietario);
	public abstract Optional<Propietario> buscaPropietario(int idPropietario);
}
