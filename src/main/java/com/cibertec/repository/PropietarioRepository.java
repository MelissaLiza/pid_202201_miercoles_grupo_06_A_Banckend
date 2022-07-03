package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entidad.Propietario;



public interface PropietarioRepository extends JpaRepository<Propietario, Integer> {
	
	@Query("Select x from Propietario x where x.id_propietario = ?1")
	public abstract List<Propietario> listaPropietarioPorId(int id);
	
	@Query("select x from Propietario x where x.nombre_propietario like ?1 or x.dni_propietario like ?1 or x.id_propietario like ?1 or x.apellido_propietario like ?1 ")
	public List<Propietario> listaPropietarioPorNombreDni(String filtro);

}
