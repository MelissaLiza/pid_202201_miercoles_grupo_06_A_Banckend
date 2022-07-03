package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cibertec.entidad.Boleta;


import com.cibertec.repository.BoletaRepository;

@Controller
public class BoletaServiceImp implements BoletaService{
	@Autowired
	private BoletaRepository repository;

	@Override
	public Boleta insertaActualizaBoleta(Boleta obj) {
		return repository.save(obj);
	}

	@Override
	public List<Boleta> listarBoleta() {
		return repository.findAll();
	}
	
	
	@Override
	public List<Boleta> listaBoletaPorfecha(String fecha_pago_boleta ,int id_departamento,String ultimo_Dia_Pago,int estado_boleta, int id_servicio) {
		
		return repository.listaBoletaPorfecha(fecha_pago_boleta,id_departamento,ultimo_Dia_Pago,estado_boleta,id_servicio);
	}
	

}
