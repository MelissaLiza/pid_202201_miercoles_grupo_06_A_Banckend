package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cibertec.entidad.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>  {
	@Query("Select x from Departamento x where x.id_departamento = ?1")
	public abstract List<Departamento> listaDepartamentoPorId(int id);
}
