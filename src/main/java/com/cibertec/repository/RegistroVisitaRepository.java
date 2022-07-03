package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entidad.RegistroVisita;


public interface RegistroVisitaRepository extends JpaRepository<RegistroVisita, Integer> {
	
	@Query("Select x from RegistroVisita x where x.id_visita = ?1")
	public abstract List<RegistroVisita> listaRegistroVisitaPorId(int id);

}
