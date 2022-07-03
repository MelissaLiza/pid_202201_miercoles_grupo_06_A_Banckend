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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entidad.Mascota;
import com.cibertec.entidad.Propietario;
import com.cibertec.service.MascotaService;

@RestController
@RequestMapping("/rest/mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {
	
	@Autowired
	private MascotaService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Mascota>> listaMascota(){
		List<Mascota> lista = service.listaMascota();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registrarMascota")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> registrarMascotas(@RequestBody Mascota obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Mascota objSalida = service.insertaActualizaMascota(obj);
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
	
	@GetMapping("/listaMascotaConFiltro/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Mascota>> listaMascotaConFiltro(@PathVariable("filtro") String filtro) {
		List<Mascota> lista  = null;
		try {
			if (filtro.equals("todos")) {
				lista = service.listaMascotaConFiltro("%");
			}else {
				lista = service.listaMascotaConFiltro("%" + filtro + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@DeleteMapping("/eliminaMascota/{id}")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> eliminaMacota(@PathVariable("id") int id){
		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Mascota> opt = service.buscaMascota(id);
			
			if (opt.isPresent()) {
				service.eliminaMascota(id);
				Optional<Mascota> optSalida = service.buscaMascota(id);
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
