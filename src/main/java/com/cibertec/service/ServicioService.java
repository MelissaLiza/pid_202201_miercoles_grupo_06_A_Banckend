package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entidad.Servicio;


public interface ServicioService {
	public abstract List<Servicio> listaServicioPorId(int id); 
	public abstract List<Servicio> listaServicio();
	public abstract Servicio insertaActualizaServicio(Servicio obj);
	public abstract void eliminaServicio(int idServicio);
	public abstract Optional<Servicio> buscaServicio(int idServicio);
}
