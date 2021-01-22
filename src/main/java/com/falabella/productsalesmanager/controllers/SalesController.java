package com.falabella.productsalesmanager.controllers;

import java.util.ArrayList;
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

import com.falabella.productsalesmanager.models.Sales;
import com.falabella.productsalesmanager.pojos.EvaluateProducts;
import com.falabella.productsalesmanager.pojos.ProductInfo;
import com.falabella.productsalesmanager.service.impl.ProductServiceImpl;
import com.falabella.productsalesmanager.service.impl.SalesServiceImpl;
import com.falabella.productsalesmanager.service.impl.SimulationServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/sales")
public class SalesController {

	@Autowired
	private SalesServiceImpl salesService;
	
	@Autowired
	private SimulationServiceImpl simulationService;
	
	@Autowired
	private ProductServiceImpl productService;
	
	@ApiOperation(value = "Obtener todos los Sales",
		    notes = "No requiere parametros de entrada",
		    response = Sales.class,
		    responseContainer = "List")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 404, message = "Not found, no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping
	public ResponseEntity<List<Sales>> list() {
		List<Sales> lista = salesService.listAll();
		return new ResponseEntity<List<Sales>>(lista, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Sales por ID",
		    notes = "Requiere especificar ID en la URL",
		    response = Sales.class,
		    responseContainer = "Sales")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 404, message = "Not found, ID no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Sales> findById(@PathVariable("id") Integer id) {
		Sales sales = salesService.findById(id);
		return new ResponseEntity<Sales>(sales, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Registrar nuevo Sales",
		    notes = "Requiere un Sales nuevo como entrada",
		    response = Sales.class,
		    responseContainer = "Sales")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PostMapping
	public ResponseEntity<Sales> registerNew(@RequestBody Sales sales) {
		Sales sal = salesService.saveNewEntry(sales);
		return new ResponseEntity<Sales>(sal, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Modificar Sales pre-existente",
		    notes = "Requiere un Sales pre-existente como entrada",
		    response = Sales.class,
		    responseContainer = "Sales")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 404, message = "Not found, Sales no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PutMapping
	public ResponseEntity<Sales> modify(@RequestBody Sales sales) {
		Sales sal = salesService.modifyEntry(sales);
		return new ResponseEntity<Sales>(sal, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar Sales",
		    notes = "Requiere un ID de Sales como entrada")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 404, message = "Not found, ID de Sales no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		Boolean sal = salesService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/evaluateProducts/{days}")
	public ResponseEntity<List<EvaluateProducts>> evaluateProducts(@PathVariable("days") Integer days) {
		List<EvaluateProducts> evaluateProductsList= salesService.getEvaluateProducts(days);
		return new ResponseEntity<List<EvaluateProducts>>(evaluateProductsList, HttpStatus.OK);
	}
}
