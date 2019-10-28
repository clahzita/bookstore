package com.bookstore.codehome.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.codehome.models.Product;

@Service
public class ProductService {

	private List<Product>  repository = new ArrayList<>();
	
	public List<Product> findAll() {
		
		return repository;
	}
	
	public Product findOne(Long id) {
		int idInt = Integer.parseInt(id.toString());
		return repository.get(idInt);
	}
	
	public Product save(Product product) {
		//return repository.saveAndFlush(product);
		repository.add(product);
		return  product;
	}
	
	public void delete(Long id) {
		int idInt = Integer.parseInt(id.toString());
		//repository.delete(id);
		repository.remove(idInt);
	}
	
}
