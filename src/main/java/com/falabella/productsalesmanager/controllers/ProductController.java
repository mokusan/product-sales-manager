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

import com.falabella.productsalesmanager.models.Product;
import com.falabella.productsalesmanager.service.impl.ProductServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;
	
	@ApiOperation(value = "Obtener todos los Products",
		    notes = "No requiere parametros de entrada",
		    response = Product.class,
		    responseContainer = "List")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 404, message = "Not found, no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping
	public ResponseEntity<List<Product>> list() {
		List<Product> lista = productService.listAll();
		return new ResponseEntity<List<Product>>(lista, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Product por ID",
		    notes = "Requiere especificar ID en la URL",
		    response = Product.class,
		    responseContainer = "Product")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 404, message = "Not found, ID no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") Integer id) {
		Product Product = productService.findById(id);
		return new ResponseEntity<Product>(Product, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Registrar nuevo Product",
		    notes = "Requiere un Product nuevo como entrada",
		    response = Product.class,
		    responseContainer = "Product")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PostMapping
	public ResponseEntity<Product> registerNew(@RequestBody Product product) {
		Product prod = productService.saveNewEntry(product);
		return new ResponseEntity<Product>(prod, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Modificar Product pre-existente",
		    notes = "Requiere un Product pre-existente como entrada",
		    response = Product.class,
		    responseContainer = "Product")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 404, message = "Not found, Product no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@PutMapping
	public ResponseEntity<Product> modify(@RequestBody Product product) {
		Product prod = productService.modifyEntry(product);
		return new ResponseEntity<Product>(prod, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar Product",
		    notes = "Requiere un ID de Product como entrada")
	 @ApiResponses(value = {
			 @ApiResponse(code = 200, message = "OK, petición correcta"),
			 @ApiResponse(code = 400, message = "Bad request, datos enviados de forma incorrecta"),
			 @ApiResponse(code = 404, message = "Not found, ID de Product no encontrado"),
			 @ApiResponse(code = 405, message = "No se encontraron registros en la BD")
	 })
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		Boolean prod = productService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
