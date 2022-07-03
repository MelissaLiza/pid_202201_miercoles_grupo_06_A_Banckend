package com.cibertec.controller;


import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entidad.Boleta;
import com.cibertec.repository.GeneracionFechas;
import com.cibertec.service.BoletaService;

import java.util.logging.Logger;
@RestController
@RequestMapping("/rest/boleta")
@CrossOrigin(origins = "http://localhost:4200")
public class BoletaController {
	@Autowired
	private BoletaService service;
	
	
	private final static Logger LOGGER = Logger.getLogger("EJECUTO");

	void im(String texto) {
		LOGGER.log(Level.WARNING, texto);
	};
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Boleta>> listaBoleta(){
		
		
		
		
		List<Boleta> lista = service.listarBoleta();
		return ResponseEntity.ok(lista);
	}
	
	
	
	//REGISTRO DE DEPARTAMENTOS
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registrarBoleta(@RequestBody Boleta obj){
		Map<String, Object> salida = new HashMap<>();
		Boleta boleta = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> lstfecha = GeneracionFechas.listaFechaPago(Integer.parseInt(obj.getUltimo_Dia_Pago()));
		for (Date date : lstfecha) {
			boleta = new Boleta();
			
			System.out.println(sdf.format(date));
			boleta.setServicio(obj.getServicio());
			boleta.setEstado_boleta(1);
			boleta.setFecha_pago_boleta("Sin registro de Pago");
			boleta.setDepartamento(obj.getDepartamento());
			boleta.setUltimo_Dia_Pago(sdf.format(date)+"");
			im(sdf.format(date)+"");
			service.insertaActualizaBoleta(boleta);
		}
		salida.put("mensaje", "Termino registro");
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizaBoleta")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaSede(@RequestBody Boleta obj) {
		im("==> insertSede ==> CodigoPostal : " + obj.getEstado_boleta());
		im("==> insertSede ==> Direccion : " + obj.getFecha_pago_boleta());
		im("==> insertSede ==> Estado : " + obj.getUltimo_Dia_Pago());
		im("==> insertSede ==> FechaRegistro : " + obj.getDepartamento());
		im("==> insertSede ==> sede : " + obj.getServicio());
		
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getId_boleta() == 0) {
				salida.put("mensaje", "El ID de sede debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			Boleta objSalida = service.insertaActualizaBoleta(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Error");
			} else {
				salida.put("mensaje", "exitoso");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "error");
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/listaBoletaPorfecha")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaBoletaPorfecha(
			@RequestParam(value = "fecha_pago_boleta", required = false, defaultValue = "") String fecha_pago_boleta,
			@RequestParam(value = "id_servicio", required = false, defaultValue = "0") int id_servicio,
			@RequestParam(value = "id_departamento", required = false, defaultValue = "0") int id_departamento,
			@RequestParam(value = "estado_boleta", required = false, defaultValue = "0") int estado_boleta,
			@RequestParam(value = "ultimo_Dia_Pago", required = false, defaultValue = "") String ultimo_Dia_Pago)
			{
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Boleta> lista = service.listaBoletaPorfecha( "%" + fecha_pago_boleta + "%",id_departamento,"%" + ultimo_Dia_Pago + "%",estado_boleta,id_servicio);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existe elementos para la consulta");
			} else {
				salida.put("lista", lista);
				salida.put("mensaje", "Se tiene " + lista.size() + " elementos");
			}
		} catch (Exception e) {
			salida.put("mensaje", "Error : " + e.getMessage());
		}

		return ResponseEntity.ok(salida);
	}
	
	
	
}
