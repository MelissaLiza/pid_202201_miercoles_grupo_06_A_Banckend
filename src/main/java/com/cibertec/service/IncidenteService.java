package com.cibertec.service;

import java.util.List;

import com.cibertec.entidad.Incidente;

public interface IncidenteService {
	
	public abstract Incidente registraActualizaIndicente(Incidente obj);
	public abstract List<Incidente> listaIncidente();
	public List<Incidente> listaIncidenteConFiltro(String filtro);
	public List<Incidente> listaIncidentePorIdCausaEstado(int id, String causa, int estado);
	public List<Incidente> listaIncidenteConFiltro2(String filtro);

}
