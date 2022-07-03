package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entidad.Incidente;

public interface IncidenteRepository extends JpaRepository<Incidente, Integer>{
	@Query("select x from Incidente x where (x.causa_incidente like ?1 or x.detalle_incidente like ?1 or x.departamento.id_departamento like ?1) ")
	public List<Incidente> listaIncidenteConFiltro(String filtro);
	
	@Query("select x from Incidente x where (x.causa_incidente like ?1 or x.detalle_incidente like ?1 or x.departamento.id_departamento like ?1) ")
	public List<Incidente> listaIncidenteConFiltro2(String filtro);
	
	@Query("select x from Incidente x where ( x.id_incidente = ?1) or (?2 is '' or x.causa_incidente = ?2) and x.estado_incidente = ?3")       
	public List<Incidente> listaIncidentePorIdCausaEstado(int id, String causa, int estado);
	
}
