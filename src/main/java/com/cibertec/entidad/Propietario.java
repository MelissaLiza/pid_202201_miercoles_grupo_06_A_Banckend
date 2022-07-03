package com.cibertec.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//CON LA LIBRERIA DE -- LOMBOK CREAMOS LOS GET AND SET
@Getter
@Setter

//CREAMOS EL CONSTRUCTOR CON TODOS LOS PARAMETROS
@AllArgsConstructor

//CREAMOS UN CONSTRUCTOR SIN PARAMETROS
@NoArgsConstructor

//USAMOS JPA PARA CREAR LAS TABLAS
@Entity
@Table(name="tb_propietario")
public class Propietario implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id //DEFINIMOS QUE EL LA PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //DEFINIMOS QUE ES AUTOINCREMENTABLE
	@Column(name="id_propietario") // DEFINIMOS QUE ES UNA COLUMNA DE UNA TABLA
	private int id_propietario;
	
	@Column(name="nombre_propietario")
	private String nombre_propietario;
	
	@Column(name="apellido_propietario")
	private String apellido_propietario;
	
	@Column(name="dni_propietario")
	private String dni_propietario;
	
	@Column(name="edad_propietario")
	private int edad_propietario;
	
	
}
