package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entidad.Visitante;

public interface VisitanteRepository extends JpaRepository<Visitante, Integer>{
	@Query("Select x from Visitante x where x.id_visitante = ?1")
	public abstract List<Visitante> listaVisitantePorId(int id);
}
