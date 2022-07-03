package com.cibertec.controller;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.loader.plan.build.internal.returns.CollectionFetchableElementCompositeGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entidad.RegistroVisita;
import com.cibertec.service.RegistroVisitaService;



@RestController
@RequestMapping("/rest/registroVisita")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistroVisitaController {
	@Autowired
	private RegistroVisitaService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<RegistroVisita>> listaRegistroVisita(){
		List<RegistroVisita> lista = service.listaRegistroVisita();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registrarRegistroVisita(@RequestBody RegistroVisita obj){
		HashMap<String, Object> salida = new HashMap<>();
		
		try {
			List<RegistroVisita> lista = service.listaRegistroVisitaPorId(obj.getId_visita());
			
			
			
			if(CollectionUtils.isEmpty(lista)) {
				RegistroVisita objSalida = service.insertaActualizaRegistroVisita(obj);
				if ( objSalida == null) {
					salida.put("mensaje","registrado");					
				}			
				else
					salida.put("mensaje", "Visttante en Visita");
			}		
			else {
				salida.put("mensaje","No se Registro");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje","SS");
		}
		return ResponseEntity.ok(salida);
	}

}
