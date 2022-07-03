package com.cibertec.entidad;

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
@Table(name="tb_incidente")
public class Incidente {
	
	//ATRIBUTOS PRIVADOS DE CLASE
	@Id //DEFINIMOS QUE EL LA PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //DEFINIMOS QUE ES AUTOINCREMENTABLE
	@Column(name="id_incidente") // DEFINIMOS QUE ES UNA COLUMNA DE UNA TABLA
	private int id_incidente;
	
	@Column(name="causa_incidente")
	private String causa_incidente;
	
	@Column(name="detalle_incidente")
	private String detalle_incidente;
	
	@Column(name="solucion_incidente")
	private String solucion_incidente;
	
	@Column(name="estado_incidente")
	private int estado_incidente;
	
	@ManyToOne
	@JoinColumn(name = "id_departamento")
	private Departamento departamento;

}
