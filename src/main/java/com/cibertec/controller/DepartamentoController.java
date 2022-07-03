package com.cibertec.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.entidad.Departamento;

import com.cibertec.service.DepartamentoService;


//
@RestController
@RequestMapping("/rest/departamento")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartamentoController {
	@Autowired
	private DepartamentoService service;
	
	private final static Logger LOGGER = Logger.getLogger("EJECUTO");

	void im(String texto) {
		LOGGER.log(Level.WARNING, texto);
	};
	 
	
	//LISTADO DE DEPARTAMENTOS
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Departamento>> listaDepartamento(){

		List<Departamento> lista = service.listaDepartamento();
		im("listarDepas");
		return ResponseEntity.ok(lista);
	}
	
	//REGISTRO DE DEPARTAMENTOS
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registrarDepartamento(@RequestBody Departamento obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Departamento objSalida = service.insertaActualizaDepartamento(obj);
			if (objSalida == null) {
				salida.put("mensaje","ERROR");
			}else {
				salida.put("mensaje","REGISTRADO");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje","ERROR");
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaPropietario(@RequestBody Departamento obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Departamento objSalida =  service.insertaActualizaDepartamento(obj);
			if (objSalida == null) {
				salida.put("mensaje","Error");
			} else {
				salida.put("mensaje","Exito");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error");
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> eliminaDepartamento(@PathVariable("id") int id){
		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Departamento> opt = service.buscaDepartamento(id);
			
			if (opt.isPresent()) {
				service.eliminaDepartamento(id);
				Optional<Departamento> optSalida = service.buscaDepartamento(id);
				if(optSalida.isEmpty()) {
					salida.put("mensaje","Eliminado");
				}
			}else {
				salida.put("mensaje","Error xd");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			salida.put("mensaje","Error");
		}
		return ResponseEntity.ok(salida);
	}
	
}
