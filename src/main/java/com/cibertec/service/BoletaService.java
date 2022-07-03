package com.cibertec.service;

import java.util.List;

import com.cibertec.entidad.Boleta;

public interface BoletaService {
	public abstract Boleta insertaActualizaBoleta(Boleta obj);
	public List<Boleta> listarBoleta();
	public abstract List<Boleta> listaBoletaPorfecha(String fecha_pago_boleta ,int id_departamento,String ultimo_Dia_Pago,int estado_boleta, int id_servicio);
	
}
