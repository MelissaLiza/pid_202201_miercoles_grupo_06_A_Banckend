package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entidad.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
	@Query("Select x from Servicio x where x.id_servicio = ?1")
	public abstract List<Servicio> listaServicioPorId(int id);
}
