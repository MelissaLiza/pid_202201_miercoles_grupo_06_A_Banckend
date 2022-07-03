package com.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entidad.Incidente;
import com.cibertec.entidad.Propietario;
import com.cibertec.service.IncidenteService;


@RestController
@RequestMapping("/rest/incidente")
@CrossOrigin(origins = "http://localhost:4200")
public class IncidenteController {

	@Autowired
	private IncidenteService service;
	
	/* ======= SERVICIO LISTAR INCIDENTE =======*/
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Incidente>> listaIndidentes(){
		List<Incidente> lista = service.listaIncidente();
		return ResponseEntity.ok(lista);
	}
	/* ======= SERVICIO LISTAR INCIDENTE CON FILTRO =======*/
	@GetMapping("/listaIncidenteConFiltro/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Incidente>> listaIncidenteConFiltro(@PathVariable("filtro") String filtro) {
		List<Incidente> lista  = null;
		try {
			if (filtro.equals("todos")) {
				lista = service.listaIncidenteConFiltro("%");
			}else {
				lista = service.listaIncidenteConFiltro("%" + filtro + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	/* ======= SERVICIO LISTAR INCIDENTE CON FILTRO =======*/
	@GetMapping("/listaIncidenteConFiltroasd/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Incidente>> listaIncidenteConFiltro2(@PathVariable("filtro") String filtro) {
		List<Incidente> lista  = null;
		try {
			if (filtro.equals("todos")) {
				lista = service.listaIncidenteConFiltro("%");
			}else {
				lista = service.listaIncidenteConFiltro("%" + filtro + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}

	/* ======= SERVICIO REGISTRAR INCIDENTE =======*/
	@PostMapping("/registrarIncidente")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registrarIncidente(@RequestBody Incidente obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setEstado_incidente(1);
			obj.setSolucion_incidente("");
			Incidente objSalida = service.registraActualizaIndicente(obj);
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
	@PutMapping("/solucionarIncidente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> solucionarIncidente(@RequestBody Incidente obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setEstado_incidente(2);
			Incidente objSalida =  service.registraActualizaIndicente(obj);
			if (objSalida == null) {
				salida.put("mensaje","ERROR");
			} else {
				salida.put("mensaje","Exito");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error");
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@GetMapping("/listaIncidenteConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaIncidentePorIdCausaEstado(
			@RequestParam(name = "id", required = false, defaultValue = "-1") int id,
			@RequestParam(name = "causa", required = false, defaultValue = "") String causa,
			@RequestParam(name = "estado", required = true, defaultValue = "1") int estado) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Incidente> lista = service.listaIncidentePorIdCausaEstado(id, "%"+causa+"%", estado);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos para mostrar");
			}else {
				salida.put("lista", lista);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR");
		}
		return ResponseEntity.ok(salida);
	}
	
	
	
	
	
	
	
	
}
