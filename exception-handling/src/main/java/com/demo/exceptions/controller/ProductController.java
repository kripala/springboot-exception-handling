package com.demo.exceptions.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exceptions.entity.Product;
import com.demo.exceptions.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService prodService;
	
	@GetMapping
	public List<Product> getAllProducts(){
		log.info("Getting all Products");
		return prodService.getProductList();
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable ("id") Integer id) {
		return prodService.getProduct(id);
	}

}
