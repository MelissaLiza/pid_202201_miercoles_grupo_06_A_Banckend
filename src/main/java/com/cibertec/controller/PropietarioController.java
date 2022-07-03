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

import com.cibertec.entidad.Propietario;
import com.cibertec.service.PropietarioService;

@RestController
@RequestMapping("/rest/propietario")
@CrossOrigin(origins = "http://localhost:4200")
public class PropietarioController {

	@Autowired
	private PropietarioService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Propietario>> listaPropietario(){
		List<Propietario> lista = service.listaPropietario();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaPropietarioPorNombreDni/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Propietario>> listaPropietarioPorNombreDni(@PathVariable("filtro") String filtro) {
		List<Propietario> lista  = null;
		try {
			if (filtro.equals("todos")) {
				lista = service.listaPropietarioPorNombreDni("%");
			}else {
				lista = service.listaPropietarioPorNombreDni("%" + filtro + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registrarPropietario(@RequestBody Propietario obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Propietario objSalida = service.insertaActualizaPropietario(obj);
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
	
	@PutMapping("/actualizaPropietario")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaPropietario(@RequestBody Propietario obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Propietario objSalida =  service.insertaActualizaPropietario(obj);
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
	
	@DeleteMapping("/eliminaPropietario/{id}")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> eliminaPropietario(@PathVariable("id") int id){
		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Propietario> opt = service.buscaPropietario(id);
			
			if (opt.isPresent()) {
				service.eliminaPropietario(id);
				Optional<Propietario> optSalida = service.buscaPropietario(id);
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
 