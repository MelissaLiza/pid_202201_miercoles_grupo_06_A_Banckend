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
@Table(name="tb_departamento")
public class Departamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//ATRIBUTOS PRIVADOS DE CLASE
	@Id //DEFINIMOS QUE EL LA PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //DEFINIMOS QUE ES AUTOINCREMENTABLE
	@Column(name="id_departamento") // DEFINIMOS QUE ES UNA COLUMNA DE UNA TABLA
	private int id_departamento;
	
	@Column(name="numero_departamento")
	private int numero_departamento;
	
	@Column(name="tamanom2_departamento")
	private int tamanom2_departamento;
	
	@ManyToOne
	@JoinColumn(name = "id_propietario")
	private Propietario propietario;
	
	
	
}
