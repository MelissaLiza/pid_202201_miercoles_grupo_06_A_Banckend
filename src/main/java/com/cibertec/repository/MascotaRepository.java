package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entidad.Mascota;


public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

	@Query("select x from Mascota x where x.nombre_mascota like ?1")
	public List<Mascota> listaMascotaConFiltro(String filtro);
	
}
