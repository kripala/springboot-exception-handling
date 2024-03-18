package com.demo.exceptions.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.exceptions.entity.Product;
import com.demo.exceptions.global.NoDataFoundException;
import com.demo.exceptions.global.ResourceNotFoundException;

@Service
public class ProductService {

	private static List<Product> prodList = new ArrayList<>();
	
	static {
		prodList.add(new Product(1,"Nokia", 10000.00));
		prodList.add(new Product(2,"Samsung", 12000.00));
		prodList.add(new Product(1,"Sony", 30000.00));
		prodList.add(new Product(1,"OnePlus", 45000.00));
		prodList.add(new Product(1,"iPhone", 60000.00));
	}
	
	public List<Product> getProductList(){
		if(prodList.isEmpty()) {
			throw new NoDataFoundException("Products data is not available");
		}
		return prodList;
	}
	
	public Product getProduct(Integer id) {
		Optional<Product> theProduct = prodList.stream()
												.filter(p -> p.getId()==id)
												.findFirst();
		if(!theProduct.isPresent()) {
			throw new ResourceNotFoundException("Product is not found for the id --> "+id);
		}
		return theProduct.get();
	}
}
