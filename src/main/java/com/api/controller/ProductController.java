package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.model.Product;
import com.api.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService ps;

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product)
	{
		Product proSaved = ps.create(product);
		return new ResponseEntity<Product>(proSaved, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> list(){
		List<Product> list = ps.findAll();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/{productid}")
	public ResponseEntity<Product> getEmpById(@PathVariable("productid") Integer productid){
		Product product = ps.getOne(productid);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{productid}")
	public ResponseEntity<Void> deleteEmpById(@PathVariable("productid") Integer productid){
		ps.delete(productid);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping
	public ResponseEntity<Product> updateEmployee(@RequestBody Product product){
		Product product2 = ps.create(product);
		return new ResponseEntity<Product>(product2, HttpStatus.CREATED);
	}
	
	
}
