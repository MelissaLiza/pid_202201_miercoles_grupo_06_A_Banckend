package com.cibertec.service;

import java.util.List;

import com.cibertec.entidad.Visitante;


public interface VisitanteService {
	public abstract List<Visitante> listaVisitante();
	public abstract List<Visitante> listaVisitanteoPorId(int id); 
	public abstract Visitante insertaActualizaVisitante(Visitante obj);


}
