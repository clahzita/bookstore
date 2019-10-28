/**
 * 
 */
package com.bookstore.codehome.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.codehome.models.Product;
import com.bookstore.codehome.service.ProductService;

/**
 * 
 * @author clarissa
 *
 */
@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/product")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/product");
		mv.addObject("products", service.findAll());
		
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Product product) {
		
		ModelAndView mv = new ModelAndView("/productAdd");
		mv.addObject("product", product);
		
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Product product, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(product);
		}
		
		service.save(product);
		
		return findAll();
	}
}

