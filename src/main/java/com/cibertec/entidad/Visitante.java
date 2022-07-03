package com.cibertec.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="tb_visitante")
public class Visitante implements Serializable{
	
	//ATRIBUTOS PRIVADOS DE CLASE
	@Id //DEFINIMOS QUE EL LA PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //DEFINIMOS QUE ES AUTOINCREMENTABLE
	@Column(name="id_visitante") // DEFINIMOS QUE ES UNA COLUMNA DE UNA TABLA
	private int id_visitante;
	
	@Column(name="nombre_visitante")
	private String nombre_visitante;
	
	@Column(name="apellido_visitante")
	private String apellido_visitante;
	
	@Column(name="telefono_visitante")
	private int telefono_visitante;
	
	@Column(name="dni_visitante")
	private String dni_visitante;
	
	@Column(name="estado_visitante")
	private int estado_visitante;

}
