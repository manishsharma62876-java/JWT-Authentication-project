package com.manish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.entity.Product;
import com.manish.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	@PostMapping("/addproduct")
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		String add = productservice.addProduct(product);
		return new ResponseEntity<>(add,HttpStatus.OK);
}
	
	@GetMapping("/allproduct")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> allProduct = productservice.getAllProduct();
		return new ResponseEntity<>(allProduct,HttpStatus.OK);
	}
	
	@PostMapping("/product/{productId}")
public ResponseEntity<Product> getproductById(@PathVariable Integer productId){
	Product getproductById = productservice.getproductById(productId);
	return new ResponseEntity<>(getproductById,HttpStatus.OK);
}
	
	
}