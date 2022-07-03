package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entidad.Boleta;


public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
	
	@Query("select d from Boleta d where "
			+ "( :p_fecha_pago_boleta is '' or d.fecha_pago_boleta like :p_fecha_pago_boleta ) and "
			+ "( :p_id_departamento is 0 or d.departamento.id_departamento = :p_id_departamento ) and "
			+ "( :p_ultimo_Dia_Pago is '' or d.ultimo_Dia_Pago like :p_ultimo_Dia_Pago ) and "
			+ "( :p_estado_boleta is 0 or d.estado_boleta = :p_estado_boleta ) and "
			+ "( :p_id_servicio is 0 or d.servicio.id_servicio = :p_id_servicio ) ")
	public abstract List<Boleta> listaBoletaPorfecha(
								 	@Param("p_fecha_pago_boleta") String fecha_pago_boleta,
								 	@Param("p_id_departamento") int id_departamento,
								 	
								 	@Param("p_ultimo_Dia_Pago") String ultimo_Dia_Pago,
								 	@Param("p_estado_boleta") int estado_boleta,
								 	@Param("p_id_servicio") int id_servicio
								 	
								 	);

}
