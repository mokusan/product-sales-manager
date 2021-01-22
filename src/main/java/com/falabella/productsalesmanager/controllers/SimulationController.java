package com.falabella.productsalesmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falabella.productsalesmanager.models.Simulation;
import com.falabella.productsalesmanager.service.impl.SimulationServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/simulation")
public class SimulationController {

	@Autowired
	private SimulationServiceImpl simulationService;
	
	@ApiOperation(value = "Obtener todos los Simulations",
		    notes = "No requiere parametros de entrada",
		    response = Simulation.class,
		    responseContainer = "List")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 404, message = "Not found, no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping
	public ResponseEntity<List<Simulation>> list() {
		List<Simulation> lista = simulationService.listAll();
		return new ResponseEntity<List<Simulation>>(lista, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Obtener Simulations disponibles para la venta",
		    notes = "No requiere parametros de entrada",
		    response = Simulation.class,
		    responseContainer = "List")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 404, message = "Not found, no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping("/available-for-sale")
	public ResponseEntity<List<Simulation>> listOnlyAvailable() {
		List<Simulation> lista = simulationService.listOnlyAvailable();
		return new ResponseEntity<List<Simulation>>(lista, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Simulation por ID",
		    notes = "Requiere especificar ID en la URL",
		    response = Simulation.class,
		    responseContainer = "Simulation")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 404, message = "Not found, ID no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Simulation> findById(@PathVariable("id") Integer id) {
		Simulation simulation = simulationService.findById(id);
		return new ResponseEntity<Simulation>(simulation, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Registrar nuevo Simulation",
		    notes = "Requiere un Simulation nuevo como entrada",
		    response = Simulation.class,
		    responseContainer = "Simulation")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PostMapping
	public ResponseEntity<Simulation> registerNew(@RequestBody Simulation simulation) {
		Simulation sim = simulationService.createEntry(simulation);
		return new ResponseEntity<Simulation>(sim, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Modificar Simulation pre-existente",
		    notes = "Requiere un Simulation pre-existente como entrada",
		    response = Simulation.class,
		    responseContainer = "Simulation")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 404, message = "Not found, Simulation no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PutMapping
	public ResponseEntity<Simulation> modify(@RequestBody Simulation simulation) {
		Simulation sim = simulationService.modifyEntry(simulation);
		return new ResponseEntity<Simulation>(sim, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar Simulation",
		    notes = "Requiere un ID de Simulation como entrada")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 404, message = "Not found, ID de Simulation no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		Boolean sim = simulationService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
