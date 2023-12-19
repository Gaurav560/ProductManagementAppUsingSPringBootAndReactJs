package com.telusko.controller;

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

import com.telusko.model.Product;
import com.telusko.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/saveProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);

	}

	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(productService.getAllProduct(), HttpStatus.OK);
	}

	@DeleteMapping("/deleteProductById/{id}")
     public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		return new ResponseEntity<String>(productService.deleteProductById(id), HttpStatus.OK);
	}

	@GetMapping("/getProductById/{id}")
public ResponseEntity<Product> getProdcutById(@PathVariable int id) {
		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
	}
	@PutMapping("/updateProductById/{id}")
	public ResponseEntity<Product> updateProductById(@PathVariable int id,@RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProductById(id, product),HttpStatus.CREATED);
		
	}

}
