package com.bookstore.codehome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.codehome.models.Product;
import com.bookstore.codehome.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {

		return repository.findAll();
	}

	public Product findOne(Long id) {
		return repository.findById(id).get();
	}

	public Product save(Product product) {
		return repository.saveAndFlush(product);

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
