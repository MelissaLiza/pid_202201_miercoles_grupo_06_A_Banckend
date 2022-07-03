package com.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entidad.Visitante;
import com.cibertec.service.VisitanteService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest/visitante")
public class VisitanteController {
	@Autowired
	private VisitanteService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Visitante>> listaVisitante(){
		List<Visitante> lista = service.listaVisitante();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registrarVisitante(@RequestBody Visitante obj){
		Map<String, Object> salida = new HashMap<>();
		
		try {
			Visitante objSalida = service.insertaActualizaVisitante(obj);
			System.out.println(salida);
			if (objSalida == null) {
				salida.put("mensaje","Realizado");
			}else {
				salida.put("mensaje","Realizado");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje","Error");
		}
		return ResponseEntity.ok(salida);
	}

}
