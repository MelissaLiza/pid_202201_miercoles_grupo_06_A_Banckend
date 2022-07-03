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
@Table(name="tb_mascota")
public class Mascota implements Serializable {
	
	@Id //DEFINIMOS QUE EL LA PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //DEFINIMOS QUE ES AUTOINCREMENTABLE
	@Column(name="id_mascota")
	private int id_mascota;
	
	@Column(name="nombre_mascota")
	private String nombre_mascota;
	
	@Column(name="descripcion_mascota")
	private String descripcion_mascota;
	
	@Column(name="edad_mascota")
	private int edad_mascota;
	
	@ManyToOne
	@JoinColumn(name = "id_propietario")
	private Propietario propietario;

}
