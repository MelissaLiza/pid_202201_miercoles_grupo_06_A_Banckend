package com.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.cibertec.entidad.Servicio;
import com.cibertec.service.ServicioService;

@RestController
@RequestMapping("/rest/servicio")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicioController {
	
	@Autowired
	private ServicioService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Servicio>> listaServicio(){
		List<Servicio> lista = service.listaServicio();
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registrarServicio(@RequestBody Servicio obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Servicio objSalida = service.insertaActualizaServicio(obj);
			if (objSalida == null) {
				salida.put("mensaje","Error");
			}else {
				salida.put("mensaje","Registrado");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje","Error");
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaPropietario(@RequestBody Servicio obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Servicio objSalida =  service.insertaActualizaServicio(obj);
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
	public  ResponseEntity<Map<String, Object>> eliminaServicio(@PathVariable("id") int id){
		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Servicio> opt = service.buscaServicio(id);
			
			if (opt.isPresent()) {
				service.eliminaServicio(id);
				Optional<Servicio> optSalida = service.buscaServicio(id);
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
